import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Simple_Socket_server {
    private static int PORT=9999;//port numbers range from 0 to 65535

    public static void main(String[] args) throws IOException {
        System.out.println("Simple Socket Server.....");
        System.out.println(".................");

        ServerSocket serverSocket=new ServerSocket(PORT);
        try {
            while (true){
                Socket socket=serverSocket.accept();
                System.out.println("Client is connected....");

                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                out.println("Hello Client");
                socket.close();
            }
        }finally {
            serverSocket.close();
        }
    }
}
