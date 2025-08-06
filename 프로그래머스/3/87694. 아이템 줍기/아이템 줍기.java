import java.util.*;

class Solution {
    // 맵 크기: 좌표는 1~50까지니까 2배하면 최대 100까지
    static int[][] board = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {1, -1, 0, 0}; // 우, 좌
    static int[] dy = {0, 0, 1, -1}; // 상, 하

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 좌표를 2배 확장해서 테두리 및 내부 설정
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            // 사각형 영역 순회
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    // 테두리 조건: 가장자리
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        // 내부가 아니면 테두리로 표시
                        if (board[i][j] != 2) {
                            board[i][j] = 1;
                        }
                    } else {
                        // 내부는 2로 표시
                        board[i][j] = 2;
                    }
                }
            }
        }

        // 2. BFS 탐색 시작 (캐릭터 시작점 → 아이템)
        Queue<Point> queue = new LinkedList<>();
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        queue.add(new Point(characterX, characterY, 0));
        visited[characterX][characterY] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 아이템에 도달하면 거리 반환 (2배 했으므로 반으로 나눔)
            if (p.x == itemX && p.y == itemY) {
                return p.dist / 2;
            }

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                // 조건: 범위 안이고, 방문 안 했고, 테두리(1)인 경우만 이동
                if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102) {
                    if (!visited[nx][ny] && board[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, p.dist + 1));
                    }
                }
            }
        }

        return 0; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }

    // 좌표와 거리 저장을 위한 내부 클래스
    static class Point {
        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
