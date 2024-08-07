package Programmers.고득점kit.DFS_BFS;

class Solution {
    static int count;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, 0, target);
        return count;
    }

    static void dfs(int depth, int[] numbers, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(depth + 1, numbers, sum + numbers[depth], target);
        dfs(depth + 1, numbers, sum - numbers[depth], target);
    }
}
