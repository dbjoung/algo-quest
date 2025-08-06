// Set에 숫자 종류 저장.
// 순열을 완전탐색 해준다.
// 소수 검사를 해서, 소수인 숫자만 Set에 넣는다.
// Set에 저장된 개수를 return;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int solution(String numbers) {
        Set answers = new HashSet<Integer>();
        List<String> temp = new ArrayList<String>();
        combinate(numbers.split(""), 0, answers, temp);
        
        return answers.size();
    }
    
    boolean isPrime(int num) {
        if (num==2) return true;
        if (num==1 || num%2==0) return false;
        
        for (int i=3 ; i<num/2 ; i+=2) {
            if (num%i==0) return false;
        }
        
        return true;
    }
    
    public void combinate(String[] numbers, int mask, Set<Integer> answers, List<String> temp) {
        if (temp.size()>0) {
            int newNum = Integer.parseInt(String.join("", temp));
            if (!answers.contains(newNum) && isPrime(newNum)) answers.add(newNum);
        }
        
        for (int s=0 ; s<numbers.length ; s++) {
            if ((mask & 1<<s) > 0) continue;
            temp.add(numbers[s]);
            combinate(numbers, mask | 1<<s, answers, temp);
            temp.remove(temp.size()-1);
        }
    }
}