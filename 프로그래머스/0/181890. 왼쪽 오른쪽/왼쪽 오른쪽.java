class Solution {
    public String[] solution(String[] str_list) {
        String s = "";
        int idx = -1;
        for(int i =0;i<str_list.length;i++){
            if(str_list[i].equals("l")){
                s="l";
                idx = i;
                break;
            }else if(str_list[i].equals("r")){
                s="r";
                idx = i;
                break;
            }
        }
        if(idx == -1){
            return new String[] {};
        }
        String[] answer;
        if(s.equals("l")){
            answer = new String[idx];
            for(int i = 0; i<idx; i++){
                answer[i] = str_list[i];
            }
        }else{
            answer = new String[str_list.length - idx-1];
            int v = 0;
            for(int i = idx+1; i<str_list.length; i++){
                answer[v++] = str_list[i];
            }
        }
        

        return answer;
    }
}