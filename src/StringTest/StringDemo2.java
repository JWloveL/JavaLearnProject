package StringTest;

import org.junit.Test;

public class StringDemo2 {
    public String getMaxSameString(String str1,String str2){
        if(str1!=null&&str2!=null){
            String maxStr=(str1.length()>=str2.length())?str1:str2;
            String minStr=(str1.length()<str2.length())?str1:str2;
            int len=minStr.length();
            for (int i = 0; i < len; i++) {
                for(int x=0,y=len-i;y<=len;x++,y++){
                    String subStr=minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void test(){
        String str1="anfdohellodsfu";
        String str2="fdhellod";
        System.out.println(getMaxSameString(str1, str2));
    }
}
