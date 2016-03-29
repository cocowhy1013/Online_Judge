package LeetCode;

/**
 * Created by Coco on 2016/3/29.
 */
public class No043_MultipleStrings {
    public String caculateExpResult(String value_R, String value_S){

        String multiply_value = value_R;
        String result = "";
        //for(int times = 0;times < value_S.length();times++) {
            result = "";
            for (int i = 0; i < value_S.length(); i++) {
                String temp = multiply(multiply_value, value_S.charAt(value_S.length() - 1 - i));
                //System.out.println("temp:" + temp);

                for (int j = 0; j < i; j++)
                    temp = temp + "0";
                //System.out.println("temp:" + temp);
                //System.out.println("result:" + result);
                result = addBinary(temp, result);
                //System.out.println("Final result:" + result);
            }
            multiply_value = result;
        //}
        int remove = 0;
        for(int i=0;i<multiply_value.length();i++){
            if(multiply_value.charAt(i)=='.') {
                remove = i;
                break;
            }
            if(multiply_value.charAt(i)!='0') {
                remove = i;
                break;
            }

        }
        multiply_value = multiply_value.substring(remove);

        char[] array = multiply_value.toCharArray();
        int len = 0;
        for(int i=0;i<multiply_value.length();i++){
            if(array[i]-'0'!=0) {
                len = i;
                break;
            }
            if(i==multiply_value.length()-1)
                len = multiply_value.length()-1;
        }

        return multiply_value.substring(len,array.length);
    }
    public String multiply(String a,char b){
        String result = "";
        int div = 0;
        int remainder = 0;
        for(int i=0;i<a.length();i++) {
            div =  (Integer.parseInt(a.charAt(a.length() - 1 - i) + "")
                    * Integer.parseInt(b + "")+remainder)%10;
            remainder =  (Integer.parseInt(a.charAt(a.length() - 1 - i) + "")
                    * Integer.parseInt(b + "")+remainder)/10;
            result = div + result;
        }
        if(remainder!=0)
            result = remainder + result;
        return result;
    }

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
            result = (plusA+plusB+remain)%10+result;
            remain = (plusA+plusB+remain)/10;
        }
        if(remain!=0)
            result = remain+result;
        //System.out.println(Arrays.toString(a_int));
        //System.out.println(Arrays.toString(b_int));
        //System.out.println(result);
        return result;
    }
    public static void main(String[] args){
        //Scanner scan = new Scanner(System.in);
        String value_R = "1333";
        //char value_P = '1';
        String value_n = "0";
        //while(scan.hasNext()){
        //    value_R = scan.next();
        //    value_n = scan.next();
            System.out.println((new No043_MultipleStrings().caculateExpResult(value_R, value_n)));
        //}
    }
    public static String plus(String a,String b){
        String result = "";
        int div = 0;
        int remainder = 0;
        for(int i=0;i<a.length();i++) {
            if (b.length() > i) {
                div = (Integer.parseInt(a.charAt(a.length() - 1 - i) + "")
                        + Integer.parseInt(b.charAt(b.length() - 1 - i) + "")+remainder)%10;
                remainder = (Integer.parseInt(a.charAt(a.length() - 1 - i) + "")
                        + Integer.parseInt(b.charAt(b.length() - 1 - i) + "")+remainder)/10;
                result = div + result;
            }
            else
            {
                div = (Integer.parseInt(a.charAt(a.length() - 1 - i) + "")
                        +remainder)%10;
                remainder = (Integer.parseInt(a.charAt(a.length() - 1 - i) + "")
                        +remainder)/10;
                result = div + result;
            }
        }

        if(b.length()>a.length()) {
            for (int j = a.length(); j < b.length(); j++) {
                div = (Integer.parseInt(b.charAt(b.length() - 1 - j) + "")
                        + remainder) % 10;
                remainder = (Integer.parseInt(b.charAt(b.length() - 1 - j) + "")
                        + remainder) / 10;
                result = div + result;
            }
        }
        result = remainder + result;
        return result;
    }
}
