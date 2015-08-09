class Pow{
    
    public double pow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        
        double ret = 1;
        while(n!=0){
            if(n%2!=0){
                ret*=x;
            }
            x*=x;
            n/=2;
        }
        return ret;
    }

}