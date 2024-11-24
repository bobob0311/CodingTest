class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i<quiz.length; i++){
            String[] arr = quiz[i].split(" ");
            int one = Integer.parseInt(arr[0]);
            int two = Integer.parseInt(arr[2]);
            if(arr[1].equals("-")){
                if(one - two == Integer.parseInt(arr[4])){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }else{
                if(one + two == Integer.parseInt(arr[4])){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }
        }
        
        return answer;
    }
}