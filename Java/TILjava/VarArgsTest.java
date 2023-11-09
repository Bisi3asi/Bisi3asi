package JavaPractice;

import java.util.Arrays;

public class VarArgsTest {
    public int varArgs1(int... i) {
        int sum = 0;
        for (int num : i){
            sum += num;
        }
        return sum;
    }

    public int[] varArgs2(int...i){
        return i;
    }

    public void varArgs3(int a, int b, int...i){
        System.out.println(a + " : 저는 불변인자입니다");
        System.out.println(b + " : 저도 불변인자입니다");
        System.out.println(Arrays.toString(i) + " : 저희는 가변인자입니다");
    }

    public static void main(String[] args) {
        VarArgsTest T = new VarArgsTest();
        System.out.println(T.varArgs1(1, 3, 5, 7, 9));
        System.out.println(Arrays.toString(T.varArgs2(1, 3, 5, 7, 9)));
        T.varArgs3(1,3,5,7,9);
    }
}
