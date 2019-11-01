package wulilab.main;

import wulilab.util.Angle;
import wulilab.util.Util;

import java.io.IOException;
import java.io.InputStreamReader;
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
            System.out.println("开尔文温度为 "+ Util.tem2kv(t)+"K");
            System.out.println("x值应该为 "+(1/ Util.tem2kv(t)));
            System.out.println("y值应该为 "+Math.log(rt)+"\n");

            xi[i]=(1/ Util.tem2kv(t));
            yi[i]=Math.log(rt);
            Ti[i]= Util.tem2kv(t);
        }
        double b = Util.LeastSquareMethodGetK(xi,yi);
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

    public static void lab_6_5(){
        System.out.println("请输入记录了11个数据");
        Scanner scanner = new Scanner(System.in);
        double numbers[];
        double lamutas[];
        numbers = new double[11];
        lamutas = new double[7];
        for (int i = 0 ;i<11;i++){
            numbers[i]= scanner.nextDouble();
            if(i>3){
                double DELTA_d=0,lamuda=0;
                DELTA_d = numbers[i]-numbers[i-4];
                lamuda = (DELTA_d*2)/200;
                lamuda = lamuda *1000000;
                System.out.printf("x %d 中的 DELTA_d 为 %.6f ; lamuta 为 %.1f\n",i*50,DELTA_d,lamuda);
                lamutas[i-4]=lamuda;
            }

        }
        System.out.println("avg is "+ Util.GetAvg(lamutas));
        System.out.println("varianse is "+ Util.GetVariance(lamutas));



    }

    public static void lab_6_6(){
        System.out.println("请一次输入6组望远镜位置");
        System.out.println("!!!由于Angle类的问题没有细调，输入在被减数可能进位的角度如\"14.3\" 要输入成\"374.3\"!!!");
        double ns[];
        ns = new double[6];
        Scanner scanner = new Scanner(System.in);
        for(int i =0; i<6; i++){
            //输入6次角度
            Angle[] angles = new Angle[4];
            for (int j =0 ; j<4; j++){
                angles[j] = new Angle();
                System.out.printf("请输入φ%d (分和秒用 . 分开)\n",j);
                String inputstring = scanner.nextLine();
                angles[j].setDegree(Integer.parseInt(inputstring.split("\\.")[0]));
                angles[j].setSecond(Integer.parseInt(inputstring.split("\\.")[1]));

            }//记录每组的数据


            double i1minarcangle = 2 * (
                    Math.abs(angles[0].getArcAngle()-angles[2].getArcAngle())+
                            Math.abs(angles[1].getArcAngle()-angles[3].getArcAngle())
            );

            System.out.print("第一组差值 ");
            Angle.sub(angles[0],angles[2]).print();
            System.out.print("第二组差值 ");
            Angle.sub(angles[1],angles[3]).print();
            /*下面为输出φ*/
            System.out.printf("求得的φ为");
            Angle.add(Angle.sub(angles[0],angles[2]),
                        Angle.sub(angles[1],angles[3])).doubleAngle().print();

            double termsum = (0.5+i1minarcangle)/1.73205;
            ns[i]= Math.sqrt(termsum*termsum+1);//计算每组的n
            System.out.println("\nLast avg is"+Util.GetAvg(ns));
        }
    }
}
