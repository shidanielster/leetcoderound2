class ReverseString{
    public static void main(String... args){
        
        System.out.println(reverse2_1("      a b cd  ").length());
        System.out.println(reverse2_1(" ").length());

    }
    
    /*
    * This is a straightforward solution.
    * For a string |.....|
    * 1) find the last string seperated by ' '
    * 2) copy a ' ' if not the first
    * 3) copy the string
    */
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1,j=str.length()-1;i>=0&&j>=0;i--,j--){
            while(i>=0&&str.charAt(i)==' ')i--;
            j=i;
            while(j>=0&&str.charAt(j)!=' ')j--;
            //copy (j,i] to the sb
            
            if(sb.length()!=0&&i!=-1){
                sb.append(' ');
            }
            for(int n=j+1;n<=i;n++){
                sb.append(str.charAt(n));
            }
            i=j;
        }
        return sb.toString();
    }
    
    /*
    * Solution 2
    * One string is identified by 2 ' '
    * 1)find a ' ' or end
    * 2) use i to mark the end
    * 3) use j to mark the begining
    * 4) copy (i,j)
    * 5) if str[i+1] is not ' ', then we can copy
    */
    public static String reverse2(String str){
        System.out.println("run 2");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length(),j=str.length()-1;j>=-1;j--){
            if(j==-1||str.charAt(j)==' '){
                //copy (j,i)
                if(j+1<str.length()&&str.charAt(j+1)!=' '){
                    if(sb.length()!=0){
                        sb.append(' ');
                    }
                    for(int n=j+1;n<i;n++){
                        sb.append(str.charAt(n));
                    }   
                }
                i=j;
            }
        }
        return sb.toString();
    }
    
    
    /* solution 2-1
     */
     
     public static String reverse2_1(String str){
         StringBuilder sb = new StringBuilder();
         for(int i=str.length(),j=str.length()-1;j>=-1;j--){
             if(j==-1||str.charAt(j)==' '){
                 //copy (j,i)
                 copy(str,j,i,sb);
                 i=j;
             }
         }
         return sb.toString();
     }
     
     private static void copy(String str,int s, int e, StringBuilder sb){
         //this it to prevent multiple useless copy of continous spaces.
         if(s+1==e)return;
         if(sb.length()!=0){
             sb.append(' ');
         }
         for(int x = s+1;x<e;x++){
             if(str.charAt(x)!=' '){
                 sb.append(str.charAt(x));
             }
         }
     }
    
    /*
    * solution 3
    * idea same as solution 2
    * copy [j,i)
    * copy condition: left is ' ',which means we can do a copy
    * use i as tail, if meat ' ', then update i
    */
    public static String reverse3(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length(),j=str.length()-1;j>=0;j--){
            //j must be in [0,str.length-1]
            if(str.charAt(j)==' '){
                i=j;
            }else if(j==0||str.charAt(j-1)== ' '){
                //this is the copy condition
                if(sb.length()!=0){
                    sb.append(' ');
                }
                for(int n=j;n<i;n++){
                    sb.append(str.charAt(n));
                }
            }
        }
        return sb.toString();
    }
    
    
    /*
    * This version reverse is for 
    * 1) no start/end spaces
    * 2) only one space between strings
    * 3) reverse [j,i)
    */
    public static void reverse4(char[] str){
        reverse4(str,0,str.length-1);
        for(int i=0,j=0;i<str.length;i++){
            //find a ' ' or reaches the end, then do a reverse
            if(i==str.length||str[i]==' '){
                reverse4(str,j,i-1);
                j=i+1;
            }
        }
    }
    
    private static void reverse4(char[] str, int i,int j){
        for(int n = i; n<(i+j)/2;n++){
            char c = str[n];
            str[n] = str[i+j-n];
            str[i+j-n] = c;
        }
    }
    
    
    
    
    
    
}