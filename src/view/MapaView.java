package view;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Seiya;
import model.Mapa;
import model.Terreno;

public class MapaView extends JFrame 
{	
	private static final long serialVersionUID = 1L;

	private Mapa m = new Mapa();
	private Terreno[][] mapa =  m.getMapa();
	
	private JLabel custo = new JLabel();
	
	private int ALT_PERSONAGEM = 18;
	private int LAR_PERSONAGEM = 17;
	private int tamBloco = 17;
	private int winSize = tamBloco*42;
	private int custoTotal = 0;
	private int casaNum = 12;

	ImageIcon img;
	
	private Seiya seiya = new Seiya(LAR_PERSONAGEM, ALT_PERSONAGEM, tamBloco);
	
	public MapaView (String titulo) throws InterruptedException{
		super (titulo);
		setLayout(null);
		
		custo.setText("Custo Total: "+custoTotal);
		custo.setBounds(8, 8, 250, 10);
		custo.setForeground(Color.GREEN);
		this.add(custo);
	
		this.add(seiya.bloco);
		
		setFocusable(true);
	    requestFocusInWindow();
		
		desenhaMapa();
		this.setResizable(false);
		this.setVisible(true);
		this.setSize (winSize, winSize+20);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void desenhaMapa (){
		for (int i = 0; i < 42; i++){
			for (int j = 0; j < 42; j++){
				
				mapa[i][j].bloco = new JButton();
				if (mapa[i][j].tipo.equals("MONTANHA")) {
					img = new ImageIcon(getRandomSky());
					mapa[i][j].bloco.setIcon(img);
				} else if (mapa[i][j].tipo.equals("ROCHA")) {
					img = new ImageIcon("src/resources/pillar.png");
					mapa[i][j].bloco.setIcon(img);
				} else if (mapa[i][j].tipo.equals("PLANO")) {
//					String imageName = getImageName(i, j);
//					img = new ImageIcon(imageName);
//					mapa[i][j].bloco.setIcon(img);
				} else if (mapa[i][j].tipo.equals("DESTINO")) {
					img = new ImageIcon("src/resources/destino.png");
					mapa[i][j].bloco.setIcon(img);
				} else if (mapa[i][j].tipo.equals("INICIO")) {
					img = new ImageIcon("src/resources/pegasus.png");
					mapa[i][j].bloco.setIcon(img);
				} else if (mapa[i][j].tipo.equals("CASA")) {
					img = new ImageIcon("src/resources/c"+casaNum+".png");
					mapa[i][j].bloco.setIcon(img);
					casaNum--;
				}  else if (mapa[i][j].tipo.equals("ATENA")) {
					img = new ImageIcon("src/resources/atena.png");
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
	
	private String getImageName(int i, int j){
		if(mapa[i][j+1].tipo.equals("Montanha")){
			return "src/resources/sky.png";
		} else if(mapa[i][j-1].tipo.equals("Montanha")){
			return "src/resources/sky.png";
		} else if(mapa[i+1][j].tipo.equals("Montanha")){
			return "src/resources/sky.png";
		} else if(mapa[i-1][j].tipo.equals("Montanha")){
			return "src/resources/sky.png";
		} 
		return "src/resources/plano.png";
	}
	
	private String getRandomSky() {
		Random random = new Random();
		int num = random.nextInt(5);
		
		String montanha = "src/resources/sky"+ num +".png";
		return montanha;
	}
}
