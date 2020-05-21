import java.util.LinkedList;
import java.util.Deque;
/**
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("First");
        deque.addLast("Last");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            deque.pollFirst();
        }
        System.out.println(deque);
    }
}