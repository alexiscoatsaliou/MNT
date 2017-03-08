package ProjetJava;

public class mnt_test {

	static String c = "D:\\Dpt_75_asc.asc";
	
	public static void main(String[] args) throws Exception{       
	    //Fenetre fen = new Fenetre(c);
	    
	    MNT m = new MNT(c);
	    
	    Fenetre f = new Fenetre();
	    
	    LireMNT();

	  }
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(1000,1000));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TestJava2D panelJava2D = new TestJava2D();
		panelJava2D.setPreferredSize(new Dimension(1000,1000));
		frame.setContentPane(panelJava2D);
		frame.setVisible(true);
	}
	
}
