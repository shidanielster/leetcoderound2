class ValidNumber{
    public static void main(String... args){
        System.out.println(valid2("1234"));
        System.out.println(valid2("1234."));
        System.out.println(valid2("12.34"));
        System.out.println(valid2(".1234"));
        System.out.println(valid2(". 1234"));
        System.out.println(valid2(" .1234"));
        System.out.println(valid2("1234 "));
        System.out.println(valid2("12c34"));
        System.out.println(valid2("12e34"));
        System.out.println(valid2("12e3.4"));
        System.out.println(valid2("1.2e34"));
    }
    
    /*
    * solution 
    * valid number is
    * 1) stip start and tail white spaces
    * 2) . occurs once
    * 3) e occurs once
    * 4) at least one number, if e, at least 2 nunbers
    * 5) if +/-, should be at start or next to e 
    */
    public static boolean valid(String str){
        int i = 0; 
        int j = str.length()-1;
        while(i<=j&&str.charAt(i)==' ')i++;
        while(j>=i&&str.charAt(j)==' ')j--;
        
        //first check the sign
        if(str.charAt(i)=='+' || str.charAt(i)== '-' )i++;
        
        //now all the valid characters are number, '.', and 'e', . and e can only occur once
        boolean hasDot = false;
        boolean hase = false;
        boolean hasNumber = false;
        
        while(i<=j){
            char x = str.charAt(i);
            if(x== '.'){
                if(!hasDot){
                    hasDot = true;
                }else{
                    return false;
                }
            }else if(x=='e'){
                if(!hase){
                    if(!hasNumber)return false;

                    hase= true;
                    hasDot = false;
                    hasNumber = false;
                }else{
                    return false;
                }
            }else if(x=='+' ||x=='-'){
                if(hase&&i>0&&str.charAt(i-1)=='e'){
                    //good
                }else{
                    return false;
                }
            }
            else if( x>='0' && x<='9'){
                hasNumber = true;
            }else{
                return false;
            }
            i++;
        }
        
        if(hase&&!hasNumber)return false;
        return true;
    }
    
    /*
    * solution2
    * 1) go through the str
    * 2) if meet e, then start again
    * 3) number before and after e
    * 4) . can be in number before e
    */
    public static boolean valid2(String str){
        int i = 0;
        int n=str.length();
        if(i<n&&str.charAt(i)==' ')i++;
        if(str.charAt(i)=='+'| str.charAt(i)=='-')i++;
        
        boolean isNum = false;
        while(i<n&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            isNum = true;
            i++;
        }
        if(i<n&&str.charAt(i)=='.'){
            i++;
        }
        while(i<n&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            isNum = true;
            i++;
        }
        if(i<n&&str.charAt(i)=='e'){
            i++;
            isNum=false;
            if(i<n&&(str.charAt(i)=='+'| str.charAt(i)=='-'))i++;
        }
        while(i<n&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            isNum = true;
            i++;
        }

        if(i<n&&str.charAt(i)==' ')i++;

        return i==n&&isNum;
    }
}