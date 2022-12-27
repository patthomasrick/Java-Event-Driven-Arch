package me.pwt5ca.jeda.fsm.transition;

import me.pwt5ca.jeda.fsm.state.State;

/**
 * A transition that evaluates to one of two states based on a boolean input.
 *
 * @author Patrick Thomas <patrick@patrickwthomas.net>
 */
public class BinaryTransition extends Transition {
    public BinaryTransition(State source, State trueDestination, State falseDestination) {
        super(source, new State[] { trueDestination, falseDestination });

        this.labels[0] = "true";
        this.labels[1] = "false";
    }

    @Override
    public State evaluate(Object object) {
        if (object instanceof Boolean) {
            return this.destinations[(Boolean) object ? 0 : 1];
        }
        return null;
    }
}
