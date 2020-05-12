import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class MyQueue<T> {

        private T frontValue;
        private Stack<T> inputStack = new Stack<T>(); // push peek pop
        private Stack<T> stateStack = new Stack<T>();

    

        public void enqueue(T inputInt) {
            if(inputStack.size() == 0) {
                frontValue = inputInt;
            }
            inputStack.push(inputInt);
        }

        public T dequeue() {
            transferToStateStack();
            T dqd = stateStack.pop();

            if(stateStack.size() > 0 ) {
                frontValue = stateStack.peek();
            }
            
            transferBackToInputStack();
            return dqd;
        }

        public T peek() {
            
            return frontValue;
        }

        private void transferToStateStack() {
            while(inputStack.size() > 0) {
                stateStack.push(inputStack.pop());
            }
            
        }

        private void transferBackToInputStack() {
            while(stateStack.size() > 0) {
                inputStack.push(stateStack.pop());
            }

        }
    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }

}
