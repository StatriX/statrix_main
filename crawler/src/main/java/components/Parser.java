package components;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class Parser {
    private Map<String, String[]> wordsForParse;
    private String pageContent;
    private Map<String, Integer>parseResultMap;


    public Parser(Map<String, String[]> nameTags, String pageContent){
        this.wordsForParse = nameTags;
        this.pageContent = pageContent;
    }

    public Map<String, Integer> getParseResult(){
        parseResultMap = new ConcurrentHashMap<String, Integer>(wordsForParse.size());

        for (Map.Entry <String, String[]> mapElement : wordsForParse.entrySet()){
            int p = getMatchCounts(mapElement.getValue());
            parseResultMap.put(mapElement.getKey(), p);
        }

        return parseResultMap;
    }

    private int getMatchCounts(String[] words){
        int count = 0;
        for (String word : words){
            Pattern pattern = Pattern.compile("(\\W|^)"+word+"(\\W|$)");
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        Map<String, String[]> testMap = new HashMap<String, String[]>();
        testMap.put("петруха", new String[]{"петр", "петру", "петром", "петра"});
        testMap.put("васька", new String[]{"васька", "ваське", "васькой", "васьки"});
        String testString = "васька для петра съел бабку, и сказал петр ваське: \"ну ты охламон васькас, нету у меня больше васьки\". И васька, обиженный петром, пошел спать.";
        Parser test = new Parser(testMap, testString);
        System.out.println(test.getParseResult());
    }
}
