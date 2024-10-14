import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    Map<String,Integer> map = new HashMap<>();
    Map<Integer,Integer> numCount = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            String[] nowOrder = order.split("");
            Arrays.sort(nowOrder);
            StringBuilder st = new StringBuilder();
            for(int i = 0; i<nowOrder.length; i++){
                st.append(nowOrder[i]);
            }
            
            find(st.toString(),-1,"");
        }
        for(String v: set){
            map.put(v,0);
        }
        
        for(int i =0; i<course.length; i++){
            numCount.put(course[i],0);
        }
        
        for(String v : set){
            for(String order : orders){
                boolean chk = false;
                for(int i=0; i<v.length(); i++){
                    if(!order.contains(v.substring(i,i+1))){
                        chk = true;
                        break;
                    };
                }
                if(!chk){
                    map.put(v,map.get(v)+1);
                    if(numCount.get(v.length())!=null){
                        if(numCount.get(v.length()) < map.get(v)){
                            numCount.put(v.length(),map.get(v));
                        }
                    }
                    
                    
                }
            }
        }
        
        List<String> list = new LinkedList<>();
        
        for(Integer v : numCount.values()){
            System.out.println(v);
        }
        
        
        for(String key : map.keySet()){
            // 2팀 이상 주문
            if(map.get(key) > 1){
                // 원하는 게 아닐 경우 패스 , 만약 찾는 값이면 list에 추가 
                if(numCount.get(key.length())!= null && map.get(key) == numCount.get(key.length())){
                    list.add(key);
                }          
                
            }
        }
        
        
        String[] answer = new String[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    void find(String order,int idx,String nowString){
        if(nowString.length() >=2){
            set.add(nowString);
        }
        for(int i =0; i<order.length(); i++){
            if(i >idx){
                find(order,i,nowString + order.substring(i,i+1));
            }
        }
    }
    
}