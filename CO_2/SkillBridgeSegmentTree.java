import java.util.Scanner;

class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] scores) {
        n = scores.length;
        tree = new int[4 * n];
        build(scores, 0, n - 1, 1);
    }

    void build(int[] scores, int start, int end, int node) {
        if (start == end) {
            tree[node] = scores[start];
            return;
        }

        int mid = (start + end) / 2;

        build(scores, start, mid, 2 * node);
        build(scores, mid + 1, end, 2 * node + 1);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    int rangeQuery(int start, int end, int left, int right, int node) {

        if (right < start || left > end)
            return 0;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        return rangeQuery(start, mid, left, right, 2 * node)
                + rangeQuery(mid + 1, end, left, right, 2 * node + 1);
    }

    void update(int start, int end, int index, int value, int node) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid)
            update(start, mid, index, value, 2 * node);
        else
            update(mid + 1, end, index, value, 2 * node + 1);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    int query(int left, int right) {
        return rangeQuery(0, n - 1, left, right, 1);
    }

    void updateScore(int index, int value) {
        update(0, n - 1, index, value, 1);
    }
}

public class SkillBridgeSegmentTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter assessment scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        SegmentTree st = new SegmentTree(scores);

        System.out.print("Enter query range (start end): ");
        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println("Range Sum = " + st.query(l, r));

        System.out.print("Enter index to update: ");
        int idx = sc.nextInt();

        System.out.print("Enter new score: ");
        int newScore = sc.nextInt();

        st.updateScore(idx, newScore);

        System.out.print("Enter query range after update (start end): ");
        l = sc.nextInt();
        r = sc.nextInt();

        System.out.println("Updated Range Sum = " + st.query(l, r));

        sc.close();
    }
}