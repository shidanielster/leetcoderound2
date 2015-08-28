import java.util.*;

class RestoreIpAddresses{

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String> ();
        String[] ips = new String[4];
        help(ips,0,list,s);
        return list;
    }
    
    private void help(String[] ips, int step,List<String> list, String s ){
        if(step == 4&&s.length()==0){
            list.add(ips[0]+"."+ips[1]+"."+ips[2]+"."+ips[3]);
            return;
        }
        if(s.length()< 4- step  || s.length() >(4-step) * 3){
          return;  
        } 
        
        for(int i = 1; i <=3&&i<=s.length(); i++){
            String x = s.substring(0,i);
            if(isValid(x)){
                ips[step]=x;
                help(ips,step+1,list,s.substring(i));
            }
        }
    }
    
    private boolean isValid(String s){
        boolean valid;
        switch(s.length()){
            case 1:
                valid = true;
                break;
            case 2:
                valid = s.charAt(0)!='0';
                break;
            case 3:
                valid = s.charAt(0)=='1'||s.charAt(0)=='2' && 
                    (s.charAt(1)<'5'||  s.charAt(1)=='5'&&s.charAt(2)<'6');
                break;
            default:
                valid = false;
        }
        return valid;
    }
}