package p1_default_methods;

public class Solution {

    public static void main(String args[]){
        /***
         * Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the default keyword.
         * This feature is also known as virtual extension methods.
         *
         * Besides the abstract method "calculate" the interface "Formula" also defines the default method "sqrt".
         * Concrete classes only have to implement the abstract method "calculate". The default method "sqrt" can be
         * used out of the box.
         */

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));

        /***
         * The formula is implemented as an anonymous object. The code is quite verbose: 6 lines of code for such a
         * simple calculation of sqrt(a * 100). As we'll see in the next section, there's a much nicer way of
         * implementing single method objects in Java 8.
         */
    }
}
