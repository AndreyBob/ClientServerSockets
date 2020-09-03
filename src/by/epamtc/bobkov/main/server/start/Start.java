package by.epamtc.bobkov.main.server.start;

import by.epamtc.bobkov.main.server.controller.TextServerSocket;

public class Start {
    public static void main(String[] args) {

        TextServerSocket server = new TextServerSocket(3000);
        server.start();

    }
}
