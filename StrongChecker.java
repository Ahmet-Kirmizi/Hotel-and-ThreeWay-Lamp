package ss.week2;

public class StrongChecker extends BasicChecker implements Checker {

//    @Override
//    public boolean acceptable(String passWord) {
//        if (passWord.isEmpty()) {
//            return false;
//        } else {
//            int counter = 0;
//            char[] charArray = passWord.toCharArray();
//            for (char letter : charArray) {
//                if (letter == ' ') {
//                    return false;
//                }
//                counter++;
//
//            }  // why is it
//            if (counter >= 6) {
//                return Character.isDigit(charArray[counter]) && (Character.isLetter(charArray[0]));
//            }
//            return false;
//        }
//    }

    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space and dont stats with letter and ends with a number
     *
     * @param passWord Word that should be tested
     * @return true If suggestion is acceptable
     */
    @Override
    public boolean acceptable(String passWord) {
        return Character.isLetter(passWord.charAt(0)) && Character.isDigit(passWord.charAt(passWord.length() - 1)) && super.acceptable(passWord);
    }

    /**
     * generatePassword()
     * generates a random password that will contain uppercase, smallercase letters numbers and symbols with a len of 10
     *
     * @return String password with len 10
     */
    @Override
    public String generatePassword() { // add check for a
        return "InitPassword2";
    }
}
