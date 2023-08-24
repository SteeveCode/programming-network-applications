package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client()throws Exception{
        Socket socket = new Socket("localHost", 2020);
        System.out.println("Successful connection to the server");

        // create input & output(I/O) buffers:
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);

        String message = inSocket.readLine();  // read message from the server
        System.out.println("Server says: " + message);
        System.out.print("Say something to the server: ");
        message = keyboard.nextLine();
        outSocket.println(message);  // write message to the server

        socket.close();
        System.out.println("Socket is closed");


    }
        public static void main(String[] args) {

        try{
            new Client();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
