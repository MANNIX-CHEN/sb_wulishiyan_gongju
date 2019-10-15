package wulilab.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int number;
        System.out.println("请输入实验编号");
        System.out.println("1:实验6-2 非平衡电桥测量。。。。。");
        Scanner scanner = new Scanner( System.in);
        number =scanner.nextInt();

        switch (number){
            case 1: All_labs.lab_6_2();
                System.out.println("感谢使用！");
                return ;
        }

        System.out.println("xxxx");


    }
}