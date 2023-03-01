package ss.week2.hotel.password;

import java.util.Random;

public class BasicChecker implements Checker {


    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space.
     *
     * @param passWord Word that should be tested
     * @return true If suggestion is acceptable
     */
    @Override
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
     * generatePassword()
     * generates a random password that will contain uppercase, smallercase letters numbers and symbols with a len of 10
     * @return String password with len 10
     */
    public String generatePassword() {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = upperLetters.toLowerCase();
        String numbers = "1234567890";
        String specialSigns = "!@#$%^&*()_+=-}{:;></|";
        String allVal = upperLetters + lowerLetters + numbers + specialSigns;
        int length = 10;
        char[] chars = new char[length];
        Random rand = new Random();  // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        for (int i = 0; i < length; i++) {
            chars[i] = allVal.charAt(rand.nextInt(allVal.length()));
        }
        StringBuilder result = new StringBuilder();
        for (char letter : chars) {
            result.append(letter);
        }
        return result.toString();
    }
}



