import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Base safety check
        if (s.length() < p.length()) return result;

        // 1. Target map: Push elements of p into targetMap using your exact syntax
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int k = 0; k < p.length(); k++) {
            targetMap.put(p.charAt(k), targetMap.getOrDefault(p.charAt(k), 0) + 1);
        }

        // 2. Window map: Build the very first window of length p.length() from string s
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (int k = 0; k < p.length(); k++) {
            windowMap.put(s.charAt(k), windowMap.getOrDefault(s.charAt(k), 0) + 1);
        }

        // Check if the very first window matches
        if (windowMap.equals(targetMap)) {
            result.add(0);
        }

        // 3. The Slide: Move the window one character at a time across string s
        for (int i = p.length(); i < s.length(); i++) {
            // Add the new character entering the front of the window
            char newChar = s.charAt(i);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            // Drop the old character leaving the back of the window
            char oldChar = s.charAt(i - p.length());
            if (windowMap.get(oldChar) == 1) {
                windowMap.remove(oldChar); // Clean up to ensure map equals() works perfectly
            } else {
                windowMap.put(oldChar, windowMap.get(oldChar) - 1);
            }

            // If the updated sliding window perfectly matches our target, grab the index
            if (windowMap.equals(targetMap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}