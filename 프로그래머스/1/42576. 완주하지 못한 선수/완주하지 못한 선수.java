import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // String 키 , Integer 값 을 가지는 HashMap 생성
        HashMap<String,Integer> map = new HashMap<>();
        
        // 1. 참가자 이름을 map에 저장(등장 횟수 기록)
        for (String p : participant){
            map.put(p,map.getOrDefault(p,0) + 1);
        }
        
        // 2. 완주자 이름을 map에서 제거(등장 횟수 감소)
        for (String c : completion){
            map.put(c,map.get(c)-1);
        }
        
        // 3. 값이 1로 남아 있는 이름이 완주 못한 사람
        for (String key : map.keySet()){
            if (map.get(key) == 1){
                return key;
            }
        }
        return "";
    }
}