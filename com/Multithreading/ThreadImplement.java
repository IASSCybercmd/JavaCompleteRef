package com.Multithreading;

/**
 * Aim: To create a thread using Runnable interface.
 * 
 * @author Priyanshu Raj
 * {@link ThreadExtend#main(String[]) To see another way to create a thread.}
 */
public class ThreadImplement implements Runnable {

    public void run() {
        System.out.println("Thread is running...");
        System.out.println("Thread name is " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadImplement obj = new ThreadImplement();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj, "Noddy");   //The name of the thread t2 is now noddy.
        
        t1.start();
        t2.start();
    }
}
