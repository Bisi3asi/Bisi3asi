package JavaPractice;

import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class UpperLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (1 <= a.length() && 20 >= a.length()){
            for(int i = 0; i < a.length(); i++){ // toCharArray 메소드로 변환하는 법도 있다.
                char c = a.charAt(i); // toCharArray 메소드로 변환하는 법도 있다.
                if((c >= 65 && c <= 90))
                    System.out.printf("%c", toLowerCase(c));  /* 소문자라면 */
                else if(c >= 97 && c <= 122) { /* 대문자라면 */
                System.out.printf("%c", toUpperCase(c));
                }
            }
        }
    }
}
