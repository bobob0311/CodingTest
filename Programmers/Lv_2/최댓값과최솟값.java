class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);
        for (String target : str) {
            int value = Integer.parseInt(target);
            max = Math.max(value, max);
            min = Math.min(value, min);
        }
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}