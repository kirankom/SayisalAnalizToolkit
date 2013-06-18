import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.Font;

@SuppressWarnings("serial")
public class MatrisInverse extends JPanel {
	private int loc1,loc2;
	private JTextField textField;
	public MatrisInverse(){
		setLayout(null);
		
		final JTextField boyut = new JTextField();
		boyut.setBounds(136, 45, 43, 20);
		add(boyut);
		boyut.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("# Matrisin inversinin alinmasi icin kare matris olmak zorunda.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 11, 404, 14);
		add(lblNewLabel);
		
		JButton btnMatrisOlustur = new JButton("Matris Olustur");
		btnMatrisOlustur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int size;
				loc1=20;
				loc2=85;
				int i,j;
				// Matris elemanlarinin bulundugu textfieldleri arraylistte tutalým
				final ArrayList<JTextField> list = new ArrayList<>();
				
				size = Integer.parseInt(boyut.getText());
				
				// gelen boyuta gore kare matris cizelim ekrana
				for( i=0; i<size; i++ ){
					for( j=0; j<size; j++ ){
						textField = new JTextField();
						textField.setText(null);
						textField.setBounds(loc1, loc2, 37, 20);
						add(textField);
						textField.setColumns(10);
						list.add(textField);
						loc1 += 40;
					}
					loc1 = 20;
					loc2 += 26;
				}
				

				JButton btnNewButton = new JButton("Inversini Bul");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int size = (int) Math.sqrt(list.size());
						double[][] matris = new double[size][size];
						double[][] tersMatris = new double[size][size];
						int i,j;
						int k=0;
						
						// textfieldlerden degerleri matrise tasýlayalým
						for( i=0; i<size; i++ ){
							for( j=0; j<size; j++ ){
								matris[i][j] = Double.parseDouble(list.get(k).getText());
								k++;
							}
						}
						
						tersMatris = InversMethod(matris, size);
						
						JLabel lblGirilenMatrisinInversi = new JLabel("Girilen Matrisin Inversi :");
						lblGirilenMatrisinInversi.setBounds(loc1, loc2, 146, 20);
						add(lblGirilenMatrisinInversi);
						
						String str;
						loc2 += 26;
						for( i=0; i<size; i++ ){
							for( j=0; j<size; j++ ){
								textField = new JTextField();
								str = tersMatris[i][j] + "";
								if( str.length() > 5 ){
									// sayinin ilk 5 rakamýný yazdýralim.
									textField.setText(str.substring(0,5));
								}else{
									textField.setText(str);
								}
								textField.setEditable(false);
								textField.setBounds(loc1, loc2, 37, 20);
								add(textField);
								textField.setColumns(10);
								loc1 += 40;
							}
							loc1 = 20;
							loc2 += 26;
						}
						
						repaint();
					}
				});
				btnNewButton.setBounds(323, 44, 121, 23);
				add(btnNewButton);
				
				repaint();
			}
		});
		btnMatrisOlustur.setBounds(193, 44, 121, 23);
		add(btnMatrisOlustur);				
		
		JLabel lblMatrisinDerecesi = new JLabel("Matrisin Derecesi :");
		lblMatrisinDerecesi.setBounds(20, 48, 106, 14);
		add(lblMatrisinDerecesi);
	}
	
	public static double[][] InversMethod(double Matris[][], int size){
	    int j,i,k;
	    double sakla;	       
	    double [][] birimMat = new double[size][size];
	    
	    
	    // birim matrisi olustur
	    for( i=0; i<size; i++){
	    	for( j=0; j<size; j++){
	    		if( i == j ){
	    			birimMat[i][j] = 1;
	    		}else{
	    			birimMat[i][j] = 0;
	    		}
	    	}
	    }	    
	    
		for( j=0; j<size; j++ ){
			// Ajj carpim sonucunda degiseceði icin ilk degeri saklamalýyýz
			sakla = Matris[j][j];
		    for( i=0; i<size; i++ ){
		        birimMat[j][i] = birimMat[j][i] / sakla; 
		        Matris[j][i] = Matris[j][i] / sakla;
		    }
		    
	        for( i=0; i<size; i++ ){
	            sakla = Matris[i][j];
		            if( i != j){
		            for( k=0; k<size; k++ ){
			            birimMat[i][k] = birimMat[i][k] - (sakla * birimMat[j][k]);
		            }   
		            
		            for( k=0; k<size; k++ ){
		            	Matris[i][k] = Matris[i][k] - (sakla * Matris[j][k]);
		            }
	            }
	        }
	    }       
        return birimMat;
    }
}

