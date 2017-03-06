package ProjetJava;

public class mnt_test {

	static String c = "D:\\Dpt_75_asc.asc";
	
	public static void main(String[] args) throws Exception{       
	    //Fenetre fen = new Fenetre(c);
	    
	    MNT m = new MNT(c);
	    
	    Fenetre f = new Fenetre();
	    
	    LireMNT();

	  }
	
}
