package september_firstweek.할인행사;

import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < want.length; i++)
            map.put(want[i], number[i]);

        for (int i = 0; i < discount.length - 9; i++) {

            for (int j = i; j < i + 10; j++) {
                if (map.get(discount[j]) != null && map.get(discount[j]) > 0) {
                    map.put(discount[j], map.get(discount[j]) - 1);
                }
            }

            boolean hasNonZeroValue = map.values().stream().anyMatch(value -> value != null && value != 0);
            if (!hasNonZeroValue)
                answer++;

            for (int k = 0; k < want.length; k++)
                map.put(want[k], number[k]);
        }

        return answer;
    }
}