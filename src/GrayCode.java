import java.util.*;

class GrayCode{
    public List<Integer> grayCode(int n) {
        
        List<Integer> list = new ArrayList<Integer>();
        if(n<0)return list;
        
        int prev = 0;
    
        int up = 1<<n;
        int i = 1;
        list.add(0);
        while(i<up){
            int v = 1;
            int x = i;
            while((x&1)!=1){
                x=x>>1;
                v=v<<1;
            }
            prev = prev ^ v;
            list.add(prev);
            i++;
        }

        return list;
    }
}