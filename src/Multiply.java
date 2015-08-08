class Multiply {
    public static void main(String[] args){
        System.out.println(new Multiply().multiply("1234","10"));
    }
    
    
    public String multiply(String num1, String num2) {
        String ret = "";
        for(int i=num2.length()-1;i>=0;i--){
            String m = mc(num1,num2.charAt(i));
            StringBuilder sb = new StringBuilder();
            sb.append(m);
            for(int j=i;j<num2.length()-1;j++){
                sb.append('0');
            }
            ret = add(ret,sb.toString());
        }
        return ret;
    }
    
    private String mc(String a, char c){
        int[] r= new int[a.length()];
        int incr  = 0;
        
        for(int i=a.length()-1;i>=0;i--){
            int m = (a.charAt(i) - '0') * (c-'0');
            r[i]=(m+incr)%10;
            incr = (m+incr)/10;
        }
        StringBuilder sb = new StringBuilder();

        if(incr!=0)sb.append(incr);
        for(int i=0;i<r.length;i++){
            sb.append(r[i]);
        }
        return sb.toString();
    }
    
    private String add(String a, String b){
        int i = a.length()-1;
        int j = b.length()-1; 
        int n = a.length()>b.length()?a.length():b.length() ;
        int[] r = new int[n];
        int incr=0;
        while(i>=0||j>=0){
            int left = i>=0 ? a.charAt(i)-'0':0;
            int right = j>=0? b.charAt(j)-'0':0;
            r[--n]= (left+right+incr)%10;
            incr = (left+right+incr)/10;
            i--;j--;
        }
        
        StringBuilder sb = new StringBuilder();
        if(incr!=0)sb.append(incr);
        for( i=0;i<r.length;i++){
            sb.append(r[i]);
        }
        return sb.toString();
    }
    
}