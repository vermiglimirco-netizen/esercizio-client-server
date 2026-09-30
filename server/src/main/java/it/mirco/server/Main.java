package it.mirco.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        // il serve apre la porta
        try (ServerSocket server = new ServerSocket(5000)) {

            System.out.println("Server in ascolto sulla porta 5000...");

            // il server aspetta un client
            Socket socket = server.accept();

            System.out.println("Client connesso");


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //apre il canale per leggere
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //creo il canale di uscita

            String messaggio = null;

            do 
            {
                messaggio= in.readLine();
                //legge il messaggio dal canale

                messaggio = messaggio.toUpperCase();
                //inverte il maiuscolo minuscolo

                if(messaggio.equalsIgnoreCase("exit"))
                    messaggio="uscito";
                
                out.println(messaggio);
                //invio il nessaggio sul canale

            } while
            (!messaggio.equalsIgnoreCase("exit"));



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}