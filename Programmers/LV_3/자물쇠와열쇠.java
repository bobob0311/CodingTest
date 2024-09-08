/*
둘다 정사각형 

코드좀 함수화좀.. 제발 하자공~
*/

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int length = key.length;

        int[][] arr1 = new int[length][length];
        int[][] arr2 = new int[length][length];
        int[][] arr3 = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr1[i][j] = key[length - 1 - j][i];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr2[i][j] = arr1[length - 1 - j][i];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr3[i][j] = arr2[length - 1 - j][i];
            }
        }

        for (int a = length - 1; a >= -(lock.length); a--) {
            for (int b = length - 1; b >= -(lock.length); b--) {
                boolean chk = false;
                for (int i = 0; i < lock.length; i++) {
                    if (chk) {
                        break;
                    }
                    for (int j = 0; j < lock.length; j++) {
                        int temp = lock[i][j];
                        if (i + a < length && j + b < length && i + a >= 0 && j + b >= 0) {
                            temp += key[i + a][j + b];
                        }
                        if (temp != 1) {
                            chk = true;
                            break;
                        }

                        if (i == lock.length - 1 && j == lock.length - 1) {
                            return true;
                        }
                    }
                }

            }
        }
        for (int a = length - 1; a >= -(lock.length); a--) {
            for (int b = length - 1; b >= -(lock.length); b--) {
                boolean chk = false;
                for (int i = 0; i < lock.length; i++) {
                    if (chk) {
                        break;
                    }
                    for (int j = 0; j < lock.length; j++) {
                        int temp = lock[i][j];
                        if (i + a < length && j + b < length && i + a >= 0 && j + b >= 0) {
                            temp += arr1[i + a][j + b];
                        }
                        if (temp != 1) {
                            chk = true;
                            break;
                        }
                        if (i == lock.length - 1 && j == lock.length - 1) {
                            return true;
                        }

                    }
                }

            }
        }
        for (int a = length - 1; a >= -(lock.length); a--) {
            for (int b = length - 1; b >= -(lock.length); b--) {
                boolean chk = false;
                for (int i = 0; i < lock.length; i++) {
                    if (chk) {
                        break;
                    }
                    for (int j = 0; j < lock.length; j++) {
                        int temp = lock[i][j];
                        if (i + a < length && j + b < length && i + a >= 0 && j + b >= 0) {
                            temp += arr2[i + a][j + b];
                        }
                        if (temp != 1) {
                            chk = true;
                            break;
                        }
                        if (i == lock.length - 1 && j == lock.length - 1) {
                            return true;
                        }

                    }
                }

            }
        }
        for (int a = length - 1; a >= -(lock.length - 1); a--) {
            for (int b = length - 1; b >= -(lock.length - 1); b--) {
                boolean chk = false;
                for (int i = 0; i < lock.length; i++) {
                    if (chk) {
                        break;
                    }
                    for (int j = 0; j < lock.length; j++) {
                        int temp = lock[i][j];
                        if (i + a < length && j + b < length && i + a >= 0 && j + b >= 0) {
                            temp += arr3[i + a][j + b];
                        }
                        if (temp != 1) {
                            chk = true;
                            break;
                        }
                        if (i == lock.length - 1 && j == lock.length - 1) {
                            return true;
                        }

                    }
                }

            }
        }

        return false;
    }
}