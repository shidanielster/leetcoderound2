class PowerOfTwo{
    public boolean isPowerOfTwo(int n) {
        for(int i=0;i<31;i++){
            if((1<<i^n)==0)return true;
        }    
        return false;
    }
}