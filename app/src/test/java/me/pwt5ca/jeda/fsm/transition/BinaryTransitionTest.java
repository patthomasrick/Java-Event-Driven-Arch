package me.pwt5ca.jeda.fsm.transition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import me.pwt5ca.jeda.fsm.state.State;

public class BinaryTransitionTest {
    @Test
    void testEvaluate() {
        State start = new State();
        State trueDestination = new State();
        State falseDestination = new State();

        BinaryTransition transition = new BinaryTransition(start, trueDestination, falseDestination);

        // 1. Evaluate true.
        Assertions.assertEquals(
                trueDestination,
                transition.evaluate(true),
                "Transition should evaluate to true destination.");

        // 2. Evaluate false.
        Assertions.assertEquals(
                falseDestination,
                transition.evaluate(false),
                "Transition should evaluate to false destination.");

        // 3. Evaluate null.
        Assertions.assertNull(
                transition.evaluate(null),
                "Transition should evaluate to null.");

        // 4. Evaluate non-boolean.
        Assertions.assertNull(
                transition.evaluate("not a boolean"),
                "Transition should evaluate to null.");

        // 5. Evaluate a state not in the transition.
        Assertions.assertNull(
                transition.evaluate(new State()),
                "Transition should evaluate to null.");
    }
}
