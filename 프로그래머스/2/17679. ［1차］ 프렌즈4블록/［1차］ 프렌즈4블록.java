import java.util.*;

class Solution {
    int count =0;
    
    public int solution(int m, int n, String[] board) {
        List<List<Character>> list = new ArrayList<>(n);
        for(int i =0; i<n; i++){
            list.add(new ArrayList<>(m));
        }
        
        for(int i =0; i<n; i++){
            for(int j = m-1; j>=0; j--){
                list.get(i).add(board[j].charAt(i));
            }
        }
        
        while(true){
            boolean[][] chk = new boolean[n][m];
            boolean chkNext = false;
            
            for(int i =0; i<n-1; i++){
                List<Character> nowList = list.get(i);
                for(int j =0; j<nowList.size(); j++){
                    Character nowChar = list.get(i).get(j);

                    if(list.get(i+1).size() > j+1 && nowList.size()> j+1){
                        if(list.get(i+1).get(j) == nowChar && list.get(i+1).get(j+1) == nowChar && nowList.get(j+1) == nowChar){
                            chk[i][j] = true;
                            chk[i+1][j] = true;
                            chk[i][j+1] = true;
                            chk[i+1][j+1] = true;
                        }    
                    }

                }
            }
            
            for(int i =0; i<n; i++){
                List<Character> chkList = list.get(i);
                for(int j =chkList.size()-1; j>=0;j--){
                    if(chk[i][j] == true){
                        chkList.remove(j);
                        count++;
                        chkNext = true;
                    }
                }
            }
            if(!chkNext){
                break;
            }
        }
        
        
        

        
        
        
        return count;
    }
}