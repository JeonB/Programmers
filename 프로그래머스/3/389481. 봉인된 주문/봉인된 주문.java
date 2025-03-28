import java.util.*;
class Solution {
    static final int MAX_LEN = 11;
    static final int ALPHABET_SIZE = 26;
    public String solution(long n, String[] bans) {
        Set<String> banSet = new HashSet<>(Arrays.asList(bans));
        long[] pow26 = new long[MAX_LEN + 1];
        pow26[0] = 1;
        for (int i = 1; i <= MAX_LEN; i++) {
            pow26[i] = pow26[i - 1] * ALPHABET_SIZE;
        }
        long[] cnt = new long[]{n};
        for (int len = 1; len <= MAX_LEN; len++) {
            long total = pow26[len];
            long banCount = 0;
            for (String s : banSet) {
                if (s.length() == len) banCount++;
            }
            long valid = total - banCount;
            if (cnt[0] <= valid) return rec("", len, cnt, banSet, pow26);
            else cnt[0] -= valid;
        }
        return "";
    }
    private String rec(String prefix, int len, long[] cnt, Set<String> banSet, long[] pow26) {
        if (prefix.length() == len) {
            if (banSet.contains(prefix)) return "";
            return prefix;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            String np = prefix + c;
            long total = pow26[len - np.length()];
            long banCnt = 0;
            for (String s : banSet) {
                if (s.length() == len && s.startsWith(np)) banCnt++;
            }
            long valid = total - banCnt;
            if (cnt[0] <= valid) {
                return rec(np, len, cnt, banSet, pow26);
            } else {
                cnt[0] -= valid;
            }
        }
        return "";
    }
}
