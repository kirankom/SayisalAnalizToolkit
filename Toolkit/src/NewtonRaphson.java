import net.astesana.javaluator.StaticVariableSet;
import net.astesana.javaluator.DoubleEvaluator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class NewtonRaphson extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	public NewtonRaphson() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(40);
		textField.setBounds(147, 24, 326, 20);
		add(textField);
		
		JLabel label = new JLabel("Fonksiyon : ");
		label.setBounds(32, 24, 92, 14);
		add(label);
		
		JLabel lblADeeri = new JLabel("X0  Degeri  : ");
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
		
		JLabel lblB = new JLabel("Tolerans Degeri : ");
		lblB.setBounds(32, 100, 100, 14);
		add(lblB);
		
		textField_4 = new JTextField();
		textField_4.setColumns(40);
		textField_4.setEditable(false);
		textField_4.setBounds(147, 131, 326, 20);
		add(textField_4);
		
		JLabel lblSonuc = new JLabel("Sonuc :");
		lblSonuc.setBounds(32, 134, 92, 14);
		add(lblSonuc);
		
		JButton button = new JButton("Hesapla");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double x,eps,son;
				
				String fonk = textField.getText();
				x = Double.parseDouble(textField_1.getText());
				eps = Double.parseDouble(textField_2.getText());
				son = NR(fonk, x, eps);
				textField_4.setText(son + "");
			}
		});
		button.setBounds(32, 166, 441, 23);
		add(button);
}
	
	public static double NR(String fonk, double xSifir, double eps){
		double fxSifir,fturevSifir,fark=0.0,yenixSifir;
		
		// Create a new evaluator
	    DoubleEvaluator evaluator = new DoubleEvaluator();
	    final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
	    
	    
	    variables.set("x", xSifir);
	    fxSifir = evaluator.evaluate(fonk, variables);
	    
	    fturevSifir = turevAl(fonk, xSifir);
	    
	    yenixSifir = xSifir - (fxSifir/fturevSifir);
    	
    	fark = Math.abs(xSifir - yenixSifir);
	    
	    while( fark > eps ){
	    	variables.set("x", xSifir);
		    fxSifir = evaluator.evaluate(fonk, variables);
		    
		    fturevSifir = turevAl(fonk, xSifir);
	    	yenixSifir = xSifir - (fxSifir/fturevSifir);
	    	
	    	fark = Math.abs(xSifir - yenixSifir);
	    	xSifir = yenixSifir;	    	
	    }
	    
	    return yenixSifir;
	    
	}

	public static double turevAl(String fonk, double xSifir){
		double dx = 0.1;
		// xEksiBir = xSifir - dx
		// xBir = xSifir + dx
		double xEksiBir = xSifir - dx;
		double xBir = xSifir + dx;
		double fxEksiBir, fxBir;
		
		// Create a new evaluator
	    DoubleEvaluator evaluator = new DoubleEvaluator();
	    final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();	    
	    
	    variables.set("x", xEksiBir);
	    fxEksiBir = evaluator.evaluate(fonk, variables);
	    
	    variables.set("x", xBir);
	    fxBir = evaluator.evaluate(fonk, variables);
	    
	    return (fxBir - fxEksiBir) / (2*dx);
	}
	
}
	

