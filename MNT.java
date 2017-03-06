package ProjetJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MNT extends PlacerPoints {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Point tab [][];
	int ncols;
	int nline;
	int pas;
	String textpath;
	
	public MNT(String textPath){
		this.textpath = textPath;	
	}

		public Point[][] LireMNT() throws Exception{
			
			String filename = this.textpath;
			File f = new File(filename);
			Scanner in = null;
			int ncols = 0;
			int nrows = 0;
			int pas = 0;
			int compteur = 1;
			double coordX = 0;
			double coordY = 0;
			DecimalFormat format = new DecimalFormat("#.00");
			
			try {
			in = new Scanner(f);
			while (in.hasNextLine()) {
			String line = in.nextLine();
				if (line.contains("ncols "))
				{
					String[] st = line.split("ncols ", ' ');
					ncols = format.parse(st[1]).intValue();
				}
				if (line.contains("nrows "))
				{
					String[] st = line.split("nrows ", ' ');
					nrows = format.parse(st[1]).intValue();
				}
				if (line.contains("cellsize "))
				{
					String[] st = line.split("cellsize ", ' ');
					pas = format.parse(st[1]).intValue();
				}
				if (line.contains("xllcorner "))
				{
					String[] st = line.split("xllcorner ", ' ');
					coordX = Double.parseDouble(st[1]);
				}
				if (line.contains("yllcorner "))
				{
					String[] st = line.split("yllcorner", ' ');
					coordY = Double.parseDouble(st[1]);
				}
				
				compteur++;
				tab = new Point [nrows][ncols];
				
				
				//création d'un tableau contenant les coordonnées des points, leur altitudes et leur position dans le tableau
				
				if (compteur >= 8){
					
					for (int i = 0; i < nrows; i++) {
						String[] st = line.split(" ");
						int j = 0;
						while ( j < ncols) {
							double z = Double.parseDouble(st[j]);
							
							tab[i][j] = new Point(coordX + (((double)pas * 0.001) * (double)j+1), coordY + (((double)pas * 0.001) * (double)i +1), z, i, j);
							
							System.out.print (tab[i][j]);
							
							j++;
							
						}
						st = null;
					}
				}
			}
			
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} finally {
			if (in != null)
			in.close();
			}
			
			return tab;

		}
}