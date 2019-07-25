package p6_builtIn_functional_interfaces;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Solution {

    public static void main(String args[]){
        /**
         * The JDK 1.8 API contains many built-in functional interfaces. Some of them are well known from older versions
         * of Java like Comparator or Runnable. Those existing interfaces are extended to enable Lambda support via the
         * @FunctionalInterface annotation.
         *
         * But the Java 8 API is also full of new functional interfaces to make your life easier. Some of those new
         * interfaces are well known from the Google Guava library. Even if you're familiar with this library you should
         * keep a close eye on how those interfaces are extended by some useful method extensions.
         *
         *
         * Predicates
         * Predicates are boolean-valued functions of one argument. The interface contains various default methods for
         * composing predicates to complex logical terms (and, or, negate)
         *
         * Predicate<String> predicate = (s) -> s.length() > 0;
         *
         * predicate.test("foo");              // true
         * predicate.negate().test("foo");     // false
         *
         * Predicate<Boolean> nonNull = Objects::nonNull;
         * Predicate<Boolean> isNull = Objects::isNull;
         *
         * Predicate<String> isEmpty = String::isEmpty;
         * Predicate<String> isNotEmpty = isEmpty.negate();
         *
         */
        Predicate<String> predicate = (s)->s.length() > 0;
        System.out.println(predicate.test("ABC"));
        System.out.println(predicate.test(""));
        System.out.println(predicate.negate().test("ABC"));
        // Write few more example here
        System.out.println("********************************************************************************************");


        /**
         * Functions
         * Functions accept one argument and produce a result. Default methods can be used to chain multiple functions
         * together (compose, andThen).
         */
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String,String> backToString = toInteger.andThen(String::valueOf);

        Integer a = toInteger.apply("123");
        System.out.println(a);
        String str = backToString.apply("123");
        System.out.println(str);
        System.out.println("********************************************************************************************");

        /**
         * Suppliers
         * Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.
         */
        Supplier<Person> personSupplier =  Person::new;
        personSupplier.get();


        /**
         * Consumers
         * Consumers represent operations to be performed on a single input argument.
         */
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));

        /**
         * Comparators
         * Comparators are well known from older versions of Java. Java 8 adds various default methods to
         * the interface.
         *
         * Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
         *
         * Person p1 = new Person("John", "Doe");
         * Person p2 = new Person("Alice", "Wonderland");
         *
         * comparator.compare(p1, p2);             // > 0
         * comparator.reversed().compare(p1, p2);  // < 0
         */
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1,p2));                  // > 0
        System.out.println(comparator.reversed().compare(p1,p2));       // < 0
    }
}
