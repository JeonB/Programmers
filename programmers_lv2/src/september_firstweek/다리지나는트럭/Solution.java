package september_firstweek.다리지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * @param bridge_length 다리에 오를 수 있는 최대 트럭 수
     * @param weight 제한 무게
     * @param truck_weights 각 트럭 무게
     * @return 모든 트럭이 다리를 통과 하는데 걸리는 최소 시간 초
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> trucks = new LinkedList<>();

        int weights = 0;
        for (int truck_weight : truck_weights) {

            while (true) {
                if (trucks.isEmpty()) {
                    trucks.offer(truck_weight);
                    weights += truck_weight;
                    answer++;
                    break;
                } else if (trucks.size() == bridge_length) {
                    weights -= trucks.poll();
                } else {
                    if (truck_weight + weights <= weight) {
                        trucks.offer(truck_weight);
                        weights += truck_weight;
                        answer++;
                        break;
                    } else {
                        trucks.offer(0);
                        answer++;
                    }
                }
            }
        }

        answer += bridge_length;

        return answer;
    }
}