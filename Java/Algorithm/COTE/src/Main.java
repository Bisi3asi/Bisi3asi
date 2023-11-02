import java.util.Arrays;

class Main {
    public static String solution(String s) {
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(i == 0 && Character.isAlphabetic(arr[i])) arr[i] = Character.toUpperCase(arr[i]);
            else if (arr[i-1] == ' ' && Character.isAlphabetic(arr[i]))
                arr[i] = Character.toUpperCase(arr[i]);
            else arr[i] = Character.toLowerCase(arr[i]);
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
}