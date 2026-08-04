class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Array to count frequency of each letter
        int[] count = new int[26];

        // Increase count for s and decrease count for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If any count is not zero, they are not anagrams
        for (int x : count) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }
}