package POJ;


import java.util.Scanner;

/**
 * Created by Coco on 2016/3/23.
 */
public class No1001_Exponentiation {
    public static String caculateExpResult(String value_R_origin, int value_n){
        String value_R = "";
        int dot = 0;
        for(int i=0;i<value_R_origin.length();i++){
            if(value_R_origin.charAt(i)=='.'){
                dot = value_R_origin.length()-1-i;
                continue;
            }
            value_R = value_R + value_R_origin.charAt(i);
        }
        String multiply_value = value_R;
        String result = "";
        for(int times = 0;times < value_n-1;times++) {
            result = "";
            for (int i = 0; i < value_R.length(); i++) {
                String temp = multiply(multiply_value, value_R.charAt(value_R.length() - 1 - i));
                for (int j = 0; j < i; j++)
                    temp = temp + "0";
                //System.out.println("temp:" + temp);
                //System.out.println("result:" + result);
                result = plus(temp, result);
                //System.out.println("Final result:" + result);
            }
            multiply_value = result;
        }
        if(dot!=0) {
            int length = multiply_value.length();
            multiply_value = multiply_value.substring(0, length - dot * value_n) +
                    "." + multiply_value.substring(length - dot * value_n);
        }
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
        if(dot!=0) {
            remove = 0;
            for (int i = 0; i < multiply_value.length(); i++) {
                if (multiply_value.charAt(multiply_value.length() - 1 - i) == '.') {
                    remove = multiply_value.length() - 2 - i;
                    break;
                }
                if (multiply_value.charAt(multiply_value.length() - 1 - i) != '0') {
                    remove = multiply_value.length() - 1 - i;
                    break;
                }
            }
            //System.out.println(multiply_value+" "+remove);
            multiply_value = multiply_value.substring(0,remove+1);
        }

        return multiply_value;
    }
    public static String multiply(String a,char b){
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
        result = remainder + result;
        return result;
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
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String value_R;
        //char value_P = '1';
        int value_n;
        while(scan.hasNext()){
            value_R = scan.next();
            value_n = scan.nextInt();
            System.out.println(caculateExpResult(value_R, value_n));
        }
    }
}