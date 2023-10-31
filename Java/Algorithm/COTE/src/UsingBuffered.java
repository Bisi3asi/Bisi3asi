import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class UsingBuffered {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] ch;

    public void DFS(int L) throws IOException {// Level {
        if (L == n + 1) {
            String temp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    temp += (i+ " ");
                }
            }
            if (temp.length() > 0) bw.write(temp+"\n");
        } else {
            ch[L] = 1;
            DFS(L + 1); // 왼쪽으로 뻗는 가지
            ch[L] = 0;
            DFS(L + 1); // 오른쪽으로 뻗는 가지
        }
    }

    public static void main(String[] args) throws IOException {
        UsingBuffered T = new UsingBuffered();

        try {
            n = Integer.parseInt(T.br.readLine());
            ch = new int[n + 1];
            T.DFS(1);
        } catch (IOException e) {
            T.bw.write(String.valueOf(e));
        }
        T.bw.flush();
        T.bw.close();
        T.br.close();
    }
}
