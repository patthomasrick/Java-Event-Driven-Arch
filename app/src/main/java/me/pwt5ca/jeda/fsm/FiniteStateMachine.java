package me.pwt5ca.jeda.fsm;

/**
 * A finite state machine. Contains states and transitions.
 * 
 * @author Patrick Thomas <patrick@patrickwthomas.net>
 */
public class FiniteStateMachine {
    protected State[] states;
    protected State currentState;
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
    }

    /**
     * Get the current state of this machine.
     *
     * @return the current state
     */
    public State getCurrentState() {
        return currentState;
    }

    public void evaluate(Object object) {
        for (Transition transition : transitions) {
            if (transition.getSource() == currentState) {
                currentState.exit();
                currentState = transition.evaluate(object);
                currentState.enter();
                return;
            }
        }
    }

    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph finite_state_machine {\n");
        sb.append("rankdir=LR;\n");
        sb.append("size=\"8,5\"\n");

        // Font: monaco
        sb.append("node [style=filled, fillcolor=white, fontname=\"Monaco\"];\n");
        sb.append("edge [fontname=\"Monaco\"];\n");
        sb.append("graph [fontname=\"Monaco\"];\n");

        sb.append("node [shape = circle];\n");
        for (State state : states) {
            sb.append(state.toDot());
            sb.append("\n");
        }
        for (Transition transition : transitions) {
            sb.append(transition.toDot());
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
