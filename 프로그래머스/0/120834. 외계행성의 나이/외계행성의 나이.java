class Solution {
    public String solution(int age) {
        // - 97;
        String answer = "";
        String str = String.valueOf(age);
        for(int i  =0; i< str.length(); i++){
            char ch = (char) (Integer.parseInt(str.substring(i,i+1)) + 97);
            String s = String.valueOf(ch);
            answer+=s;
        }
        return answer;
    }
}