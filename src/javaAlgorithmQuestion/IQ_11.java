package javaAlgorithmQuestion;

import java.util.*;

public class IQ_11 {

    /**
     * Given a string s, find the length of the longest
     * substring without repeating characters.
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * katalan --> kat  atmaca --> atm
     */

    public static void main(String[] args) {

        System.out.println(longestSubWithoutRepeat("ahmat")); //4
        System.out.println(longestSubWithoutRepeat("abcbabc")); //3
        System.out.println(longestSubWithoutRepeat("abcabbcbbabcd")); //4

        System.out.println(longestSubWithoutRepeat2("ahmat")); //4
        System.out.println(longestSubWithoutRepeat2("abcbabc")); //3
        System.out.println(longestSubWithoutRepeat2("abcabbcbbabcd")); //4
        System.out.println(longestSubWithoutRepeat2("abcabcbbbggaabc"));

        System.out.println(lengthOfLongestSubstring("abcabbcbb"));
        System.out.println(lengthOfLongestSubstring("abcabbcbbabcd"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcbabc"));
        System.out.println(lengthOfLongestSubstring("abcabcbbbggaabc"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println(lengthOfLongestSubstring2("abcabbcbb"));
        System.out.println(lengthOfLongestSubstring2("abcabbcbbabcd"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcbabc"));
        System.out.println(lengthOfLongestSubstring2("abcabcbbbggaabc"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));

    }

    public static int longestSubWithoutRepeat(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            String control = str.substring(i, i + 1);
            for (int j = i + 1; j < str.length(); j++) {
                if (!control.contains(str.substring(j, j + 1))) {
                    control += str.substring(j, j + 1);
                } else break;
            }
            max = Math.max(max, control.length());
        }
        return max;
    }

    public static int longestSubWithoutRepeat2(String str) {
        if (str.length() == 0) return 0;
        List<String> allSubs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String newStr = str.substring(i, j);
                allSubs.add(newStr);
            }
        }
        System.out.println("allSubs = " + allSubs);
        List<String> allUniqueSubs = new ArrayList<>();
        for (String sub : allSubs) {
            if (isUnique(sub)) {
                allUniqueSubs.add(sub);
            }
        }
        System.out.println("allUniqueSubs = " + allUniqueSubs);
        List<Integer> allUniqueSubsLength = new ArrayList<>();
        for (String allUniqueSub : allUniqueSubs) {
            allUniqueSubsLength.add(allUniqueSub.length());
        }
        return Collections.max(allUniqueSubsLength);
    }

    public static boolean isUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }



    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int lastIdx = map.get(c);
                if (i - lastIdx <= dp[i - 1]) {
                    dp[i] = i - lastIdx;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }



}
