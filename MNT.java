package ProjetJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
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

	public Point[][] LireMNT(){

		String filename = this.textpath;
		File f = new File(filename);
		Scanner in = null;
		ncols = 0;
		nline = 0;
		pas = 0;
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
					nline = format.parse(st[1]).intValue();
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
				tab = new Point [nline][ncols];


				//création d'un tableau contenant les coordonnées des points, leur altitudes et leur position dans le tableau

				if (compteur >= 8){

					for (int i = 0; i < nline; i++) {
						String[] st = line.split(" ");
						int j = 0;
						while ( j < ncols) {
							double z = Double.parseDouble(st[j]);

							tab[i][j] = new Point(coordX + (((double)pas * 0.001) * (double)j+1), coordY + (((double)pas * 0.001) * (double)i +1), z, i, j);

							j++;

						}
						st = null;
					}
				}
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}

		return tab;

	}
}


