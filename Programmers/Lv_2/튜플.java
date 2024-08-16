import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] arr = s.split(",");
        for (String str : arr) {
            if (map.get(str) != null) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        int[] answer = new int[map.size()];

        for (String key : map.keySet()) {
            answer[map.size() - map.get(key)] = Integer.parseInt(key);
        }

        return answer;
    }
}
