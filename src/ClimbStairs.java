class ClimbStairs{
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        while(n>1){
            b=a+b;
            a=b-a;
            n--;
        }
        return a;
    }
}