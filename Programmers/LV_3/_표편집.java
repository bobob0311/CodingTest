/*
구현은 했는데 시간초과 
이게 중간에 z하는거 때문에 연결하는 방법을 찾아야할듯

8 : 00
9 : 00

한 번에 한 행만을 선택할 수 있ㄷ. 

U X => 선택된 해에서 X칸위
D X => 선택된 행에서 X칸 아래 행
C => 선택된 행을 삭제후 바로 아래 행 선택 
        * 삭제된 행이 마지막인 경우 바로 윗행 선택
Z => 가장 최근에 삭제된 행 원래대로 복구 
        * 선택된 해은 바뀌지 않는다.
*/

/*
n => 표의 행 개수
k=> 선택된 행
cmd => 수행한 명령어들이 담긴 문자열 배열
*/
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] list = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            list[i] = 1;
        }
        int nowIdx = k;

        for (int i = 0; i < cmd.length; i++) {
            String nowString = cmd[i];

            if (nowString.equals("C")) {
                list[nowIdx] = 0;
                st.push(nowIdx);

                int searchIdx = nowIdx;
                boolean chk = false;

                while (searchIdx < n - 1) {
                    // 최대 n-1까지 확인
                    if (list[++searchIdx] == 1) {
                        nowIdx = searchIdx;
                        chk = true;
                        break;
                    }
                }
                if (!chk) {
                    searchIdx = nowIdx;
                    while (searchIdx > 0) {
                        if (list[--searchIdx] == 1) {
                            nowIdx = searchIdx;
                            break;
                        }
                    }
                }
            } else if (nowString.charAt(0) == 'U') {
                String temp = nowString.substring(2);
                int upCount = Integer.parseInt(temp);
                int count = 0;
                while (count != upCount) {
                    if (list[--nowIdx] == 1) {
                        count++;
                    }
                }

            } else if (nowString.charAt(0) == 'D') {
                String temp = nowString.substring(2);
                int downCount = Integer.parseInt(temp);
                int count = 0;
                while (count != downCount) {
                    if (list[++nowIdx] == 1) {
                        count++;
                    }
                }

            } else {
                int undoIdx = st.pop();
                list[undoIdx] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 1) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }
}