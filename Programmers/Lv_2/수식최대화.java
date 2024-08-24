import java.util.*;
/*
나눠 
*/

class Solution {
    static long max = 0;

    public long solution(String expression) {
        List<String> list = new LinkedList<>();
        String temp = "";
        for (int i = 0; i < expression.length(); i++) {
            char v = expression.charAt(i);
            if (v == '+' || v == '*' || v == '-') {
                list.add(temp);
                list.add(String.valueOf(v));
                temp = "";
            } else {
                temp += String.valueOf(v);
            }
        }
        list.add(temp);

        String[] op = new String[] { "-*+", "-+*", "+*-", "+-*", "*-+", "*+-" };
        for (int j = 0; j < op.length; j++) {
            List<String> copiedList = new ArrayList<>(list);
            String now = op[j];

            for (int q = 0; q < 3; q++) {
                char nowOp = now.charAt(q);

                for (int i = 0; i < copiedList.size(); i++) {
                    if (copiedList.get(i).equals(String.valueOf(nowOp))) {

                        long a = Long.parseLong(copiedList.get(i - 1));
                        long b = Long.parseLong(copiedList.get(i + 1));

                        copiedList.remove(i - 1);
                        copiedList.remove(i - 1);
                        copiedList.remove(i - 1);

                        if (nowOp == '-') {
                            copiedList.add(i - 1, String.valueOf(a - b));
                        } else if (nowOp == '+') {
                            copiedList.add(i - 1, String.valueOf(a + b));
                        } else {
                            copiedList.add(i - 1, String.valueOf(a * b));
                        }
                        i--;

                    }
                    if (copiedList.size() == 1) {
                        max = Math.max(Math.abs(Long.parseLong(copiedList.get(0))), max);
                        break;
                    }
                }

            }

        }

        return max;
    }
}