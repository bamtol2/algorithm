import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	static class Atom{
		int x,y;
		int m;
		int s;
		int d;
		
		Atom(int x, int y, int m, int s, int d){
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static List<Atom> atoms = new ArrayList<>(); // 원자들을 담을 리스트
	static List<Atom>[][] grid; // 각 칸에 모인 원자들
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 격자의 크기
		M = Integer.parseInt(st.nextToken()); // 원자의 개수
		K = Integer.parseInt(st.nextToken()); // 실험 시간
		
		grid = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }
		
		// 입력 -> atoms 리스트에 담기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			atoms.add(new Atom(x,y,m,s,d));
		}
		
		for (int i = 0; i < K; i++) {
			simulate();
		}
		
		int answer = addAll();
		
		System.out.println(answer);
	}
	
	public static void simulate() {
		// 1. 원자 이동
		move();
		// 2. 합성
		merge();
	}
	
	public static void move() {
		// grid 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j].clear();
			}
		}
		
		// 모든 원자 이동 -> grid에 넣기
		for (Atom a: atoms) {
			int nx = ((a.x + dx[a.d] * a.s) % N + N) % N;
			int ny = ((a.y + dy[a.d] * a.s) % N + N) % N;
			a.x = nx;
			a.y = ny;
			grid[nx][ny].add(a);
		}
	}
	
	public static void merge() {
		// 규칙을 적용한 결과를 담을 새로운 리스트
		List<Atom> newAtoms = new ArrayList<>();
		
		// 모든칸을 돌면서 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j].size() == 1) {
					// 원자 그대로 유지
					newAtoms.add(grid[i][j].get(0));
				} else if(grid[i][j].size() >= 2) {
					int m_sum = 0, s_sum = 0;
					boolean allEven = true, allOdd = true;
					
					for (Atom a : grid[i][j]) {
						m_sum += a.m;
						s_sum += a.s;
						// 만약 상하좌우 방향이 있으면, 대각선은 x
						if (a.d % 2 == 0) allOdd = false;
						// 대각선이 있으면 상화좌우는 x
						else allEven = false;
					}
					
					int newM = m_sum / 5;
					if (newM == 0) continue;
					int newS = s_sum / grid[i][j].size();
					
					int[] dirs;
					
					if (allEven || allOdd) {
						dirs = new int[] {0,2,4,6};
					} else {
						dirs = new int[] {1,3,5,7};
					}
					
					for(int d : dirs) {
						newAtoms.add(new Atom(i,j,newM,newS,d));
					}
				}
			}
		}
		atoms = newAtoms;
	}
	
	public static int addAll() {
		int sum = 0;
		for (Atom a : atoms) {
			sum += a.m;
		}
		
		return sum;
	}
}
