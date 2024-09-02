package com.anudip.list;

import java.util.Stack;


public class Assignment1D4
{

    
    public static boolean isSequenceInStack(Stack<Integer> stack, int[] sequence) {
        Stack<Integer> tempStack = new Stack<Integer>();

       
        for (int i = sequence.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() != sequence[i]) {
                tempStack.push(stack.pop());
            }
            
          
            if (stack.isEmpty()) {
                return false;
            }
            
            
            stack.pop();
            
           
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

       
        return true;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        int[] sequence1 = {3, 4, 5};
        int[] sequence2 = {5, 3};

        System.out.println("Sequence 1 present in stack: " + isSequenceInStack(stack, sequence1));
        System.out.println("Sequence 2 present in stack: " + isSequenceInStack(stack, sequence2));
    }
}