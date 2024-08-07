package Programmers.고득점kit.DFS_BFS;

import java.util.*;

class Solution {
    class Info {
        String word;
        int count;

        Info(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        Queue<Info> que = new LinkedList<>();

        int length = begin.length();
        que.add(new Info(begin, 0));
        visited = new boolean[words.length];
        int count = 0;

        while (!que.isEmpty()) {
            Info now = que.poll();

            String nowWord = now.word;
            int nowCount = now.count;

            if (nowWord.equals(target)) {
                return nowCount;
            }
            for (int i = 0; i < words.length; i++) {
                int c = 0;
                if (visited[i] == true) {
                    continue;
                }
                for (int j = 0; j < length; j++) {
                    if (words[i].charAt(j) != nowWord.charAt(j)) {
                        c++;
                    }
                    if (c >= 2) {
                        break;
                    }
                }
                if (c == 1) {
                    visited[i] = true;
                    que.add(new Info(words[i], nowCount + 1));
                }

            }
        }

        return 0;
    }
}
