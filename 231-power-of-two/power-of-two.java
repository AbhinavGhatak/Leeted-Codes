class Solution {
    public boolean isPowerOfTwo(int n) {
        for (int x = 0; x < 31; x++) {
            if (n == Math.pow(2, x)) return true;
        }
        return false;
    }
}