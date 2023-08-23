package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(2020); // opening a new port on 20202
        System.out.println("Port 2020 is open. Waiting for connection...");
        Socket socket = serverSocket.accept();
        System.out.printf("Client " + socket.getInetAddress() + "has connected");

        // create input & output(I/O) buffers:
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        outSocket.println("Welcome"); // send "Welcome" to the client
        String message =  inSocket.readLine();
        System.out.println("Client says: " + message); // display client's message in the console

        socket.close();
        System.out.println("Socket is closed");

    }
    public static void main(String[] args) {
      try{
          new Server();
      }catch (Exception e) {
          e.printStackTrace();

      }
    }
}
