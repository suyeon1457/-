import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> tHash = new HashMap<String,Integer>();
		Map<String,String> gHash = new HashMap<String,String>();
		Map<String,Integer> pHash = new HashMap<String,Integer>();
		// 1. �ؽð� ����
		// - �帣�� �� �뷡����� �� �ؽ�
		// - ���� ��ȣ,�帣 / ���� ��ȣ,����� �ؽ�
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
		// 2. ����
		// 2-1. pHash ����
		// ������������� ������������ �����ϰ�, ������� ������ ������ȣ ������������ ����
        Map<String, Integer> sortedPMap = sortByValue(pHash);
        // 2-2. tHash ����
        Map<String, Integer> sortedTMap = sortByValue(tHash);
        // 3. ����Ʈ�ٹ� �ؽ� ����
        Map<String, String[]> result = new HashMap<String, String[]>();
        for ( String key : sortedTMap.keySet() ) {
        	result.put(key,new String[]{"-1","-1"});
		}
		// 4. ����Ʈ�ٹ� �ؽ� �� ����
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
		// 5. ����Ʈ�ٹ� �迭 �ϼ�
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