import java.util.Scanner;

class Main{
    public int solution(String str, char t) {
        int answer = 0;
        t = Character.toLowerCase(t);
        char[] arr = str.toLowerCase().toCharArray();
        for(char c : arr){
            if(c == t) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // sc.next() string으로 가져온다
        char c = sc.next().charAt(0);
        // char 가져올 댸는 string에서 charAt(index)로 한자리수만 가져온다.
        System.out.println(T.solution(str, c));
    }
}

