package p7_optionals;

import java.util.Optional;

public class Solution {
    public static void main(String args[]){
        /**
         * Optionals are not functional interfaces, but nifty utilities to prevent NullPointerException.
         * It's an important concept for the next section, so let's have a quick look at how Optionals work.
         *
         * Optional is a simple container for a value which may be null or non-null. Think of a method which may return
         * a non-null result but sometimes return nothing. Instead of returning null you return an Optional in Java 8.
         */
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
