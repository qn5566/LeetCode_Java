package FoodPandan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 解題
 * https://www.geeksforgeeks.org/smallest-substring-with-each-letter-occurring-both-in-uppercase-and-lowercase/
 * 
 * To optimize the above approach, the idea is to use the concept of Sliding
 * Window. Follow the steps below to solve the problem:
 * 
 * Traverse the given string and store the characters whose only lowercase or
 * uppercase form are present in the input string in a Map mp.
 * Initialize two arrays to keep track of the lowercase and uppercase characters
 * obtained so far.
 * Now, traverse the string maintaining two pointers i and st (initialized with
 * 0), where st will point to the start of the current substring and i will
 * point to the current character.
 * If the current character is in mp, neglect all the characters obtained so far
 * and start from the next character and adjust the arrays accordingly.
 * If the current character is not in mp, remove the extra characters from the
 * beginning of the substring with the help of st pointer, such that the
 * frequency of any character does not convert to 0 and adjust the arrays
 * accordingly.
 * Now, check whether the substring {S[st], ….., S[i]} is balanced or not. If
 * balanced and i – st + 1 is smaller than the length of balanced substring
 * obtained so far. Update the length and also store the start and end indices
 * of the substring, i.e. st and i respectively.
 * Repeat the steps till the end of the string.
 */
class Solution {
    static boolean balanced(int small[],
            int caps[]) {
        for (int i = 0; i < 26; i++) {
            if (small[i] != 0 && (caps[i] == 0))
                return false;

            else if ((small[i] == 0) && (caps[i] != 0))
                return false;
        }
        return true;
    }

    static void smallestBalancedSubstring(String s) {

        int[] small = new int[26];

        int[] caps = new int[26];

        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        // Count frequency of characters
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                caps[s.charAt(i) - 'A']++;
            else
                small[s.charAt(i) - 'a']++;
        }

        Map<Character, Integer> mp = new HashMap<Character, Integer>();

        for (int i = 0; i < 26; i++) {
            if (small[i] != 0 && caps[i] == 0)
                mp.put((char) (i + 'a'), 1);
            else if (caps[i] != 0 && small[i] == 0)
                mp.put((char) (i + 'A'), 1);

        }

        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        int i = 0, st = 0;

        int start = -1, end = -1;

        int minm = Integer.MAX_VALUE;

        while (i < s.length()) {
            if (mp.get(s.charAt(i)) != null) {
                while (st < i) {
                    if (s.charAt(st) >= 65 &&
                            s.charAt(st) <= 90)
                        caps[s.charAt(st) - 'A']--;
                    else
                        small[s.charAt(st) - 'a']--;

                    st++;
                }
                i += 1;
                st = i;
            } else {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                    caps[s.charAt(i) - 'A']++;
                else
                    small[s.charAt(i) - 'a']++;
                while (true) {
                    if (s.charAt(st) >= 65 &&
                            s.charAt(st) <= 90 &&
                            caps[s.charAt(st) - 'A'] > 1) {
                        caps[s.charAt(st) - 'A']--;
                        st++;
                    } else if (s.charAt(st) >= 97 &&
                            s.charAt(st) <= 122 &&
                            small[s.charAt(st) - 'a'] > 1) {
                        small[s.charAt(st) - 'a']--;
                        st++;
                    } else
                        break;
                }

                if (balanced(small, caps)) {
                    if (minm > (i - st + 1)) {
                        minm = i - st + 1;
                        start = st;
                        end = i;
                    }
                }
                i += 1;
            }
        }

        if (start == -1 || end == -1) {
            System.out.println(-1);
        } else {
            String ans = "";
            for (int j = start; j <= end; j++)
                ans += s.charAt(j);

            System.out.println(ans);
        }
    }
}
