// 자기가 신고한 사람중에 정지가되면 처리 결과 메일이 신고한 사람한테 간다잉~
// 누가 누구를 신고했는지 기억
// 신고당한 수도 기억


import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>();
        Map<String, List<String> > map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>(); 
        
        for(int i =0; i<id_list.length; i++){
            map.put(id_list[i], new LinkedList<String>());
            countMap.put(id_list[i],0);
        }
        
        
        for(String s : report){
            set.add(s);
        }
        
        for(String v :set){
            String[] people = v.split(" ");
            String first = people[0];
            String second = people[1];
            
            map.get(first).add(people[1]);
            countMap.put(second,countMap.get(second)+1);
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i =0; i<id_list.length; i++){
            int count = 0;
            for(String v :map.get(id_list[i])){

                if(countMap.get(v) >= k){
                    
                    count++;
                }
            }
            answer[i] = count;

        }
        

        return answer;
    }
}