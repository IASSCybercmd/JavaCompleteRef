package com.DataStructure.Staaack;

public class Staek {
    public int arr[];
    public int top;
    public int size;

    // creating a stack
    Staek(int size) {
        arr = new int[size];
        this.size = size;
        top = -1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full\nProgram terminated\n ");
            System.exit(1);
        }
        System.out.println("Inserting :" + element);
        arr[++top] = element;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty\nProgram ");
            System.exit(1);
        }
        System.out.println("Removing " + arr[top]);
        top--;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        System.out.print("{ ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i]);
            if (i != top) {
                System.out.print(", ");
            }
        }
        System.out.print(" }");
        System.out.println();

    }

    public static void main(String[] args) {
        Staek stack = new Staek(5);
        stack.push(5);
        stack.push(6);
        stack.push(1);
        stack.push(9);

        stack.pop();
        stack.printStack();
    }
}