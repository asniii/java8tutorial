package p91_maps;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String args[]){
        /**
         * As already mentioned maps do not directly support streams. There's no stream() method available on the Map
         * interface itself, however you can create specialized streams upon the keys, values or entries of a map via
         * map.keySet().stream(), map.values().stream() and map.entrySet().stream().
         *
         * Furthermore maps support various new and useful methods for doing common tasks.
         */
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        for(int i = -5; i<15;i++){
            map.putIfAbsent(i,"sub" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
        System.out.println("********************************************************************************************");

        /**
         * The above code should be self-explaining: putIfAbsent prevents us from writing additional if null checks;
         * forEach accepts a consumer to perform operations for each value of the map.
         *
         * This example shows how to compute code on the map by utilizing functions:
         */
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));             // val33

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));     // false

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));    // true

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));             // val33
        System.out.println("********************************************************************************************");

        /**
         * Next, we learn how to remove entries for a given key, only if it's currently mapped to a given value:
         */
        map.remove(3, "val3");
        System.out.println(map.get(3));             // val33

        map.remove(3, "val33");
        System.out.println(map.get(3));             // null

        /**
         * Another helpful method:
         */
        System.out.println(map.getOrDefault(42, "not found"));  // not found

        /**
         * Merging entries of a map is quite easy:
         */
        map.merge(9, "val90", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));

    }
}
