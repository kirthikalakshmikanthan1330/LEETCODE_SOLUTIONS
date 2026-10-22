import java.util.*;

class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String answer = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {

                answer = list.get(mid).value;

                // We found a valid timestamp.
                // Try to find a larger valid timestamp.
                left = mid + 1;
            }
            else {
                // Timestamp is too large.
                right = mid - 1;
            }
        }

        return answer;
    }

    class Pair {

        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}