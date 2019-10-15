package wulilab.main;

import wulilab.util.util;

import java.util.Scanner;

public class All_labs {
    private All_labs(){}

    public static void lab_6_2(){
        System.out.println("请依次输入每组的温度(摄氏温标)，记录的Ig和Rt");
        Scanner scanner = new Scanner(System.in);
        double xi[],yi[],Ti[];
        xi = new double[10];
        yi = new double[10];
        Ti = new double[10];
        for (int i=0;i<10;i++){
            System.out.println("现在输入的是第"+(i+1)+"组");
            System.out.print("温度: ");
            double t=0,ig=0,rt=0;
            t=scanner.nextDouble();
            System.out.print("Ig: ");
            ig = scanner.nextDouble();
            System.out.print("Rt: ");
            rt = scanner.nextDouble();
            System.out.println("开尔文温度为 "+ util.tem2kv(t)+"K");
            System.out.println("x值应该为 "+(1/util.tem2kv(t)));
            System.out.println("y值应该为 "+Math.log(rt)+"\n");

            xi[i]=(1/util.tem2kv(t));
            yi[i]=Math.log(rt);
            Ti[i]=util.tem2kv(t);
        }
        double b =util.LeastSquareMethodGetK(xi,yi);
        System.out.println("实验书上最后二乘法求得的b值应该为"+b);
        for (int i =0;i<10;i++){
            System.out.printf("%5f ",Ti[i]);
        }
        System.out.print("\n");
        for (int i =0;i<10;i++){
            System.out.printf("%5f ",-(b/(Ti[i]*Ti[i])));
        }
        System.out.print("\n");
    }
}
