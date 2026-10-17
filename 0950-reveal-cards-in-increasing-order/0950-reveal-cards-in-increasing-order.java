import java.util.*;
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int index = queue.poll();
            answer[index] = deck[i];
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return answer;
    }
}