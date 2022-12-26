package me.pwt5ca.jeda.fsm;

public class DebugState extends State {
    /**
     * Empty constructor.
     */
    public DebugState() {
    }

    /**
     * Constructor with label.
     * 
     * @param label
     */
    public DebugState(String label) {
        super(label);
    }

    @Override
    public void enter() {
        super.enter();

        System.out.println("Entered state " + this);
    }

    @Override
    public void exit() {
        super.exit();

        System.out.println("Exited state " + this);
    }
}
