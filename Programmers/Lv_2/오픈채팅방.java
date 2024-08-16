import java.util.*;

class Solution {
    static int strLength = 0;

    public String[] solution(String[] record) {

        Map<String, String> name = new HashMap<>();
        int length = record.length;

        for (int i = 0; i < length; i++) {
            if (record[i].charAt(0) == 'E') {
                String[] arr = record[i].split(" ");
                String id = arr[1];
                name.put(id, arr[2]);
                strLength++;
            } else if (record[i].charAt(0) == 'C') {
                String[] arr = record[i].split(" ");
                String id = arr[1];
                name.put(id, arr[2]);

            } else {
                strLength++;
            }
        }
        String[] answer = new String[strLength];

        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (record[i].charAt(0) == 'E') {
                String[] arr = record[i].split(" ");
                String id = arr[1];
                String my_name = name.get(id);
                answer[idx] = my_name + "님이 들어왔습니다.";
                idx++;

            } else if (record[i].charAt(0) == 'C') {
                String[] arr = record[i].split(" ");
                String id = arr[1];
                String my_name = name.get(id);
            } else {
                String[] arr = record[i].split(" ");
                String id = arr[1];
                String my_name = name.get(id);
                answer[idx] = my_name + "님이 나갔습니다.";
                idx++;
            }
        }
        return answer;
    }
}
