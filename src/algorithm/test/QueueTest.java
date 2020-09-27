package algorithm.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 */
public class QueueTest {

    public void josephus(int n, int m) {
        Queue queue = new ArrayBlockingQueue(n + 1);
        for (int i = 0; i < n; i++)
            queue.add(i + 1);

        int count = 0;
        int index = 0;
        int[] order = new int[n + 1];
        while (!queue.isEmpty()) {
            Integer ppl = (Integer) queue.poll();
            count++;
            if (count + 1 == m) {
                order[index++] = ppl;
                count = 0;
                continue;
            }
            queue.add(ppl);
        }

        System.out.println(Arrays.toString(order));
    }

    @Test
    public void test() {
        josephus(12, 5);
    }
}
