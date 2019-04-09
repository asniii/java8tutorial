package p2_lambda_expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String args[]) {

        /**
         * Let's start with a simple example of how to sort a list of strings in prior versions of java.
         *
         * The static utility method Collections.sort accepts a list and a comparator in order to sort the elements
         * of the given list. You often find yourself creating anonymous comparators and pass them to the sort method.
         */
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        /**
         * *************************************************************************************************************
         * Instead of creating anonymous objects all day long, Java 8 comes with a much shorter syntax, lambda expressions:
         */
        List<String> names1 = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names1, (String a, String b)->{
            return b.compareTo(a);
        });
        System.out.println(names1);

        /**
         * As you can see the code is much shorter and easier to read. But it gets even shorter:
         *
         * Collections.sort(names, (String a, String b) -> b.compareTo(a));
         * For one line method bodies you can skip both the braces {} and the return keyword. But it gets even shorter:
         *
         * names.sort((a, b) -> b.compareTo(a));
         * List now has a sort method. Also the java compiler is aware of the parameter types so you can skip them as
         * well. Let's dive deeper into how lambda expressions can be used in the wild.
         */
    }
}
