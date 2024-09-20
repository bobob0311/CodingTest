class Solution {
    public String solution(int a, int b) {
        int days = 0;
        int[] month = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
        for(int i =0; i<a-1;i++){
            days += month[i];
        }
        days += b-1;
        int idx = days % 7;
        
        String[] x = new String[] {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        
        
        
        return x[idx];
    }
}