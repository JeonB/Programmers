package 공원산책;

import java.util.Arrays;

public class Park {
    public String solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int n = park.length;
        int pos = 0;
        int index = 0;
        boolean hasS = true;
        for (int i = 0 ; i<n;i++){
            if(park[i].contains("S")){
                answer[1]+= park[i].indexOf('S');
                pos = park[i].indexOf('S');
                index = i;
                break;
            }
            else{
                answer[1] += park[i].length();
            }
        }

        for(int i = 0 ; i< routes.length ; i++){
            String[] route = routes[i].split(" ");
            int range = pos + Integer.parseInt(route[1]) ;
            if(range>park[index].length()){
                range = park[index].length();
            }
            if(route[0].equals("W")) {
                if (!(answer[1] - Integer.parseInt(route[1]) < 0) && !(park[index].substring(pos, range).contains("X")))
                   {
                    answer[1] -= Integer.parseInt(route[1]);
                    pos = 0;
                    index++;
                }
            }
            else if(route[0].equals("E")) {

                if (!(answer[1] + Integer.parseInt(route[1]) > park[index].length()-1)&& !(park[index].substring(pos , range).contains("X")))
                {
                    answer[1] += Integer.parseInt(route[1]);
                    pos = 0;
                    index++;
                }
            }
            else if(route[0].equals("N")) {
                if (!(answer[0]- Integer.parseInt(route[1]) <0) && !(park[index].substring(pos , range).contains("X")))
                {
                    answer[0] -= Integer.parseInt(route[1]);
                    pos = 0;
                    index++;
                }
            }
            else if(route[0].equals("S")) {
                if (!(answer[0] + Integer.parseInt(route[1]) > park[index].length()-1) && !(park[index].substring(pos, range).contains("X")))
                {
                    answer[0] += Integer.parseInt(route[1]);
                    pos = 0;
                    index++;
                }
              }
            }

        return Arrays.toString(answer);
    }
 }

