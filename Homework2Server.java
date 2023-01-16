import java.net.*;
import java.io.*;

public class Homework2Server {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);
            
            Runnable task = () -> {
                try {
                    Socket client = sock.accept();
                
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                    pout.println(new java.util.Date().toString());
                
                    client.close();
                }
                catch (IOException ioe) {
                    System.err.println(ioe);
                }
		    };

            while (true) {
                Thread worker = new Thread(task);
                worker.start();
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
