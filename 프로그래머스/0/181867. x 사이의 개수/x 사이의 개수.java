class Solution {
    public int[] solution(String myString) {
        String[] str = myString.split("x");
        int[] answer;
        if(myString.charAt(myString.length()-1) == 'x'){
            answer = new int[str.length+1];
        }else{
            answer = new int[str.length];
        }
        for(int i =0; i<str.length; i++){
            answer[i] = str[i].length();
        }
        if(myString.charAt(myString.length()-1) == 'x'){
            answer[str.length] = 0;
        }
        return answer;
    }
}