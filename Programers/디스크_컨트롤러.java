import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] j1, int[] j2) {
                if (j1[2]==j2[2]) {
                    if (j1[1]==j2[1]) {
                        return j1[0]-j2[0];
                    } else return j1[1]-j2[1];
                } else return j1[2]-j2[2];
            }
        });
        
        
        List<int[]> list = new ArrayList<>();
        for (int i=0 ; i<jobs.length ; i++) {
            list.add(new int[]{i, jobs[i][0], jobs[i][1]});
        }
        
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] j1, int[] j2) {
                return j1[1] - j2[1];
            }
        });
        
        int time = 0;
        int returnTime = 0;
    
        
        while(!list.isEmpty()) {
            time = list.get(0)[1];
            while(!list.isEmpty() && list.get(0)[1]==time) {
                queue.add(list.remove(0));
            }


            while(!queue.isEmpty()) {
                int[] job = queue.poll();
                time += job[2];
                returnTime += (time-job[1]);

                while(!list.isEmpty() && list.get(0)[1]<=time) {
                    queue.add(list.remove(0));
                }
            }
        }
        
        return returnTime/jobs.length;
    }
}