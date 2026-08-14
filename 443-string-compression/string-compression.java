class Solution {
    public int compress(char[] chars) {
        int write = 0; // Index where we overwrite chars array
        int i = 0;

        while (i < chars.length) {
            int j = i;

            // Count how far the consecutive matching sequence goes
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            int count = j - i; // Number of consecutive identical characters

            // Step 1: Write the character back into chars array
            chars[write++] = chars[i];

            // Step 2: If count > 1, write each digit of the count into chars
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }

            // Move i to the start of the next new character group
            i = j;
        }

        return write; // Length of the modified portion of chars
    }
}