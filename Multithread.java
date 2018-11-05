/*
Gurbir Matharu
Matthew D'Angelo

Operating Systems
Assignment 3 Question 2

References:
    Assignment 2 Question 1
 */

import java.io.*;
import java.net.*;
import java.lang.Thread;
/*
Multithread class extends thread which is essentially going to take
care of the multithreading functionatlity when .start() is called in the main class

the run() method carries the same functionality as it did with Assignment 2 Question 1, this time it is part of the multithread class
so it can be ran multiple times for multiple clients
 */
public class Multithread extends Thread {
    Socket client;
    Multithread(Socket client){
        this.client = client;
    }

    public void run(){
        try{
            /* creates print writer for sending text over the socket*/
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            /*buffer reader to read the text sent from the socket by client*/
            BufferedReader bin = new BufferedReader(new InputStreamReader(client.getInputStream()));
            /*start of the continuous loop*/
            while (true)
            {
                String line = "notNull";
                /*start of the loop, loop breaks if the text being sent is null */
                while(line!= null){
                    /*gets value of the string from client*/
                    line = bin.readLine();
                    /*if the line is not null, the server continues onto the next line*/
                    if ( line != null )
                        /*prints the line back into the socket but adds "Server: " in front of it
                        so the client knows the data is being sent back from the server
                         */
                        pout.println("Server: "+ line);
                    pout.flush();
                }

                /*close connection second while loop was exited*/
                client.close();
            }
        }


        catch(IOException ioe){
            System.err.println((ioe));
        }
    }

}
