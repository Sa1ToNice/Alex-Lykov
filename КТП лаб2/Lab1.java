package lab1;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import static lab1.Point3d.srav;

/**
 *
 * @author Александр
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
   {
        // TODO code application logic here
    Scanner in = new Scanner(System.in);
    Point3d onePoint = new Point3d();
    Point3d twoPoint = new Point3d(1,2,3);
    Point3d threePoint = new Point3d();
    System.out.println("Введите X");
    threePoint.setX(in.nextDouble());
    System.out.println("Введите Y");
    threePoint.setY(in.nextDouble());
    System.out.println("Введите Z");
    threePoint.setZ(in.nextDouble());
    if (srav(onePoint,twoPoint) || srav(twoPoint,threePoint) || srav(onePoint,threePoint))
            System.out.println("Ошибка в вычислении пощади");
        else
            computeArea(onePoint,twoPoint,threePoint);
            
   }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double computeArea(Point3d a, Point3d b, Point3d c) {
        double x = Point3d.distanceTo(a, b);
        double y = Point3d.distanceTo(b, c);
        double z = Point3d.distanceTo(a, c);
        double f = (x+y+z)/2;
        f = sqrt(f*(f-x)*(f-y)*(f-z));
        System.out.println("Площадь равна " + f);
        return f;
        }

    
}
