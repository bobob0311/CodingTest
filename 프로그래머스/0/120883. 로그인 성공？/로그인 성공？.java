class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = "fail";
        for(String[] nowDB : db){
            String nowId = nowDB[0];
            String nowPw = nowDB[1];
            if(nowId.equals(id_pw[0])){
                id = "wrong pw";
                if(nowPw.equals(id_pw[1])){
                    return "login";
                }
            }
        }
        return id;
    }
}