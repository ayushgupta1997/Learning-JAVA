
/*
  @author Ayush Gupta
Description : If we don't know the number of arguments that will be sent, we can
use the concept of varargs,(Variable-Arguments)
Note : If you pass the value, it will check for exact signature method, or then search for varargs

 */
public class VarArgs {
    public static void main(String args[]) {
        Display obj = new Display();
        obj.show(5,6);
    }
}
class Display { 
    public void show(int ... a) {          // VarArgs
        for ( int i : a)                  // Enhanced for-loop
          System.out.println(i);
    }
   
} 
