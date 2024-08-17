import java.util.*;

/*
출력을 책임지는 List가 필요
사전 추가 및 조회가 가능한 Map이 필요


*/

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new LinkedList<>();

        String oneWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // 기본 단어 넣기
        for (int i = 0; i < oneWord.length(); i++) {
            String v = String.valueOf(oneWord.charAt(i));
            map.put(v, i + 1);
        }
        int nowIdx = 27;
        for (int i = 0; i < msg.length(); i++) {
            String v = String.valueOf(msg.charAt(i));
            String chkV = v;
            while (true) {
                if (i + 1 == msg.length()) {
                    answer.add(map.get(chkV));
                    break;
                }
                String next_v = String.valueOf(msg.charAt(i + 1));
                if (map.get(chkV + next_v) == null) {
                    map.put(chkV + next_v, nowIdx);
                    nowIdx++;
                    answer.add(map.get(chkV));
                    break;
                } else {
                    chkV += next_v;
                    i++;
                }
            }
        }
        int[] answers = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answers[i] = answer.get(i);
        }

        return answers;
    }
}