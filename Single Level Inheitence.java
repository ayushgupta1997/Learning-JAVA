
/**
 *
 * @author Ayush Gupta
 */
public class SingleLevelIneritence {
    public static void main(String[] args) {
        Sub obj = new Sub();    // create object of child class
        obj.num1 = 3;
        obj.num2 = 2;
        obj.add();
        System.out.println(obj.result);
        obj.sub();
        System.out.println(obj.result);
    }
}
class Sum {
    int num1, num2, result = 0;
    public void add() {
        result = num1+num2;
    }
}
class Sub extends Sum {  // extends keyword is used to inherit all the properties of parent class Sum
    public void sub() {
        result = num1 - num2;
    }
}
