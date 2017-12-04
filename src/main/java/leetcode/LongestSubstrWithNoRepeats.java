package leetcode;

import java.util.HashMap;
import java.util.Arrays;

public class LongestSubstrWithNoRepeats {
  public static void main (String [] args) {
    LongestSubstrWithNoRepeats p = new LongestSubstrWithNoRepeats();
    String def = "pwwkew";

    System.out.println("LSWNR for " + (args.length > 0 ? args[0] : def) + ": " +  p.lengthOfLongestSubstring(args.length > 0 ? args[0] : def));
    System.out.println("LSWNR for " + (args.length > 0 ? args[0] : def) + ": " +  p.lengthOfLongestSubstringFast(args.length > 0 ? args[0] : def));
  }

  // See if I can do better in terms of timing by avoiding the use of hashmap lookups
  // the idea is to think that max such length is <= # letters in the alphabet
  public int lengthOfLongestSubstringFast(String s) {
    int [] alph = new int[256];
    Arrays.fill(alph, -1);

    int startIdx = 0;
    int endIdx = 0;

    int maxLength = -1;
    int runningLength = 0;

    while (endIdx < s.length()) {
      char c = s.charAt(endIdx);
      
      if (alph[c] >= startIdx) {
        runningLength = endIdx - alph[c]; 
        startIdx = alph[c] + 1;
      } else {
        ++runningLength;
        maxLength = runningLength > maxLength ? runningLength : maxLength;
      }
      alph[c] = endIdx;

      ++endIdx;
    }
    return maxLength;
  }

  // My original code
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> charToPos = new HashMap<>();
    int startIdx = 0;
    int endIdx = 0;

    int maxStartIdx = 0;
    int maxEndIdx = 0;
    int maxLength = -1;
    int runningLength = 0;

    while (endIdx < s.length()) {
      Character c = s.charAt(endIdx);
      if (charToPos.containsKey(c)){
        // Check if pos of that is within our window
        if (charToPos.get(c) >= startIdx) {
          // char at endIdx is a duplicate, so update startIdx and update char's pos
          if (runningLength > maxLength){
            maxLength = runningLength;
            maxEndIdx = endIdx-1;
            maxStartIdx = startIdx;
          }
          startIdx = charToPos.get(c) + 1;
          charToPos.put(c, endIdx);
          runningLength = (endIdx - startIdx) + 1;
        } else {
          // char from a previous window, so update its pos
          charToPos.put(c, endIdx);
          ++runningLength;
        }
      } else {
        charToPos.put(c, endIdx);
        ++runningLength;
      }

      ++endIdx;
    }
    
    if (runningLength > maxLength) {
      maxLength = runningLength;
      maxEndIdx = --endIdx;
    }

    System.out.println("**startIdx: " + startIdx + " endIdx: "  + endIdx + " maxStartIdx: " + maxStartIdx + " maxEndIdx: " + maxEndIdx);
    System.out.println("Longest substr with no repeats for: " + s + " is " + (s.substring(maxStartIdx, maxEndIdx+1)));
    return  maxLength;
  }
}
