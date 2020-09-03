package by.epamtc.bobkov.main.server.controller;

import by.epamtc.bobkov.main.entity.Text;
import by.epamtc.bobkov.main.service.ServiceFactory;
import by.epamtc.bobkov.main.service.TextActionService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TextServerSocket {
    private ServerSocket server;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int port;
    private Text textServer;
    private ServiceFactory factory;
    private TextActionService textActionService;

    public TextServerSocket(int port) {


        this.port = port;

    }
    public void start() {
        try {

            server = new ServerSocket(port);
            System.out.println("Ожидаем подключения.");
            socket = server.accept();
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            String textServer = readObjectFromClient();
            sendResponseToClient(textServer,1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                    server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public String readObjectFromClient() throws IOException, ClassNotFoundException {
        textServer = (Text) in.readObject();
        String textFromObject = textServer.getAllText();
        return textFromObject;
    }

    private void sendResponseToClient(String text, int numOfService) throws IOException {
        factory = ServiceFactory.getInstance();
        textActionService = factory.getTextActionService();
        String resultText;
        switch (numOfService) {
            case 1: {
                resultText = textActionService.replaceWordsOnSubstring(3, "555", text);
                textServer.setAllText(resultText);
                out.writeObject(textServer);
                break;
            }
            case 2: {
                resultText = textActionService.replaceWordsBeginConsonantCharOnSubstring(3,text);
                textServer.setAllText(resultText);
                out.writeObject(textServer);
                break;
            }
            default: {
                System.out.println("Такой операции не существует!");
                break;
            }
        }
    }



}
