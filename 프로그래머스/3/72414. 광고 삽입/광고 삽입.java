class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int limitTime = changeInt(play_time);
        int during = changeInt(adv_time);
        int[] time = new int[limitTime+1];
        System.out.println(during);
        for(String log : logs){
            int startTime = changeInt(log.substring(0,8));
            int endTime = changeInt(log.substring(9));
            time[startTime] += 1;
            time[endTime] += -1;
        }
        
        for(int i =1; i<limitTime ; i++){
            time[i] += time[i-1];
        }
        long temp = 0;
        
        for(int i =0; i<during; i++){
            temp+=time[i];
        }
        long max = temp;
        int answer = 0;
        for(int i = 0; i<limitTime-during; i++){
            temp += time[i+during] - time[i];
            
            if(temp > max){
                max = temp;
                answer = i+1;
            }
        }
        String first = String.valueOf(answer/3600);
        String second = String.valueOf((answer%3600)/60);
        String third = String.valueOf(answer%60);
        if(first.length() == 1){
            first = "0"+first;
        }
        if(second.length() == 1){
            second = "0"+second;
        }
        if(third.length() == 1){
            third = "0"+third;
        }
       
            
        String a = "";
        return first+":"+second+":"+third;
    }
    
    int changeInt(String time){
        String[] tempStr = time.split(":");
        int timeInt = Integer.parseInt(tempStr[0]) * 60 * 60 + Integer.parseInt(tempStr[1])*60 + Integer.parseInt(tempStr[2]);
        
        return timeInt;
        
    }
}