package JavaPractice;

import java.util.Scanner;
public class Scan{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        if(1 <= str.length() && 10 >= str.length()){
            if(1 <= n && 5 >= n){
                for(int i=1; i<=n; i++){
                    System.out.printf(str);
                }
            }
        }
        if(1 <= str.length() && 10 >= str.length()){
            if(1 <= n && 5 >= n){
                System.out.printf(str.repeat(n)); /*repeat 메소드 활용법도 있음*/
                }
            }
        sc.close();
    }
}
