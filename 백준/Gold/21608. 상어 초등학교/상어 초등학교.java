import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] order; // 앉힐 순서 저장
	static int[][] likes; // 각 학생이 좋아하는 학생 4명 저장
	static int[][] seats; // 놀이기구 좌석 배열
	static boolean[][] likeSet; //likeSet[s][x] = s 가 x를 좋아하면 true
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int total = n * n;
		
		order = new int[total];
		likes = new int[total + 1][4];
		seats = new int[n][n];
		likeSet = new boolean[total+1][total+1];
		
		for (int i = 0; i < total; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken()); 
			order[i] = student;
			
			for (int j = 0; j < 4; j++) {
				int f = Integer.parseInt(st.nextToken());
				likes[student][j] = f; // 좋아하는 학생 4명
				likeSet[student][f] = true;
			}
		}
		
		// 순서대로 배치
		seatAll();
		
		// 만족도 계산 후 출력
		int ans = calc();
		System.out.println(ans);
		
	}
	
	// 모든 학생을 순서대로 배치
	static void seatAll() {
		for (int i = 0; i < order.length; i++) {
			int s = order[i];
			placeStudent(s);
		}
	}
	
	static void placeStudent(int s) {
		// 지금까지 찾은 "최적의 칸" 정보를 저장할 변수들
		int bestR = -1, bestC = -1; // 최적 칸의 위치
		int bestLike = -1; // 그 칸에서 인접한 '좋아하는 학생' 수 
		int bestEmpty = -1; // 그 칸에서 인접한 '빈 칸' 수
		
		// 교실 모든 칸을 후보로 순회
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				// 이미 자리가 차 있으면 후보에서 제외
				if(seats[r][c] != 0) continue;
				
				int likeCnt = 0; // 현재 칸 (r,c) 기준으로 인접 4칸 중 좋아하는 학생 수
				int emptyCnt = 0; // 현재 칸 (r,c) 기준으로 인접 4칸 중 빈 칸 수
				
				// 상하좌우 인접 4칸 조사
				for (int d = 0; d < 4; d++) {
					int nr = r + dx[d];
					int nc = c + dy[d];
					
					// 범위를 벗어나면 스킵
					if (nr < 0 || nr >= n || nc < 0 || nc >=n) continue;
					
					int neighbor = seats[nr][nc]; // 인접 칸에 앉은 학생 번호(0이면 빈칸)
					// 인접 칸이 비어있다면 빈칸 수 증가
					if(neighbor == 0) {
						emptyCnt++;
					} else if (likeSet[s][neighbor]) {
						// 인접 칸에 학생이 있고, 그 학생을 s가 좋아한다면 likeCnt 증가
						likeCnt++;
					}
				}
				
				// 1. 좋아하는 학생 수 비교
				if (likeCnt > bestLike) {
					bestLike = likeCnt;
				    bestEmpty = emptyCnt;
				    bestR = r;
				    bestC = c;
				}
				// 2. 같으면 빈칸 수 비교
				else if (likeCnt == bestLike && emptyCnt > bestEmpty) {
					bestLike = likeCnt;
				    bestEmpty = emptyCnt;
				    bestR = r;
				    bestC = c;
				}
				// 3. 같으면 행 번호 비교
				else if (likeCnt == bestLike && emptyCnt == bestEmpty && r < bestR) {
					bestLike = likeCnt;
				    bestEmpty = emptyCnt;
				    bestR = r;
				    bestC = c;
				}
				// 4. 같으면 열 번호 비교
				else if (likeCnt == bestLike && emptyCnt == bestEmpty && r == bestR && c < bestC) {
					bestLike = likeCnt;
				    bestEmpty = emptyCnt;
				    bestR = r;
				    bestC = c;
				}
			}
		}
		// 찾은 최적 칸에 학생 s 배치
		seats[bestR][bestC] = s;
	}
	
	static int calc() {
		int sum = 0;
		int[] score = {0,1,10,100,1000};
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int s = seats[r][c];
				int likeCnt = 0;
				
				// 인접 칸 체크
				for (int d = 0; d < 4; d++) {
					int nr = r + dx[d];
					int nc = c + dy[d];
					if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
					
					int neighbor = seats[nr][nc];
					if (likeSet[s][neighbor]) likeCnt++;
				}
				
				sum += score[likeCnt];
			}
		}
		return sum;
	}
	
}
