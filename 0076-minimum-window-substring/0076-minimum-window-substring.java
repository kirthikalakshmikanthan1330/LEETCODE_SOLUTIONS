import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Store the characters required from t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        // Expand the window using right
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Character requirement is completely satisfied
            if (need.containsKey(ch)
                    && window.get(ch).intValue() == need.get(ch).intValue()) {

                formed++;
            }

            // Window is valid → try to shrink it
            while (formed == need.size()) {

                // Save the smallest window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                // Removing this character made the window invalid
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {

                    formed--;
                }

                left++;
            }
        }

        // No valid window found
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}