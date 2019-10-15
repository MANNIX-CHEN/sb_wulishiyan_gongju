package wulilab.util;
import java.text.DecimalFormat;

/* url:https://blog.csdn.net/fjssharpsword/article/details/54581468
 * 功能：一元线性回归模型最小二乘法Java实现
 * 作者：Jason.F
 * 时间：2017-01-16
 */
public class LeastSquares {
    private final static int n=20;//随机生成10个点的(x,y)
    private LeastSquares(){}
//    public static void main(String[] args){
//        //随机生成20个坐标点
//        Random random = new Random();
//        double[] x=new double[n];
//        double[] y=new double[n];
//        /* y = A x + B
//         * B = sum( y ) / n - a * sum( x ) / n
//         * A = ( n * sum( xy ) - sum( x ) * sum( y ) ) / ( n * sum( x^2 ) - sum(x) ^ 2 )
//         * */
//        estimate(x, y, x.length );
//    }
    /**
     * 得到相应的函数表达式
     * @param x,y,i
     */
    public static void estimate( double[] x , double[] y , int i ) {
        double a = getA( x , y ) ;
        double b = getB( x , y , a ) ;
        //设置doubl字符串输出格式，不以科学计数法输出
        DecimalFormat df=new DecimalFormat("#,##0.00");//格式化设置
        System.out.println("y="+df.format(a)+"x"+"+"+df.format(b));
    }

    /**
     * 计算 x的系数a
     * @param x, y
     * @return a
     */
    public static double getA( double[] x , double[] y ){
        int n = x.length ;
        return ( n * pSum( x , y ) - sum( x ) * sum( y ) )/ ( n * sqSum( x ) - Math.pow(sum(x), 2) ) ;
    }

    /**
     * 计算常量系数b
     * @param x,y,a
     * @returnb
     */
    public static double getB( double[] x , double[] y , double a ){
        int n = x.length ;
        return sum( y ) / n - a * sum( x ) / n ;
    }

    /**
     * 计算常量系数b
     * @param x, y
     * @return b
     */
    public static double getC( double[] x , double[] y ){
        int n = x.length ;
        double a = getA( x , y ) ;
        return sum( y ) / n - a * sum( x ) / n ;
    }

    //计算和值
    private static double sum(double[] ds) {
        double s = 0 ;
        for( double d : ds ) s = s + d ;
        return s ;
    }
    //计算开平方和值
    private static double sqSum(double[] ds) {
        double s = 0 ;
        for( double d : ds ) s = s + Math.pow(d, 2) ;
        return s ;
    }
    //计算x和y积的和值
    private static double pSum( double[] x , double[] y ) {
        double s = 0 ;
        for( int i = 0 ; i < x.length ; i++ ) s = s + x[i] * y[i] ;
        return s ;
    }
}
