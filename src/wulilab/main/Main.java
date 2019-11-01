package wulilab.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int number;
        System.out.println("请输入实验编号");
        System.out.println("0:运行TEST文件");//随便瞎几把乱写测试想要的功能就可以了
        System.out.println("1:实验6-2 非平衡电桥测量。。。。。");
        System.out.println("2:实验6-5 用迈克尔。。。。。");
        System.out.println("3:实验6-6 掠入法。。。。。");
        Scanner scanner = new Scanner( System.in);
        number =scanner.nextInt();

        switch (number){
            case 0:
                System.out.print("\n");
//                test.Test();
                System.out.println("感谢使用！");
                return ;
            case 1:
                System.out.print("\n");
                All_labs.lab_6_2();
                System.out.println("感谢使用！");
                return ;
            case 2:
                System.out.print("\n");
                All_labs.lab_6_6();
                System.out.println("感谢使用！");
                return ;
        }

        System.out.println("xxxx");


    }
}