/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Gupta
 */
public class AbDemo {
    public static void main(String[] args) {
//        MaheshPhone obj = new MaheshPhone();   // cannot instantiate abstract class
//        obj.call();
            SureshPhone obj = new SureshPhone();
            obj.call();
            obj.dance();
            obj.cook();
    }
}
abstract class MaheshPhone {  // abstact methods are defined in abstract class
    //Future Plans which may use in future
    public void call() {
        System.out.println("Calling.....");
    }
    //declared but not defined;
    public abstract void move();  //we dont know the implementation of the function
    public abstract void dance();
    public abstract void cook();
}

abstract class RameshPhone extends MaheshPhone {
    public void move() {  //this also a abstract method so the class will also be abstract class
        System.out.println("Moving Dude.....");
    }
}
class SureshPhone extends RameshPhone { // Concrete class no abstract methods
    public void dance() {
        System.out.println("Dancing ....");
    }
    public void cook() {
        System.out.println("Cooking....");
    }
}
