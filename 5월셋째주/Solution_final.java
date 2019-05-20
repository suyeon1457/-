import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> tHash = new HashMap<String,Integer>();
		Map<String,String> gHash = new HashMap<String,String>();
		Map<String,Integer> pHash = new HashMap<String,Integer>();
		// 1. 해시값 생성
		// - 장르별 총 노래재생수 합 해시
		// - 고유 번호,장르 / 고유 번호,재생수 해시
		for(int i = 0 ; i<genres.length;i++){
			if(tHash.containsKey(genres[i])){
				tHash.put(genres[i], tHash.get(genres[i]) + plays[i]);
			}
			else{
				tHash.put(genres[i],plays[i]);
			}
			gHash.put(Integer.toString(i),genres[i]);
			pHash.put(Integer.toString(i),plays[i]);
		}
		// 2. 정렬
		// 2-1. pHash 정렬
		// 재생수기준으로 오림차순으로 정렬하고, 재생수가 같으면 고유번호 오름차순으로 정렬
        Map<String, Integer> sortedPMap = sortByValue(pHash);
        // 2-2. tHash 정렬
        Map<String, Integer> sortedTMap = sortByValue(tHash);
        // 3. 베스트앨범 해시 생성
        Map<String, String[]> result = new HashMap<String, String[]>();
        for ( String key : sortedTMap.keySet() ) {
        	result.put(key,new String[]{"-1","-1"});
		}
		// 4. 베스트앨범 해시 값 세팅
		int count = 0;
		for ( String key : sortedPMap.keySet() ) {
			if(result.get(gHash.get(key))[0].equals("-1")){
				result.get(gHash.get(key))[0] = key;
				count++;
			}
			else if(result.get(gHash.get(key))[1].equals("-1")){
				result.get(gHash.get(key))[1] = key;
				count++;
			}
		}
		// 5. 베스트앨범 배열 완성
		int[] answer = new int[count];
		int i = 0;
        Iterator<String> keys = sortedTMap.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            String[] val = result.get(key);
            if(val[0].equals("-1") == false){
    			answer[i] = Integer.parseInt(val[0]);
    			i++;
    		}
    		if(val[1].equals("-1") == false){
    			answer[i] = Integer.parseInt(val[1]);
    			i++;
    		}
        }
		// for ( String key : result.keySet() ) {
		// String[] val = result.get(key);
		// if(val[0].equals("-1") == false){
		// answer[i] = Integer.parseInt(val[0]);
		// i++;
		// }
		// if(val[1].equals("-1") == false){
		// answer[i] = Integer.parseInt(val[1]);
		// i++;
		// }
		// }
        // for ( int k = 0; k<answer.length;k++ ) {
        //     System.out.println(answer[k]);
        // }
        return answer;
    }
    
	public static Map sortByValue(final Map map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedMap;
    }
}