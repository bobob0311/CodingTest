class Solution {
    public int solution(int[][] dots) {

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {

                int dx1 = dots[i][0] - dots[j][0];
                int dy1 = dots[i][1] - dots[j][1];
                
                for (int k = 0; k < dots.length; k++) {
                    for (int l = k + 1; l < dots.length; l++) {

                        if (i == k || i == l || j == k || j == l) continue;
                        
                        int dx2 = dots[k][0] - dots[l][0];
                        int dy2 = dots[k][1] - dots[l][1];
                        
                        if (dy1 * dx2 == dy2 * dx1) {
                            return 1; 
                        }
                    }
                }
            }
        }
        return 0; 
    }
}
