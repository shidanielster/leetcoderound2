public class Divide {

    /*
     * simple thought
     * each int could be represented as 2N+2(n-1)+...+2+2(0)
     * so use 1<<x should be fine
     * others will need to check corner cases
     */
    
   public int divide(int d1, int d2) {
        if(d1==(1<<31)){
            if(d2==-1){return divide(d1-d2,d2);}
            else{ return d2>0?divide(d1+d2,d2)-1: divide(d1-d2,d2)+1; }       
        }else if(d2==1<<31){
        	return 0;
        }
        if((d1^d2)<0){
            return -divide(Math.abs(d1),Math.abs(d2));
        }else if(d1<0){
        	return divide(Math.abs(d1),Math.abs(d2));
        }
        if(d1<d2)return 0; 
        
        int x = 0;
        for(int i = 0;i<31;i++){
            if(d2<<i <= d1&&d2<<i+1>d1 || d2<<i <= d1 && d2<<i+1 < 0){
                x = i;
                break;
            }
        }
        int ret=0;
        for(int i=x;i>=0;i--){
            if(d2<<i <=d1){
                ret += 1<<i;
                d1-=d2<<i;
            }
        }
        return ret;
    }
}