import java.util.*;

public class Solution {
    public static int solution(String[] user_id, String[] banned_id) {
        List<List<String>> possibleMatches = new ArrayList<>();
        
        // 각 banned_id에 매칭되는 user_id 리스트를 구합니다.
        for (String ban : banned_id) {
            List<String> matches = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(user, ban)) {
                    matches.add(user);
                }
            }
            possibleMatches.add(matches);
        }

      
        // 가능한 제재 아이디 조합을 계산
        Set<Set<String>> result = new HashSet<>();
        findCombinations(possibleMatches, 0, new HashSet<>(), result);

        return result.size();
    }

    // banned_id와 user_id가 매칭되는지 확인
    private static boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // 가능한 조합을 구하는 DFS
    private static void findCombinations(List<List<String>> possibleMatches, int index, Set<String> current, Set<Set<String>> result) {
        if (index == possibleMatches.size()) {
            result.add(new HashSet<>(current));
            return;
        }

        for (String user : possibleMatches.get(index)) {
            if (!current.contains(user)) {
                current.add(user);
                findCombinations(possibleMatches, index + 1, current, result);
                current.remove(user);
            }
        }
    }

    
}
