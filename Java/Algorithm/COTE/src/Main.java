import java.util.Scanner;

class Main{
    public String[] solution(int n, String[] word) {
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            sb.append(word[i]);
            answer[i] = sb.reverse().toString();
            sb.setLength(0);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.next();
        for(String s : T.solution(n, arr))
            System.out.println(s);
    }
}

