package weekOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class MaxSlidingWindow {
    static int n;
    static int[] array;
    static int windows;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(tokenizer.nextToken());
            }
            windows = Integer.parseInt(br.readLine());
        }

        bruteForce();
        optimized();
    }

    static void bruteForce() {
        for (int i = 0; i <= n - windows; i++) {
            int max = 0;
            for (int j = i; j < i + windows; j++) {
                max = Math.max(max, array[j]);
            }
            System.out.println(max);
        }
    }

    static void optimized() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            deque.addLast(i);
            if (deque.peekFirst() == i - windows) {
                deque.pollFirst();
            }

            if (i >= windows - 1) {
                System.out.println(array[deque.peekFirst()]);
            }
        }

    }
}
