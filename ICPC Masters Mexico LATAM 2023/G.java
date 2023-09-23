// https://codeforces.com/group/j7YsoIFtw4/contest/104393/problem/G

import java.util.ArrayList;
import java.util.List;

class G {
    public void Solution(int input) {
        List<Integer> weights = new ArrayList<>();
        double max = Math.ceil(input / 2);

        for (int i = 0; i < max + 1; i++) {
            int current = ((i + 1) * (i + 1));
            int found = search(input + current, i + 1);
            if (found != -1) {
                weights.add(found);
            }
        }

        System.out.println(weights.size());
        weights.forEach(System.out::println);
        
    }
    public static int search (int target, int current) {
        int left = current;
        int right = target;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid == target) {
                return mid;
            } else if (mid * mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
