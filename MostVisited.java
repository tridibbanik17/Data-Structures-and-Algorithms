import java.util.Map;
import java.util.HashMap;

// Write a method that accepts an array of location strings as input and uses a SymbolTable to determine the most frequently visited location.

import java.util.Map;
import java.util.HashMap;

public class MostVisited {
    // Method to find the most frequently visited location
    public String mostVisited(String[] locations) {
        Map<String, Integer> freqTable = new HashMap<>();
        String mostFreqKey = "";
        int mostFreqValue = -1;

        for (String loc : locations) {
            int count;
            if (freqTable.containsKey(loc)) {
                count = freqTable.get(loc) + 1;
            } else {
                count = 1;
            }

            freqTable.put(loc, count);

            if (count > mostFreqValue) {
                mostFreqValue = count;
                mostFreqKey = loc;
            }
        }

        return mostFreqKey;
    }
}
