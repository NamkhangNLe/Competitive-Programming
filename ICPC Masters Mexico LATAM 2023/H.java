import java.util.Scanner;
// https://codeforces.com/group/j7YsoIFtw4/contest/104393/problem/H
class H {
    /**
     * N baskets in a row with Ci max capacity
     * choose basket b and adds Ad apples
     * if added apples > Ci, then excess is saved
     * 
     * How many apples from left to right after Day D if he had delivered
     * 
     * baskets = 3 days = 5 questions = 5
     * Ci capacities: 10 1 5 
     * basket selected = 1 apples harvested 10
     * D = 1 L = 2 R = 3
     */

    public void Solution(String input) {
        Scanner sc = new Scanner(input);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }

        int[][] ba = new int[M][2];
        for (int j = 0; j < M; j++) {
            ba[j][0] = sc.nextInt();
            ba[j][1] = sc.nextInt();
        }

        int[][] DLR = new int[Q][3];
        for (int k = 0; k < Q; k++) {
            DLR[k][0] = sc.nextInt();
            DLR[k][1] = sc.nextInt();
            DLR[k][2] = sc.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            System.out.println(calculate(ba, DLR, C, N, M, Q));
        }
        sc.close();
    }

    public int calculate(int[][] ba, int[][] DLR, int[] C, int N, int M, int Q) {
        int[] apples = new int[N];
        for (int i = 0; i < M; i++) {
            int basket = ba[i][0];
            int applesToAdd = ba[i][1];
            int capacity = C[basket - 1];
            if (applesToAdd > capacity) {
                apples[basket - 1] += capacity;
                apples[basket] += applesToAdd - capacity;
            } else {
                apples[basket - 1] += applesToAdd;
            }
        }

        for (int i = 0; i < Q; i++) {
            int day = DLR[i][0];
            int left = DLR[i][1];
            int right = DLR[i][2];
            int total = 0;
            for (int j = left - 1; j < right; j++) {
                total += apples[j];
            }
            return(total);
        }
        return -1;
    }
}