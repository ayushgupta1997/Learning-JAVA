/
package MultilvelInheritenceDemo;

/**
 * @author Ayush Gupta
 */
public class MultilvelInheritenceDemo {
    public static void main(String[] args) {
        AddSubMul obj = new AddSubMul();
        obj.num1 = 5;
        obj.num2 = 4;
        obj.sum();
        System.out.println(obj.result);
        obj.sub();
        System.out.println(obj.result);
        obj.mul();
        System.out.println(obj.result);
    }
}
    class Add { // parent class/ Base Class/ SuperClass
         int num1, num2, result=0;
        public void sum() {
            result = num1+num2;
        }
    }
    class AddSub extends Add { // child class/ Derived Class/  Sub Class wrt to class  Add
        public void sub() {
            result = num1-num2;
        }
    }
    class AddSubMul extends AddSub {
        public void mul() {
            result = num1 * num2;
        }
    }
    
            
    

