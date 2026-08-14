class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();

        // Push 's' in REVERSE so the 1st character of 's' is at the TOP of the stack
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }

        // Scan 't' character by character
        for (int j = 0; j < t.length(); j++) {
            if (!stack.isEmpty() && t.charAt(j) == stack.peek()) {
                stack.pop(); // Found match in order! Pop to look for the next required letter
            }
        }

        // If the stack is completely empty, all characters of 's' were matched in order
        return stack.isEmpty();
    }
}