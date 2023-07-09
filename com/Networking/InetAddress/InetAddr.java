package com.Networking.InetAddress;

import java.net.*;

/***
 * This program is used to show the uses of java InetAddress class.
 */
public class InetAddr {
    public static void main(String[] args) {

        /**
         * These factory methods described below are used to get the object of InetAddress class.
         * 1.getLocalHost()
         * 2.getByName()
         * 3.getAllByName()
         * 4.getByAddress()
         */

        try{
            /* getLocalHost() method simply returns the InetAddress object
            * that represents that local host. 
            */
            InetAddress obj = InetAddress.getLocalHost();
            System.out.println(obj);
            

            /* getByName() method returns an InetAddress for a host name
            * passed. 
            */
            obj = InetAddress.getByName("www.google.com");
            System.out.println(obj);


            /* getAllByName() method returns an array of InetAddress
             * that represents all of the address that a particular domain
             * resolves to.
             */
            InetAddress adds[] = InetAddress.getAllByName("www.nba.com");
            for (int i = 0; i < adds.length; i++) {
                System.out.println(adds[i]);
            }

        }catch(Exception e){
            e.getStackTrace();
        }


        /**
         * These instance methods described below are used to work on
         *  the object returned from above factory methods.
         * 
         * 1. String getHostAddress()
         * 2. String getHostName()
         * 3. boolean equals(Object other)
         * 4. boolean isMultiplecastAddress()
         * 5. Strign toString()
         * 
         */

         try{
            InetAddress ads = InetAddress.getByName("www.youtube.com");
            //Inet4Address gives only ipv4 address as result.
            InetAddress ad4 = Inet4Address.getByName("www.cgcassignment.com");
            System.out.println(ad4);
            System.out.println(ads.getHostAddress());
            System.out.println(ads.getHostName());

            System.out.println(ads);
            if(ads.isMulticastAddress()){
                System.out.println("yes it's multiple cast address...");
            }
            else
                {System.out.println("NO...");}
         }catch(UnknownHostException e ){
            System.out.println(e);
         }

    }
}
