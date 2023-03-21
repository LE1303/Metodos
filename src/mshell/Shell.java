package mshell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Shell extends JFrame implements ActionListener{
	//Atributos de la clase
		private JLabel nombre;
		private JButton ordenar;
		private JPanel pantalla;
		private JTextField valX;
		
		//constructor de la clase
		public  Shell(){
			pantalla = new JPanel();
			pantalla.setBounds(5, 5, 490, 490);
			pantalla.setBackground(new Color(0,255,102	));
			pantalla.setLayout(null);
			add(pantalla);
			
			//Font sirve para cambiarle el formato a las letras, en este caso se probo con el titulo de Método Burbuja
			 Font fuente=new Font("Times New Roman", Font.PLAIN, 20);
			
			nombre= new JLabel("Método de Shell");//es el titlo que contendra nuestra pantalla
			nombre.setBounds(155, 20, 250, 30);
			nombre.setFont(fuente);
			pantalla.add(nombre);
			
			nombre = new JLabel("Arreglo Original: 64, 25, 12, 22, 11");//Imprime sobre la pantalla la palabra arreglo
			nombre.setBounds(20, 50, 250, 50);
			pantalla.add(nombre);
			
			
			nombre = new JLabel ("Arreglo Ordenado: ");
			nombre.setBounds(20, 100, 200, 20);
			pantalla.add(nombre);
			
			
			
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
			new Shell();
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int arr[] = {64, 25, 12, 22,11};
			if(e.getSource() == ordenar) {
				System.out.println("Ordenar");
				
				nombre.setText("Arreglo Ordenado:");
				nombre.setBounds(20, 200,120, 20);
				int[] arrOrdenado = metodoShell(arr);
				nombre.setText(nombre.getText() + " " + Arrays.toString(arrOrdenado));
				
				
				System.out.println("Arreglo Ordenado: " + arrOrdenado);
				JOptionPane.showMessageDialog(null, "Arreglo Ordenado: " + arrOrdenado, "Ordenado", JOptionPane.INFORMATION_MESSAGE);
			}
				
		}
		
		public static int[] metodoShell (int arr []) {
			int n = arr.length;
			for (int gap = n/2; gap > 0; gap /= 2) {
				for (int i = gap; i <n; i++) {
					int temp = arr[i];
					int j;
					for (j = i; j >= gap && arr[j-gap] > temp; j-=gap) {
						arr[j] = arr[j - gap];
					}
					arr[j] = temp;
				}
			}
			return arr;
			
		}
}
