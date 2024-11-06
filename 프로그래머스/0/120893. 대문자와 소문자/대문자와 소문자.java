class Solution {
    public String solution(String my_string) {
        System.out.println((int) 'A');
        System.out.println((int) 'a');
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<my_string.length(); i++){
            char ch = my_string.charAt(i);
            int num = (int) ch;
            
            if(num >= 97){
                num-=32;
            }else{
                num+=32;
            }
            
            st.append(String.valueOf((char) num));
        }
        
        return st.toString();
    }
}