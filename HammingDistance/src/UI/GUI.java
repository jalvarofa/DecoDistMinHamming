package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class GUI extends JFrame {

	private JPanel contentPane;
	private UI UI;
	private JTextField textFieldCode;
	private JTextField textFieldWord;
	private JTextField textFieldPercent;

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
		setBounds(100, 100, 650, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 638, 452);
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
		label_1.setBounds(6, 90, 139, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Porcentaje:");
		label_2.setBounds(426, 90, 87, 15);
		panel.add(label_2);
		
		JButton button_1 = new JButton("Descodificador");
		button_1.setBounds(6, 400, 139, 25);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Simular");
		button_2.setBounds(267, 400, 87, 25);
		panel.add(button_2);
		
		JButton button = new JButton("Dist. Minima");
		button.setBounds(505, 400, 121, 25);
		panel.add(button);
		
		textFieldWord = new JTextField();
		textFieldWord.setBounds(72, 88, 114, 19);
		panel.add(textFieldWord);
		textFieldWord.setColumns(10);
		
		textFieldPercent = new JTextField();
		textFieldPercent.setBounds(512, 88, 114, 19);
		panel.add(textFieldPercent);
		textFieldPercent.setColumns(10);
		
		JLabel lblDistanciaMinimaDe = new JLabel("Distancia Minima de Hamming: ");
		lblDistanciaMinimaDe.setBounds(72, 191, 240, 15);
		panel.add(lblDistanciaMinimaDe);
		
		JLabel labelShowDistMin = new JLabel("");
		labelShowDistMin.setBounds(284, 164, 70, 15);
		panel.add(labelShowDistMin);
		
		JLabel lblErroresQue = new JLabel("Errores que detecta:");
		lblErroresQue.setBounds(131, 189, 152, 15);
		panel.add(lblErroresQue);
		
		JLabel labelShowDetectErrors = new JLabel("");
		labelShowDetectErrors.setBounds(284, 189, 70, 15);
		panel.add(labelShowDetectErrors);
		
		JLabel lblErroresQueCorrige = new JLabel("Errores que corrige:");
		lblErroresQueCorrige.setBounds(131, 214, 152, 15);
		panel.add(lblErroresQueCorrige);
		
		JLabel labelShowCorrectErrors = new JLabel("");
		labelShowCorrectErrors.setBounds(284, 191, 70, 15);
		panel.add(labelShowCorrectErrors);
	}
}
