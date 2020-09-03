package by.epamtc.bobkov.main.client.start;

import by.epamtc.bobkov.main.client.controller.TextClientSocket;
import by.epamtc.bobkov.main.exception.ServiceException;
import by.epamtc.bobkov.main.service.ServiceFactory;
import by.epamtc.bobkov.main.service.TextActionService;

public class Start {

    public static void main(String[] args)  {
        try {
         TextActionService textActionService = ServiceFactory.getInstance().getTextActionService();
         String textFromFile = textFromFile = textActionService.readText();
         TextClientSocket client = new TextClientSocket("localhost", 3000);
         client.start(textFromFile);
     } catch (ServiceException e) {
        System.err.println("Ошибка!");
        }
    }
}
