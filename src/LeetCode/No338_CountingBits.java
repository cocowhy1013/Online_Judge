package LeetCode;

/**
 * Created by Coco on 2016/3/22.
 */
public class No338_CountingBits {
    public int[] countBits(int num) {

        int level = 0;
        int [] number = new int[num+1];
        number[0] = 0;
        int power = 1;
        for(int i=1;i<num+1;i++){
            if(i==power*2) {
                power = power*2;
                number[i] = 1;
            }
            else if(i<power*2)
                number[i] = 1 + number[(int)(0+i-power)];

        }
        return number;
    }
    public static void main(String [] args){
        int [] b = new No338_CountingBits().countBits(5);
        for(int i=0;i<b.length;i++)
            System.out.print(b[i]+" ");
        System.out.println(Math.pow(2,3));
    }
}

