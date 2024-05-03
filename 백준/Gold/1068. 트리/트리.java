import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int N, delete, rootIndex, count = 0;
    static boolean[] visited;
    static LinkedList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new LinkedList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == -1) {
                rootIndex = i;
                continue;
            }
            tree[n].add(i);
        }
        delete = sc.nextInt();

        if (delete == rootIndex) {
            count = 0;
        } else {
            dfs(rootIndex);
        }
        System.out.println(count);
    }

    static void dfs(int node) {
        if (node == delete) {
            visited[node] = true;
            return;
        }

        if (tree[node].isEmpty()) {
            visited[node] = true;
            count++;
            return;
        }

        boolean hasChild = false;
        for (int i = 0; i < tree[node].size(); i++) {
            Integer child = tree[node].get(i);
            if (child == delete) {
                visited[child] = true;
                continue;
            }
            if (!visited[child]) {
                hasChild = true;
                dfs(child);
            }
        }

        // 삭제된 노드의 부모 노드가 자식이 없을 때 count 증가
        if (!hasChild) {
            count++;
        }
    }
}
