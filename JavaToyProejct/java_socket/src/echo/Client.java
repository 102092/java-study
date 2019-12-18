package echo;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket soket = new Socket("127.0.0.1", 9999);
            System.out.println("Connection Success!");
            Scanner scanner = new Scanner(System.in);

            String message = scanner.nextLine();
            OutputStream out = soket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(message);

            InputStream in = soket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            System.out.println("Receive" + dis.readUTF());

            dis.close();
            dos.close();
            soket.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}