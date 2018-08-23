/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Gupta
 Concept : It is type of polymorphism which happens between two different classes.
 Other names : Runtime polymorphism, Late binding, Dynamic Binding, And Method Overriding.
 */
public class Telusko {
    public static void main(String[] args) {
         B obj = new B();
         obj.show();
    }  
}
class A { // Late Binding ----Dynamic binding And Run-time Polymorphism
    public void show() {
        System.out.println("In A");
    }
} 
class B extends A {
   public void show() {
        System.out.println("In B");
    }
}
