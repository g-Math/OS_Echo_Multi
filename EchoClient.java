/*
Gurbir Matharu
Matthew D'Angelo

Operating Systems
Assignment 3 Question 2

References:
    Assignment 2 Question 1 EchoClient.java
 */

import java.io.*;
import java.net.*;

public class EchoClient
{
    public static void main(String args[]) throws Exception
    {
        try {
            /* creates variable to use for socket using ServerSocket and ip address
            assigned from command line argument, assigns to port 6013*/
            Socket sock = new Socket(args[0], 6013);
            /* creates print writer for sending text over the socket*/
            PrintWriter write = new PrintWriter(sock.getOutputStream());
            /*buffer reader for sending and receiving text form server*/
            InputStream in = sock.getInputStream();
            BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readFromServer=new BufferedReader(new InputStreamReader(sock.getInputStream()));

            /*variables for sending and receiving text to and from server*/
            String sendText = "notnull", receiveText;

                /*start of the loop, loop breaks if the text being sent is null */
                while (sendText != null) {
                    /* reads the next line and adds it into sendText*/
                    sendText = inputBuffer.readLine();
                    /*writes to the socket*/
                    write.println(sendText);
                    /*if the value of the text entered is "." the loop is broken and client stops*/
                    if (sendText.equals(".")){
                        break;
                    }
                    /*receive text gets the text sent from the server and stores it into the variable*/
                    write.flush();
                    receiveText = readFromServer.readLine();
                    /*prints out the text which was received from the server*/
                    System.out.println(receiveText);
            }
        }

        catch(Exception ioe)
        {
            System.err.println(ioe);
        }
    }
}