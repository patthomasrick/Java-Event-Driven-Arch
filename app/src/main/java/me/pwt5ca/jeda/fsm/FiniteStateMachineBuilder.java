package me.pwt5ca.jeda.fsm;

import java.util.ArrayList;
import java.util.List;

/**
 * A builder for finite state machines.
 *
 * @author Patrick Thomas <patrick@patrickwthomas.net>
 */
public class FiniteStateMachineBuilder {
    protected List<State> states;
    protected List<Transition> transitions;

    public FiniteStateMachineBuilder() {
        this.states = new ArrayList<State>();
        this.transitions = new ArrayList<Transition>();
    }

    public State newState() {
        State newState = new State() {
        };
        this.states.add(newState);
        return newState;
    }

    public Transition addBinaryTransition(State source, State trueDestination, State falseDestination) {
        Transition newTransition = new BinaryTransition(source, trueDestination, falseDestination);
        this.transitions.add(newTransition);
        return newTransition;
    }

    public FiniteStateMachine build() {
        FiniteStateMachine fsm = new FiniteStateMachine(
                this.states.toArray(new State[this.states.size()]),
                this.transitions.toArray(new Transition[this.transitions.size()]));
        return fsm;
    }
}
