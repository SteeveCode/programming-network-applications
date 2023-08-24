package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private ServerMain serverMain;
    public ServerThread (Socket socket, ServerMain serverMain) {
        this.socket = socket;
        this.serverMain = serverMain;
    }

    @Override
    public void run() {
        try {

            int clientNumber = serverMain.getClientNumber();
            System.out.println("Client " + clientNumber + ". has connected.");

            // I/O buffers:
            BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);

            out_socket.println("Welcome! You are client number " + clientNumber+ ". What's your name? "); // send "Welcome" to the Client
            String message = in_socket.readLine(); // receive "Thanks!"
            System.out.println("Client says: " + message); // display Client's message in the console

            socket.close();
            System.out.println("Client " + clientNumber + ". has disconnected.");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
