package StringTest;

import org.junit.Test;

public class StringDemo1 {
    public int getCount(String mainStr,String subStr){
        int mainLen=mainStr.length();
        int subLen=subStr.length();
        int count=0;
        int index=0;
        if(mainLen>=subLen){
//            while ((index=mainStr.indexOf(subStr))!=-1){
//                count++;
//                mainStr=mainStr.substring(index+subStr.length());
//            }
//            return count;
            while ((index=mainStr.indexOf(subStr,index))!=-1){
                count++;
                index+=subLen;
            }
            return count;
        }
        else {
            return 0;
        }
    }
    @Test
    public void testGetCount(){
        String mainStr="abkkcabeojoabfloaboebab";
        String subStr="ab";
        System.out.println(getCount(mainStr, subStr));
    }
}
