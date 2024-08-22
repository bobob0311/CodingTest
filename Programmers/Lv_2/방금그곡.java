class Solution {
    public String solution(String m, String[] musicinfos) {
        StringBuilder sb = new StringBuilder();
        String answer = "(None)";
        int max_time = 0;
        m = m.replace("A#", "H").replace("C#", "I").replace("D#", "J").replace("F#", "K").replace("G#", "M")
                .replace("B#", "Z");

        for (int j = 0; j < musicinfos.length; j++) {
            String[] target = musicinfos[j].split(",");
            String startTime = target[0];
            String endTime = target[1];
            String title = target[2];
            String info = target[3];
            info = info.replace("A#", "H").replace("C#", "I").replace("D#", "J").replace("F#", "K").replace("G#", "M")
                    .replace("B#", "Z");

            int playTime = (Integer.parseInt(endTime.substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2)))
                    * 60 + Integer.parseInt(endTime.substring(3)) - Integer.parseInt(startTime.substring(3));

            for (int i = 0; i < playTime; i++) {
                int idx = i % info.length();
                // System.out.println(info);
                sb.append(String.valueOf(info.charAt(idx)));
            }
            // System.out.println(sb.toString());
            if (sb.toString().contains(m)) {
                if (max_time < playTime) {
                    answer = title;
                    max_time = playTime;
                }

            }
            sb.setLength(0);

        }

        return answer;
    }
}