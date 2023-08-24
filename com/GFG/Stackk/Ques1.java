package com.GFG.Stackk;

import java.util.Stack;
public class Ques1 {
    
    Stack<Integer> stack; // A stack to hold elements
    int minEle; // A variable to keep track of the minimum element

    // Constructor to initialize the stack and minEle
    Ques1() {
        stack = new Stack<>();
        minEle = Integer.MAX_VALUE; // Initialize minEle to a very large value
    }

    /* Pushes an element x onto the stack */
    void push(int x) {
        // When pushing a new element, if it's less than or equal to the current minimum element,
        // we do a special operation to keep track of this new minimum element.
        if (x <= minEle) {
            // First, we push the current minimum element onto the stack.
            stack.push(minEle);

            // Then, we update minEle to the new element 'x'.
            minEle = x;
        }

        // Finally, we push the element 'x' onto the stack.
        stack.push(x);
    }

    /* Pops an element from the stack and returns it */
    int pop() {
        // If the stack is empty, we return -1 to indicate that the stack is empty.
        if (stack.isEmpty())
            return -1;

        // We pop the top element from the stack.
        int popped = stack.pop();

        // If the popped element is the current minimum element, it means the minimum is changing.
        // In this case, we do a special operation to update the current minimum element.
        if (popped == minEle) {
            // We pop the next element from the stack, which was the previous minimum before the update.
            // This effectively restores the previous minimum value.
            minEle = stack.pop();
        }

        // We return the popped element.
        return popped;
    }

    /* Returns the current minimum element in the stack */
    int getMin() {
        // If the stack is empty, we return -1 to indicate that the stack is empty.
        if (stack.isEmpty())
            return -1;

        // The 'minEle' variable always holds the current minimum element,
        // so we simply return its value.
        return minEle;
    }
}




/* Understanding the concept
 * 
 * During insertion: 
 * 1. If curr element is <= minElement then, we first insert minElement then as ususal the curr element
 *    but special thing about this insertion is that, in our stack below every new min element is previous
 *    minElement so when we start popping out then as soon our min element pop we can get the immeadite
 *    minElement element sitting beneath it.
 * 
 * 2. our current minElement is always in the `minEle` variable and not in stack.
 * 
 * 3. Special insertion only happens in case when elemnet smaller than curr Min Element is found.
 */

