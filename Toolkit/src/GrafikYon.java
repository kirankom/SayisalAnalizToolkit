import net.astesana.javaluator.StaticVariableSet;
import net.astesana.javaluator.DoubleEvaluator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GrafikYon extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public GrafikYon() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(40);
		textField.setBounds(147, 24, 326, 20);
		add(textField);
		
		JLabel label = new JLabel("Fonksiyon : ");
		label.setBounds(32, 24, 92, 14);
		add(label);
		
		JLabel lblADeeri = new JLabel("x  Degeri  : ");
		lblADeeri.setBounds(32, 62, 92, 14);
		add(lblADeeri);
		
		textField_1 = new JTextField();
		textField_1.setColumns(40);
		textField_1.setBounds(145, 62, 326, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(40);
		textField_2.setBounds(147, 100, 326, 20);
		add(textField_2);
		
		JLabel lblB = new JLabel("deltaX Degeri : ");
		lblB.setBounds(32, 100, 92, 14);
		add(lblB);
		
		JLabel lblToleransDegeri = new JLabel("Tolerans Degeri : ");
		lblToleransDegeri.setBounds(32, 138, 105, 14);
		add(lblToleransDegeri);
		
		textField_3 = new JTextField();
		textField_3.setColumns(40);
		textField_3.setBounds(147, 138, 326, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(40);
		textField_4.setEditable(false);
		textField_4.setBounds(147, 176, 326, 20);
		add(textField_4);
		
		JLabel lblSonuc = new JLabel("Sonuc :");
		lblSonuc.setBounds(32, 176, 92, 14);
		add(lblSonuc);
		
		JButton button = new JButton("Hesapla");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double x,dx,tol,son;
				
				String fonk = textField.getText();
				x = Double.parseDouble(textField_1.getText());
				dx = Double.parseDouble(textField_2.getText());
				tol = Double.parseDouble(textField_3.getText());
				son = GY(fonk, x, dx, tol);
				textField_4.setText(son + "");
			}
		});
		button.setBounds(32, 211, 441, 23);
		add(button);
}

	
	public static double GY(String fonk, double x, double dx, double tol){	
		double fx,fyeniX,gececiHata;
		double yeniX = x + dx;
		
		DoubleEvaluator evaluator = new DoubleEvaluator();
	    final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
	    	    
	    variables.set("x", x);
	    fx = evaluator.evaluate(fonk, variables);
	    
	    variables.set("x", yeniX);
	    fyeniX = evaluator.evaluate(fonk, variables);
	    
	    gececiHata = fyeniX - fx;
	    
	    while( Math.abs(gececiHata) >= tol ){
		  if( (fx * fyeniX) < 0 ){
		    	yeniX -= dx;
		    	dx = dx / 2;
		    	yeniX += dx;    	
		    }else{
		    	x = yeniX;
		    	yeniX += dx;
		    }
		  
		  	variables.set("x", x);
		    fx = evaluator.evaluate(fonk, variables);
		    
		    variables.set("x", yeniX);
		    fyeniX = evaluator.evaluate(fonk, variables);
		    gececiHata = fyeniX - fx;
	    }    
	  
		return yeniX;                     
	}
	
}


