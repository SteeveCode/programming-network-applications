package simple_tcp_game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client()throws Exception{
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successful connection to the server");

        // create input & output(I/O) buffers:
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);
        String userNumber;

        while (inSocket.readLine().startsWith("Guess")){
            System.out.println("Server says: Guess a number [1 - 10]");
            userNumber = keyboard.nextLine();
            outSocket.println(userNumber);
        }
        System.out.println("You got it !!!");

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
