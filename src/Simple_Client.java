import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Simple_Client {
    private static int PORT=9999;

    public static void main(String[] args) throws IOException {
        System.out.println("Simple Client...");
        System.out.println("--------------------------");
        //127.0.0.1
        InetAddress ipAddress=InetAddress.getLocalHost();
        Socket socket=new Socket(ipAddress,PORT);
        System.out.println("Server is connected ....");
        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        BufferedReader in=new BufferedReader(isr);
        String input=in.readLine();
        System.out.println("Server says : "+input);
        in.close();
        socket.close();
    }
}
