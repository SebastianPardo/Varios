package co.edu.unal.ds.main;

import co.edu.unal.ds.stack.*;
import co.edu.unal.ds.list.*;


public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new DerivedArrayStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.printf("Stack is %s empty\n", stack.isEmpty() ? "" : "not");
        System.out.printf("Stack is %s\n", stack);
        

        while (!stack.isEmpty()) {
            stack.pop();
        }

        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.printf("Stack is %s\n", stack);

        /* Since DerivedArrayStack is also an ArrayLinearList, we can 
         * "legally" do the following cast. */
        @SuppressWarnings("unchecked")
        ArrayLinearList<Integer> ls = (ArrayLinearList<Integer>) stack;

		//We're calling indexOf on a Stack, breaking the rules we imposed for the stack
        //although it is not so bad since we're not modifying the stacks contents.
        System.out.printf("Index of 2 in stack is %d\n", ls.indexOf(2));

        //This is bad.
        ls.add(1, 5);
        //Stop it.
        ls.add(2, -5000);
        //Come on, stop it. .
        ls.add(2, Integer.MAX_VALUE);

        System.out.printf("Stack is %s\n", stack);

        System.out.printf("Index of 2 in stack is %d\n", ls.indexOf(2));

        ls.remove(2);
        
        System.out.printf("Stack is %s\n", stack);

        
    }
}
