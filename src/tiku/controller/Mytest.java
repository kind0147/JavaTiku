package tiku.controller;

import java.util.Scanner;

public class Mytest {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            String snum = Integer.toString(num);
            if(num/2!=0){
                System.out.println("NO");
            }
            else{
                int[] arr1 = new int[num/2];
                int[] arr2 = new int[num/2];
                for(int i=0; i<num/2; i++){
                    arr1[i] = Integer.parseInt(snum.substring(i, i));
                    arr2[i] = Integer.parseInt(snum.substring(num-i, num-i));
                }
                int sum1 = 1, sum2 = 1;
                for(int i=0; i<num/2; i++){
                    sum1 *= arr1[i];
                    sum2 *= arr2[i];
                }
                if(sum1==sum2){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
