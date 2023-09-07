package JavaPractice;
/* IntelliJ 단축키 정리 */
// 0. 탐색 관련
// ctrl + shift + a : 모든 액션(단축키) 탐색
// shift + shift : 모두 탐색
// f11 : 북마크 추가

// 1. 각주 관련
// ctrl + / : ln 각주
// ctrl + shift + / : 블럭 단위 주석 토글

// 2. 이동 관련
// shift + enter : 다음 줄로 생성하고 첫 줄로 이동
// tab / shift + tab : 들여쓰기, 내여쓰기
// ctrl + f8 : set breakpoint
// ctrl + g  : 해당 입력 줄로 이동
// alt + shift + up / down : 줄 바꾸기
// ctrl + b : 다음 심볼 선언으로 이동하기
// ctrl + alt + F7 : 어떤 항목이 사용된 위치를 모두 검색하기

// 3. 복사 관련
// ctrl + shift + v : 붙여넣기 선택(클립보드)
// ctrl + shift + alt + l / ctrl + alt + l : 서식 복사 / 서식 붙여넣기
// ctrl + d : 줄 전체 복사하기
// ctrl + w / ctrl + shift + t : 선택 영역 확대 / 축소

// 4. 코드 관련
// shift + F9 / shift + F10 : Debugger / Run
// ctrl + -/+ : 코드 블록 접기 / 펼치기
// alt + enter : 오류 발견 시 해당 오류에 대한 수정 제안 받기
// F2 : 다음 오류 / 경고 / 제안으로 점프
// alt + 1 : 도구창 열기
// ctrl + shift + alt + t : 리팩토링 제안
// ctrl + ctrl : run anything
// sout + tab : System.out.println 자동생성
// main + tab : public static void main(String[] args) {} 자동생성
// ctrl + alt + shift + a : Screenshot / * Plugin added

public class Operator {
    public static void main(String[] args) {
        int i;
        boolean tf = true;
        float fl = 7.5f; /*f 붙여야함 java는 실수값은 double이 default*/
        String str = "I am String";
        char ch =  'a';

        System.out.println("hello and welcome to java");
        System.out.println();
        for (i = 1; i <= 5; i++) {
            System.out.println(i + "번 출력");
        }
        System.out.println("String says : " + str);
        System.out.println("Char says : char ha h" + ch);

        int arr[] = {1, 2, 3, 4, 5};
        String strarr[] = {"hello", "mr", "my", "yesterday"};

        for (String a : strarr){ /* for each 문 arr가 가지고 있는 각각의 요소 a에 대해 반복한다 */
            System.out.printf(a);
            System.out.printf(" ");
        }
        System.out.println();

        for (i = 0; i < arr.length; i++) {
            int k = arr[i];
            System.out.printf("%d", k); /* printf는 decimal 넣어야한다. */
        }

    }
}
