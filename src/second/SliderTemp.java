package second;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTemp extends JFrame implements ChangeListener {
									
	JSlider		sliderFahr, sliderCel;
	JTextField celsiusText,	fahrenheitText;
	JLabel title    = new JLabel ("Konvertiere Fahrenheit in Celsius");
	JLabel inLabel  = new JLabel ("Slider für Fahrenheit");
	JLabel outLabel = new JLabel ("Ausgabe Celsius ");
	JLabel title2   = new JLabel ("Konvertiere Celsius in Fahrenheit");
	JLabel inLabel2  = new JLabel ("Slider für Celsius");
	JLabel outLabel2 = new JLabel ("Ausgabe Fahrenheit ");
	JPanel fahrToCelPanel = new JPanel();
	JPanel celToFahrPanel = new JPanel();
	
	/**
	 * Konstruktor des Temperaturumrechners
	 */
	
	public SliderTemp() {
		
	setTitle ("Temperaturumrechner");
	setDefaultCloseOperation( EXIT_ON_CLOSE);
	setBounds(500, 300, 450, 300);
	sliderFahr = new JSlider( SwingConstants.HORIZONTAL, -450, 450, 0);
	sliderFahr.setMajorTickSpacing(150);
	sliderFahr.setMinorTickSpacing(10);
	sliderFahr.setPaintTicks(true);
	sliderFahr.setPaintLabels(true);
	sliderFahr.setPreferredSize(new Dimension(500,50));	
	sliderFahr.addChangeListener( this );
	sliderFahr.add(title);
	sliderFahr.setName("sliderFahr");
	sliderFahr.setToolTipText ("Schieber für Fahrenheit einstellen");
	celsiusText   = new JTextField( 4 );
	celsiusText.setText( sliderFahr.getValue() + " " );
	celsiusText.setToolTipText ("Ergebnis Celsius");
	celsiusText.setFont(new Font("", Font.BOLD, 25));
	sliderCel = new JSlider( SwingConstants.HORIZONTAL, -200, 200, 0);
	sliderCel.setMajorTickSpacing( 100 );
	sliderCel.setMinorTickSpacing(  10);
	sliderCel.setPaintTicks( true );sliderCel.setPaintLabels( true );sliderCel.setPreferredSize( new Dimension(500,50));
	sliderCel.addChangeListener( this );
	sliderCel.setName("sliderCel");
	fahrenheitText   = new JTextField( 4 );	
	fahrenheitText.setText( sliderCel.getValue() + " " );
	fahrenheitText.setFont(new Font("", Font.BOLD, 25));
	fahrenheitText.setToolTipText ("Ergebnis Fahrenheit");
	sliderCel.setToolTipText ("Schieber für Celsius einstellen");
	
	/**
	 * content pane
	 */
	
	fahrToCelPanel.setLayout(
			new FlowLayout());
			
	getContentPane().add( title );	
	getContentPane().add( outLabel);
	getContentPane().add( celsiusText  );
	getContentPane().add( inLabel );
	getContentPane().add( sliderFahr  );
	
	celToFahrPanel.setLayout(
			new FlowLayout());
	
	getContentPane().add( title2 );	
	getContentPane().add( outLabel2);
	getContentPane().add( fahrenheitText  );
	getContentPane().add( inLabel2 );
	getContentPane().add( sliderCel  );
	
	
	getContentPane().setLayout(        								// Layout Gesamt-Fenster
			new BoxLayout(getContentPane(), BoxLayout.Y_AXIS ));	// ... vertikal	
	getContentPane().add( fahrToCelPanel );
	getContentPane().add( celToFahrPanel );		
	celsiusText.setEditable (false);
	fahrenheitText.setEditable (false);
	}
			
	public void stateChanged( ChangeEvent evt ) {
		JSlider source;
		source = (JSlider)evt.getSource();
		if ( !source.getValueIsAdjusting() && source.getName().equals("sliderFahr") )
			celsiusText.setText( (source.getValue() - 32)*5/9 + " " );
		if ( source.getName().equals("sliderCel") )
			fahrenheitText.setText( source.getValue()*9/5+32 + " " );
	}
	
	public static void main ( String[] args ) {
		
		
		SliderTemp weightApp  = new SliderTemp();
		weightApp.setSize( 800, 400 );
		weightApp.setVisible( true ); 
	}

}