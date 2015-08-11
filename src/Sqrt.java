class Sqrt{
    public int mySqrt(int x) {
        if(x==0)return 0;
        int s=1;
        int e = 2<<16<x?2<<16:x;
        while(s<e-1){
            int m = (s+e)/2;
            long r = (long)m*m;
            if(r>x){
                e=m;
            }else{
                s=m;
            }
        }
        return s;
    }
}