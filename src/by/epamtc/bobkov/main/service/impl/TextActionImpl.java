package by.epamtc.bobkov.main.service.impl;



import by.epamtc.bobkov.main.dao.DAOFactory;
import by.epamtc.bobkov.main.dao.TextReaderDAO;
import by.epamtc.bobkov.main.exception.DaoException;
import by.epamtc.bobkov.main.exception.ServiceException;
import by.epamtc.bobkov.main.parser.SentenceParser;
import by.epamtc.bobkov.main.parser.WordParser;
import by.epamtc.bobkov.main.service.TextActionService;

import java.util.List;

public class TextActionImpl implements TextActionService {
    private DAOFactory daoFactory;

    SentenceParser sentenceParser = SentenceParser.getInstance();
    WordParser wordParser = WordParser.getInstance();


    public String replaceWordsOnSubstring(int lengthOfWord, String substing, String text) {
        sentenceParser.parseText(text);
        wordParser.parseText(sentenceParser.getListOfSentence());
        List<String> listOfWords = wordParser.getListOfWords();
        for (int i = 0; i < listOfWords.size(); i++ ) {
            if(listOfWords.get(i).length() == lengthOfWord) {
                listOfWords.set(i, substing);
            }
        }
        return listOfWords.toString();
    }

    public String replaceWordsBeginConsonantCharOnSubstring(int lengthOfWord,String text) {
        sentenceParser.parseText(text);
        wordParser.parseText(sentenceParser.getListOfSentence());
        List<String> listOfWords = wordParser.getListOfWords();
        for (int i = 0; i < listOfWords.size(); i++ ) {
            if(listOfWords.get(i).length() == lengthOfWord &&
                    (listOfWords.get(i).matches("[ЦцЙйКкНнГгШшЩщЗзХхЪъФфВвПпРрЛлДдЖжЧчСсМмТтЬьБб]+.+?"))) {
                listOfWords.remove(i);
            }
        }
        return listOfWords.toString();
    }

    public String readText() throws ServiceException {
        daoFactory = DAOFactory.getInstance();
        String textFromFile = null;
        try {
            textFromFile = daoFactory.getTextDAO().readTextFromFile();
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return textFromFile;
    }

}
