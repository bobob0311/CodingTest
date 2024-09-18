import java.util.*;

class Solution {
    class Node{
        String upName = "";
        int amount = 0;
        int index;
        
        Node(int index){
            this.index = index;
        }
        
        public void linkNext(String nextName){
            this.upName = nextName;
            return;
        }
        public String next(){
            return this.upName;
        }
    }
    
    
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,Node> map = new HashMap<>();
        int[] arr = new int[enroll.length];
        
        for(int i = 0; i<enroll.length; i++){
            Node temp = new Node(i);
            temp.linkNext(referral[i]);
            map.put(enroll[i], temp);
        }
        
        for(int i =0; i<seller.length; i++){
            String sell = seller[i];
            int v = amount[i];
            int money = v * 100;
            
            Node now = map.get(sell);
            while(money> 0){
                String next = now.next();
                if(next.equals("-")){
                    int ten = (int) money/10;
                    arr[now.index] += money - ten;
                    break;
                }else{
                    int ten = (int) money/10;
                    int nowMoney = money - ten;
                    money = ten;
                    arr[now.index]+=nowMoney;
                    now = map.get(next);
                }
            }
        }

        return arr;
    }
}