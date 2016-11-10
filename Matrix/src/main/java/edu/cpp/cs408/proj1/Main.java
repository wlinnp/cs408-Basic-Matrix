package edu.cpp.cs408.proj1;

import edu.cpp.cs408.proj1.Drivers.AdvancedDriver;
import edu.cpp.cs408.proj1.Drivers.SimpleDriver;
import edu.cpp.cs408.proj1.Drivers.UserDriver;

import java.util.Scanner;

/**
 * @author Wai Phyo
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("wanna see the basic and performance test? 0 for No, others for Yes");
        if ((new Scanner(System.in)).nextInt() != 0) {
            runSimpleDriver();
            System.out.println(AdvancedDriver.getInstance().performanceTest());
        }
        new UserDriver();
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
