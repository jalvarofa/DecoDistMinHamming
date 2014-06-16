package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class GUI extends JFrame {

	private JPanel contentPane;
	private UI UI;
	private JTextField textFieldCode;
	private JTextField textFieldWord;
	private JTextField textFieldPercent;
	private JLabel labelShowDistMin;
	private JLabel lblErroresQueDetecta;
	private JLabel labelShowDetectErrors;
	private JLabel labelShowCorrectErrors;
	private JLabel labelShowPercent;
	private JTextField textFieldNumSimulations;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 638, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Codigo (C):");
		label.setBounds(267, 6, 87, 15);
		panel.add(label);
		
		textFieldCode = new JTextField();
		
		textFieldCode.setBounds(12, 33, 614, 25);
		panel.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		JLabel label_1 = new JLabel("Palabra:");
		label_1.setBounds(446, 173, 70, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Porcentaje:");
		label_2.setBounds(467, 90, 75, 15);
		panel.add(label_2);
		
		JButton button_1 = new JButton("Descodificador");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UI = new UI(textFieldCode.getText());
				JOptionPane.showMessageDialog(new JPanel(), UI.decoderAuto(textFieldWord.getText()), "DECODED", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_1.setBounds(6, 264, 139, 25);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Simular");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UI = new UI(textFieldCode.getText());
				StringBuffer message = new StringBuffer();
				UI.simulateWords(Integer.parseInt(textFieldNumSimulations.getText()));
				message.append("Descodificaciones Correctas: " + UI.simulator.getNumOk() + "\n Descodificaciones fallidas" + UI.simulator.getNumFail() + "\n Porcentaje de aciertos: " + UI.simulator.getpercentageOk());
				JOptionPane.showMessageDialog(new JPanel(), message, "SIMULATOR", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_2.setBounds(267, 264, 87, 25);
		panel.add(button_2);
		
		JButton button = new JButton("Dist. Minima");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldCode.getText().equals("")) {
					UI = new UI(textFieldCode.getText());
					labelShowDistMin.setText(""+UI.getMinimumDistance());
					labelShowDistMin.setVisible(true);
					labelShowDetectErrors.setText(""+(UI.getMinimumDistance()-1));
					labelShowCorrectErrors.setText(""+ ((UI.getMinimumDistance()-1)/2));
					
					labelShowPercent.setText(String.valueOf(UI.simulator.getP()));
				}
				
			}
		});
		button.setBounds(505, 264, 121, 25);
		panel.add(button);
		
		textFieldWord = new JTextField();
		textFieldWord.setBounds(512, 171, 114, 19);
		panel.add(textFieldWord);
		textFieldWord.setColumns(10);
		
		textFieldPercent = new JTextField();
		textFieldPercent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					UI.simulator.setP(Float.parseFloat(textFieldPercent.getText()));
					labelShowPercent.setText(textFieldPercent.getText());
				}
			}
		});
		textFieldPercent.setBounds(539, 88, 87, 19);
		panel.add(textFieldPercent);
		textFieldPercent.setColumns(10);
		
		JLabel lblDistanciaMinimaDe = new JLabel("Distancia Minima de Hamming: ");
		lblDistanciaMinimaDe.setBounds(12, 90, 201, 15);
		panel.add(lblDistanciaMinimaDe);
		
		labelShowDistMin = new JLabel("");
		labelShowDistMin.setBounds(224, 90, 70, 15);
		panel.add(labelShowDistMin);
		
		lblErroresQueDetecta = new JLabel("Errores que detecta:");
		lblErroresQueDetecta.setBounds(83, 117, 130, 15);
		panel.add(lblErroresQueDetecta);
		
		labelShowDetectErrors = new JLabel("");
		labelShowDetectErrors.setBounds(224, 117, 70, 15);
		panel.add(labelShowDetectErrors);
		
		JLabel lblErroresQueCorrige = new JLabel("Errores que corrige:");
		lblErroresQueCorrige.setHorizontalAlignment(SwingConstants.CENTER);
		lblErroresQueCorrige.setBounds(83, 144, 130, 15);
		panel.add(lblErroresQueCorrige);
		
		labelShowCorrectErrors = new JLabel("");
		labelShowCorrectErrors.setBounds(224, 144, 70, 15);
		panel.add(labelShowCorrectErrors);
		
		JLabel lblPorcentajeDeRuido = new JLabel("Porcentaje de ruido:");
		lblPorcentajeDeRuido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentajeDeRuido.setBounds(83, 171, 130, 16);
		panel.add(lblPorcentajeDeRuido);
		
		labelShowPercent = new JLabel("");
		labelShowPercent.setBounds(224, 171, 61, 16);
		panel.add(labelShowPercent);
		
		JLabel labelShowDecodedWord = new JLabel("");
		labelShowDecodedWord.setBounds(284, 273, 61, 16);
		panel.add(labelShowDecodedWord);
		
		JLabel lblNDeSimulaciones = new JLabel("N\u00BA de Simulaciones:");
		lblNDeSimulaciones.setBounds(412, 136, 130, 16);
		panel.add(lblNDeSimulaciones);
		
		textFieldNumSimulations = new JTextField();
		textFieldNumSimulations.setBounds(539, 130, 87, 28);
		panel.add(textFieldNumSimulations);
		textFieldNumSimulations.setColumns(10);
	}
}
