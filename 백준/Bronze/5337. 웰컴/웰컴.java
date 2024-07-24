import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


       bw.write(".  .   .\n" +
               "|  | _ | _. _ ._ _  _\n" +
               "|/\\|(/.|(_.(_)[ | )(/.\n");

        bw.flush();
        bw.close();
    }

    }

