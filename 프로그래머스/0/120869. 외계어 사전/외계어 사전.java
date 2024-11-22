class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String now : dic){
            // 만약 길이가 다르면 다음
            if(now.length() != spell.length){
                continue;
            }
            boolean chk = true;
            for(int i =0; i<spell.length; i++){
                if(!now.contains(spell[i])){
                    chk = false;
                    break;
                }
            }
            if(chk){
                return 1;
            }
        }
        

        return 2;
    }
}