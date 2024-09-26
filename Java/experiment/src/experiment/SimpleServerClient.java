package experiment;
import java.net.*;
import java.io.*;

// Single class with both server and client functionalities
public class SimpleServerClient {
    
    public static void main(String[] args) {
        // Start the server thread
        new Thread(() -> startServer()).start();

        // Give the server a moment to start up before the client tries to connect
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the client thread
        new Thread(() -> startClient()).start();
    }

    // Server code
    public static void startServer() {
        try (ServerSocket server = new ServerSocket(8080);
             Socket socket = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Client says: " + in.readLine());
            out.println("Hello, client!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Client code
    public static void startClient() {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello, server!");
            System.out.println("Server says: " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
