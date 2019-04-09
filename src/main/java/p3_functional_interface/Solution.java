package p3_functional_interface;

public class Solution {

    public static void main(String args[]){
        /***
         * How does lambda expressions fit into Java's type system? Each lambda corresponds to a given type, specified
         * by an interface. A so called functional interface must contain exactly one abstract method declaration. Each
         * lambda expression of that type will be matched to this abstract method. Since default methods are not abstract
         * you're free to add default methods to your functional interface.
         */

        Converter<String, Integer> converter = (from ) -> Integer.valueOf(from);
        Integer converted = converter.convert("12345");
        System.out.println(converted);

        /**
         * Keep in mind that the code is also valid if the @FunctionalInterface annotation would be omitted.
         */
    }
}
