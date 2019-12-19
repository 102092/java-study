package chatting;

import java.util.*;
import java.net.*;
import java.io.*;

public class Muti_Server {

    HashMap<String, Object> clients;

    Muti_Server() {
        clients = new HashMap<>();
        Collections.synchronizedMap(clients); // Threads lock
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("start server....");

            while (true) {
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress() + ": " + socket.getPort() + " ..Connected!");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendToAll(String msg) {
        Iterator<String> iterator = clients.keySet().iterator();

        while (iterator.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(iterator.next());
                out.writeUTF(msg);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Muti_Server server = new Muti_Server();
        server.start();
    }

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket) {
            this.socket = socket;

            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String name = "";

            try {
                name = in.readUTF();
                if (clients.get(name) != null) {
                    out.writeUTF("#Already Exist Name : " + name);
                    out.writeUTF("#Please Reconnect by other Name ");
                    System.out.println(socket.getInetAddress() + ": " + socket.getPort() + " disconnected!");

                    in.close();
                    out.close();
                    socket.close();
                    socket = null;
                } else {
                    sendToAll("#" + name + " Join!");
                    clients.put(name, out);

                    while (in != null) { // 입력 스트림 있으면 계속 보내줌
                        sendToAll(in.readUTF());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                if (socket != null) {
                    sendToAll("$" + name + " exit!");
                    clients.remove(name);
                    System.out.println(socket.getInetAddress() + ": " + socket.getPort() + " disconneted!");
                }
            }
        }

    }

}