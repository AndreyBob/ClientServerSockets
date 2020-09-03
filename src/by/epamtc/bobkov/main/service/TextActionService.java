package by.epamtc.bobkov.main.service;

import by.epamtc.bobkov.main.exception.ServiceException;

public interface TextActionService {

    String replaceWordsOnSubstring(int lengthOfWord, String substing, String text);
    String replaceWordsBeginConsonantCharOnSubstring(int lengthOfWord, String text);
    public String readText() throws ServiceException;
}
