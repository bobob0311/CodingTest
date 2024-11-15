class Solution {
    public int solution(String binomial) {
        String[] temp = binomial.split(" ");
        int temp0 = Integer.parseInt(temp[0]);
        int temp2 = Integer.parseInt(temp[2]);
        
        if(temp[1].equals("+")){
            return temp0 + temp2;
        }else if(temp[1].equals("-")){
            return temp0 - temp2;
        }else{
            return temp0 * temp2;
        }
    }
}