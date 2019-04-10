package p5_lambda_scopes;



public class Solution {

    static int outerStaticNum;
    int outerNum;

    public static void main(String args[]){
        /**
         * Accessing outer scope variables from lambda expressions is very similar to anonymous objects. You can access
         * final variables from the local outer scope as well as instance fields and static variables.
         *
         * We can read final local variables from the outer scope of lambda expression:
         */

        final int num = 1;
        Converter<Integer,String> stringConverter = (from )-> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));
        System.out.println("*******************************************************************************************");

        /**
         * But different to anonymous object the variable num does not have to be declared final. This code is also valid:
         */
        int num1 = 1;
        Converter<Integer,String>  stringConverter1 = (from) -> String.valueOf(from + num1);
        System.out.println(stringConverter1.convert(2));
        System.out.println("*******************************************************************************************");

        /**
         * However num must be implicitly final for the code to compile. The following code does not compile:
         *
         * Error : Error:(34, 86) java: local variables referenced from a lambda expression must be final or effectively final
         *
         * Writing to num from within the lambda expression is also prohibited.
         */
//        int num2 = 1;
//        Converter<Integer,String> stringConverter2 = (from) -> String.valueOf(from + num2);
//        System.out.println(stringConverter2.convert(2));
//        num2 = 0;

        /**
         * Plz read the method testScopes() first.
         */

        /**
         *Accessing Default Interface Methods
         * Remember the formula example from the first section? Interface Formula defines a default method sqrt which
         * can be accessed from each formula instance including anonymous objects. This does not work with lambda expressions.
         *
         * Default methods cannot be accessed from within lambda expressions. The following code does not compile:
         */
        //Formula formula = (a) -> sqrt(a * 100);


    }

    void testScopes(){
        /**
         * Accessing fields and static variables
         * In contrast to local variables, we have both read and write access to instance fields and static variables
         * from within lambda expressions. This behaviour is well known from anonymous objects.
         */
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
