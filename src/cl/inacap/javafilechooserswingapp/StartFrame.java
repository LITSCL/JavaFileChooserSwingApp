package cl.inacap.javafilechooserswingapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textArchivoSeleccionado;
	private JButton btnSeleccionarArchivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		setTitle("JavaFileChooserSwingApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ruta");
		lblNewLabel.setBounds(10, 33, 39, 14);
		contentPane.add(lblNewLabel);
		
		textArchivoSeleccionado = new JTextField();
		textArchivoSeleccionado.setBounds(38, 30, 200, 20);
		contentPane.add(textArchivoSeleccionado);
		textArchivoSeleccionado.setColumns(10);
		
		btnSeleccionarArchivo = new JButton("Seleccionar");
		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser archivo = new JFileChooser();
				archivo.setDialogTitle("Busque el archivo");
				int ventana = archivo.showOpenDialog(null); //Esta instrucción habre la ventana que permite seleccionar el archivo.
				if (ventana == JFileChooser.APPROVE_OPTION) { //Aca se esta consultando si el usuario le dio click al boton "Abrir" (En el caso de que lo haya hecho se ejecuta el código).
					File fi = archivo.getSelectedFile(); //Esta instrucción contiene la ruta del archivo.
					textArchivoSeleccionado.setText(String.valueOf(fi)); //Se modifica el texto con la ruta seleccionada (También se puede utilizar el toString para refindir el dato).	
				}
			}
		});
		btnSeleccionarArchivo.setBounds(248, 29, 104, 23);
		contentPane.add(btnSeleccionarArchivo);
	}
}
