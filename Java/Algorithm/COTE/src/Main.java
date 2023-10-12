import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pof implements Comparable<Pof> {
    int x;
    int y;
    Pof(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pof p) {
        if (this.x == p.x) return this.y - p.y;
        else return this.x - p.x;
    }
}

class Main {
    public static void main(String[] args) {
        // 실행 시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pof> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            list.add(new Pof(x, y));
        }
        Collections.sort(list);
        for (Pof p : list) System.out.println(p.x+ " "+p.y);
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}