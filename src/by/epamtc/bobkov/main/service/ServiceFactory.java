package by.epamtc.bobkov.main.service;

import by.epamtc.bobkov.main.service.impl.TextActionImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TextActionService textActionService = new TextActionImpl();

    private ServiceFactory() {}

    public TextActionService getTextActionService() {

        return textActionService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
