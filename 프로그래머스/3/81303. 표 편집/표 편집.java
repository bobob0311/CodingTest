/*
8 : 00

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
        Stack<Integer> st = new Stack<Integer>();
        int size = n;
        for(int i=0; i<cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c=='D')
                k+=Integer.parseInt(cmd[i].substring(2));
            else if(c=='U')
                k-=Integer.parseInt(cmd[i].substring(2));
            else if(c=='C') {
                st.add(k);
                size--;
                if(k==size)
                    k--;
            }
            else if(c=='Z') {
                if(st.pop()<=k)
                    k++;
                size++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<size; i++)
            builder.append("O");
        while(!st.isEmpty())
            builder.insert(st.pop().intValue(), "X");
        String answer=builder.toString();
        return answer;
    }
}
