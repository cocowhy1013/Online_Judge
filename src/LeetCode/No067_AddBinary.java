package LeetCode;

/**
 * Created by Coco on 2016/3/29.
 */
public class No067_AddBinary {
    public String addBinary(String a, String b) {
        char []a_elements = a.toCharArray();
        char []b_elements = b.toCharArray();

        int l1 = a_elements.length;
        int l2 = b_elements.length;
        int[] a_int = new int[l1];
        int[] b_int = new int[l2];
        for(int i=0;i<l1;i++)
            a_int[i]=a_elements[l1-i-1]-'0';
        for(int i=0;i<l2;i++)
            b_int[i]=b_elements[l2-i-1]-'0';
        String result = "";
        int remain = 0;
        for(int i=0;i<(l1<l2?l2:l1);i++){
            int plusA = 0;
            int plusB = 0;
            if(i>l1-1)
                plusA = 0;
            else plusA = a_int[i];
            if(i>l2-1)
                plusB = 0;
            else plusB = b_int[i];
            result = (plusA+plusB+remain)%2+result;
            remain = (plusA+plusB+remain)/2;
        }
        if(remain!=0)
            result = remain+result;
        //System.out.println(Arrays.toString(a_int));
        //System.out.println(Arrays.toString(b_int));
        //System.out.println(result);
        return result;
    }
    public static void main(String[] args){
        String a = "0";
        String b = "0";
        System.out.println("a+b:"+(new No067_AddBinary().addBinary(a,b)));
    }
}
