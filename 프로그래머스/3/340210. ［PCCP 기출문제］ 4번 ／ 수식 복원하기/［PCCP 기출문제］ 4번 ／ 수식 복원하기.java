// 개선된 버전
class Solution {
    public String[] solution(String[] expressions) {
        // 모든 표현식을 대상으로, 각 base(2~9)가 artifact에 등장하는 모든 숫자를 표현 가능한지,
        // 그리고 완전한 수식에 대해 산술 연산이 성립하는지를 체크하여 후보 진법을 결정한다.
        java.util.ArrayList<Integer> candBases = new java.util.ArrayList<>();
        for (int b = 2; b <= 9; b++) {
            boolean valid = true;
            for (String expr : expressions) {
                String[] parts = expr.split(" ");
                if (!isValid(parts[0], b) || !isValid(parts[2], b)) { 
                    valid = false; break; 
                }
                if (!parts[4].equals("X")) {
                    if (!isValid(parts[4], b)) { valid = false; break; }
                    int a = toInt(parts[0], b);
                    int bVal = toInt(parts[2], b);
                    int c = toInt(parts[4], b);
                    int res = parts[1].equals("+") ? a + bVal : a - bVal;
                    if (res != c) { valid = false; break; }
                }
            }
            if (valid) candBases.add(b);
        }
        
        // 각 미완성 수식(X가 있는)에 대해, 모든 후보 진법에서 계산한 결과가 동일하면 그 값을,
        // 다르면 "?"로 채워 넣는다.
        java.util.ArrayList<String> resultList = new java.util.ArrayList<>();
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            if (parts[4].equals("X")) {
                java.util.HashSet<String> outcomes = new java.util.HashSet<>();
                for (int base : candBases) {
                    int a = toInt(parts[0], base);
                    int bVal = toInt(parts[2], base);
                    int res = parts[1].equals("+") ? a + bVal : a - bVal;
                    outcomes.add(toBaseStr(res, base));
                }
                String fill = outcomes.size() == 1 ? outcomes.iterator().next() : "?";
                resultList.add(parts[0] + " " + parts[1] + " " + parts[2] + " = " + fill);
            }
        }
        return resultList.toArray(new String[0]);
    }
    
    private boolean isValid(String s, int base) {
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (d < 0 || d >= base) return false;
        }
        return true;
    }
    
    private int toInt(String s, int base) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            val = val * base + d;
        }
        return val;
    }
    
    private String toBaseStr(int num, int base) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int d = num % base;
            sb.append((char)('0' + d));
            num /= base;
        }
        return sb.reverse().toString();
    }
}
