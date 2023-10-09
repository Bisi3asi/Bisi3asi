import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LearnClassMethod {
    public static void main(String[] args) {

        /* Stack */
        // 1. 생성자
        Stack<String> stack = new Stack<>();
        // 2. push
        stack.push("철수");
        stack.push("영희");
        stack.push("바둑이");
        stack.push("갑돌이");
        stack.push("갑순이");
        System.out.println(stack);
        // out : 철수, 영희, 바둑이, 갑돌이, 갑순이
        // 3. pop
        System.out.println(stack.pop()); // out : 갑순이
        // 4. peek
        System.out.println(stack.peek()); // out : 갑돌이
        // 5. empty
        System.out.println(stack.empty()); // out : false
        // 6. search
        System.out.println(stack.search("철수")); // out : 4 (꼭대기에서 4번째)
        System.out.println(stack.search("민철")); // out : -1 (스택에 해당 원소 없음)
        // 7. size (extends Vector)
        System.out.println(stack.size()); // out : 4 (철수, 영희, 바둑이, 갑돌이)
        // 8. clear (extends Vector)
        stack.clear();
        System.out.println(stack.empty()); // out : true
        /* Queue */
        // 1. 생성자
        Queue<String> queue = new LinkedList<>();
        // 2. add, offer
        queue.add("철수");
        queue.add("영희");
        queue.offer("바둑이");
        System.out.println(queue); // out : 철수, 영희, 바둑이
        // 3. poll, peak, contains
        System.out.println(queue.poll()); // out : 철수
        System.out.println(queue.peek()); // out : 영희
        System.out.println(queue.contains("바둑이")); // out : true
        // 4. size, clear, isEmpty
        System.out.println(queue.size()); // out : 2
        queue.clear();
        System.out.println(queue.isEmpty()); // out : true

    }
}
