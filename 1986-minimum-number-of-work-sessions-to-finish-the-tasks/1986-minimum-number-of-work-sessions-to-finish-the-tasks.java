class Solution {

    int answer;

    public int minSessions(int[] tasks, int sessionTime) {

        // Initially, the maximum possible sessions
        // is the number of tasks
        answer = tasks.length;

        // Store the time used in each session
        int[] sessions = new int[tasks.length];

        // Start from the first task
        solve(tasks, sessionTime, 0, sessions, 0);

        return answer;
    }

    public void solve(int[] tasks, int sessionTime,
                      int index, int[] sessions, int count) {

        // All tasks are completed
        if (index == tasks.length) {

            answer = Math.min(answer, count);

            return;
        }

        // Try putting the current task
        // into every existing session
        for (int i = 0; i < count; i++) {

            // Check whether the task fits
            if (sessions[i] + tasks[index] <= sessionTime) {

                // Add the task
                sessions[i] += tasks[index];

                // Process the next task
                solve(tasks, sessionTime,
                      index + 1, sessions, count);

                // Backtrack
                sessions[i] -= tasks[index];
            }
        }

        // Try creating a new session
        sessions[count] = tasks[index];

        // Process the next task
        solve(tasks, sessionTime,
              index + 1, sessions, count + 1);

        // Backtrack
        sessions[count] = 0;
    }
}