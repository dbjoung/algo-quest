// 매일 다른 옷 입는 코니.
// 각 종류별로 최대 1가지 의상만 착용
// 파츠가 하나만 달라져도 다른 의상으로 취급
// Map<String, Set<String>>
// 조합 경우의 수를 구한다. 1 : AB, 2 : C 일 경우는 1 혹은 2 타입의 옷을 아예 안 입는
// 경우까지 고려해서 2C1 * 3C1을 구한다. 하지만 아예 안 입는 경우는 제외해야하므로 결과-1.

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String[][] clothes) {
        int combination = 1;
        HashMap<String, HashSet<String>> clothesType = new HashMap<String, HashSet<String>>();
        
        for (String[] cloth : clothes) {
            if (clothesType.containsKey(cloth[1])) {
                clothesType.get(cloth[1]).add(cloth[0]);
            } else {
                HashSet<String> newSet = new HashSet<String>();
                newSet.add(cloth[0]);
                clothesType.put(cloth[1], newSet);
            }
        }
        
        for (Map.Entry<String, HashSet<String>> entry : clothesType.entrySet()) {
            combination *= (entry.getValue().size()+1);
        }
        
        return combination-1;
    }
}