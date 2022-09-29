package ua.lviv.iot;

import java.util.*;


class Node {

    public int x, y, min_distance;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int min_distance) {
        this.x = x;
        this.y = y;
        this.min_distance = min_distance;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y, min_distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y &&
                min_distance == node.min_distance;
    }
}

class Main {
    private static int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int[] col = {-1, 1, 1, -1, 2, -2, 2, -2};


    private static boolean isValid(int x, int y, int chessboard) {
        return (x >= 0 && x < chessboard) && (y >= 0 && y < chessboard);
    }

    public static int findShortestDistance(Node source, Node destination, int chessboard) {
        Set<Node> visited = new HashSet<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add(source);

        while (!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int min_distance = node.min_distance;

            if (x == destination.x && y == destination.y) {
                return min_distance;
            }

            if (!visited.contains(node)) {
                visited.add(node);

                for (int i = 0; i < row.length; i++) {
                    int x1 = x + row[i];
                    int y1 = y + col[i];

                    if (isValid(x1, y1, chessboard)) {
                        q.add(new Node(x1, y1, min_distance + 1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int chessboard = 8;
        Node source = new Node(0, 7);
        Node destination = new Node(7, 0);
        System.out.println("The minimum number of steps required is " +
                findShortestDistance(source, destination, chessboard));
    }
}
