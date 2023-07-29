package com.Multithreading;

/**
 * Aim: Creating a thread by Extending thread class.
 * 
 * @author Priyanshu Raj
 * {@link ThreadImplement#main() See this to find another way to create a thread.}
 */
public class ThreadExtend extends Thread {
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        ThreadExtend t1 = new ThreadExtend();
        t1.start();
        
    }
}