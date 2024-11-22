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
    public int solution(int[] rank, boolean[] attendance) {
        List<Node> list = new LinkedList<>();
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                list.add(new Node(i,rank[i]));
            }
        }
        Collections.sort(list,(a,b)-> Integer.compare(a.num,b.num));

        return list.get(0).idx*10000 + 100*list.get(1).idx + list.get(2).idx;
    }
}