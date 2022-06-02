package thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    private static int PORT=9999;
    public static void main(String[] args) throws IOException {
        System.out.println("Simple Socket Server.....");
        System.out.println(".................");

        ServerSocket serverSocket=new ServerSocket(PORT);
        int currentClients=0;
        try {
            while (true){
                Socket client=serverSocket.accept();
                System.out.println("Client is connected....");
                ServerThread ct=new ServerThread(client,currentClients);
                ct.start();
                currentClients++;
            }
        }finally {
            serverSocket.close();
        }
    }
}
