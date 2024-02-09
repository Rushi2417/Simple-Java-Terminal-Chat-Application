import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            startListening();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startListening() throws IOException {
        String inputLine;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Start chatting (type 'exit' to quit):");

        while (true) {
            // Listening for client's messages
            if (in.ready()) {
                inputLine = in.readLine();
                if (inputLine.equals("exit")) break;
                System.out.println("Client: " + inputLine);
            }

            // Sending message to client
            if (stdIn.ready()) {
                inputLine = stdIn.readLine();
                out.println(inputLine);
                if (inputLine.equals("exit")) break;
            }
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(12345);
    }
}
