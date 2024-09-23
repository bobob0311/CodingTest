class Solution {
    public int solution(int[] ingredient) {
        StringBuilder temp = new StringBuilder();

        for(int i = 0; i < ingredient.length; i++) {
            temp.append(ingredient[i]);
            int length = temp.length();
            
            if (length >= 4 && temp.substring(length - 4).equals("1231")) {
                temp.delete(length - 4, length);
            }
        }

        return (ingredient.length - temp.length()) / 4;
    }
}
