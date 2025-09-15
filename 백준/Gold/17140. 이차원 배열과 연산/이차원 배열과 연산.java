import java.io.*;
import java.util.*;

public class Main {
	static int R,C,K;
	static List<int[]> lst = new ArrayList<>();
	static int[][] map;
	
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		K = Integer.parseInt(st.nextToken()); //목표숫자
		
		map = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while(true) {
			// 1. 답이 100초를 초과한다면 -1 출력
			if (time > 100) {
				System.out.println(-1);
				return;
			}
			
			// 2. 목표 위치 값이 K인지 확인 (map 크기 안에 있을때만)
			if (R <= map.length && C <= map[0].length && map[R-1][C-1] == K) {
				System.out.println(time);
				return;
			}
			
			// 3. 게임 실행
			game();
			
			// 4. 시간 증가
			time++;
		}
	}
	
	public static void game() {
		// 행 개수 >= 열 개수 이면 R연산
		if (map.length >= map[0].length) {
			R_game();
		} 
		// 행 개수 < 열 개수 이면 C연산
		else {
			C_game();
		}
	}
	
	public static void R_game() {
		// 새로운 행들을 담을 리스트
		List<List<Integer>> newRows = new ArrayList<>();
		int maxLen = 0; 
		
		// 1. 각 행에 대해서 등장 횟수 세기
		for (int[] row : map) {
			Map<Integer,Integer> countMap = new HashMap<>();
			
			for (int num : row) {
				if (num == 0) continue;
				countMap.put(num, countMap.getOrDefault(num, 0) + 1);
			}
			
			// 1-1. (숫자, 횟수) 쌍 리스트 만들기
			List<int[]> pairs = new ArrayList<>();
			for (int key : countMap.keySet()) {
				pairs.add(new int[] {key, countMap.get(key)});
			}
			
			// 1-2. 정렬 (횟수 오름차순 -> 숫자 오름차순)
			Collections.sort(pairs, (a,b) -> {
				if(a[1] == b[1]) {
					return a[0] - b[0]; // 숫자가 작은 순
				}
				return a[1]-b[1];
			});
			
			// 1-3. 정렬된 결과를 [숫자,횟수,숫자,횟수..]로 변환
			List<Integer> newRow = new ArrayList<>();
			for (int[] p : pairs) {
				newRow.add(p[0]);
				newRow.add(p[1]);
			}
			
			// 1-4. 길이가 100이 넘으면 잘라야함
			if (newRow.size() > 100) {
				List<Integer> cutRow = new ArrayList<>();
				for (int i = 0; i < 100; i++) {
					cutRow.add(newRow.get(i));
				}
				newRow = cutRow;
			}
			
			// 1-5. 가장 긴 행 길이 갱신
			if (newRow.size() > maxLen) {
				maxLen = newRow.size();
			}
			
			// 1-6. 완성된 행을 newRows에 추가
			newRows.add(newRow);
		}
		
		// 2. 새로운 map 배열 만들기 (행 개수는 newRow.size(), 열 개수는 maxLen)
		int[][] newMap = new int[newRows.size()][maxLen];
		
		// 3. newRows 내용을 newMap에 복사
		for (int i = 0; i < newRows.size(); i++) {
			List<Integer> row = newRows.get(i);
			for (int j = 0; j < row.size(); j++) {
				newMap[i][j] = row.get(j);
			}
		}
		
		// 4. map교체
		map = newMap;
		

	}
	
	public static void C_game() {
	    // 새로운 열들을 담을 리스트
	    List<List<Integer>> newColumns = new ArrayList<>();
	    int maxLen = 0;

	    // 1. 각 열에 대해서 등장 횟수 세기
	    for (int c = 0; c < map[0].length; c++) {  // 열 인덱스
	        Map<Integer, Integer> countMap = new HashMap<>();

	        for (int r = 0; r < map.length; r++) {  // 행 인덱스
	            int num = map[r][c];
	            if (num == 0) continue; // 0은 무시
	            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
	        }

	        // 1-1. (숫자, 횟수) 쌍 리스트 만들기
	        List<int[]> pairs = new ArrayList<>();
	        for (int key : countMap.keySet()) {
	            pairs.add(new int[]{key, countMap.get(key)});
	        }

	        // 1-2. 정렬 (횟수 오름차순 -> 숫자 오름차순)
	        Collections.sort(pairs, (a, b) -> {
	            if (a[1] == b[1]) return a[0] - b[0];
	            return a[1] - b[1];
	        });

	        // 1-3. 정렬된 결과를 [숫자,횟수...] 로 변환
	        List<Integer> newCol = new ArrayList<>();
	        for (int[] p : pairs) {
	            newCol.add(p[0]);
	            newCol.add(p[1]);
	        }

	        // 1-4. 길이가 100 넘으면 자르기
	        if (newCol.size() > 100) {
	            List<Integer> cutCol = new ArrayList<>();
	            for (int i = 0; i < 100; i++) {
	                cutCol.add(newCol.get(i));
	            }
	            newCol = cutCol;
	        }

	        // 1-5. 가장 긴 열 길이 갱신
	        if (newCol.size() > maxLen) {
	            maxLen = newCol.size();
	        }

	        // 1-6. 완성된 열 저장
	        newColumns.add(newCol);
	    }

	    // 2. 새로운 map 배열 만들기 (행 = maxLen, 열 = newColumns.size())
	    int[][] newMap = new int[maxLen][newColumns.size()];

	    // 3. newColumns 내용을 newMap에 복사
	    for (int c = 0; c < newColumns.size(); c++) {
	        List<Integer> col = newColumns.get(c);
	        for (int r = 0; r < col.size(); r++) {
	            newMap[r][c] = col.get(r); // (행, 열) 주의
	        }
	    }

	    // 4. map 교체
	    map = newMap;
	}
}
