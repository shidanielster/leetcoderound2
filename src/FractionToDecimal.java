import java.util.*;

class FractionToDecimal{
    
    public static void main(String[] a){
        System.out.println(new FractionToDecimal().fractionToDecimal(5,2));
        System.out.println(new FractionToDecimal().fractionToDecimal(1,6));
        System.out.println(new FractionToDecimal().fractionToDecimal(2,7));
        System.out.println(new FractionToDecimal().fractionToDecimal(4,8));
        System.out.println(new FractionToDecimal().fractionToDecimal(30,1));
        System.out.println(new FractionToDecimal().fractionToDecimal(1000,234));
        
    }
    
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        StringBuilder sb=new StringBuilder();
        boolean start =false;
        while(numerator!=0){

            //handle repeat
            if(map.containsKey(numerator)){
                sb.insert(map.get(numerator),"(");
                sb.append(')');
                break;
            }
            if(start){
                map.put(numerator,sb.length());
            }
            int r = numerator/denominator;
            if(r==0){
                if(start){
                    sb.append("0");
                }else{
                //handle "."
                    start = true;
                    if(sb.length()==0){
                        sb.append("0");
                    }
                    sb.append(".");
                }
            }else{
                sb.append(r);
                numerator-=r*denominator;
            }
            if(start)numerator *=10;
        }
        
        if(sb.length()==0)return "0";
        return sb.toString();
    }
}