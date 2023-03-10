package me.pwt5ca.jeda.fsm.transition;

import me.pwt5ca.jeda.fsm.state.State;

/**
 * A transition in a finite state machine.
 *
 * @author Patrick Thomas <patrick@patrickwthomas.net>
 */
public abstract class Transition {
    /** The source of the transition, i.e. where the edge starts. */
    protected final State source;

    /** All possible end locations. */
    protected final State[] destinations;

    /** Labels for the edges from source to dest. */
    protected String[] labels;

    /**
     * Constructs a new transition.
     *
     * Order of state transitions is not guaranteed, and this function is ran
     * before the current FSM state is exited.
     *
     * @param source
     * @param destinations
     */
    public Transition(State source, State[] destinations) {
        if (source == null || destinations == null) {
            throw new IllegalArgumentException(
                    "Source and destinations must be non-null.");
        }

        this.source = source;
        this.destinations = destinations;
        this.labels = new String[destinations.length];
    }

    protected Transition(State source, int numDestinations) {
        if (source == null) {
            throw new IllegalArgumentException(
                    "Source must be non-null.");
        }

        this.source = source;
        this.destinations = new State[numDestinations];
        this.labels = new String[numDestinations];
    }

    /**
     * Constructs a new transition.
     *
     * Order of state transitions is not guaranteed, and this function is ran
     * before the current FSM state is exited.
     *
     * @param source
     * @param destinations
     * @param labels
     */
    public Transition(State source, State[] destinations, String[] labels) {
        this(source, destinations);

        if (labels == null || labels.length != destinations.length) {
            throw new IllegalArgumentException(
                    "Labels must be non-null and have the same number of elements as destinations.");
        }

        this.labels = labels;
    }

    /**
     * Get the source state of this transition.
     *
     * @return the source state
     */
    public State getSource() {
        return this.source;
    }

    /**
     * Get the destination states of this transition.
     *
     * @return the destination states
     */
    public State[] getDestinations() {
        return this.destinations;
    }

    /**
     * Evaluate, given some input, what the output state should be.
     *
     * @param object the input
     * @return the output state
     */
    public abstract State evaluate(Object object);

    /**
     * Returns a DOT representation of this transition.
     *
     * @return a DOT representation of this transition
     */
    public String toDot() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.destinations.length; i++) {
            State dest = this.destinations[i];
            sb.append(this.source.getId());
            sb.append(" -> ");
            sb.append(dest.getId());
            if (this.labels[i] != null) {
                sb.append(" [label=\"");
                sb.append(this.labels[i]);
                sb.append("\"]");
            }

            // Add newline if not last.
            if (i < this.destinations.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
