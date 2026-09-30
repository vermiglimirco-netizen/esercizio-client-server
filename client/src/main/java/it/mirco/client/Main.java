package it.mirco.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         try (Socket socket = new Socket("localhost", 5000)) {
            
            //il client cerca il server e apre la socket

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //creo il canale di uscita

            //accendo la tastiera
            Scanner tastiera = new Scanner(System.in);

            do{
            //prendo la tastiera
            String messaggioin = tastiera.nextLine();

            out.println(messaggioin);
            //invio il nessaggio sul canale

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //apre il canale per leggere

            String messaggioout= in.readLine();
            //legge il messaggio dal canale

            System.out.println(messaggioout);

            }while
            (messaggioin=="exit" || messaggioin=="EXIT")

            in.close();

            out.close();


            

        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

    }
}