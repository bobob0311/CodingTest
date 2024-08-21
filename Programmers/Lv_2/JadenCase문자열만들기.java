class Solution {
    public String solution(String s) {
        String[] str = s.split(" ", -1);
        String answer = "";

        for (String target : str) {
            if (target.equals("")) {
                answer += " ";
                continue;
            }
            // 첫 글자
            String temp = String.valueOf(target.charAt(0));
            temp = temp.toUpperCase();

            // 나머지
            String temp2 = "";
            if (target.length() > 1) {
                temp2 = target.substring(1);
                temp2 = temp2.toLowerCase();
            }

            if (answer.equals("")) {
                answer += temp + temp2;
            } else {
                answer = answer + " " + temp + temp2;
            }
        }
        return answer;
    }
}