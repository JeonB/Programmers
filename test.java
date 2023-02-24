import java.util.*;

public class test {

  static Scanner scan = new Scanner(System.in);
  static List<String> nameList = new LinkedList<>();
  static List<List<Double>> scoreList = new ArrayList<>();
  static boolean flag2 = true;
  static int name_index = 0;
  // static String name = "";

  static String[] subject = { "국어", "영어", "수학" };

  public static void main(String[] args) {
    boolean flag = true;
    while (flag) {
      System.out.println("==============================");
      System.out.println("\t성적 관리 시스템");
      System.out.println("------------------------------");
      System.out.println("  1. 성적 등록");
      System.out.println("  2. 성적 조회(전체)");
      System.out.println("  3. 성적 검색");
      System.out.println("  4. 성적 수정");
      System.out.println("  5. 성적 삭제");
      System.out.println("  0. 프로그램 종료");
      System.out.println("==============================");
      System.out.print("메뉴선택(숫자)> ");
      int menu = scan.nextInt();

      switch (menu) {
        case 1: //등록
          System.out.print("학생 수 입력 :");
          scoreRegistration();
          break;
        case 2: //조회(전체)
          scoreTotSearch();
          break;
        case 3: //검색
          System.out.println("성적 검색");
          System.out.print("검색하려는 학생 이름 입력 > ");
          scoreSearch();
          break;
        case 4: //수정
          System.out.println("성적 검색");
          System.out.print("수정하려는 학생 이름 입력 > ");
          scoreFix();
          break;
        case 5: //삭제
          System.out.println("성적 삭제");
          System.out.print("삭제하려는 학생 이름 입력 > ");
          scoreDelete();
          break;
        case 0: //프로그램 종료
          System.out.println("프로그램을 종료합니다.");
          flag = false;
          //System.exit(0);
          break;
        default: //메뉴 이외의 다른 숫자 입력 시
          System.out.println("다른 메뉴를 선택해주세요");
      } //switch
    } //while

    System.out.println("-- 프로세스 종료 --");
  } //main

  //성적 등록
  public static void scoreRegistration() {
    int size = scan.nextInt();
    String name = "";
    boolean flag = true;
    for (int i = 0; i < size; i++) {
      List<Double> score = new ArrayList<>();
      System.out.print("이름 등록: ");
      name = scan.next();
      //중복체크
      if (isDuplicate(name)) {
        size++;
        continue;
      } else {
        nameList.add(name);
        for (int j = 0; j < subject.length; j++) {
          System.out.printf("%s 점수: ", subject[j]);
          score.add(scan.nextDouble());
        }
        System.out.println();
        scoreList.add(score);
      }
    }
    while (flag) {
      System.out.println(
        "추가로 등록하시겠습니까? 계속 하시려면 아무키나 누르십시오."
      );
      System.out.println("종료하시려면 n을 눌러주세요");
      char c = scan.next().charAt(0);
      if (c == 'n') {
        flag = false;
      } else {
        addRegi();
      }
    }
  }

  //추가 등록
  public static void addRegi() {
    String name = "";
    List<Double> score = new ArrayList<>();
    System.out.print("이름 등록: ");
    name = scan.next();
    //중복체크
    if (isDuplicate(name)) {
      addRegi();
    } else {
      nameList.add(name);
      for (int j = 0; j < subject.length; j++) {
        System.out.printf("%s 점수: ", subject[j]);
        score.add(scan.nextDouble());
      }
      System.out.println();
      scoreList.add(score);
    }
  }

  //중복체크
  public static boolean isDuplicate(String name) {
    if (nameList.contains(name)) {
      System.out.println("이미 등록된 이름입니다");
      System.out.println("다시 등록해 주십시오");
      return true;
    } else {
      return false;
    }
  }

  //성적 조회
  public static void scoreTotSearch() {
    if (scoreList == null || scoreList.isEmpty()) {
      System.out.println("목록이 비어있습니다!");
    } else {
      System.out.println("전체 학생 성적 조회");
      for (int i = 0; i < scoreList.size(); i++) {
        double tot = 0;
        double avg = 0;
        System.out.printf("%s > ", nameList.get(i));
        for (int j = 0; j < subject.length; j++) {
          System.out.printf("%s: %.2f ", subject[j], scoreList.get(i).get(j));
          tot += scoreList.get(i).get(j);
        }
        avg = tot / 3;
        System.out.printf(" 총점: %.2f 평균: %.2f\n", tot, avg);
      }
    }
  }

  //특정 학생의 성적 검색
  public static void scoreSearch() {
    String name = "";
    name = scan.next();
    if (nameList.contains(name)) {
      System.out.printf(
        "%s의 과목 성적: ",
        nameList.get(nameList.indexOf(name))
      );
      System.out.println(scoreList.get(nameList.indexOf(name)));
      flag2 = true;
      name_index = nameList.indexOf(name);
    } else {
      System.out.println("일치하는 학생이 없습니다!");
      System.out.println("메인 메뉴로 돌아갑니다");
      flag2 = false;
    }
  }

  //성적 수정
  public static void scoreFix() {
    scoreSearch();
    if (flag2 == true) {
      int count = 0;
      for (int j = 0; j < subject.length; j++) {
        System.out.printf(
          "수정하려는 과목 선택 >> \"%s\"를 수정하시겠습니까? 수정하시려면 y키 입력, 아니라면 아무 키나 입력",
          subject[j]
        );
        char select = scan.next().charAt(0);
        switch (select) {
          case 'y':
            System.out.print("수정하려는 점수 입력: ");
            scoreList.get(name_index).set(j, scan.nextDouble());
            count++;
            break;
        }
      }
      if (count > 0) {
        System.out.printf("수정된 %s의 과목 성적: ", nameList.get(name_index));
        System.out.println(scoreList.get(name_index));
      } else {
        System.out.println("성적 수정 작업을 취소합니다!");
      }
    }
  }

  //성적 삭제
  public static void scoreDelete() {
    scoreSearch();
    if (flag2 == true) {
      System.out.println(
        "정말로 삭제하시겠습니까? 삭제하시려면 y키를 누르십시오. 삭제를 취소하시려면 아무키나 누르십시오."
      );
      char select = scan.next().charAt(0);

      switch (select) {
        case 'y':
          scoreList.remove(name_index);
          nameList.remove(name_index);
          System.out.println("삭제 완료!");
          break;
        default:
          System.out.println("성적 삭제 작업을 취소합니다!");
      }
    }
  }
}
