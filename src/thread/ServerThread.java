package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;
    private int clientId;

    public ServerThread(Socket client, int cid) throws IOException {
        this.client=client;
        this.clientId=cid;
        in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        out=new PrintWriter(client.getOutputStream(),true);
        scanner=new Scanner(System.in);
    }
    @Override
    public void run(){
        try {
            while (true){
                System.out.println("Server : ");
                String input=scanner.nextLine();
                out.println(input);
                String output=in.readLine();
                System.out.println("Client"+clientId+" says "+output);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
