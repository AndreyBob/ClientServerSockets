package by.epamtc.bobkov.main.dao;


import by.epamtc.bobkov.main.dao.impl.TextReaderDAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final TextReaderDAO textDAO = new TextReaderDAOImpl();
	
	private DAOFactory() {}

	public TextReaderDAO getTextDAO() {
		return textDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
