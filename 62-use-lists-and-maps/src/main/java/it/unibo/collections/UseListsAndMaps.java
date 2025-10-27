package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int LIST_START = 1000;
    private static final int LIST_END = 2000;
    private static final int N_TEST_INSERTS = 100_000;
    private static final int N_TEST_GET = 1000;
    private static final int INDEX_TEST_GET = 51_000;
    // Avoid "Magic Numbers" in code    
    private static final int AFRICA_POP = 1_110_635_000; 
    private static final int AMERICAS_POP = 972_005_000;
    private static final int ANTARCTICA_POP = 0;
    private static final int EUROPE_POP = 742_452_000;
    private static final int OCEANIA_POP = 38_304_000;
    private static final long ASIA_POP = 4_298_723_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arrayList = new ArrayList<>();
        for (int i = LIST_START; i < LIST_END; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int first = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, first);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        StringBuilder sb = new StringBuilder();
        for (int integer : arrayList) {
            sb.append(integer + " ");
        }
        System.out.println(sb);
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < N_TEST_INSERTS; i++) {
            arrayList.addFirst(i);
        }
        time = System.nanoTime() - time;
        printPerformance("Inserting", "ArrayList", N_TEST_INSERTS, time);
        time = System.nanoTime();
        for (int i = 0; i < N_TEST_INSERTS; i++) {
            linkedList.addFirst(i);
        }
        time = System.nanoTime() - time;
        printPerformance("Inserting", "LinkedList", N_TEST_INSERTS, time);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        // ArrayList
        time = System.nanoTime();
        for (int i = 0; i < N_TEST_GET; i++) {
            arrayList.get(INDEX_TEST_GET);
        }
        time = System.nanoTime() - time;
        printPerformance("Getting", "ArrayList", INDEX_TEST_GET, time);
        // LinkedList
        time = System.nanoTime();
        for (int i = 0; i < N_TEST_GET; i++) {
            linkedList.get(INDEX_TEST_GET);
        }
        time = System.nanoTime() - time;
        printPerformance("Getting", "LinkedList", INDEX_TEST_GET, time);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Number> continentsPopulation = new HashMap<>();
        continentsPopulation.put("Africa", AFRICA_POP);
        continentsPopulation.put("Americas", AMERICAS_POP);
        continentsPopulation.put("Antarctica", ANTARCTICA_POP);
        continentsPopulation.put("Asia", ASIA_POP);
        continentsPopulation.put("Europe", EUROPE_POP);
        continentsPopulation.put("Oceania", OCEANIA_POP);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for (Number continentPopulation : continentsPopulation.values()) {
            worldPopulation += continentPopulation.longValue();
        }
        System.err.println(worldPopulation);
    }

    private static void printPerformance(String test_type, String collection_type, int test_param, long time) {
        System.out.println(
            test_type + " "
                    + test_param
                    + "th element in a " + collection_type + " took "
                    + time
                    + "ns ("
                    + TimeUnit.NANOSECONDS.toMillis(time)
                    + "ms)");
    }
}