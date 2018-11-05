/*
Gurbir Matharu
Matthew D'Angelo

Operating Systems
Assignment 3 Question 2

References:
    Assignment 2 Question 1 EchoServer.java
 */

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String [] args){
        try{
            ServerSocket sock = new ServerSocket((6013));
            // runs a while loop to handle multiple connection
            while(true) {
                /* essential steps to begin connection via port 6013*/
                Socket client = sock.accept();
                // uses multithread class which extends Thread
                Multithread multiThread = new Multithread(client);
                // calls start() from Thread class
                multiThread.start();
            }
        }

        catch(IOException ioe){
            System.err.println((ioe));
        }
    }
}
