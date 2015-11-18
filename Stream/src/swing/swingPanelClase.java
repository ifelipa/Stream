package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class swingPanelClase {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingPanelClase window = new swingPanelClase();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public swingPanelClase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("boton");
		btnNewButton.setBounds(257, 139, 117, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog d = new JDialog(frame, "Hello", true);
				d.setLocationRelativeTo(frame);
				d.setVisible(true);
				
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		Label label = new Label("Nombre");
		label.setBounds(40, 29, 57, 21);
		panel.add(label);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(150, 108, -135, 11);
		panel.add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(40, 56, 191, 25);
		panel.add(textField_2);
		
		Label label_1 = new Label("Apellido");
		label_1.setBounds(40, 87, 57, 21);
		panel.add(label_1);
	}
}
