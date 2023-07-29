package com.Multithreading;

public class Naming extends Thread {

    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        Naming t1 = new Naming();
        Naming t2 = new Naming();

        System.out.println("Name of t1:" + t1.getName());
        System.out.println("Name of t2:" + t2.getName());

        t1.start();
        t2.start();

        t1.setName("Doaremon :)");
        System.out.println("After changing name of t1:" + t1.getName());
    }
}
