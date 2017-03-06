package ProjetJava;

public class Pointbis {

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
	
	public String toString(){
		return "" + i +" - "+ j + ", ";
	}
	
	public double getX(){
		return this.X;
	}
	
	public double getY(){
		return this.Y;
	}
	
	public double getZ(){
		return this.Z;
	}
	
	
	
}