// 가로 >= 세로
// 카펫 무조건 직사각형이라고 가정 (문제가 좀 불친절한듯...)
// 가로 세로 크기를 r, c라고 침
// r * c = brown + yellow
// (r-2) * (c-2) = yellow
// r과 c에 해당할 수 있는 모든 경우를 두 번째 수식에 대조

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int rc = brown + yellow;
        for (int c=3 ; c<=rc/3 ; c++) {
            if (rc%c!=0) continue;
                        
            if ((c-2) * (rc/c-2) == yellow) {
                answer[1] = rc/c;
                answer[0] = c;
            }
        }
        
        return answer;
    }
}