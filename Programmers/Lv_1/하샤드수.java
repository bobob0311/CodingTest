class Solution {
    public boolean solution(int x) {
        String str = String.valueOf(x);

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        if (x % num == 0) {
            return true;
        } else {
            return false;
        }
    }
}