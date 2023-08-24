package simple_tcp_game;

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
        System.out.println("Client " + socket.getInetAddress() + " has connected");

        // create input & output(I/O) buffers:
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        String message;

        int secretNumber = (int)(Math.random()*10 + 1); // generate a number between 1 - 10 . Don't start from 0
        do{
            outSocket.println("Guess a number [1 - 10]");
            message = inSocket.readLine();
        }while (Integer.parseInt(message) != secretNumber);
        outSocket.println("You got it !!!");
        System.out.println("The secret number is: " + secretNumber);
        System.out.println("Exiting the app...");


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
