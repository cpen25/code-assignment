package com.securepay.assignment.util;

import java.util.Random;

public class MathUtil {

    /**
     * method to generate random int data between a and b
     * @param a
     * @param b
     * @return
     */
    public static int generateIntRandom(int a, int b) {
        return a + (int) (new Random().nextFloat() * (b - a));
    }

}
