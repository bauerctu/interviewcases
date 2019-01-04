/**
 * Created by chenxuehui on 2018/7/31
 * https://www.cnblogs.com/chenssy/p/3388487.html
 */
public class OuterClass {
    private String name;
    private int age;
    private static String nickName = "static chenssy";

    public void display() {
        System.out.println("OuterClass...");
    }

    /** 推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 */
    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    /**
     * 在成员内部类中要注意两点，
     * 第一：成员内部类中不能存在任何static的变量和方法；
     * 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
     */
    public class InnerClass {
        public InnerClass() {
            name = "chenssy";
            age = 23;
            /* 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的 */
            nickName = " inner static chenssy";
        }

        /**
         * 内部类是个编译时的概念，一旦编译成功后，它就与外围类属于两个完全不同的类（当然他们之间还是有联系的）。
         * 对于一个名为OuterClass的外围类和一个名为InnerClass的内部类，在编译成功后，
         * 会出现这样两个class文件：OuterClass.class和OuterClass$InnerClass.class
         */
        public OuterClass getOuterClass() {
            return OuterClass.this;
        }

        public void display() {
            System.out.println("innerClass, name: " + getName() + ", age: " + getAge());
        }

        //内部类可以访问外围类的private成员
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    /**
     * 静态内部类
     * 使用static修饰的内部类我们称之为静态内部类，不过我们更喜欢称之为嵌套内部类。
     * 静态内部类与非静态内部类之间存在一个最大的区别，
     * 我们知道非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围内，
     * 但是静态内部类却没有。没有这个引用就意味着：
     * 1.它的创建是不需要依赖于外围类的。
     * 2.它不能使用任何外围类的非static成员变量和方法。
     */
    static class InnerClassStatic{
        /* 在静态内部类中可以存在静态成员 */
        public static String _name1 = "chenssy_static";

        public void display(){
            /*
             * 静态内部类只能访问外围类的静态成员变量和方法
             * 不能访问外围类的非静态成员变量和方法
             */
            System.out.println("OutClass name :" + nickName);
        }
    }


    public static void main(String[] args) {
        String aa = "祮ta_筦g絟ecu灓a祮u៷idgﵟecy?駧ofa_wke祼";
        String a = "灓";
        int l = a.length();
        int s = a.getBytes().length;

        System.out.println(String.format("string %s length %d, size %d",a,l,s));

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        OuterClass.InnerClass innerClass2 = new OuterClass().new InnerClass();
        innerClass.display();
        innerClass2.getOuterClass().display();
        outerClass.getInnerClass().display();
    }

    public interface IProduct {
        void print(); // 这是要暴露的方法
    }

    public abstract class AbstractProduct implements IProduct {
        protected void printBefore(){
            System.out.println("before print"); // 这里所公共的实现
        }
    }

    public class AProduct extends AbstractProduct {
        private String name;
        public AProduct(String name){
            this.name = name;
        }
        //@Override
        public void print() {
            this.printBefore();
            System.out.println("print A >>>"+name);
        }
    }

}
