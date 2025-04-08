public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("arm", "ran"));
    }

    // Frequency Count Using Arrays
    // Time Complexity: O(n)
    // Space Complexity: O(1) (fixed-size array of 26)
    public static boolean isAnagram(String s, String t) {
        // Two strings must have the same length
        if (s.length() != t.length()) {
            return false;
        }
        // Assuming lowercase English letters
        // Use an integer array of size 26 (since there are 26 letters in the alphabet).
        // To count how many times each character appears in both strings.
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
