import javax.swing.JPanel;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Welcome extends JPanel {

	/**
	 * Create the panel.
	 */
	public Welcome() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("# Fonksiyonlari x^2+5*x+3 seklinde girebilirsiniz.");
		lblNewLabel.setBounds(10, 11, 430, 14);
		add(lblNewLabel);
		
		JLabel lblGirdilerinKontrolleri = new JLabel("# Girdilerin kontrolleri yapilmamistir. Girilmesi gerektigi gibi giriniz.");
		lblGirdilerinKontrolleri.setBounds(10, 85, 430, 14);
		add(lblGirdilerinKontrolleri);
		
		JLabel lblBazDurumlarda = new JLabel("# Baz\u0131 durumlarda ciktilar pencereye sigmayabilir. L\u00FCtfen kenarlar\u0131ndan b\u00FCy\u00FCt\u00FCn.");
		lblBazDurumlarda.setBounds(10, 110, 440, 14);
		add(lblBazDurumlarda);
		
		JLabel lblBaziYontemlerde = new JLabel("# Bazi yontemlerde siz butonlara bastikca veri girebileceksiniz.");
		lblBaziYontemlerde.setBounds(10, 135, 440, 14);
		add(lblBaziYontemlerde);
		
		JLabel lblFonksiyonlariUstteki = new JLabel("# Fonksiyonlari yazarken parantezi l\u00FCtfen yaziniz.");
		lblFonksiyonlariUstteki.setBounds(10, 35, 430, 14);
		add(lblFonksiyonlariUstteki);
		
		JLabel lblAyniSekilde = new JLabel("# Ayni sekilde 5x girmek yerine 5*x girmelisiniz.");
		lblAyniSekilde.setBounds(10, 60, 430, 14);
		add(lblAyniSekilde);
		
		JLabel lblProgramlarTum = new JLabel("# Programlar tum olusabilecek hatalara karsi kontrol edilmemistir.");
		lblProgramlarTum.setBounds(10, 220, 440, 14);
		add(lblProgramlarTum);
		
		JLabel lblAmaGirdiler = new JLabel("# Ama girdiler raporda anlatildigi gibi girildiginde sorunsuz calisacaktir.");
		lblAmaGirdiler.setBounds(10, 245, 440, 14);
		add(lblAmaGirdiler);
		
		JLabel lblHerhangiBir = new JLabel("# Herhangi bir hata durumunda kapatma-acma islemi uygulanmalidir :)");
		lblHerhangiBir.setBounds(10, 270, 440, 14);
		add(lblHerhangiBir);

	}

}
