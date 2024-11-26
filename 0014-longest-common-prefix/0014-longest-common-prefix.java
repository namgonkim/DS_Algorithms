import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String maxStr = strs[strs.length-1];
        String minStr = strs[0];

        // 젤 긴거랑 젤 짧은거랑 한글자씩 비교 
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            if(idx >= minStr.length()) {
                break;
            }
            if(maxStr.charAt(idx) == minStr.charAt(idx)) {
                sb.append(minStr.charAt(idx));
                idx++;
            }
            else {
                break;
            }
        }
        return sb.toString();
    }
}