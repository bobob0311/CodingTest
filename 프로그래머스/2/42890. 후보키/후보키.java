import java.util.*;

class Solution {
    int length;
    int count;
    boolean[] chk;
    Set<String> list = new HashSet<>();
    List<String> list2 = new ArrayList<>();
    
    public int solution(String[][] relation) {
        length = relation[0].length;
        count = relation.length;
        chk = new boolean[length];
        
        for (int i = 1; i <= length; i++) {
            comb(0, i, relation);
            unique(relation);
            list.clear();
        }
        return list2.size();
    }
    
    void comb(int start, int r, String[][] relation) {
        if (r == 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (chk[i]) {
                    temp.append(i);
                }
            }
            list.add(temp.toString());
            return;
        }
            
        for (int i = start; i < length; i++) {
            if (!chk[i]) {
                chk[i] = true;
                comb(i + 1, r - 1, relation);
                chk[i] = false;
            }
        }
    }

    void unique(String[][] relation) {
        for (String str : list) {
            String[] temp = str.split("");
            int[] arr = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                int c = Integer.parseInt(temp[i]);
                arr[i] = c;
            }

            Set<String> set = new HashSet<>();
            for (int i = 0; i < count; i++) {
                StringBuilder tempStr = new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    tempStr.append(relation[i][arr[j]]);
                }
                set.add(tempStr.toString());
            }

            if (set.size() == count) {
                boolean flag = false;
                for (String d : list2) {
                    int cnt = 0;
                    String[] tempC = d.split("");
                    for (String ch : tempC) {
                        if (str.contains(ch)) {
                            cnt++;
                        }
                    }
                    if (cnt == d.length()) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    list2.add(str);
                }
            }
        }
    }
}
