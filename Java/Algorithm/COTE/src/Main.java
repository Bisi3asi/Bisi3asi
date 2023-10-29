import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    static int[] arr;
    public int DFS(int n) {
        if (arr[n] > 0) return arr[n];
        if (n == 1) return arr[n] = 1;
        else if (n == 2) return arr[n] = 1;
        else return arr[n] = DFS(n-2) + DFS(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();
        try {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            T.DFS(n);
            for (int i = 1; i < n; i++)
            bw.write(arr[i] +" ");
        } catch (IOException e) {
            throw new IOException(e);
        }
        bw.close();
        br.close();
    }
}