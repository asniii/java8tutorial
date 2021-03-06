package p8_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Solution {

    public static void main(String args[]){
        /**
         * A java.util.Stream represents a sequence of elements on which one or more operations can be performed. Stream
         * operations are either intermediate or terminal. While terminal operations return a result of a certain type,
         * intermediate operations return the stream itself so you can chain multiple method calls in a row. Streams are
         * created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). Stream
         * operations can either be executed sequentially or parallely.
         *
         * Let's first look how sequential streams work. First we create a sample source in form of a list of strings:
         */

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        /**
         * Collections in Java 8 are extended so you can simply create streams either by calling Collection.stream() or
         * Collection.parallelStream(). The following sections explain the most common stream operations.
         *
         * Filter
         * Filter accepts a predicate to filter all elements of the stream. This operation is intermediate which enables
         * us to call another stream operation (forEach) on the result. ForEach accepts a consumer to be executed for
         * each element in the filtered stream. ForEach is a terminal operation. It's void, so we cannot call another
         * stream operation.
         */
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println("********************************************************************************************");

        /**
         * Sorted is an intermediate operation which returns a sorted view of the stream. The elements are sorted in
         * natural order unless you pass a custom Comparator.
         *
         * Keep in mind that sorted does only create a sorted view of the stream without manipulating the ordering of
         * the backed collection. The ordering of stringCollection is untouched:
         */
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println("********************************************************************************************");


        /**
         * Map
         *
         * The intermediate operation map converts each element into another object via the given function. The following
         * example converts each string into an upper-cased string. But you can also use map to transform each object
         * into another type. The generic type of the resulting stream depends on the generic type of the function you pass
         * to map.
         */
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b) -> b.compareTo(a))
                .forEach(System.out::println);
        System.out.println("********************************************************************************************");


        /**
         * Match
         *
         * Various matching operations can be used to check whether a certain predicate matches the stream. All of those
         * operations are terminal and return a boolean result.
         */
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch(s-> s.startsWith("a"));
        System.out.println(anyStartsWithA);

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA);

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch( s -> s.startsWith("a"));
        System.out.println(noneStartsWithZ);
        System.out.println("********************************************************************************************");

        /**
         * Count
         *
         * Count is a terminal operation returning the number of elements in the stream as a long.
         */
        long startsWithB = stringCollection
                .stream()
                .filter(s -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);
        System.out.println("********************************************************************************************");

        /**
         * Reduce
         *
         * This terminal operation performs a reduction on the elements of the stream with the given function. The
         * result is an Optional holding the reduced value.
         */
        Optional<String> reduced = stringCollection
                .stream()
                .sorted()
                .reduce((s1,s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);


    }
}
