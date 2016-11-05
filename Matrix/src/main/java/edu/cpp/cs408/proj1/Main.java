package edu.cpp.cs408.proj1;

import edu.cpp.cs408.proj1.Drivers.AdvancedDriver;
import edu.cpp.cs408.proj1.Drivers.SimpleDriver;

/**
 * @author Wai Phyo
 */
public class Main {
    public static void main(String[] args) {
        runSimpleDriver();
        System.out.println(AdvancedDriver.getInstance().performanceTest());
    }

    private static void runSimpleDriver() {
        SimpleDriver simpleDriver = SimpleDriver.getInstance();
        System.out.println("left\n" + simpleDriver.showLeft());
        System.out.println("right\n" + simpleDriver.showRight());
        System.out.println("addition\n" + simpleDriver.performAddition());
        System.out.println("subtraction\n" + simpleDriver.performSubtraction());
        System.out.println("multiplication\n" + simpleDriver.performMultiplication());
    }
}
