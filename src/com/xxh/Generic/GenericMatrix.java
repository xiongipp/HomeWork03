package com.xxh.Generic;

    public abstract class GenericMatrix<E extends Number> {
    protected  abstract E add(E element1,E element2);
    protected  abstract E multiply(E  element1,E element2);
    protected  abstract E zero();

    public  E[][] addMatrix(E[][] matrix1,E[][] matrix2){
        E[][] result=( E[][])new Number[matrix1.length][matrix1[0].length];
        if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){
            throw new RuntimeException("数组类型不同");
        }else{
            for(int i=0;i<matrix1.length;i++){
                for(int j=0;j<matrix1[i].length;j++){
                    result[i][j]=add(matrix1[i][j],matrix2[i][j]);
                }
            }
        }
        return result;
    }
    public E[][] multiplyMatrix(E [][] matrix1, E[][] matrix2){
        E[][] result=(E[][])new Number[matrix1.length][matrix1[0].length];
        if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){
            throw new RuntimeException("数组类型不同");
        }else {
            for(int i=0;i<matrix1.length;i++){
                for(int j=0;j<matrix1[i].length;j++){
                    result[i][j]=zero();
                    for(int k=0;k<matrix1[0].length;k++){
                    result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
                    }
                }
            }
        }
        return result;
    }



        public void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op){
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length;j++){
                System.out.print(" "+m1[i][j]);
            }
            if(m1[0].length/2==i){
                System.out.print(op);
            }
            else {
                System.out.print(" ");
            }
            for(int k=0;k<m1[0].length;k++){
                System.out.print(" "+m2[i][k]);
            }
            if(m1[0].length/2==i){
                System.out.print("=");
            }
            else {
                System.out.print(" ");
            }

            for (int j=0;j<m3[0].length;j++){
                System.out.print(" "+m3[i][j]+" ");
            }

            System.out.println();
        }
    }


}
