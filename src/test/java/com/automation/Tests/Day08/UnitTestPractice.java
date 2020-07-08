package com.automation.Tests.Day08;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {

        //unit test
        //to check if our method work properly
        //if assertion fails, that means our method doesn't work correctly
        //that means we have to fix the method
        System.out.println(reverseString("apple"));
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        //Assertion
        verifyEquals(expected, actual);

    }

    //annotation
    //description - is not working for JUnit, make sure that use testNG
    @Test(description = "Verify if method can reverse a string")
    public void test() {
        String expected = "elppa";
        String actual = reverseString("apple");
        //it's coming from testNG, JUnit also has this class
        //you can compare any data types here: strings, primitives, arrays, objects
        //to verify if expected result is equals to actual
        Assert.assertEquals(actual, expected);

    }

    @Test(description = "Verify if method can reverse a string")
    public void test2() {
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual, expected);
    }

    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("TEST FAILED!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
            return false;

        }
    }

    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

}
