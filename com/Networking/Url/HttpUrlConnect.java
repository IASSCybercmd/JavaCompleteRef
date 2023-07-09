package com.Networking.Url;

import java.net.*;
import java.util.*;
import java.io.*;

/**
 * This program show the working of HttpUrlConnection subclass, that provide support for HTTP connections.
 * 
 * @author Priyanshu Raj
 * @version 5 July 2023
 * 
 */
public class HttpUrlConnect {
    public static void main(String[] args) throws MalformedURLException,IOException{
        URL url = new URL("http://www.google.com");

        HttpURLConnection huc = (HttpURLConnection) url.openConnection();

        //Display request method.
        System.out.println("Request method is " + huc.getRequestMethod());

        //Display response code
        System.out.println("Response code is " + huc.getResponseCode());

        //Display response message
        System.out.println("Response message is " + huc.getResponseMessage());

        //Get a list of the header fields and a setof header keys

        //Here we use List<string> as each header field can have multiple fields
        Map<String,List<String>> hdrMap = huc.getHeaderFields();
        //Here we got all the keys
        Set<String> hdrField = hdrMap.keySet();


        System.out.println("\nHere is the header:");

        //Dispaly all header fields (i.e keys and value)
            for (String key : hdrField) {
                System.out.println(key + "  :" + hdrMap.get(key));
            }
        }


    }

