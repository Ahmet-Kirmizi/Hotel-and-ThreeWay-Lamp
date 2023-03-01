package ss.week2;

import java.util.Scanner;
/**
 * This class records an amount of money as dollars and cents.
 */
public class DollarsAndCentsCounter {
    int dollars, cents;

    public DollarsAndCentsCounter() {
        this.dollars = 0;
        this.cents = 0;
    }
    /**
     * Return the amount of getDollars.
     * @return the amount of getDollars
     */
    //@ ensures \result >= 0;
    public int getDollars() {
        return this.dollars;
    }

    /**
     * Return the amount of cents.
     * @return the amount of cents
     */
    //@ ensures \result >= 0 && \result < 100;
    public int getCents() {
        return this.cents;
    }

    /**
     * Add the specified amount of dollars and cents to this counter.
     *
     * @param dollars the amount of dollars to add
     * @param cents   the amount of cents to add
     */
    //@ ensures getDollars() * 100 + getCents() == \old(getDollars() * 100 + getCents()) + dollars * 100 + cents;
    public void add(int dollars, int cents) {
        this.dollars += dollars;
        this.cents += cents;
        if (this.cents >= 100) {
            this.dollars += this.cents / 100;
            this.cents = this.cents % 100;
        }
    }

    /**
     * Reset this counter to 0.
     * @ ensures getDollars(dollars) == 0 && getCents(cents) == 0;
     */
    public void reset() {
        this.dollars = 0;
        this.cents = 0;
    }


}