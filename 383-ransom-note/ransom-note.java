class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

        // Outer loop: iterate through every character in ransomNote
        for (int i = 0; i < note.length; i++) {
            boolean found = false;

            // Inner loop: check if note[i] exists anywhere in magazine
            for (int j = 0; j < mag.length; j++) {
                if (note[i] == mag[j]) {
                    mag[j] = '#'; // Mark as used so it cannot be matched again!
                    found = true;
                    break;        // Move on to the next character in ransomNote
                }
            }

            // If note[i] was not found anywhere in magazine, return false immediately
            if (!found) {
                return false;
            }
        }

        return true; // All characters in ransomNote found a match
    }
}