import java.util.*;

class Anagrams{
    public static void main(String[] args){
        System.out.println(new Anagrams().anagrams(new String[] {"",""}));
    }
    
    public List<String> anagrams(String[] strs) {
        Map<Map<Character, Integer>,List<String>> all = new HashMap<Map<Character, Integer>,List<String>>();
        for(int i=0;i<strs.length;i++){
            Map<Character, Integer> map = new HashMap<Character,Integer>();
            for(int j=0;j<strs[i].length();j++){
                char c = strs[i].charAt(j);
                int count = map.containsKey(c)?map.get(c):0;
                map.put(c,count+1);
            }
            if(all.containsKey(map)){
                List<String> list = all.get(map);
                list.add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                all.put(map,list);
            }
        }
        List<String> ret = new ArrayList<String>();
        for(List<String> l : all.values()){
            if(l.size()>1){
                ret.addAll(l);
            }
        }
        return ret;
    }
}