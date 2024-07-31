package Programmers.고득점kit.해시;

import java.util.*;
/*
다시 여러번 풀어보는게 중요할 듯

장르별로 가장 많이 재생된 노래를 두개씩 모아 베스트 앨범 출시 

1. 노래가 많이 재생된 장르  (genres => 종류는 100가지 이내)
2. 장르 내에서 많이 재생된 노래 (plays =>10000 이하)
3. 재생횟수가 같을 경우 고유 번호가 낮은 노래

! => 장르에 속한 곡이 하나라면 하나의 곡만을 선택한다. 
*/

/*
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
*/

/*
data[장르] => 많이 재생된 노래 순서대로 나열 


*/

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<int[]>> info = new HashMap<>();

        int length = genres.length;

        for (int i = 0; i < length; i++) {
            if (genreMap.get(genres[i]) == null) {
                genreMap.put(genres[i], plays[i]);
                info.put(genres[i], new ArrayList<>());
            } else {
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            }
            info.get(genres[i]).add(new int[] { i, plays[i] });
        }

        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        sortedGenres.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = info.get(genre);

            songs.sort((a, b) -> {
                if (b[1] == a[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });

            int count = 0;
            for (int[] song : songs) {
                if (count != 2) {
                    bestAlbum.add(song[0]);
                    count++;
                }
            }
        }

        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
}
