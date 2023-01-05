package 두개뽑아서더하기;

import java.util.*;
import java.util.stream.Collectors;

public class sumTwoNums {

  public int[] solution(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        list.add(numbers[i] + numbers[j]);
      }
    }
    Collections.sort(list);
    List<Integer> newList = list
      .stream()
      .distinct()
      .collect(Collectors.toList());
    return newList.stream().mapToInt(i -> i).toArray();
  }
}
/* 모범답안. Set은 중복을 자동으로 걸러준다. TreeSetdms 중복도 제거하면서 정렬도 해준다.
 public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
 */
