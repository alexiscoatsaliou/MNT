package ProjetJava;

public class Point {

	double X;
	double Y;
	double Z;
	int i;
	int j;
	
	public Point(double a, double b, double c, int d, int e){
		X = a;
		Y = b;
		Z = c;
		i = d;
		j = e;
		
		
	}
	
	public  double getX(){
		return this.X;
	}
	public  double getY(){
		return this.Y;
	}
	public  double getZ(){
		return this.Z;
	}
	public double getj(){
		return this.j;
	}
	public double geti(){
		return this.i;
	}
	public String toString() {
		return this.X + " - " + this.Y + " - " + this.Z;
	}
}
