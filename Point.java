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
	
	public String toString(){
		return "X = " + this.X + ", i = " + this.i + ", Y = " + this.Y + ", " + "j = " + this.j + ", ";
		
	}
}
