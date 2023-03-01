package ss.week2;


public class BasicPassword {

    public static void main(String[] args) {
        BasicPassword testPass = new BasicPassword();
        System.out.println(testPass.testWord("gfhf"));
    }

    private String passWord;

    public static final String INITIAL = "InitialPassword";

    /**
     * Constructor
     * sets passWord in newly created instance of BasicPassword to INITIAL
     */
    BasicPassword() {
        this.passWord = INITIAL;
    }

    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space.
     *
     * @param passWord Word that should be tested
     * @return true If suggestion is acceptable
     */

    public boolean acceptable(String passWord) {
        if (passWord.isEmpty()) {
            return false;
        } else {
            int counter = 0;
            char[] charArray = passWord.toCharArray();
            for (char letter : charArray) {
                if (letter == ' ') {
                    return false;
                }
                counter++;
            }
            return counter >= 6;
        }
    }

    /**
     * Changes this password.
     *
     * @param oldPass The current password
     * @param newPass The new password
     * @return true If oldPass is equal to the current password and newPass is an acceptable password
     */
    public boolean setWord(String oldPass, String newPass) {
        if (acceptable(newPass) && testWord(oldPass)) {
            this.passWord = newPass;
            return true;

        } else {
            return false;
        }
    }

    /**
     * Tests if a given word is equal to the current password.
     *
     * @param givenPass Word that should be tested
     * @return true If test is equal to the current password
     */
    public boolean testWord(String givenPass) {
        return givenPass.equals(this.passWord);
    }


}
