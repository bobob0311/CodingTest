class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int length = arr1.length;
        String[] answer = new String[n];
        
        for(int i =0 ; i<n; i++){
            String tempStr1="";
            String tempStr2="";
            
            int v1 = arr1[i];
            int v2 = arr2[i];
            while(v1>=2){
                tempStr1 = String.valueOf(v1%2) + tempStr1;
                v1/=2;
            }
            tempStr1 = String.valueOf(v1) + tempStr1;

            
            while(v2>=2){
                tempStr2 = String.valueOf(v2%2) + tempStr2;
                v2/=2;
            }
            tempStr2 = String.valueOf(v2) + tempStr2;
            
            long num = Long.parseLong(tempStr1) + Long.parseLong(tempStr2);
            String str = String.valueOf(num);
            while(str.length() <n){
                str="0" + str;
            }
            
            String temp="";
            for(int j = 0; j< str.length(); j++){
                if(str.charAt(j) == '0'){
                    temp+=" ";
                }else{
                    temp+="#";
                }
            }
            answer[i] = temp;
        }
        
        

        return answer;
    }
}