class Solution {
    public double myPow(double x, int n) {
        if (n==1) {
            return x;
        }
        double product = Math.pow(x, n);
        return product;
    }
}