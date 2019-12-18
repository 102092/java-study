package echo;

import java.net.*;
import java.io.*;

/**
 * Server
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Server Ready");
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                Socket socket = serverSocket.accept();
                System.out.println("Client Connecting  Success!");

                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                String message = dis.readUTF();
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("[ECHO] " + message + " (From Server)");

                dos.close();
                dis.close();
                socket.close();
                System.out.println("client socket closed...");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}