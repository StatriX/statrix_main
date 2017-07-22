package components;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Map<String, String[]> wordsForParse;
    private String pageContent;
    private Map<String, Integer> parseResultMap;
    private ExecutorService executorService = Executors.newFixedThreadPool(8);


    public Parser(Map<String, String[]> nameTags, String pageContent) {
        this.wordsForParse = nameTags;
        this.pageContent = pageContent;
    }

    public Map<String, Integer> getParseResult() {
        parseResultMap = new ConcurrentHashMap<>(wordsForParse.size());

        for (Map.Entry<String, String[]> mapElement : wordsForParse.entrySet()) {
            executorService.execute(() -> {
                int p = getMatchCounts(mapElement.getValue());
                parseResultMap.put(mapElement.getKey(), p);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return parseResultMap;
    }

    private int getMatchCounts(String[] words) {
        int count = 0;
        for (String word : words) {
            Pattern pattern = Pattern.compile("(\\W|^)" + word + "(\\W|$)", Pattern.UNICODE_CHARACTER_CLASS);
            System.out.println(pattern);
            Matcher matcher = pattern.matcher(pageContent);
            while (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
