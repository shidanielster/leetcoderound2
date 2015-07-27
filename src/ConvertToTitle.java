import java.util.*;

class ConvertToTitle{
    public static void main(String[] a){
        // System.out.println(new ConvertToTitle().convertToTitle(1));
        // System.out.println(new ConvertToTitle().convertToTitle(26));
        // System.out.println(new ConvertToTitle().convertToTitle(27));
        // System.out.println(new ConvertToTitle().convertToTitle(28));
        // System.out.println(new ConvertToTitle().convertToTitle(52));
        // System.out.println(new ConvertToTitle().convertToTitle(260));
        // System.out.println(new ConvertToTitle().convertToTitle(259));
        System.out.println(new ConvertToTitle().convertToTitle(261));

    }
    public String convertToTitle(int n) {
        Map<Integer, Character> map = new HashMap<Integer,Character>();
        char c='A';
        for(int i = 1;i<26;i++,c++){
            map.put(i,c);
        }
        map.put(0,'Z');
        StringBuilder sb = new StringBuilder();
        
        while(n!=0){
            sb.insert(0,map.get(n%26));
            if(n%26==0){
                n-=26;
            }
            n/=26;
        }
        return sb.toString();
    }
}