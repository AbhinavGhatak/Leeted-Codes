class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) return -1;

        // Initialize window of size nLen
        int left = 0;
        int right = nLen - 1;

        while (right < hLen) {
            // Check if the current window frame matches needle
            if (haystack.substring(left, right + 1).equals(needle)) {
                return left; // Found start index!
            }
            
            // Slide the window rightward
            left++;
            right++;
        }

        return -1;
    }
}