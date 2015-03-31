package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Mapa;
import model.Terreno;

public class MapaView extends JFrame 
{	
	private static final long serialVersionUID = 1L;

	private Mapa m = new Mapa();
	private Terreno[][] mapa =  m.getMapa();
	
	private JLabel custo = new JLabel();
	
	private int tamBloco = 20;
	private int custoTotal = 0;

	ImageIcon img;
	
	public MapaView (String titulo) throws InterruptedException{
		super (titulo);
		setLayout(null);
		
		custo.setText("Custo Total: "+custoTotal);
		custo.setBounds(700, 4, 250, 10);
		custo.setForeground(Color.BLACK);
		this.add(custo);
	
		setFocusable(true);
	    requestFocusInWindow();
		
		desenhaMapa();
		this.setResizable(false);
		this.setVisible(true);
		this.setSize (845, 870);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void desenhaMapa (){
		for (int i = 0; i < 42; i++){
			for (int j = 0; j < 42; j++){
				
				mapa[i][j].bloco = new JButton();
				if (mapa[i][j].tipo.equals("MONTANHA"))
				{
					img = new ImageIcon("src/resources/montanha.png");
					mapa[i][j].bloco.setIcon(img);
				}
				if (mapa[i][j].tipo.equals("ROCHA"))
				{
					img = new ImageIcon("src/resources/rocha.png");
					mapa[i][j].bloco.setIcon(img);
				}
				if (mapa[i][j].tipo.equals("PLANO"))
				{
					img = new ImageIcon("src/resources/plano.png");
					mapa[i][j].bloco.setIcon(img);
				}
				if (mapa[i][j].tipo.equals("DESTINO"))
                {
					img = new ImageIcon("src/resources/c1.png");
					mapa[i][j].bloco.setIcon(img);
				}
				if (mapa[i][j].tipo.equals("INICIO"))
				{
					img = new ImageIcon("src/resources/c2.png");
					mapa[i][j].bloco.setIcon(img);
				}
				if (mapa[i][j].tipo.equals("CASA"))
				{
					img = new ImageIcon("src/resources/c3.png");
					mapa[i][j].bloco.setIcon(img);
				}

				mapa[i][j].bloco.setBounds(j* tamBloco, i*tamBloco, tamBloco, tamBloco); 
				mapa[i][j].bloco.setBorderPainted(false);
				mapa[i][j].bloco.setContentAreaFilled(false);
				mapa[i][j].bloco.setFocusPainted(false);
				this.add(mapa[i][j].bloco);
			}
		}
	}
}
