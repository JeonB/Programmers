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
/* 모범답안. Set은 중복을 자동으로 걸러준다. TreeSet은 HashSet과 마찬가지로 Set 인터페이스를 구현한 클래스로, 중복도 제거하면서 정렬도 해준다.
HashSet과는 달리 레드블랙 트리로써 정렬과 검색에 좀 더 유리하다.반면, HashSet은 값의 추가와 삭제에 좀 더 유리하다.
public Integer[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
      
        return set.toArray(new Integer[0]);
    }
 */
