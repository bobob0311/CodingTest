class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" ");
        int x = 0;
        int c = 0;
        
        for(String value:arr){
            if(value.contains("x")){
                if(value.equals("x")){
                    x+=1;
                }else{
                    x+= Integer.parseInt(value.substring(0,value.length()-1));    
                }
            }else if(value.equals("+")){
                continue;
            }else{
                c+=Integer.parseInt(value);
            }
        }
        String answer ="";
        if(x != 0){
            if(x == 1){
                answer +="x";
            }else{
                answer +=String.valueOf(x) +"x";
            }
        }
        if(c != 0){
            if(x == 0){
                return String.valueOf(c);
            }else{
                answer +=" + "+String.valueOf(c);    
            }
        }
        return answer;
    }
}