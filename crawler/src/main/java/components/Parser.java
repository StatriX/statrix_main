package components;

import java.util.Map;

public class Parser {
    private Map<String, String[]> wordsForParse;
    private String pageContent;

    public Parser(Map<String, String[]> nameTags, String pageContent){
        this.wordsForParse = nameTags;
        this.pageContent = pageContent;
    }

    public Map<String, Integer> getParseResult(){
        return null;
    }
}
