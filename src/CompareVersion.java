class CompareVersion{
    public int compareVersion(String version1, String version2) {
        if(version1==null)return version2==null?-1:0;
        if(version2==null)return 1;
        
        for(int i = 0,k=0;i<version1.length()||k<version2.length();){
            int j=i;
            while(j<version1.length()&&version1.charAt(j)!='.')j++;
            int v1 = j==i?0:Integer.valueOf(version1.substring(i,j));
            i=j+1;
            
            j=k;
            while(j<version2.length()&&version2.charAt(j)!='.')j++;
            int v2 = j==k?0:Integer.valueOf(version2.substring(k,j));
            k=j
            
            if(v1>v2)return 1;
            else if(v1<v2)return -1;
        }
        return 0;
    }

}