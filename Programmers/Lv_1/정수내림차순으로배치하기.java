import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}