class AtoI{
    public static void main(String ... args) {
        System.out.println(atoi(" ")+" expected: 0");
        System.out.println(atoi(" -1")+" expected -1");
        System.out.println(atoi("234")+" expected 234");
        System.out.println(atoi("234324324234324")+" expected 2147483647");
        System.out.println(atoi("-23423432423423424324")+" expected -2147483648");
        System.out.println(atoi("2147483647")+" expected 2147483647");
        System.out.println(atoi("2147483648")+ " expected 2147483647");
        System.out.println(atoi("-2147483648")+ " expected -2147483648");
        System.out.println(atoi("-2147483647")+" expected -2147483648");
    }
    
    /*
    * Heart of the is solution is to deal with overflow
    * 1) if none match digital find, return 0
    * 2) first, skip the white spaces, this is easy by a loop
    * 3) then, check the sign
    * 4) after that, handle all the digital
    * 5) if current value > max/10, then next will overflow
    * 6) if current value = max/10, and next is great than 8, then overflow
    * 7) if current value = max/10, and next is 8, and sign is +, then overflow
    * 8) if current value = max/10, and next is 8, and isgn is -, then overflow
    * 9) merge 6,7,8 for overflow or none overflow, they all return same max/min value.
    *   So >=8 is a good condition to go
    */
    public static int atoi(String str ){
        int maxdiv10 = Integer.MAX_VALUE/10;
        int i =0;
        String sign = "+";
        while(i<str.length() && str.charAt(i) == ' ')i++;
        if(i<str.length()&&str.charAt(i)=='-'){
            sign="-";
            i++;
        }
        
        int n = 0;

        while(i<str.length() && (str.charAt(i) <= '9' && str.charAt(i)>='0')){
            int x = str.charAt(i) - '0';
            if( n > maxdiv10 || n==maxdiv10 &&x>=8){
                return "+".equals(sign)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }else{
                n=n*10+x;
            }
            i++;
        }
        return "+".equals(sign)?n:-n;
    }
}