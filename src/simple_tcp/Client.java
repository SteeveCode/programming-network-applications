package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public Client()throws Exception{
        Socket socket = new Socket("localHost", 2020);
        System.out.println("Successful connection to the server");

        // create input & output(I/O) buffers:
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = inSocket.readLine();  // read message from the server
        System.out.println("Server says: " + message);
        outSocket.println("Thanks!");  // write message to the server

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
