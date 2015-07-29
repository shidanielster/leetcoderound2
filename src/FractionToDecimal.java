import java.util.*;

class FractionToDecimal{
    
    public static void main(String[] a){
        System.out.println(new FractionToDecimal().fractionToDecimal(5,2));
        System.out.println(new FractionToDecimal().fractionToDecimal(1,6));
        System.out.println(new FractionToDecimal().fractionToDecimal(2,7));
        System.out.println(new FractionToDecimal().fractionToDecimal(4,8));
        System.out.println(new FractionToDecimal().fractionToDecimal(30,1));
        System.out.println(new FractionToDecimal().fractionToDecimal(1000,234));
        System.out.println(new FractionToDecimal().fractionToDecimal(-22,2));
        System.out.println(new FractionToDecimal().fractionToDecimal(-22,-2));
        
    }
    
public String fractionToDecimal(int numerator, int denominator) {

    Map<Long,Integer> map = new HashMap<Long,Integer>();
    StringBuilder sb=new StringBuilder();

     if(numerator<0&&denominator>0||numerator>0&denominator<0){
        sb.append("-");
     }
     long deno = Math.abs((long)denominator);
     long num = Math.abs((long)numerator);
     
     sb.append(num/deno);
     num=num%deno;
     
     if(num!=0){
         sb.append(".");
     }
     while(num!=0){
         num*=10;
         if(map.containsKey(num)){
             sb.insert(map.get(num),"(");
             sb.append(')');
             break;
         }
         map.put(num,sb.length());
         sb.append(num/deno);
         num=num%deno;
     }
    return sb.toString();

    }
}