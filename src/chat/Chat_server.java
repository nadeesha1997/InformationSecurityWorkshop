package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Chat_server {
    private static int PORT=9999;//port numbers range from 0 to 65535

    public static void main(String[] args) throws IOException {
        System.out.println("Simple Socket Server.....");
        System.out.println(".................");

        ServerSocket serverSocket=new ServerSocket(PORT);
        Scanner scanner=new Scanner(System.in);
        try {
            while (true){
                Socket socket=serverSocket.accept();
                System.out.println("Client is connected....");

                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                try {
                    while (true){
                        System.out.print("Server : ");
                        String input=scanner.nextLine();
                        out.println(input);

                        String output=in.readLine();
                        System.out.println("Client says : "+output);
                    }
                }
                finally {
                    socket.close();
                    out.close();
                    in.close();
                }
            }
        }finally {
            serverSocket.close();
        }
    }
}
