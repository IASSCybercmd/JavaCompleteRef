package com.Multithreading;

class Ninja extends Thread {

    // overriding the run method.
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                sleep(500);
                System.out.println("The thread running is " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("The exception is " + e);
            }
            System.out.println(i);
        }
    }
}

public class JoinMethod {
    public static void main(String[] args) {
        Ninja t1 = new Ninja();
        Ninja t2 = new Ninja();
        Ninja t3 = new Ninja();

        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());

            // invoking the join() method
            t1.join();
        }

        // catch block for catching the raised exception
        catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

        // thread th2 starts
        t2.start();

        // starting the th3 thread after when the thread th2 has ended or died.
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());
            t2.join();
        }

        // catch block for catching the raised exception
        catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

        // thread th3 starts
        t3.start();
    }
}
