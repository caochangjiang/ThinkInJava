package chapter14.toys;

/**
 * Created by Changjiang on 2016/6/25.
 */
interface HasBatteries{}
interface Wateproof{}
interface Shoots{}
class Toy{
    Toy(){}
    Toy(int i){}
}
class FancyToy extends Toy implements HasBatteries,Wateproof,Shoots{
    FancyToy(){
        super(1);
    }
}
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name:"+cc.getName()+" is interface ?["+cc.isInterface()+"]");
        System.out.println("Sample name:"+cc.getSimpleName());
        System.out.println("Canonical name:"+cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c=null;
        try {
            c=Class.forName("chapter14.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can`t find FancyToy");
        }
        printInfo(c);
        for(Class face:c.getInterfaces()){
            printInfo(face);
        }
        Class up=c.getSuperclass();
        Object obj=null;
        try {
            obj=up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cant instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cant not access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
