package wulilab.util;
//该类记录一些比较常用的方法吧（其实也不常用

/*
* H x 表示第 x 行
*
* 目录（没错就是乱排的
* H 14      摄氏度转化成热力学温度
*
* */
public class util {
    private util(){}

    public static double tem2kv(double temperature){
        //摄氏度温度转化成开尔文温度
        return 273.15+temperature;
    }

}
