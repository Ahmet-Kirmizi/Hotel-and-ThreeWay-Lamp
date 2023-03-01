package ss.week2;

public interface Checker {
    /**
     * Passes if fulfill criteria
     * @param arg
     * @return true if the arg is acceptable false otherwise
     */
    public boolean acceptable(String arg);

    /**
     * Generate password
     * @return correct pass for a class
     */

    public String generatePassword();
}

