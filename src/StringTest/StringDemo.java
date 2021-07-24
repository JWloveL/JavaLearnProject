package StringTest;

public class StringDemo {
    public String Reverse(String str,int startIndex,int endIndex){
        if(str!=null){
            char[] arr=str.toCharArray();
            for (int i=startIndex,j=endIndex;i<j;i++,j--){
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            return new String(arr);
        }
        return null;
    }
    public String reverse1(String str,int startIndex,int endIndex){
        StringBuilder builder=new StringBuilder(str.length());
        //第一部分
        builder.append(str.substring(0,startIndex));
        //第二部分
        for(int i=endIndex;i>=startIndex;i--){
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex+1));

        return builder.toString();
    }
    public static void main(String[] args) {
        StringDemo sd=new StringDemo();
        String str="abcooer";
        System.out.println(sd.Reverse(str,2,4));
        System.out.println(sd.reverse1(str, 2, 4));
    }
}
