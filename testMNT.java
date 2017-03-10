package ProjetJava;

public class testMNT {
	
	public static void main (String[] args) throws Exception{
		
		String fichier ="D:\\Dpt_75_asc.asc";
		
		MNT m = new MNT(fichier);

		m.LireMNT();
	}

	

}
