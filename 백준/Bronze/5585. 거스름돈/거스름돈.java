import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int charge = 1000 - Integer.parseInt(br.readLine());
        int count = 0;

        if(charge>=500){
            count += charge/500;
            charge %= 500;
        }
        if(charge>=100){
            count += charge/100;
            charge %= 100;
        }
        if(charge>=50){
            count += charge/50;
            charge %= 50;
        }
        if(charge>=10){
            count += charge/10;
            charge %= 10;
        }
        if(charge>=5){
            count += charge/5;
            charge %= 5;
        }
        if(charge>=1){
            count += charge;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

 }

