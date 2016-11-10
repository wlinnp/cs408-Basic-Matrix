package edu.cpp.cs408.proj1.Drivers;

import java.util.Random;

/**
 * @author Wai Phyo
 */
public class Utils {
    public static final String TAB_CHARACTER = "\t\t";
    public static final String NEXT_LINE_CHARACTER = "\n";
    private Random random;
    private static Utils INSTANCE;

    private Utils() {
        random = new Random();
    }

    public static Utils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Utils();
        }
        return INSTANCE;
    }

    public double getRandom(final int lowerBound, final int upperBound) {
        return lowerBound + (random.nextDouble() * (upperBound - lowerBound));
    }
}
