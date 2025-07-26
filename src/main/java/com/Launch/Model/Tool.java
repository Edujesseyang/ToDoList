package com.Launch.Model;

import java.time.Year;

public class Tool {
    public static int getCurrentYear() {
        return Year.now().getValue();
    }

    public static int calcAgeFormBirthYear(int birthYear) {
        return getCurrentYear() - birthYear;
    }
}
