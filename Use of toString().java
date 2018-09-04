/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush Gupta
 */
public class DemoString {
    public static void main(String[] args) {
        Student s1 = new Student("Ayush", 40);
        System.out.println(s1.toString());          // It is used to present the object in real.
    }
   
}
class Student {             //This class extends the object class in java, that's why it is overriden here 
    int rollno;
    String name;
    public Student (String name, int r) {
        this.rollno = r;
        this.name = name;
    }
    @Override
     public String toString() {
      return rollno+" "+name;
    }
    
}
