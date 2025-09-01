import java.io.*;
import java.util.*;

public class Main {
	static int n,m; // 도시크기n, 남길 병원 개수m
	static int[][] arr; // 도시지도
	static List<int[]> peopleList = new ArrayList<>();
	static List<int[]> hospitalList = new ArrayList<>();
	static int minValue = Integer.MAX_VALUE;
	
	static boolean[] selected; // 병원 선택 여부 체크용 배
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
				
		arr = new int[n][n];
		
		// 지도 입력 + 집/병원 좌표 저
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					peopleList.add(new int[]{i,j}); // 사람 좌표 저장
				} else if (arr[i][j] == 2) {
					hospitalList.add(new int[]{i,j}); // 병원 좌표 저장
				}
			}
		}
		
		// 병원 개수만큼 선택 여부 배열 초기화
		selected = new boolean[hospitalList.size()];
		
		// DFS 시작 : 0번째 병원부터, 현재 선택 개수 0
		dfs(0,0);
		
		System.out.println(minValue);
			
	}
	// DFS로 병원 조합 선택
	// @param idx : 현재 병원 인덱스, count : 지금까지 선택한 병원 개수
	static void dfs(int idx, int count) {
		// M개 선택 완료 시 거리 계산
		if (count == m) {
			int cityDist = calculateCityDistance(); // 사람 병원 거리 계산
			minValue = Math.min(minValue, cityDist);
			return;
		}
		
		// 병원 리스트 끝까지 탐색했으면 종료
		if(idx == hospitalList.size()) return;
		
		// 현재 병원 선택
		selected[idx] = true;
		dfs(idx + 1, count + 1);
		
		selected[idx] = false;
		dfs(idx + 1, count);
	}
	
	static int calculateCityDistance() {
		int totalDist = 0;
		
		// 각 집마다 최소 병원 거리 계산
		for (int[] people : peopleList) {
			int minDist = Integer.MAX_VALUE;
			for (int i = 0; i < hospitalList.size(); i++) {
				if (selected[i]) {
					int[] hospital = hospitalList.get(i);
					int dist = Math.abs(people[0] - hospital[0]) + Math.abs(people[1] - hospital[1]);
                    minDist = Math.min(minDist, dist);
				}
			}
			totalDist += minDist; //모든 사람의 최소 병원 거리 합산
		}
		return totalDist;
	}
}
