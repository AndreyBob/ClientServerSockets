package by.epamtc.bobkov.main.client.controller;

import by.epamtc.bobkov.main.entity.Text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class TextClientSocket {

    private String ip;
    private int port;
    private Text textClient;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public TextClientSocket(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start(String text) {
        try {
            socket = new Socket(ip, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Клиент: соединение установлено.");
            sendObjectToServer(text);
            System.out.println("Ожидаем ответа от сервера...");
            String resultText = readAnswerFromServer();
            System.out.println(resultText);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendObjectToServer(String text) throws IOException {
        textClient = new Text(text);
        out.writeObject(textClient);
        out.flush();

    }

    private String readAnswerFromServer() throws IOException, ClassNotFoundException {
        Text newObjectText = (Text) in.readObject();
        String resultText = newObjectText.getAllText();
        return resultText;
    }

}
