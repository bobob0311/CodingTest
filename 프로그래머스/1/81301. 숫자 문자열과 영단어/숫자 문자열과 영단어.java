class Solution {
    public int solution(String s) {
        String[] Str = new String[] {"zero","one", "two", "three", "four","five","six", "seven","eight", "nine"};
        String[] num = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        for(int i =0; i<Str.length; i++){
            s = s.replace(Str[i],num[i]);
        }
        return Integer.parseInt(s);
    }
}