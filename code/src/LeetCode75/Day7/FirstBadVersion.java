package LeetCode75.Day7;

// leetcode 278
public class FirstBadVersion {
    public static void main(String[] args) {

    }

    // dummy implementation to stop intellij from shouting
    public static boolean isBadVersion(int version) {
        return false;
    }

    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n;

        while (start <= end) {
            // remember this formula now
            // the simpler one results in TLE
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                if (mid == 1) return mid;
                if (!(isBadVersion(mid - 1))) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
