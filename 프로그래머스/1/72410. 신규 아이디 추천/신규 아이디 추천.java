// 97~122 , 45, 46,95;
class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        StringBuilder st = new StringBuilder();
        boolean pre = false;
        for(int i = 0; i<new_id.length() ; i++){
            char target = new_id.charAt(i);
            int v = (int) target;
            if(Character.isDigit(target)){
                st.append(String.valueOf(target));
                pre = false;
            }else if( v >=97 && v<=122){
                st.append(String.valueOf(target));
                pre = false;
            }else if( v == 45 || v == 95){
                st.append(String.valueOf(target));
                pre = false;
            }else if(v== 46){
                if(pre){
                    continue;
                }
                st.append(String.valueOf(target));
                pre = true;
            }
        }
        if(st.length() !=0){
            if(st.charAt(0) =='.'){
                st.delete(0,1);
            }    
        }
        
        if(st.length() !=0){
            if(st.charAt(st.length()-1) =='.'){
                st.delete(st.length()-1,st.length());
            }    
        }
        
        if(st.length() == 0){
            st.append("a");
        }
        
        if(st.length() >=16){
            st.delete(15,st.length());
        }
        
        if(st.charAt(st.length()-1) =='.'){
            st.delete(st.length()-1,st.length());
        }
        
        while(st.length()<3){
            st.append(String.valueOf(st.charAt(st.length()-1)));
        }

        
        
        System.out.println(st.toString());
        
        
        

        

        return st.toString();
    }
}