package Programmers.Lv_2;

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        // 곡괭이로 캘 수 있는 최대 광물 수
        int _pickCount = 0;
        for (int pick : picks) {
            _pickCount += pick;
        }
        int limit = _pickCount * 5;

        // 광물을 5단위로 끊어서 넣을 bucket
        // minerals의 수가 남을지 곡괭이가 남을지
        int bucket_length;
        if (minerals.length % 5 == 0) {
            bucket_length = Math.min(_pickCount, minerals.length / 5);
        } else {
            bucket_length = Math.min(_pickCount, minerals.length / 5 + 1);
        }

        int[][] bucket = new int[bucket_length][2];

        int count = 0;
        for (int i = 0; i < limit; i++) {
            if (minerals[i].equals("iron")) {
                count += 6;
            } else if (minerals[i].equals("diamond")) {
                count += 40;
            } else {
                count += 1;
            }

            if (i + 1 == minerals.length) {
                int idx = 0;
                if ((i + 1) % 5 == 0) {
                    idx = (i + 1) / 5 - 1;
                } else {
                    idx = (i + 1) / 5;
                }
                bucket[idx] = new int[] { idx, count };
                break;
            }

            if ((i + 1) % 5 == 0) {
                int idx = (i + 1) / 5 - 1;
                bucket[idx] = new int[] { idx, count };
                count = 0;
            }

        }
        Arrays.sort(bucket, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });

        count = 0;

        for (int[] arr : bucket) {
            int length = Math.min(arr[0] * 5 + 5, minerals.length);
            for (int i = arr[0] * 5; i < length; i++) {
                if (picks[0] != 0) {
                    if (minerals[i].equals("iron")) {
                        count += 1;
                    } else if (minerals[i].equals("diamond")) {
                        count += 1;
                    } else {
                        count += 1;
                    }

                } else if (picks[1] != 0) {
                    if (minerals[i].equals("iron")) {
                        count += 1;
                    } else if (minerals[i].equals("diamond")) {
                        count += 5;
                    } else {
                        count += 1;
                    }
                } else {
                    if (minerals[i].equals("iron")) {
                        count += 5;
                    } else if (minerals[i].equals("diamond")) {
                        count += 25;
                    } else {
                        count += 1;
                    }
                }
            }
            if (picks[0] != 0) {
                picks[0]--;
            } else if (picks[1] != 0) {
                picks[1]--;
            }

        }

        return count;
    }
}
