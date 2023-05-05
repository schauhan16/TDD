package org.sc.test;

public class FizzBuzz {
    public String get(int i) {
        boolean multipleOf3 = i % 3 == 0;
        boolean multipleOf5 = i % 5 == 0;
        if (multipleOf5 && multipleOf3)
            return "org.sc.test.FizzBuzz";
        if (multipleOf3) {
            return "Fizz";
        }
        if (multipleOf5)
            return "Buzz";

        return String.valueOf(i);
    }
}
