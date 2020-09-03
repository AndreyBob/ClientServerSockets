package by.epamtc.bobkov.main.dao.impl;



import by.epamtc.bobkov.main.dao.TextReaderDAO;
import by.epamtc.bobkov.main.exception.DaoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReaderDAOImpl implements TextReaderDAO {
    private static final String PATH_TO_FILE = "resources/test.txt";
    String textLine;
    StringBuilder sb = new StringBuilder();
    public String readTextFromFile() throws DaoException {
        try(BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_FILE))) {
            while ((textLine = reader.readLine()) != null) {
                sb.append(textLine).append("\n");
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
        return sb.toString();
    }
}
