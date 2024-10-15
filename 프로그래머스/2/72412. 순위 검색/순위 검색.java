import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();

        // 1. info 데이터 전처리
        for (String person : info) {
            String[] split = person.split(" ");
            String[] langs = {split[0], "-"};
            String[] jobs = {split[1], "-"};
            String[] exps = {split[2], "-"};
            String[] foods = {split[3], "-"};
            int score = Integer.parseInt(split[4]);

            // 각 속성의 모든 조합을 만들어서 map에 저장
            for (String lang : langs) {
                for (String job : jobs) {
                    for (String exp : exps) {
                        for (String food : foods) {
                            String key = lang + job + exp + food;
                            map.computeIfAbsent(key, x -> new ArrayList<>()).add(score);
                        }
                    }
                }
            }
        }

        // 2. 점수 리스트 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // 3. query 처리
        int[] answer = new int[query.length];
        int idx = 0;

        for (String q : query) {
            q = q.replaceAll(" and ", ""); // and 제거
            String[] split = q.split(" ");
            String key = split[0]; // 조건 키
            int targetScore = Integer.parseInt(split[1]); // 쿼리에서 요구하는 점수

            // 해당 조건에 맞는 점수 리스트 가져오기
            List<Integer> scores = map.getOrDefault(key, new ArrayList<>());

            // 점수 리스트에서 targetScore 이상인 사람의 수를 빠르게 찾기 (이진 탐색)
            int start = 0;
            int end = scores.size();
            while (start < end) {
                int mid = (start + end) / 2;
                if (scores.get(mid) >= targetScore) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            // start부터 끝까지가 targetScore 이상인 사람 수
            answer[idx++] = scores.size() - start;
        }

        return answer;
    }
}
