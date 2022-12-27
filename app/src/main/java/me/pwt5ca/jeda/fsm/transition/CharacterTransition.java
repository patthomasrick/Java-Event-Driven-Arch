package me.pwt5ca.jeda.fsm.transition;

import java.util.Map;

import me.pwt5ca.jeda.fsm.state.State;

/**
 * A transition in a finite state machine that accepts a single character.
 */
public class CharacterTransition extends Transition {
    protected final Map<Character, State> destinationMap;

    public CharacterTransition(State source, Map<Character, State> destinationMap) {
        super(source, destinationMap != null ? destinationMap.size() : 0);

        if (destinationMap == null) {
            throw new IllegalArgumentException(
                    "Destination map must be non-null.");
        }

        int count = 0;
        for (Character c : destinationMap.keySet()) {
            this.labels[count] = c.toString();
            this.destinations[count] = destinationMap.get(c);

            count++;
        }

        this.destinationMap = destinationMap;
    }

    @Override
    public State evaluate(Object object) {
        if (object instanceof Character) {
            return this.destinationMap.get(object);
        } else if (object instanceof String) {
            String s = (String) object;
            if (s.length() == 1) {
                return this.destinationMap.get(s.charAt(0));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
