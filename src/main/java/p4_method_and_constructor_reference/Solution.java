package p4_method_and_constructor_reference;

public class Solution {

    public static void main(String args[]){

        /**
         * The above example code can be further simplfied by utilizing static method references:
         */
        Converter<String,Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("124");
        System.out.println(converted);

        /**
         * Java 8 enables you to pass references of methods or constructors via the :: keyword. The above example shows
         * how to reference a static method. But we can also reference object methods:
         */
        Something something = new Something();
        Converter<String, String> converter1 = something::startsWith;
        String converted1 = converter1.convert("Java");
        System.out.println(converted1);
        System.out.println("********************************************************************************************");
        System.out.println("********************************************************************************************");


        /**
         * Instead of implementing the factory manually, we glue everything together via constructor references:
         */
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter","Parker");
        /**
         * We create a reference to the Person constructor via Person::new. The Java compiler automatically chooses the
         * right constructor by matching the signature of PersonFactory.create.
         */


    }
}
