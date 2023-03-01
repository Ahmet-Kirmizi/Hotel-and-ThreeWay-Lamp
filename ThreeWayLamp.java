package ss.week2;

import java.util.Scanner;


/**
 * ThreeWayLamp models a lamp that is either off, or in one
 * of three states: low, medium, or high.  Clients may query
 * the lamp for its state, or have it cycle through its states.
 */
public class ThreeWayLamp {
    public enum lampStatus {
        off,
        low,
        medium,
        high
    }

    private lampStatus lamplevel;


    /**
     * constructor that sets the lamp to off
     *
     * @ensures lampLevel == lampStatus.off = off
     */
    public ThreeWayLamp() {
        this.lamplevel = lampStatus.off;
    }

    public void setSetting(lampStatus status) {
        this.lamplevel = status;

    }
    /**
     * @return the current state of the lamp
     * @ensures lampLevel == lampStatus.off ||
     * lampLevel == lampStatus.low || lampLevel == lampStatus.medium || lampLevel == lampStatus.high
     */

    /**
     * @return the current state of the lamp
     */

    public lampStatus getLamplevel() {
        return this.lamplevel;

    }

    /**
     * changed the level of the lamp using this schema: off-low-medium-high
     *
     * @return the new state of the lamp after the changes
     * @ensures changeLevel() == /oldchangeLevel() + 1
     */
    public lampStatus changeLevel() {
        switch (this.lamplevel) {
            case off:
                this.lamplevel = lampStatus.low;
                return this.lamplevel;

            case low:
                this.lamplevel = lampStatus.medium;
                return this.lamplevel;
            case medium:
                this.lamplevel = lampStatus.high;
                return this.lamplevel;
            case high:
                this.lamplevel = lampStatus.off;
                return this.lamplevel;
        }
        return this.lamplevel;
    }


}