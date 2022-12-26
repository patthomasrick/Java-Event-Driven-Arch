package me.pwt5ca.jeda.fsm;

/**
 * A state in a finite state machine.
 *
 * @author Patrick Thomas <patrick@patrickwthomas.net>
 */
public class State {
    private static int idCounter = 0;

    /**
     * The unique ID of this state. Is set on construction.
     */
    private int id;

    /** Custom label of the node. */
    private String label;

    /**
     * Constructs a new state.
     */
    public State() {
        this.id = State.idCounter++;
    }

    public State(String label) {
        this();
        this.label = label;
    }

    @Override
    public String toString() {
        if (this.getLabel() != null) {
            return String.format("State(%d, \"%s\")", this.getId(), this.getLabel());
        } else {
            return String.format("State(%d)", this.getId());
        }
    }

    /**
     * Returns the unique ID of this state.
     *
     * @return the unique ID of this state
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the label of this state.
     *
     * @return the label of this state
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the label of this state.
     *
     * @param label the label of this state
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public void enter() {
    }

    public void exit() {
    }

    public void update() {
    }

    /**
     * Returns a DOT representation of this state.
     *
     * @return Line that creates a node with a label in DOT
     */
    public String toDot() {
        if (this.getLabel() != null) {
            return String.format("%d [label=\"%s\"]", this.id, this.label);
        } else {
            return String.format("%d [label=\"%d\"]", this.id, this.id);
        }
    }
}
