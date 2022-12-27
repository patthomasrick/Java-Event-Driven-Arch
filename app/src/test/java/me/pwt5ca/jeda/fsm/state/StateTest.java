package me.pwt5ca.jeda.fsm.state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateTest {
    @Test
    void testEnter() {
        State state = new State() {

            @Override
            public void enter() {
                super.enter();
                this.setLabel("entered");
            }
        };
        state.setLabel("not entered");

        Assertions.assertEquals("not entered", state.getLabel());
        state.enter();
        Assertions.assertEquals("entered", state.getLabel());
    }

    @Test
    void testExit() {
        State state = new State() {

            @Override
            public void exit() {
                super.exit();
                this.setLabel("exited");
            }
        };
        state.setLabel("not exited");

        Assertions.assertEquals("not exited", state.getLabel());
        state.exit();
        Assertions.assertEquals("exited", state.getLabel());
    }

    @Test
    void testGetId() {
        // 1. State ID must be a non-negative integer.
        State state1 = new State();
        Assertions.assertInstanceOf(
                Integer.class,
                state1.getId(),
                "State ID must be an Integer.");
        Assertions.assertTrue(
                state1.getId() >= 0,
                "State ID must be a non-negative integer");

        // 2. State IDs must be unique.
        State state2 = new State();
        Assertions.assertNotEquals(
                state1.getId(),
                state2.getId());
    }

    @Test
    void testGetLabel() {
        // 1. State label must be initialized to empty.
        State state = new State();
        Assertions.assertEquals(
                "",
                state.getLabel(),
                "State label must be initialized to empty.");
    }

    @Test
    void testSetLabel() {
        // 1. State label must be settable.
        State state = new State();
        state.setLabel("test");
        Assertions.assertEquals(
                "test",
                state.getLabel(),
                "State label must be settable.");

        // 2. Set again.
        state.setLabel("test2");
        Assertions.assertEquals(
                "test2",
                state.getLabel(),
                "State label must be settable.");
    }

    @Test
    void testToString() {
        // 1. Convert state to a string representation, must match regex `"State(\d+,
        // \"\w+\")""`
        State state = new State("test");
        Assertions.assertTrue(
                state.toString().matches("State\\(\\d+, \"\\w+\"\\)"),
                "State must be convertible to a string representation.");
    }
}
