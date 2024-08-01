import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isMinusExist = false;

        String operation = br.readLine();
        char[] operationArr = operation.toCharArray();
        for (int i = 0; i < operationArr.length; i++) {
            if (isMinusExist == false && operationArr[i] == '-') {
                isMinusExist = true;
                continue;
            }
            if(isMinusExist){
                if(operationArr[i] == '+'){
                    operationArr[i] = '-';
                }
            }
        }
        String result = String.valueOf(operationArr);
        String[] resultByMinus = result.split("-");
        int sum = 0;

        for(int i = 0 ; i < resultByMinus.length; i++){
            if(resultByMinus[i].contains("+")){
                String[] resultByPlus = resultByMinus[i].split("\\+");
                int tempSum = 0;
                for(int j = 0; j < resultByPlus.length; j++){
                    tempSum += Integer.parseInt(resultByPlus[j]);
                }
                sum += tempSum;
                continue;
            }
            if(i == 0){
                sum += Integer.parseInt(resultByMinus[i]);
                continue;
            }
            sum -= Integer.parseInt(resultByMinus[i]);
        }



        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}