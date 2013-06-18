import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NAT implements ItemListener {
    JPanel cards;
    final static String c1 = "Lütfen Listeden Bir Yontem Seciniz";
    final static String c2 = "[+] Kok Bulma Yontemleri";
    final static String c3 = "     Bisection Yontemi";
    final static String c4 = "     Grafik Yontemi";
    final static String c5 = "     Regula False Yontemi";
    final static String c6 = "     Newton Raphson Yontemi";
    final static String c7 = "[+] Numerik Turev";
    final static String c8 = "     Ileri Fark Yontemi";
    final static String c9 = "     Geri Fark Yontemi";
   final static String c17 = "     Merkezi Fark Yontemi"; 
   final static String c10 = "[+] Numerik Integral";
   final static String c11 = "     Simpson Yontemi";
   final static String c12 = "     Trapez Yontemi";
   final static String c13 = "[+] Matris Islemleri";
   final static String c14 = "     Matris Inversinin Alinmasi";
   final static String c15 = "[+] Dogrusal Denklem Takimlarinin Cozulmesi";
   final static String c16 = "     Gauss Eliminasyon Yontemi";
    
    public void addComponentToPane(Container pane) {
        JPanel comboBoxPane = new JPanel();
        FlowLayout flowLayout = (FlowLayout) comboBoxPane.getLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        String comboBoxItems[] = { c1,c2,c3,c4,c5,c6,c7,c8,c9,c17,c10,c11,c12,c13,c14,c15,c16 };
        @SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cb = new JComboBox(comboBoxItems);
        cb.setMaximumRowCount(300);
        cb.setEditable(false);
        cb.addItemListener(this);
        cb.setPreferredSize(new Dimension(500, 30));
        comboBoxPane.add(cb);
        
        //Create the "cards".
        JPanel card1 = new Welcome();         
        JPanel card3 = new Bisection();
        JPanel card4 = new GrafikYon();
        JPanel card5 = new RegulaFalse();
        JPanel card6 = new NewtonRaphson();
        JPanel card8 = new IleriFark();
        JPanel card9 = new GeriFark();
        JPanel card17 = new MerkeziFark();
        JPanel card11 = new Simpson();
        JPanel card12 = new Trapez();
        JPanel card14 = new MatrisInverse();
        JPanel card16 = new GaussEliminasyon();
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, c1);
        cards.add(card3, c3);
        cards.add(card4, c4);
        cards.add(card5, c5);
        cards.add(card6, c6);
        cards.add(card8, c8);
        cards.add(card9, c9);
        cards.add(card17, c17);
        cards.add(card11, c11);
        cards.add(card12, c12);
        cards.add(card14, c14);
        cards.add(card16, c16);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Sayisal Analiz Araci - SSSelim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(520, 380));
        
        //Create and set up the content pane.
        NAT demo = new NAT();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}