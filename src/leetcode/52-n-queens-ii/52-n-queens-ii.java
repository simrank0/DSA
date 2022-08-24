class Solution {
    public int totalNQueens(int n) {
        if(n==0)return 0;
        char[][] board=new char[n][n];
        int left[]=new int [n];
        int upperdiagonal[]=new int[2*n-1];
        int lowerdiagonal[]=new int[2*n-1];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        return solve(0,board,left,upperdiagonal,lowerdiagonal,0);
    }
    public int solve(int col,char[][] board,int[] left,int[] upperdiagonal,int[] lowerdiagonal,int res)
    {int n=board.length;
        if(col==n)
            return res+1;
     for(int i=0;i<n;i++)
     {
         if(left[i]==0&&upperdiagonal[n-1+col-i]==0&& lowerdiagonal[i+col]==0)
         {
             left[i]=1;
             upperdiagonal[n-1+col-i]=1;
             lowerdiagonal[i+col]=1;
             board[i][col]='Q';
             res=solve(col+1,board,left,upperdiagonal,lowerdiagonal,res);
             board[i][col]='.';
             left[i]=0;
             upperdiagonal[n-1+col-i]=0;
             lowerdiagonal[i+col]=0;
         }
     }
     return res;
    }
}