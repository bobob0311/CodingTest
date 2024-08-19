import java.util.*;

class Solution {
    static int target;

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int people = 0;
        set.add(words[0]);
        char endChar = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            String nowWord = words[i];
            if (endChar == nowWord.charAt(0)) {
                set.add(nowWord);
            } else {
                target = i + 1;
                break;
            }
            endChar = nowWord.charAt(nowWord.length() - 1);
            if (set.size() != i + 1) {
                target = i + 1;
                break;
            }
        }
        if (target != 0) {
            if (target % n == 0) {
                people = n;
                target = (target / n);
            } else {
                people = (target % n);
                target = (target / n) + 1;
            }
        }

        int[] answer = new int[] { people, target };
        return answer;
    }
}