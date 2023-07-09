package com.Networking.TcpIpSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * This class show the working of sockets in Java.
 */
public class SocketImplement{
    public static void main(String[] args) throws Exception {
        int c;

        //Create a socket connected to internic.net on port 43.
        Socket skt = new Socket("whois.internic.net", 43);

        //Obtaining input & output stream...
        InputStream in = skt.getInputStream();
        OutputStream out = skt.getOutputStream();

        //Construct a request string.
        String str = (args.length == 0 ? "www.scanme.nmap.org" : args[0] ) + "\n";
        byte buf[] = str.getBytes();
        
        //perfoming the write operation - < Send request >
        out.write(buf);

        //Read and display response,
        while((c = in.read()) != -1){
            System.out.print((char)c);
        }
        skt.close();
    }
}