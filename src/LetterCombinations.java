import java.util.*;

class LetterCombinations{
     private static Map<Character,String> map = new HashMap<Character,String>();
    {
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0',"");
    }

    
    public List<String> letterCombinations(String digits) {
        
        List<String> list = new ArrayList<String>();
        if("".equals(digits)){
            return list;
        }else{
            String next = digits.substring(1);
            List<String> nextList = letterCombinations(next);
            String s = map.get(digits.charAt(0));
            if(s.length()==0)return nextList;
            else if(nextList.size()==0){
                for(char c:s.toCharArray()){
                    list.add(c+"");
                }    
            }else{
                for(String nextS: nextList){
                    for(char c:s.toCharArray()){
                        list.add(c+nextS);
                    }
                }
            }
        }
        return list;
    }
}