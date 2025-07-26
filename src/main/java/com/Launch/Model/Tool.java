package com.Launch.Model;

import java.time.Year;
import java.util.Set;

public class Tool {
    public static int getCurrentYear() {
        return Year.now().getValue();
    }

    public static int calcAgeFormBirthYear(int birthYear) {
        return getCurrentYear() - birthYear;
    }

    public static boolean passwordValidCheck(String password, String confirm) {
        Set<Character> forbiddenChar = Set.of('<', ',', '>', '.', '?', '/', ':', ';', '\'', '"', '`', '~', '\\', '|');

        int len = password.length();
        if (!password.equals(confirm) || len < 8) {
            return false;
        }

        int numCount = 0;
        int upperCaseCount = 0;
        int lowerCaseCount = 0;

        for (Character c : password.toCharArray()) {
            if (Character.isWhitespace(c) || forbiddenChar.contains(c)) {
                return false;
            } else if (Character.isDigit(c)) {
                numCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            }
        }

        return numCount >= 2 && upperCaseCount >= 2 && lowerCaseCount >= 2;
    }
}
