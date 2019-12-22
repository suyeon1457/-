import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        PriorityQueue<int[]> disk = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        int index = 0;
        int end = 0;
        int answer = 0;
        while(index < jobs.length) {
            end = jobs[index][0]+jobs[index][1];
            answer += jobs[index][1];
            index++;
            while(index < jobs.length) {
                if(jobs[index][0] <end) {
                    disk.add(jobs[index]);
                    index++;
                } else{
                  break;
                }
            }
            while(!disk.isEmpty()) {
                int[] arr = disk.poll();
                answer += end-arr[0]+arr[1];
                end += arr[1];
                while(index<jobs.length) {
                    if(jobs[index][0]<end) {
                        disk.add(jobs[index]);
                        index++;
                    }
                    else break;
                }
            }
        }
        answer = (int) Math.floor(answer/jobs.length);
        return answer;
    }
}
