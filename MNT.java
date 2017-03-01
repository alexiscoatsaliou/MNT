package ProjetJava;

import java.io.File;
import java.io.FileNotFoundException;
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

		public MNT LireMNT(){
			MNT mnt = null;
			
			String filename = "D:\\mnt_test.txt";
			File f = new File(filename);
			Scanner in = null;
			String ligne;
			int ncols = 0;
			int nrows = 0;
			int pas = 0;
			
			try {
			in = new Scanner(f);
			while (in.hasNextLine()) {
			String line = in.nextLine();
				if (line.contains("ncols "))
				{
					String[] st = line.split("ncols ", ' ');
					ncols = Integer.parseInt(st[1]);
				}
				if (line.contains("nrows "))
				{
					String[] st = line.split("nrows", ' ');
					nrows = Integer.parseInt(st[1]);
				}
				if (line.contains("cellsize "))
				{
					String[] st = line.split("cellsize ", ' ');
					pas = Integer.parseInt(st[1]);
				}
				mnt = new MNT(ncols, nrows, pas);
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


