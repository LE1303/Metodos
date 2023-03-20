package interfaz;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class burbujaInterfaz extends JFrame implements ActionListener{
	//Atributos de la clase
	private JLabel titulo;
	private JButton ordenar;
	private JPanel pantalla;
	private JTextField valX;
	
	//constructor de la clase
	public burbujaInterfaz(){
		pantalla = new JPanel();
		pantalla.setBounds(10, 10, 480, 480);
		pantalla.setBackground(new Color(102,0,255));
		pantalla.setLayout(null);
		add(pantalla);
		
		//Font sirve para cambiarle el formato a las letras, en este caso se probo con el titulo de Método Burbuja
		 Font fuente=new Font("Times New Roman", Font.PLAIN, 20);
		
		titulo = new JLabel("Método Burbuja");//es el titlo que contendra nuestra pantalla
		titulo.setBounds(190, 20, 250, 30);
		titulo.setFont(fuente);
		pantalla.add(titulo);
		
		titulo = new JLabel("Arreglo Original: 64, 25, 12, 22, 11");//Imprime sobre la pantalla la palabra arreglo
		titulo.setBounds(20, 50, 250, 50);
		pantalla.add(titulo);
		
		/*valX = new JTextField();//Sirve para hacer un cuadro de texto donde podamos escribir
		valX.setBounds(75, 55, 200, 20);
		pantalla.add(valX);*/
		titulo = new JLabel ("Arreglo Ordenado: ");
		titulo.setBounds(20, 100, 200, 20);
		pantalla.add(titulo);
		
		
		
		ordenar = new JButton("Ordenar");
		ordenar.setBounds(95, 350, 300, 40);
		ordenar.addActionListener(this);
		pantalla.add(ordenar);
		
		
		
		setResizable(false);
		setLayout(null);
		setSize(500, 500);//tamaño de la pantalla
		setVisible(true);
		//instrucción para centrar la pantalla
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (pantalla.width - getWidth()) / 2;
		int y = (pantalla.height - getHeight()) / 2;
		setLocation(x, y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new burbujaInterfaz();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Se reciben los eventos del mause y del teclado.
		int arr[] = {64, 25, 12, 22, 11};
		if(e.getSource() == ordenar) {
			System.out.println("Ordenar");
			
			titulo.setText("Arreglo Ordenado:");
			titulo.setBounds(20, 200,120, 20);
			
			bubble(arr);
			
			//convertimos el arreglo ordenado en un string para poder mostrarlo en pantalla
			String arregloOrdenado = "";
			for(int i = 0; i < arr.length;i++) {
				arregloOrdenado += arr[i] + ",";
			}
			
			
			System.out.println("Arreglo Ordenado: " + arregloOrdenado);
			JOptionPane.showMessageDialog(null, "Arreglo Ordenado: " + arregloOrdenado, "Ordenado", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	public static void bubble(int arr[]) {
		int n = arr.length;
		int temp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < (n-i);j++) {
					if(arr[j-1] > arr[j]) {
						//Aqui se intercambian los elementos
						temp = arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}

}
