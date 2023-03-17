package DartGame;
public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        int[] num =new int[3];
        int j = 0;
        for(int i=0; i<dartResult.length();i++){
            if(0<=dartResult.charAt(i)-'0'&&dartResult.charAt(i)-'0'<=9){
                if(dartResult.charAt(i)=='1'){
                    if(dartResult.charAt(i+1) == '0'){
                        num[j] =10;
                        i++;
                        continue;
                    }
                }
                num[j] = dartResult.charAt(i)-'0';
            }
            else if(dartResult.charAt(i)=='S'){
                num[j] = (int)Math.pow(num[j],1);
                j++;
            }
            else if(dartResult.charAt(i)=='D'){
                num[j] = (int)Math.pow(num[j],2);
                j++;
            }
            else if(dartResult.charAt(i)=='T'){
                num[j] = (int)Math.pow(num[j],3);
                j++;
            } else if (dartResult.charAt(i)=='*') {
                num[j-1] = num[j-1]*2;
                if(j>1){
                    int k = j-2;
                    num[k] = num[k]*2;

                }
            } else if(dartResult.charAt(i)=='#'){
                num[j-1] = -num[j-1];
            }
        }
        answer = num[0]+num[1]+num[2];
        return answer;
    }
}

