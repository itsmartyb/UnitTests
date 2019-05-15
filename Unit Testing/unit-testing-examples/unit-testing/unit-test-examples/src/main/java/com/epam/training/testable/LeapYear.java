package com.epam.training.testable;

public class LeapYear {

    public boolean isLeapYear(int year) {
        boolean normalLeapYear = year % 4 == 0;
        boolean notLeapYear = year % 100 == 0;
        boolean alwaysLeapYear = year % 400 == 0;
        return alwaysLeapYear || (normalLeapYear && !notLeapYear);
    }
}
