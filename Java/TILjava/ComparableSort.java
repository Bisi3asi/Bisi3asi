package JavaPractice;
import java.util.ArrayList;
import java.util.Collections;

class Pos implements Comparable<Pos> {
    int x;
    int y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pos p) {
        if (this.x == p.x) return p.y - this.y;
        else return p.x - this.x;
    }
}

class ComparableSort {
    public static void main(String[] args) {
        ArrayList<Pos> list = new ArrayList<>();
        list.add(new Pos(4, 1));
        list.add(new Pos(1, 3));
        list.add(new Pos(1, 2));
        list.add(new Pos(3, 3));

        Collections.sort(list);
        for (Pos p : list) System.out.println(p.x+ " "+p.y);
    }
}