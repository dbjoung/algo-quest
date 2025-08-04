// N마리 중 N/2 마리 가져가도 좋음.
// 포켓몬 종류에 따라 번호 붙임 (같은 종류의 폰켓몬은 같은 종류)

import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer ,Integer> phone = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (phone.containsKey(num)) {
                int value = phone.get(num)+1;
                phone.put(num, value);
            } else phone.put(num, 1);
        }
        
        if (phone.size() < nums.length/2) return phone.size();
        else return nums.length/2;
    }
}