class CountAndSay{
    public static void main(String[] args){
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));

    }
    public String countAndSay(int n) {
        if(n==1)return "1";
        String p = countAndSay(n-1);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<p.length();i++){
            char say = p.charAt(i);
            if(say==p.charAt(i-1)){
                count ++;
            }else{
                sb.append(count);
                sb.append(p.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(p.charAt(p.length()-1));
        return sb.toString();
    }
}