package by.epamtc.bobkov.main.parser;


import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static SentenceParser instance;

    private SentenceParser(){

    }

    public static SentenceParser getInstance() {
        if (instance == null) {
            instance = new SentenceParser();
        }
        return instance;
    }


    private static String SENTENCE_REGEX = ".+?\\n?[\\.\\!\\?]+";
 //   Pattern patternSentence = Pattern.compile(SENTENCE_REGEX);
 //   Matcher matcherSentence;

    public List<String> getListOfSentence() {
        return listOfSentence;  }



    private List<String> listOfSentence = new LinkedList<>();


    public List<String> parseText(String text) {
        Pattern patternSentence = Pattern.compile(SENTENCE_REGEX);
        Matcher matcherSentence = patternSentence.matcher(text.trim());
        while (matcherSentence.find()) {
           listOfSentence.add(matcherSentence.group());


        }
        return listOfSentence;
    }
}
