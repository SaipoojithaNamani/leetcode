class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] a = new int[26];
        int[] b = new int[26];

        for (char c : p.toCharArray()) {
            b[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                a[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(a, b)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}