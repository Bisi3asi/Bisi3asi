class DFSTest {
    static int n;
    static int[] ch;
    public void DFS(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) sb.append(i + " ");
            }
            if (sb.length()!= 0) System.out.println(sb);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        DFSTest T = new DFSTest();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);
    }
}