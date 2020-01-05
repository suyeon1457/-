import java.util.*;

class Solution {
    int min = 9;
    public void dp(int N, int number, int count, long result) {
        // N를 사용한 횟수가 최솟값보다 클때
        if (min < count) {
            return;
        }
        if (result == number) {
            if (count < min) {
                min = count;
            }
            return;
        }
        if (count == 8) {
            return;
        }
        else {
            int rest = 8 - count;
            for (int i = 1; i <= rest; i ++) {
                int tailmax = i / 2;
                // N ~ NNNNNNNN 반복
                for (int j = 0; j <= tailmax; j ++) {
                    int head = 0;
                    for (int k = 1; k <= i - j; k ++) {
                        head = head * 10 + N;
                    }
                    int next = head;
                    int tail = 0;
                    for (int k = 1; k <= j; k ++) {
                        tail = tail * 10 + N;
                    }
                    if (tail > 0)
                        next /= tail;

                    dp(N, number, count + i, result + next);
                    dp(N, number, count + i, result - next);
                    dp(N, number, count + i, result * next);
                    dp(N, number, count + i, result / next);
                    dp(N, number, count + i, result * -1 * next);
                    dp(N, number, count + i, result * -1 / next);
                }
                if (i > 2) {
                    dp(N, number, count + i, result);
                    dp(N, number, count + i, 0);
                }
            }
        }
    }
    public int solution(int N, int number) {
        dp(N, number, 0, 0);
        // 최솟값이 8보다 크면 -1 return
        if (min > 8) {
            min = -1;
        }
        return min;
    }
}
