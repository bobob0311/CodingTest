class Solution {
    static int maxSheep = 1;
    static int count = 0;
    public int solution(int[] info, int[][] edges) {
        boolean[] chk = new boolean[info.length];
        for(int i =0; i<info.length; i++){
            if(info[i] == 0){
                count++;
            }
        }
        System.out.println(count);
        
        
        dfs(0,0,0,info,edges,chk);
        
        return maxSheep;
    }
    void dfs(int idx, int sheep, int wolf,int[] info, int[][] edges, boolean[] chk){
        chk[idx] = true;
        if(sheep == 0){
            sheep++;
        }else if(info[idx] == 0){
            sheep+=1;
            if(maxSheep < sheep){
                maxSheep = sheep;
            }
            if(sheep == count){
                return;
            }
        }else{
            wolf+=1;
        }
        
        if(sheep <= wolf){
            return;
        }
        
        for(int[] edge : edges){
            if(chk[edge[0]] && !chk[edge[1]]){
                boolean[] chkB = new boolean[info.length];
                for(int i =0; i<info.length; i++){
                    chkB[i] = chk[i];
                }
                dfs(edge[1], sheep,wolf,info,edges,chkB);
            }
        }
    }
}