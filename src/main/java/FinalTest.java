/**
 * Created by chenxuehui on 2018/12/11
 */
public class FinalTest {
    public static void main(String[] args) {
        new FinalTest().test();
        Thread t = Thread.currentThread();
        System.out.println("Thread" + t.getId() + ":主线程结束");
        // 执行到此处，主线程结束
    }
    public void test() {
        // 定义一个局部变量
         final int var = 1;//Error:(21, 70) java: 从内部类中访问本地变量var; 需要被声明为最终类型
         final int[] refer = {1};
        // 在内部类里访问局部变量var和refer
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 此处将一直可以访问到var局部变量
                    Thread t = Thread.currentThread();
                    System.out.println("Thread" + t.getId() + ":" + (var + i));//实际上编译后是System.out.println(1 + i)
                    //引用类型局部变量
                    System.out.println("Thread" + t.getId() + ":" + refer +"="+ (refer[0] + i));
                    // 暂停0.1秒
                    try {
                        Thread.sleep(100);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    //var = var + i;//不能修改
                    //引用类型虽然不让修改变量的引用地址，但是可以修改变量里的内容
                    //refer = {i};//不允许
                    refer[0] = i;//允许
                    // 暂停0.2秒
                    try {
                        Thread.sleep(200);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
        System.gc();//主线程执行完毕后，通知虚拟机垃圾回收，此时无论线程执行多久，var和refer都不会被回收掉
    }
}
