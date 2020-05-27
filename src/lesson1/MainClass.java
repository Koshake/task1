package lesson1;

import com.sun.deploy.security.SelectableSecurityManager;

import java.sql.SQLOutput;

public class MainClass {
    public static void main(String[] args) {

        // task 1
        byte byteVal = 127;
        int intVal = 20000;
        long longVal = -40000L;
        float floatVal = 3.14f;
        double doubleVal = 20000.55555;
        char symbol = 'k';
        boolean boolVal = false;

        //task 2
        System.out.printf("Java types: byte %d; int %d; long %d; float %1.3f; double %5.2f; char %c; bool %b\n",
                byteVal, intVal, longVal, floatVal, doubleVal, symbol, boolVal);

        //task 3
        System.out.println("Result of task 3: " + countValue(1, 2, 3, 4));

        //task 4
        System.out.println("Result of task 4: " + checkSum(8.6, 2));

        //task 5
        printIsPositive(-6);
        printIsPositive(20);
        printIsPositive(0);

        //task 6
        final int val = -10;
        System.out.println(val + " is negative: " + isNegative(val));

        //task 7
        sayHello("Kate");

        // task 8
        printLeapYear(2020);
        printLeapYear(1000);
        printLeapYear(800);
        printLeapYear(1990);


    }

    public static double countValue(double a, double b, double c, double d) {
        double v = a * (b + (c / d));
        return v;
    }

    public static boolean checkSum(double a, double b) {
        double sum = a + b;
        if(sum >= 10 && sum <= 20)
            return true;
        else
            return false;
    }

    public static void printIsPositive(int a) {
        if(a >= 0)
            System.out.println("Positive");
        else
            System.out.println("Negative");
    }

    public static boolean isNegative(int a) {
        if(a < 0)
            return true;
        else
            return false;
    }

    public static void sayHello(String name) {
        System.out.printf("Hello, %s!%n", name);
    }

    public static void printLeapYear(int year) {
        if(year % 4 == 0  && (year % 100 != 0 || year % 400 == 0))
            System.out.printf("Year %d is leap!\n", year);
        else
            System.out.printf("Year %d is not leap!\n", year);
    }

}

