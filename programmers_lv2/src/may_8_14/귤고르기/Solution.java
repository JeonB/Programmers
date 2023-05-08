package may_8_14.귤고르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
서로 다른 종류의 수를 최소화하고 k개에 해당하는 귤을 담을 때, 최소화한 서로 다른 종류의 수를 출력.
*/
public class Solution {
    public int solution(int k, int[] tangerine) {
        if(k==1)
            return 1;
        int answer = 0;
        int cnt = 1;
        int[] gyuel = Arrays.stream(tangerine).sorted().toArray();
        ArrayList<Integer> cntList = new ArrayList<>();

        for(int i = 1 ; i<gyuel.length ; i++){
            if(gyuel[i] != gyuel[i-1]){
                cntList.add(cnt);
                cnt = 0;
            }
            cnt++;
            if(i == gyuel.length -1)
                cntList.add(cnt);
        }
        Collections.sort(cntList);
        for(int i = 1 ; i<= cntList.size();i++){
            if(cntList.get(cntList.size() - i) >= k){
                answer++;
                break;
            }else{
                k-= cntList.get(cntList.size() - i);
                answer++;
            }
        }


        return answer;
    }
}

/* 맵을 사용함. 시간차이 그다지 없음
 public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key:list){
            k -=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }

        return answer;
    }
    */
