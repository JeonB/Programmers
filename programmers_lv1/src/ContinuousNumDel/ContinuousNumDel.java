package ContinuousNumDel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ContinuousNumDel {

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 7, 7, 3, 4, 4, 5, 1, 1, 1, 3, 3, 3 };
    System.out.println(Arrays.toString(solution2(arr)));
  }

  public static int[] solution(int[] arr) {
    //String[] arr2 = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
    //LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(arr2));
    LinkedList<Integer> linkedList = new LinkedList<>();
    ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays
      .stream(arr)
      .boxed()
      .collect(Collectors.toList());
    // ArrayList<Integer> arrayList = (ArrayList<Integer>) IntStream.of(arr).boxed().collect(Collectors.toList());
    int i = 0;
    for (int j = 0; j < arr.length - 1; j++) {
      if (arr[j] == arr[j + 1]) {} else {
        linkedList.add(i, arrayList.get(j));
        i++;
      }
      if (j == arr.length - 2) {
        linkedList.add(i, arrayList.get(j + 1));
      }
    }
    // String[] resultArr = Arrays
    //   .stream(arr)
    //   .distinct()
    //   .mapToObj(String::valueOf)
    //   .toArray(String[]::new);
    // int[] answer = Stream.of(resultArr).mapToInt(Integer::parseInt).toArray();
    int[] answer = linkedList.stream().mapToInt(Integer::intValue).toArray();
    return answer;
  }

  //모범답안 굉장히 깔끔
  public static int[] solution2(int[] arr) {
    ArrayList<Integer> tempList = new ArrayList<Integer>();
    int preNum = 10;
    for (int num : arr) {
      if (preNum != num) tempList.add(num);
      preNum = num;
    }
    int[] answer = tempList.stream().mapToInt(Integer::intValue).toArray();
    /* 
    int[] answer = int[templist.size()];
     for(int i =0;i<answer.length;i++){
      answer[i] = tempList.get(i).intValue();
     }
     */
    return answer;
  }

  public int[] solution3(int []arr) {

    Stack<Integer> st = new Stack<>();
    for(int num : arr){
      if(st.isEmpty()){
        st.push(num);
      }
      else if(!st.contains(num) || st.peek() != num){
        st.push(num);
      }
    }
    Integer[] tempArr = st.toArray(new Integer[st.size()]);
    int[] answer = new int[tempArr.length];
    for(int i = 0; i < tempArr.length ; i++){
      answer[i] = tempArr[i];
    }

    return answer;
  }
}
