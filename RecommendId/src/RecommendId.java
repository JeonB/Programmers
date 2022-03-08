public class RecommendId {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("Aabcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        String answer = "";
        char lastChar;

        new_id = new_id.toLowerCase(); // 1단계 대문자를 소문자로 변경
        new_id = new_id.replaceAll("[^\\w\\d-_.]", ""); // 2단계 소문자,숫자,-,_,. 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[.]{2,}", "."); // 3단계 마침표가 2개이상일 때 한 개로 치환
        new_id = new_id.replaceAll("^[.]|[.]$", ""); // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거

        if (new_id.equals("")) { // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입
            new_id = "a";
        }
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15); // 6단계 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
            new_id = new_id.replaceAll("^[.]|[.]$", "");
        }
        if (new_id.length() < 3) {
            lastChar = new_id.charAt(new_id.length() - 1); // 문자열의 반복할 마지막 문자
            while (new_id.length() < 3) {
                new_id = new_id + String.valueOf(lastChar);
            }
        }

        answer = new_id;
        return answer;
    }

}