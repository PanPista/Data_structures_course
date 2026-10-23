package weekOne;

import java.util.*;
import java.io.*;

public class TreeHeightCalculation {

    static public void main(String[] args) throws IOException {
        new Thread(null, () -> {
            try {
                new TreeHeightCalculation().run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}

class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    FastScanner() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (!tok.hasMoreElements())
            tok = new StringTokenizer(in.readLine());
        return tok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}


class TreeHeight {
    int n;
    int[] parent;

    void read() throws IOException {
        FastScanner in = new FastScanner();
        n = in.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = in.nextInt();
        }
    }

    int computeHeight() {
        List<Integer>[] children = new ArrayList[n];
        Queue<Integer> queue = new ArrayDeque<>();
        int height = 0;
        int root = -1;

        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                children[parent[i]].add(i);
            } else  {
                root = i;
            }
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            height++;
            for (int i = 0; i < queue.size(); i++) {
                int vertex = queue.poll();
                queue.addAll(children[vertex]);
            }
        }

        return height;
    }
}

