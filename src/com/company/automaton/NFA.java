package com.company.automaton;

import com.company.state.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Objects;

public class NFA extends Automaton {


    public NFA(StateSet Q) {
        super(Q);
    }

    /* Depth First Search version. */
    /*
     public void isAccept(String inputString){

        Deque<State> stack =  new ArrayDeque<State>();
        q0.currentString = inputString;
        stack.push(q0);

        while(!stack.isEmpty()) {
            State currentState = stack.pop();
            System.out.println("currentState is " + currentState.name + ".");
            System.out.println("currentString is " + currentState.currentString);

            if (currentState.currentString.isEmpty()) {
                System.out.println(currentState.isAcceptState);
            }else{
                for (State s : currentState.nextStateSet()) {
                    System.out.println("Next state is " + s.name);
                    stack.push(s);
                }
            }
        }
    }
    */

    /* Breadth First Search version. */
    public void isAccept(String inputString){

        Deque<State> queue =  new ArrayDeque<State>();
        q0.currentString = inputString;
        queue.offer(q0);

        while(!queue.isEmpty()) {
            State currentState = queue.poll();
            System.out.println("currentState is " + currentState.name + ".");
            System.out.println("currentString is " + currentState.currentString);

            if (currentState.currentString.isEmpty()) {
                System.out.println(currentState.isAcceptState);
            }else{
                for (State s : currentState.nextStateSet()) {
                    System.out.println("Next state is " + s.name);
                    queue.offer(s);
                }
            }
        }
    }
}
