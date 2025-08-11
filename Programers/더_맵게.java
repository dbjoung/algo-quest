// 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
// 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만든다.
// 가장 맵지 않은 음식의 스코빌 + 두 번째로 맵지 않은 음식의 스코빌 * 2

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovs = new PriorityQueue<>();
        
        for (int sco : scoville) {
            scovs.add(sco);
        }
        
        while(!scovs.isEmpty()) {
            if (scovs.peek()>=K) break;
            if (scovs.size()==1) {
                scovs.poll();
                break;
            }
            
            scovs.add(scovs.poll()+scovs.poll()*2);
        }
        
        if (scovs.isEmpty()) return -1;
        else return scoville.length-scovs.size();
    }
}