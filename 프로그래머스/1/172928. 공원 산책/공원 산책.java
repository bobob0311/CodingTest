class Solution {
    public int[] solution(String[] park, String[] routes) {
        Character[][] map = new Character[park.length][park[0].length()];
        int x = 0;
        int y = 0;
        
        for(int i =0; i<park.length; i++){
            for(int j =0; j<park[0].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    map[i][j] = 'O';
                    x=i;
                    y=j;
                }else{
                    map[i][j] =park[i].charAt(j);    
                }
            }
        }

        
        for(String route : routes){
            char d = route.charAt(0);
            int num = Integer.parseInt(String.valueOf(route.charAt(2)));
            boolean chk = false;
            
            if(d == 'N'){
                if(x-num<0){
                    continue;
                }
                int temp = x;

                for(int i = 1; i<=num;i++){
                    if(map[x-i][y] == 'X'){
                        chk = true;
                        break;
                    }
                }
                if(!chk){
                    x = x-num;
                }
                
            }else if(d == 'S'){
                if(x+num>= park.length){
                    continue;
                }
                int temp = x;

                for(int i = 1; i<=num;i++){
                    if(map[x+i][y] == 'X'){
                        chk = true;
                        break;
                    }
                }
                if(!chk){
                    x = x+num;
                }
                
            }else if(d == 'E'){
                if(y+num >= park[0].length()){
                    continue;
                }
                int temp = y;

                for(int i = 1; i<=num;i++){
                    if(map[x][y+i] == 'X'){
                        chk = true;
                        break;
                    }
                }
                if(!chk){
                    y = y+num;
                }
                
            }else{
                if(y-num <0){
                    continue;
                }
                int temp = y;

                for(int i = 1; i<=num;i++){
                    if(map[x][y-i] == 'X'){
                        chk = true;
                        break;
                    }
                }
                if(!chk){
                    y = y-num;
                }
                
            }
        }
            
        
        
        
        int[] answer = {x,y};
        return answer;
    }
}