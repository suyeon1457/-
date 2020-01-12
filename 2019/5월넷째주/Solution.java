import java.lang.*;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    // 제곱 함수
    // Mash.pow보다 처리 시간이 이게 짧다고해서 써봤으나 별차이 없음
    // public static long p(long a) {
    //     return a*a;
    // }
    public long solution(int n, int[] works) {
      long start = System.currentTimeMillis();
      // 작업량 배열을 list형으로 변환
      List<Integer> work =  Arrays.stream(works).boxed().collect(Collectors.toList());

      // 남은시간이 0이 될때까지
  		while(n > 0){
        // 작업량을 내림차순 정렬
        Collections.sort(work, Collections.reverseOrder());
        // 작업량중 0이 있다면 모두삭제
        work.removeAll(Arrays.asList(0));
        // 작업량이 0이 되면 끝
  			if(work.size() == 0){
  				break;
  			}
        // 작업량의 제일 큰값이 0이 아니라면
  			if(work.get(0) != 0){
          // 작업량의 제일 큰값을 -1
          work.set(0,work.get(0)-1);
          // 작업시간 -1
  				n--;
  			}
  		}
      // 최종 작업량 확인 for문
  		for(int i=0;i<work.size();i++){
  		    System.out.printf("%d ",work.get(i));
  		}
  		System.out.println();

  		long answer = 0;
      // 작업량 제곱
  		for(int tempValue : work){
  			answer += Math.pow(tempValue,2);
  		}

      System.out.printf("%d ",answer);
      long end = System.currentTimeMillis();
      System.out.println("걸린 시간: " + (end-start) + " ms");
      return answer;
    }
}


// 		for(int i = 0; i < work.size(); i++){
// 			if(work.get(i) != 0){
// 				// answer += (int)Math.pow(work.get(i),2);
//                 answer += p(work.get(i));

// 			}
// 		}
//         long start = System.currentTimeMillis();
//         List<Integer> work =  Arrays.stream(works).boxed().collect(Collectors.toList());

// 		while(n > 0){
//             Collections.sort(work, Collections.reverseOrder());
//             work.removeAll(Arrays.asList(0));
// 			if(work.size() == 0){
// 				break;
// 			}
// 			if(work.get(0) != 0){
//                 work.set(0,work.get(0)-1);
// 				n--;
// 			}
// 		}
// 		long answer = 0;
// 		// for(int i = 0; i < work.size(); i++){
//         for(int item : work){
// 			// if(work.get(i) != 0){
//             if(item != 0){
// 				// answer += Math.pow(item,2);
//                 answer += p(item);
// 			}
// 		}
//         long end = System.currentTimeMillis();
//         System.out.println("걸린 시간: " + (end-start) + " ms");
		// System.out.printf("결과 : %d ",answer);
//         List<Integer> work =  Arrays.stream(works).boxed().collect(Collectors.toList());

// 		while(n > 0 && work.size() > 0){
//             System.out.println(work.size());
// 			// Arrays.sort(work, Collections.reverseOrder());
//             Collections.sort(work, Collections.reverseOrder());
//             work.removeAll(Arrays.asList(0));
// 			// for(int i=0;i<works.length;i++){
// 			// 	System.out.printf("%d ",works[i]);
// 			// }
// 			// System.out.println();
// 			if(work.get(0) != 0){
// 				// work[0] -= 1;
//                 work.set(0,work.get(0)-1);
// 				n--;
// 			}
// 		}
// 		// // System.out.println("============================");
// 		long answer = 0;
		// for(int i = 0; i < work.size(); i++){
		// 	// System.out.printf("%d ",works[i]);
		// 	if(work.get(i) != 0){
		// 		System.out.println((int)Math.pow(work.get(i),2));
		// 		answer += (int)Math.pow(work.get(i),2);
		// 	}
		// }
		// // System.out.println();
		// // System.out.printf("결과 : %d ",answer);
