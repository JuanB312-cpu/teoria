package euclides;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;

public class Marco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField entrar1;
	private String texto;
	private int mcd1;

	Maximocomundivisor mcd = new Maximocomundivisor();
	static ArrayList<Integer> numeros = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marco frame = new Marco();
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
	@SuppressWarnings({})
	public Marco() {
		setType(Type.UTILITY);
		setTitle("Euclides paso a paso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton calculo = new JButton("Calcular");
		calculo.setBounds(10, 11, 86, 23);
		contentPane.add(calculo);

		entrar1 = new JTextField();
		entrar1.setBounds(10, 43, 493, 20);
		contentPane.add(entrar1);
		entrar1.setColumns(10);

		entrar1.setEnabled(true);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(1, 1, 520, 434);
		contentPane.add(textArea);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 74, 495, 436);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Ingrese los n\u00FAmeros en cualquier orden para sacar su MCD, y combinaci\u00F3n lineal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(106, 15, 399, 20);
		contentPane.add(lblNewLabel);

		calculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (entrar1.getText().length()!=0) {

				String[] entradas = entrar1.getText().split(",");

				for (int j = 0; j < entradas.length; j++) {

					numeros.add(Integer.parseInt(entradas[j]));}

				}

				if (numeros.size() != 0 && numeros.size() != 1) {

					texto = "\n\t" + ("\n\tEmpezamos haciendo divisiones sucesivas");

					mcd.coeficientes(1, 0, numeros, 1);
					texto = texto + mcd.imprimir(1, 0, numeros, 1).getexto();
					mcd1 = mcd.imprimir(1, 0, numeros, 1).getmcd1();

					for (int j = 2; j < numeros.size(); j++) {

						texto = texto + "\n\t" + ("\n\tSeguimos ahora con el mcd entre " + mcd1
								+ " y el siguente valor " + numeros.get(j));
						mcd.coeficientes(j, 1, numeros, mcd1);
						texto = texto + mcd.imprimir(j, 1, numeros, mcd1).getexto();
						mcd1 = mcd.imprimir(j, 1, numeros, mcd1).getmcd1();

					}

					textArea.setText(texto);

					mcd.limpiarfinal();
				}

				if (numeros.size() == 0) {

					JOptionPane.showMessageDialog(null, "No se han ingresado entradas", "Error",
							JOptionPane.WARNING_MESSAGE);

				}

				if (numeros.size() == 1) {

					JOptionPane.showMessageDialog(null, "Solo se ha ingresado un número", "Error",
							JOptionPane.WARNING_MESSAGE);

				}

				numeros.clear();

				texto = " ";

			}
		});

		entrar1.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				if ((caracter < '0' || caracter > '9') && caracter != ',') {

					e.consume();
				}
			}
		});
	}
}
