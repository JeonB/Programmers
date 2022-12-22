public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(3);
        String test = new String("hi"); //추천하지 않는 방법
        String test2 = "sibbalk";
        int i = 1;
        String a = i + test2 + i;
        System.out.println(a);
        sb.append(test2);
        sb.insert(6, "Jon");
        sb.toString();
        System.out.println(sb);
    }


}
