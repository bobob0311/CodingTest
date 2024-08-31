
/*
08 50 시작
09 48 끝...

우선 문제를 제대로 읽어야할 필요성이있고 게산을 한 후에 내가 가리키고있는 인덱스는 어떤 인덱스인가를 생각해봐야겠다. 

모든 보석을 포함하고 있는 가장짧은 구간을 구해야하는 문제입니다.

HashMap을 사용하여 해결해보고자한다.
*/
import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();

        HashMap<String, Integer> map2 = new HashMap<>();

        int lastIdx = 0;
        int firstIdx = 0;

        for (int i = 0; i < gems.length; i++) {
            String v = gems[i];

            // 마지막으로 map이 늘어날때.
            if (map.get(v) == null) {
                map.put(v, 1);
                lastIdx = i + 1;
            } else {
                map.put(v, map.get(v) + 1);
            }
        }

        int size = map.size();
        System.out.println(size);

        for (int i = lastIdx - 1; i >= 0; i--) {
            String v = gems[i];
            if (map2.get(v) == null) {
                map2.put(v, 1);
            } else {
                map2.put(v, map2.get(v) + 1);
            }
            if (map2.size() == size) {
                firstIdx = i + 1;
                break;
            }
        }
        int l = lastIdx - firstIdx;

        int idx1 = firstIdx - 2;
        int idx2 = lastIdx - 1;

        while (true) {
            if (map2.size() == size) {

                if (l > idx2 - idx1 - 1) {
                    l = idx2 - idx1 - 1;
                    firstIdx = idx1 + 2;
                    lastIdx = idx2 + 1;
                }

                idx1++;
                if (idx1 >= gems.length) {
                    break;
                }
                String v = gems[idx1];

                if (map2.get(v) == 1) {
                    map2.remove(v);
                } else {
                    map2.put(v, map2.get(v) - 1);
                }

            } else {
                idx2++;
                if (idx2 >= gems.length) {
                    break;
                }
                String v = gems[idx2];

                if (map2.get(v) == null) {
                    map2.put(v, 1);
                } else {
                    map2.put(v, map2.get(v) + 1);
                }
            }
        }

        int[] answer = { firstIdx, lastIdx };
        return answer;
    }
}