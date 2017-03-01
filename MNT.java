package ProjetJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MNT {
	
	
	public static void main(String[] args){
	
	    String chaine="";
		String fichier ="D:\\mnt_test.txt";
 
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if (ligne.contains("cellsize "))
				{
					String[] st = ligne.split("cellsize", ' ');
					double pas = Double.parseDouble(st[1]);
					System.out.println(pas);
				}
				if (ligne.contains("nrows "))
				{
					String[] st = ligne.split("nrows", ' ');
					double nrows = Double.parseDouble(st[1]);
					System.out.println(nrows);
				}
				if (ligne.contains("ncols "))
				{
					String[] st = ligne.split("ncols", ' ');
					double ncols = Double.parseDouble(st[1]);
					System.out.println(ncols);
				}

			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

	}


}
