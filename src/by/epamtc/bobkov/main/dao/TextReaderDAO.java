package by.epamtc.bobkov.main.dao;


import by.epamtc.bobkov.main.exception.DaoException;

public interface TextReaderDAO {
    String readTextFromFile() throws DaoException;
}
