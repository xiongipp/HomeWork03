package com.xxh.Generic;

public class Rational extends Number {
    private long numerator=0;//分子为0
    private long denominator=1;//分母为1
    Rational(){
        numerator=0;
        denominator=1;
    }
    Rational(long num1,long num2){
        long gcd=gcd(num1,num2);
        numerator=(num2>0?1:-1)*num1/gcd;
        denominator=Math.abs(num2)/gcd;
    }
    private  static  long gcd(long n,long d){
        long n1=Math.abs(n);
        long n2=Math.abs(d);
        int gcd=1;
        for(int k=1;k<=n1&&k<=n2;k++){
            if(n1%k==0&&n2%k==0){
                gcd=k;
            }
        }
        return gcd;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
    //模拟分数的加法，分母有理化后，分子相加。
    public Rational add(Rational second){
        long n=numerator*second.getDenominator()+denominator*second.getNumerator();
        long d=denominator*second.getDenominator();
        return new Rational(n,d);
    }
    //模拟分数的乘法，分子乘分子，分母乘分母。
    public Rational multiply(Rational second){
        long n=numerator*second.getNumerator();
        long d=denominator*second.getDenominator();
        return new Rational(n,d);
    }

    //重写toString方法，以分数形式输出。
    @Override
    public String toString() {
        if(denominator==1){
            return numerator+"";
        }else {
            return numerator +"/"+ denominator;
        }
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
