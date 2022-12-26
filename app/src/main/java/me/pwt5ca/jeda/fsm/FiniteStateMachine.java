package me.pwt5ca.jeda.fsm;

/**
 * A finite state machine. Contains states and transitions.
 * 
 * @author Patrick Thomas <patrick@patrickwthomas.net>
 */
public class FiniteStateMachine {
    /** States in the machine. */
    protected State[] states;

    /** The current state of the machine. */
    protected State currentState;

    /** The end state of the machine that means the input string is recognized. */
    protected State endState;

    /**
     * The transitions of the machine. Each transition has a source state and
     * one or more destinations.
     */
    protected Transition[] transitions;

    /**
     * Constructs a new finite state machine.
     *
     * @param states      the states of this machine
     * @param transitions the transitions of this machine
     */
    public FiniteStateMachine(State[] states, Transition[] transitions) {
        this.states = states;
        this.transitions = transitions;

        // Assume state 0 is the start state.
        this.currentState = states[0];
    }

    /**
     * Get the current state of this machine.
     *
     * @return the current state
     */
    public State getCurrentState() {
        return this.currentState;
    }

    /**
     * Determine if the current input string is recognized by this machine.
     * 
     * @return true if the current input string is recognized by this machine
     */
    public Boolean inEndState() {
        return this.currentState == this.endState;
    }

    /**
     * Evaluate the current input string.
     *
     * @param object the current input string
     */
    public void evaluate(Object object) {
        for (Transition transition : this.transitions) {
            if (transition.getSource() == this.currentState) {
                State newState = transition.evaluate(object);
                if (newState == null) {
                    continue;
                }

                this.currentState.exit();
                this.currentState = newState;
                this.currentState.enter();
                return;
            }
        }
    }

    /**
     * Evaluate a whole input string.
     * 
     * @param objects
     */
    public void evaluateMany(Iterable<Object> objects) {
        for (Object object : objects) {
            this.evaluate(object);
        }
    }

    /**
     * Returns a DOT representation of this machine.
     *
     * @return the DOT representation
     */
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph finite_state_machine {\n");
        sb.append("rankdir=LR;\n");
        sb.append("size=\"8,5\"\n");

        // Font: monaco
        sb.append("node [style=filled, fillcolor=white, fontname=\"Monaco\"];\n");
        sb.append("edge [fontname=\"Monaco\"];\n");
        sb.append("graph [fontname=\"Monaco\"];\n");

        sb.append("node [shape = oval];\n");
        for (State state : this.states) {
            sb.append(state.toDot());
            sb.append("\n");
        }
        for (Transition transition : this.transitions) {
            sb.append(transition.toDot());
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
