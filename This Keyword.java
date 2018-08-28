/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Gupta
 */
public class ThisDemo {
    public static void main(String[] args) {
        Ak obj = new Ak(6);
        obj.show();
    }
}
class Ak {
    private int x;     // Instance Variable : Outside the method
    public Ak(int x) {   // Local Variable 
        this.x = x;     // Current Instance is represented with this keyword
    }
    public void show() {
        System.out.println("In the variable x" + x);
    }
        
}
