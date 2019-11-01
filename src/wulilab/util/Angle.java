package wulilab.util;

public class Angle {

    private int degree;
    private int second;

    public int getDegree() {
        return degree;
    }

    public int getSecond() {
        return second;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public double getArcAngle(){
        //获取弧度角度
        return (degree+(second/60))*Math.PI/180;
    }

    public void print(){
        System.out.println("This angle degrees is "+degree+"."+second);
    }

    public static Angle sub(Angle minuend,Angle subtractor){
        //前一个参数是被减数，后一个参数是减数
        //返回结果即 miuend - subtractor

        Angle sum = new Angle();
        int carrybit=0;
        if (minuend.getSecond()<subtractor.getSecond()){
            carrybit++;
        }
        sum.setDegree(minuend.getDegree()-subtractor.getDegree()-carrybit);
        sum.setSecond(minuend.getSecond()-subtractor.getSecond()+carrybit*60);
        return sum;
    }
    public static Angle add(Angle add1,Angle add2){
        Angle sum = new Angle();
        int carrybit=0;
        if ((add1.getSecond()+add2.getSecond())>60){
            carrybit++;
        }
        sum.setDegree(add1.getDegree()+add2.getDegree()+carrybit);
        sum.setSecond((add1.getSecond()+add2.getSecond())%60);
        return sum;
    }
    public Angle doubleAngle(){
        return add(this,this);
    }


}
