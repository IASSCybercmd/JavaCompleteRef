package com.Networking.Url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class shows the working of URL class and how it is used
 * to make url object that will be used as an url duing establishing 
 * connection.
 * 
 * @author Priyanshu Raj
 * @version V1.0(4 July 2023)
 */
public class UrlBasicIntro {
    public static void main(String[] args) throws MalformedURLException {
        // Url => protocol://host:port/path (eg. https://google.com:80/serch?query=java%20is)

        URL obj = new URL("http://www.HerbSchildt.com/WhatsNew?serch=hello");

        //There are few methods defined that are used to get info about it's protocol, port and 
        //other things.

        System.out.println(obj.getProtocol());
        System.out.println(obj.getHost());
        System.out.println(obj.getPort());
        System.out.println(obj.getPath());
        System.out.println(obj.getFile());
        System.out.println(obj.toExternalForm());
    }
}
