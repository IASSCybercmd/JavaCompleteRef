package com.Networking.Url;

import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.util.Date;

/**
 * Objectives : 
 * 
 * (1) In this program we show that how we make a URL class obj that contain the address
 * to the remote resource which we want to connect.
 * 
 * (2) then we will connct to the url using URLConnection class methods and access the 
 * attributes of http headers.
 * 
 * @author   Priyanshu Raj
 * @version  V1.0(4 July 2023)
 * @see      (https://chat.openai.com/share/8b0e234e-3900-4b4c-8742-0ae88cb14c56) Ref to (*)Date class used in the program.
 */

public class UrlConnections {
    public static void main(String[] args) throws Exception {
        
        //First, lets make an URL object that will act as a address to target website
        URL ul = new URL("https://www.programiz.com/dsa/linked-list-types");

        //Second, lets make an URLConnection obj so to get info about http headers.
        URLConnection urlcon = ul.openConnection();

        //Now lets get the information about several http headers.
        
        //1. get date
        long d = urlcon.getDate();
        if(d == 0){
            System.out.println("No date information...");
        }else{
            System.out.println("Date: " + new Date(d));
        }

        //2. get content type
        System.out.println("Content type: " + urlcon.getContentType());

        //3. get Expiration date
        d = urlcon.getExpiration();
        if(d==0){
            System.out.println("No expiration information...");
        }else{
            System.out.println("Expires: " + new Date(d));
        }

        //4. get last-modified date
        d = urlcon.getLastModified();
        if(d==0){
            System.out.println("No last-modified information.");
        }else{
            System.out.println("Last-modified: " + new Date(d));
        }

        //5. get content length
        int c;
        long len = urlcon.getContentLengthLong();
        if(len == -1){
            System.out.println("Content length unavailable.");
        }else{
            System.out.println("Content-length: " + len);
        }

        if(len != 0){
            System.out.println("=== Content ===");
            InputStream input = urlcon.getInputStream();
            while(((c = input.read()) != -1)){
                System.out.print((char)c);
            }input.close();
        }else{
            System.out.println("No content available...");
        }
    }
}
