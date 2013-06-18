import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.util.*;

@SuppressWarnings("serial")
public class GaussEliminasyon extends JPanel {
	private JTextField derece;
	private JTextField textField;
	
	public GaussEliminasyon() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("[!] Denklem sistemini matris duzeninde yazmalisiniz.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 393, 26);
		add(lblNewLabel);
		
		derece = new JTextField();
		derece.setBounds(150, 49, 71, 20);
		add(derece);
		derece.setColumns(10);
		
		JButton btnNewButton = new JButton("Devam Et");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int loc1=20,loc2=120;
				int i,j;
				int size = Integer.parseInt(derece.getText());
				final ArrayList<JTextField> list = new ArrayList<>();
				
				JLabel lblNewLabel_1 = new JLabel("Ilk " + size + "x" + size + " katsayilar matrisi, son sutun sonuc matrisidir.");
				lblNewLabel_1.setBounds(10, 85, 450, 14);
				add(lblNewLabel_1);
				
				for( i=0; i<size; i++ ){
					for( j=0; j<size+1; j++ ){
						textField = new JTextField();
						textField.setText(null);
						textField.setBounds(loc1, loc2, 42, 20);
						add(textField);
						textField.setColumns(10);
						list.add(textField);
						loc1 += 54;
					}
					loc1 = 20;
					loc2 += 31;
				}
				
				JButton btnDenklemSisteminiCoz = new JButton("Denklemi Coz");
				btnDenklemSisteminiCoz.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int size = (int) Math.sqrt(list.size());
						double[][] matris = new double[size][size+1];
						double[][] xler = new double[size][1];
						int i,j;
						int k=0;
						
						for( i=0; i<size; i++ ){
							for( j=0; j<size+1; j++ ){
								matris[i][j] = Double.parseDouble(list.get(k).getText());
								k++;
							}
						}
						
						
						xler = GE(matris, size);
						
						String str = "Cozum : ";
						for( i=0; i<size; i++ ){
							str += " x" + (i+1) + " : " + xler[i][0] + ",  "; 
						}
						
						JLabel cozum = new JLabel("New label");
						cozum.setText(str);
						cozum.setBounds(10, 281, 500, 14);
						add(cozum);
						
						repaint();
					}
				});
				btnDenklemSisteminiCoz.setBounds(337, 48, 160, 23);
				add(btnDenklemSisteminiCoz);
				
				repaint();
			}
			
			
		});
		btnNewButton.setBounds(238, 48, 89, 23);
		add(btnNewButton);
		
		JLabel lblDenklemlerinDerecesi = new JLabel("Denklemlerin Derecesi :");
		lblDenklemlerinDerecesi.setBounds(10, 52, 140, 14);
		add(lblDenklemlerinDerecesi);
		
		
	}
	

	public static double[][] GE(double Amatrisi[][], int size){
		double t1;
		int sut = size + 1;
		double[][] xler = new double[size][1];
		double[][] cler = new double[size][1];
		double[][] sler = new double[size][1];
		int i,j,k;		
		
		for( k=0; k<size; k++ ){ // a11, a22, a33 için
			
			//a11 1.satiri boluyor
			t1 = Amatrisi[k][k];
			for( j=0; j<sut; j++ ){ // sutunlari dolasiyor
				Amatrisi[k][j] /= t1;
			}
			
			for(i=k+1; i<size; i++){ // a21, a31
				t1 = Amatrisi[i][k];
				for( j=0; j<sut; j++ ){ // i.satýr sutunlarini boluyor
					Amatrisi[i][j] /= t1;
				}
				
				for( j=0; j<sut; j++ ){  //i.satirdan k.satiri cikariyoruz
					Amatrisi[i][j] -= Amatrisi[k][j];
				}
				
				for( j=0; j<sut; j++ ){ // i.satiri Aik ile carpiyoruz
					Amatrisi[k+1][j] *= t1;
				}			
			}
		}
		
		for( i=0; i<size; i++ ){
			cler[i][0] = Amatrisi[i][size];
		}
		
		
		for( i = size-1; i >=0; i--) { // aRow
		    for( j = 0; j >= 0; j--) { // bColumn
		      for( k = size-1; k >= 0; k--) { // aColumn
		    	if( i != k ){
		    		sler[i][j] += Amatrisi[i][k] * xler[k][j];
		    	}		        
		      }
		    }  
		    xler[i][0] = cler[i][0] - sler[i][0]; 
		}
		return xler;
	}	
}
	

