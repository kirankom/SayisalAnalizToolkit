import net.astesana.javaluator.StaticVariableSet;
import net.astesana.javaluator.DoubleEvaluator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Trapez extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public Trapez() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(40);
		textField.setBounds(147, 24, 326, 20);
		add(textField);
		
		JLabel label = new JLabel("Fonksiyon : ");
		label.setBounds(32, 24, 92, 14);
		add(label);
		
		JLabel lblADeeri = new JLabel("AltSinir Degeri  : ");
		lblADeeri.setBounds(32, 100, 105, 14);
		add(lblADeeri);
		
		JLabel lblB = new JLabel("Ustsinir Degeri : ");
		lblB.setBounds(32, 62, 103, 14);
		add(lblB);
		
		textField_1 = new JTextField();
		textField_1.setColumns(40);
		textField_1.setBounds(145, 62, 326, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(40);
		textField_2.setBounds(147, 100, 326, 20);
		add(textField_2);
		
		JLabel lblToleransDegeri = new JLabel("Bolme Sayisi : ");
		lblToleransDegeri.setBounds(32, 138, 92, 14);
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
				double altSinir,ustSinir,bolmeSayisi,son;
				
				String fonk = textField.getText();
				ustSinir = Double.parseDouble(textField_1.getText());
				altSinir = Double.parseDouble(textField_2.getText());
				bolmeSayisi = Double.parseDouble(textField_3.getText());
				son = T(fonk, altSinir, ustSinir, bolmeSayisi);
				textField_4.setText(son + "");
			}
		});
		button.setBounds(32, 211, 441, 23);
		add(button);
}

	
	public static double T(String fonk, double aSinir, double uSinir, double bolmeSayisi){
		double ArtimMiktari;
	    double Sonuc,s1,s2;
	    double x=aSinir;
	    
		DoubleEvaluator evaluator = new DoubleEvaluator();
	    final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();

	    ArtimMiktari=(uSinir-aSinir)/bolmeSayisi;
	    
	    variables.set("x", uSinir);
	    s1 = evaluator.evaluate(fonk, variables);
	    
	    variables.set("x", aSinir);
	    s2 = evaluator.evaluate(fonk, variables);
	    
	    Sonuc=(s1+s2);
	    x=x+ArtimMiktari;
	    
	    s1 = 0;
	    s2 = 0;
	    while(x<uSinir){
	    	
	    	//Tekler
	    	variables.set("x", x);
	        s1 += evaluator.evaluate(fonk, variables);
	        x=x+ArtimMiktari;
	        //Ciftler
	        variables.set("x", x);
	        s2 += evaluator.evaluate(fonk, variables);
	        x=x+ArtimMiktari;        
	    }
	    Sonuc += 4*s1+2*s2;
		return ArtimMiktari/3*Sonuc;                     
	}
	
}


