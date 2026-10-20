class Solution {
    public int countOrders(int n) {
      long answer=1;
      int mod=1000000007;
      for(int i=1;i<=n;i++){
        answer=answer*i%mod;
        answer=answer*(2*i-1)%mod;
      }
      return (int) answer;  
    }
}