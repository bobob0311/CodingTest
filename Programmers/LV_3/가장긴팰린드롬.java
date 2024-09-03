class Solution {
    public int solution(String s) {
        int answer = 0;
        if (s.length() == 1) {
            return 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char v = s.charAt(i);
            int start = i - 1;

            int end;
            int count;
            end = i + 1;
            count = 1;

            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) == s.charAt(end)) {
                    count += 2;
                } else {
                    break;
                }
                start--;
                end++;
            }

            answer = Math.max(answer, count);

            if (s.charAt(i + 1) == v) {
                start = i - 1;
                end = i + 2;
                count = 2;
            }
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) == s.charAt(end)) {
                    count += 2;
                } else {
                    break;
                }
                start--;
                end++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}