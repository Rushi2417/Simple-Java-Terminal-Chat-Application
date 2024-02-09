import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ipAddress, int port) {
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected to server: " + ipAddress + ":" + port);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            startChatting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startChatting() throws IOException {
        String inputLine;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Start chatting (type 'exit' to quit):");

        while (true) {
            // Listening for server's messages
            if (in.ready()) {
                inputLine = in.readLine();
                if (inputLine.equals("exit")) break;
                System.out.println("Server: " + inputLine);
            }

            // Sending message to server
            if (stdIn.ready()) {
                inputLine = stdIn.readLine();
                out.println(inputLine);
                if (inputLine.equals("exit")) break;
            }
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startConnection("localhost", 12345);
    }
}
