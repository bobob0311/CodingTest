class Solution {
    public String solution(String myString) {
        System.out.println((int)'a');
        System.out.println((int)'A');
        String answer = "";
        for(int i =0; i<myString.length(); i++){
            if (myString.charAt(i) == 'a'){
                answer+="A";
            }else if((int) myString.charAt(i) >65 && (int)myString.charAt(i) < 97){
               char tempChar = (char) ((int) myString.charAt(i) + 32);
                String str = String.valueOf(tempChar);
                answer+=str;
            }else{
                answer+= String.valueOf(myString.charAt(i));
            }
        }
        
        
        
        return answer;
    }
}