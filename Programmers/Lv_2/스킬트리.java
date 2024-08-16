import java.util.*;

class Solution {
    static int count = 0;

    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            map.put(c, i);
        }

        for (String st : skill_trees) {
            boolean chk = true;
            int pre = 0;
            for (int i = 0; i < st.length(); i++) {
                char c = st.charAt(i);
                if (map.get(c) != null) {
                    int temp = map.get(c);
                    if (pre == temp) {
                        pre++;
                    } else {
                        chk = false;
                        break;
                    }
                }
            }
            if (chk) {
                count++;
            }
        }

        return count;
    }
}