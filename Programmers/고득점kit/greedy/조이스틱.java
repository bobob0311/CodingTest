package Programmers.고득점kit.greedy;

/*
모든 A들을 우선 원하는 결과로 만들기위해 필요한 스틱 횟수 구하기 

1. 첫시작을 앞으로 진행하는 것이 빠른가?
2. 첫시작을 뒤로 진행하는 것이 빠른가?
    
    공통) 연속되는 A가 나왔을 때 그 A를 진행하는 것이 좋은지 되돌아가는 것이 좋은지 
*/

class Solution {
    static int length;
    static int index;
    static int move;
    static int change;

    public int solution(String name) {
        length = name.length();
        move = length - 1;
        for (int i = 0; i < length; i++) {
            change += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            index = i + 1;

            while (index < length && name.charAt(index) == 'A') {
                index++;
            }
            ;

            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        return move + change;
    }
}
