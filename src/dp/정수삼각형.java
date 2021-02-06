package dp;

public class 정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution_정수삼각형 s = new Solution_정수삼각형();

        s.solution(triangle);
    }
}

class Solution_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = -999;
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        for(int i=0;i<triangle.length;i++){
            if(answer< dp[triangle.length-1][i]) answer = dp[triangle.length-1][i];
        }

        return answer;
    }
}