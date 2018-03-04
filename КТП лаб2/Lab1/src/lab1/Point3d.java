package lab1;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
/**
 *
 * @author Александр
 */

public class Point3d 
{
    private double xCoord;
    private double yCoord;
    private double zCoord;
	
    /**
     *
     * @param x
     * @param y
     * @param z
     */
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    /**
     *
     */
    public Point3d() {
        
        this(0, 0, 0);
    }

    /**
     *
     * @return
     */
    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }
	
    public double getZ() {
        return zCoord;
    }
	
    public void setX(double val) {
        xCoord = val;
    }

    public void setY(double val) {
        yCoord = val;
    }
	
    public void setZ(double val) {
        zCoord = val;
    }

	
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static double distanceTo(Point3d a, Point3d b) 
	{
        return sqrt(pow(b.xCoord-a.xCoord,2)
		+ pow(b.yCoord-a.yCoord,2)+ pow(b.zCoord-a.zCoord,2));
                            
	}
	
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean srav(Point3d a, Point3d b)
	{
        return (a.getX()==b.getX() || a.getY()==b.getY() || a.getZ()==b.getZ());
      
	}
	
}
