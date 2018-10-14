/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Gupta
 */
public class DemoException {
    public static void main(String[] args) {
        int i,j,k=0;
        i=8;
        j=2;
        int a[] = new int[4];
        try{
            k=i/j;
            for (int c=0; c<=4;c++) {
                a[c]=c+1;
            }
            for (int i:a) {
                System.out.println(a+"");
            }
        }
        catch(ArithmeticException e) {
            System.out.println("cannot handle this this");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("max index reached already ");
        }
        System.out.println(k+"");
    }
  
}
