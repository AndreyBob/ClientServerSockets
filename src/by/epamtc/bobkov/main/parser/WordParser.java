package by.epamtc.bobkov.main.parser;


import java.util.LinkedList;
import java.util.List;

public class WordParser{

    private static WordParser instance;

    private WordParser(){

    }

    public static WordParser getInstance() {
        if (instance == null) {
            instance = new WordParser();
        }
        return instance;
    }


    private static String REGEX_WORD_SPLIT = "[\\s\\p{Punct}]+";

    private List<String> listOfWords = new LinkedList<>();

    public List<String> getListOfWords() {
        return listOfWords;
    }

    public List<String> parseText(List<String> sentence) {
        for(int i = 0; i < sentence.size(); i++) {
            String[] arrayOfWords = sentence.get(i).trim().split("[\\s\\p{Punct}]+");
            for(int j = 0; j < arrayOfWords.length; j++) {
                listOfWords.add(arrayOfWords[j]);
            }
        }
       return listOfWords;
    }
}
