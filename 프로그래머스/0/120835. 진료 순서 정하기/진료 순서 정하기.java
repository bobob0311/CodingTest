import java.util.*;
class Solution {
    class Node{
        int idx;
        int num;
        Node(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
    public int[] solution(int[] emergency) {
        List<Node> list = new LinkedList<>();
        for(int i = 0; i<emergency.length; i++){
            list.add(new Node(i,emergency[i]));
        }
        Collections.sort(list,(a,b) -> Integer.compare(b.num,a.num));
        int[] answer = new int[list.size()];
        int s = 1;
        for(int i = 0; i<list.size(); i++){
            Node node = list.get(i);
            answer[node.idx] = s++;
        }
        
        
        return answer;
    }
}