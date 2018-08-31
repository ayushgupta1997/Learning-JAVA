/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Gupta
 */
public class Abstraction {
    public static void main(String[] args) {
        Iphone obj = new Iphone();
        //show(obj);
        SamsungS4 obj2 = new SamsungS4();
        show(obj2);
       
        
    }
//    public static void show(Iphone obj) {
//        System.out.println("2gb iphone");       // To reduce this sort of redundancy we can use abstract class which inherit
//    }
//    public static void show(SamsungS4 obj) {
//        System.out.println("2gb iphfhdhone");
//    }
     public static void show(Phone obj) {
            obj.showConfig();
     } 
}
abstract class Phone {
    abstract public void showConfig();
}
class Iphone extends Phone {
    public void showConfig() {
            System.out.println("2 gb ram Iphone");
    }
}
class SamsungS4 extends Phone{
    public void showConfig() {
     System.out.println("2 gb ram Samsung");

    }
}
