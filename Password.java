package ss.week2;


public class Password {

    public static void main(String[] args) {
        BasicPassword testPass = new BasicPassword();
        System.out.println(testPass.testWord("gfhf"));
    }

    private String passWord;
    private Checker checker;
    private String initPass = "InitPassword2";


    /**
     * Constructor
     */
    Password(Checker checker) {
        this.checker = checker;

    }

    Password() {
        this.checker = new BasicChecker();
    }

    public String getInitPass() {
        return this.initPass;
    }

    public Checker getChecker() {
        return this.checker;
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
        return this.checker.acceptable(passWord);

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
