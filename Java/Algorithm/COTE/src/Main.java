import java.util.Scanner;
class Main{
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isAlphabetic(str.charAt(i))) {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        String temp = sb.toString();
        return (temp.contentEquals(sb.reverse()) ? "YES" : "NO");
    }
    public static void main(String[] args) {
        // 실행시간 측정
        // long beforeTime = System.currentTimeMillis();
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println((T.solution(str)));
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}

