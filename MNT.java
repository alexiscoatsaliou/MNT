package ProjetJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

public class MNT {
	
	Point tab [][];
	int ncols;
	int nline;
	int pas;
	
	public MNT(int ncols2, int nline2, int pas2){
		ncols = ncols2;
		nline = nline2;
		pas = pas2;
		
		tab = new Point [nline][ncols];
	}

		public MNT LireMNT() throws Exception{
			MNT mnt = null;
			
			String filename = "D:\\Dpt_75_asc.asc";
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
				mnt = new MNT(ncols, nrows, pas);
				compteur++;
				
				if (compteur >= 8){
					
					for (int i = 0; i < ncols; i++) {
						String[] st = line.split(" ");
						int j = 0;
						while ( j != nrows) {
							double z = Double.parseDouble(st[j]);
							
							tab[i][j] = new Point(coordX + ((double)pas * (double)i), coordY + ((double)pas * (double)j), z, i, j);
							
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
			
			return mnt;

		}
		
}


