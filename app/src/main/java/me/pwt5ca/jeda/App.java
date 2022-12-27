/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package me.pwt5ca.jeda;

import java.io.FileWriter;
import java.io.IOException;

import me.pwt5ca.jeda.fsm.FiniteStateMachine;
import me.pwt5ca.jeda.fsm.FiniteStateMachineBuilder;
import me.pwt5ca.jeda.fsm.state.DebugState;
import me.pwt5ca.jeda.fsm.state.State;

public class App {
    public static void main(String[] args) {
        FiniteStateMachineBuilder builder = new FiniteStateMachineBuilder();
        // Add debug states.
        State start = new DebugState("Start");
        builder.addState(start);
        State end = new DebugState("End");
        builder.addState(end);

        builder.addBinaryTransition(start, end, start);
        builder.addBinaryTransition(end, start, end);
        FiniteStateMachine fsm = builder.build();

        // Write DOT representation of FSM to file.
        try {
            FileWriter writer = new FileWriter("fsm.dot");
            writer.write(fsm.toDot());
            writer.close();

            // Run dot
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", "fsm.dot", "-o", "fsm.png");
            Process p = pb.start();
            p.waitFor();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            Boolean input = i % 2 == 0;
            System.out.println("Input: " + input);
            fsm.evaluate(input);
        }
    }
}
