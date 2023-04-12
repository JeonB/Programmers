package 달리기경주;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer =new String[players.length];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i< players.length ;i++){
            map.put(players[i],i);
        }
        int idx = 0;
        String tmp = "";
        for (String call : callings) {
            idx = map.get(call);
            tmp = players[idx - 1];
            players[idx - 1] = call;
            players[idx] = tmp;
            map.replace(call,idx-1);
            map.replace(tmp,idx);
        }
        return answer;
    }
    /* 시간초과로 통과 실패 indexOf()는 시간복잡도가 n이다(최악의 경우 리스트 엘리먼트 전부 순회). 반복문 안에서 사용하면 O(n^2)이므로
    시간 초과가 발생할 수 밖에 없다.
    public String[] solution(String[] players, String[] callings) {
        List<String> list = new ArrayList<>(Arrays.asList(players));

        int temp = 0;
        for (String call: callings) {
            temp = list.indexOf(call);
            temp--;
            list.remove(call);
            list.add(temp,call);
        }
        String[] answer = list.toArray(new String[players.length]);

        return answer;
    }
    */

    /* 시간 초과2
    public String[] solution(String[] players, String[] callings) {
        List<String> list = new LinkedList<>(Arrays.asList(players));

        int temp = 0;
        int idx = 0;
        String tempStr = "";
        for (String call: callings) {
            idx = list.indexOf(call);
            temp = idx-1;
            tempStr = list.get(temp);
            list.set(temp,call);
            list.set(idx,tempStr);
        }
        String[] answer = list.toArray(new String[players.length]);

        return answer;
    }
    */
}
