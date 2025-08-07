import java.util.*;

class Point {
    int x,y,dist;
    
    Point(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 방문 배열 선언
        boolean[][] visited = new boolean[102][102];
        // map 배열 선언
        int[][] map = new int[102][102];
        
        // step1. 사각형을 2배 한 다음 map에 넣기
        for (int rec[] : rectangle){
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            // 사각형 순회하면서 map배열에 찍기
            for (int i = x1; i <= x2; i++){
                for (int j = y1; j <= y2; j++){
                    // 사각형의 테두리에 있으면
                    if (i == x1 || i == x2 || j == y1 || j == y2){
                        // 테두리이자 내부가 아니면
                        if (map[i][j] != 2){
                            map[i][j] = 1;
                        }
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        // 새로운 큐를 생성
        Queue<Point> queue = new LinkedList<>();
        
        // 출발지랑 아이템 위치도 2배로 바꿔줌
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        queue.offer(new Point(characterX, characterY, 0));
        visited[characterX][characterY] = true; // 빼먹음
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            // 종료 조건 설정
            if (p.x == itemX && p.y == itemY){
                return p.dist / 2;
            }
            
            // 네 방향으로 이동
            for (int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                // 유효한 범위 내이고 <- 빼먹음
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102){
                    // 방문하지 않았고 갈 수 있으면
                    if (!visited[nx][ny] && map[nx][ny] == 1){
                        queue.offer(new Point(nx, ny, p.dist + 1));
                        visited[nx][ny] = true;
                    }
                }            
            }
        }
        return 0;
    }
}