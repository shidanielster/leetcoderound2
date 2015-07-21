import java.util.*;

class MissingRange{
    public static void main(String... args){
        int[] a = new int[]{1,2,5,7,10};
        System.out.println(missing(a,0,20));
        System.out.println(missing(a,5,20));
        System.out.println(missing(a,0,6));
        
    }
    
    
    public static List<String> missing(int[] a, int start ,int end){
        List<String> list = new ArrayList<String>();
        int x = start;

        end++;
        int y = end;
        for(int i =0; i<a.length||x<end;i++){
            if(i<a.length){
                y = a[i]<end?a[i]:end;
            }else{
                y= end;
            }
            
            if(x>y){
                continue;
            }else if(x==y){
                x=y+1;
            }else if(x==y-1){
                String c = "" + x;
                list.add(c);
                x=y+1;
            }else{
                String c = "" + x + "->"+ (y-1);
                list.add(c);
                x=y+1;
            }
        }
        return list;
    }
    
    /*
     * Solution2
     * 
     */
     public static List<String> missing2(int[] a, int start ,int end){
         List<String> list = new ArrayList<String>();
         int prev = start -1;
         int cur = start;
         for(int i=0; i<=a.length;i++){
             
         }
         return list;
     }
     
    private static String rannge(int s, int e){
        return s==e?String.valueOf(s):s + "->" +e;
    }


     
     
}


