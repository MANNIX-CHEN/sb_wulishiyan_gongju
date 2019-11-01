package wulilab.util;

//该类记录一些比较常用的方法吧（其实也不常用

/*
 * 目录（没错就是乱排的
 * 1.摄氏度转化成热力学温度
 * 2.最小二乘法相关（y = k x + b 求 k 和 求 b）
 * */
public class Util {
    private Util(){}

    public static double tem2kv(double temperature){
        //摄氏度温度转化成开尔文温度
        return 273.15+temperature;
    }

    public static double LeastSquareMethodGetK(double[]xi,double []yi){
        /**最小二乘法求 k
         * 对于 y = k x + b
         * 计算 x 的系数 k
         * @param xi, yi
         * @return  k
         */
        return  LeastSquares.getA(xi, yi);
    }

    public static double LeastSquareMethodGetB(double[]xi,double []yi){
        /**最小二乘法求b
         * 对于 y = k x + b
         * 计算常数 b
         * @param xi, yi
         * @return  b
         */
        double a = LeastSquareMethodGetK(xi,yi);
        return LeastSquares.getB(xi,yi,a);
    }
    public static double GetAvg(double[] numbers){
        /**求平均值
         */
        double sum = 0;
        for (double num :numbers){
            sum+=num;
        }
        return sum/numbers.length;
    }
    public static double GetVariance(double[] numbers){
        /**求方差
         */
        double avg=GetAvg(numbers);
        double []varnumbers;
        varnumbers = new double[numbers.length];
        for (int i = 0 ; i<numbers.length; i++){
            varnumbers[i]=(numbers[i]-avg)*(numbers[i]-avg);
        }
        return GetAvg(varnumbers);
    }


}
