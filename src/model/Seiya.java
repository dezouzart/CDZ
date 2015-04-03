package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Seiya
{
	private int xIni = 37;
	private int yIni = 37;
	private int x = 18;
	private int y = 22;
	private int altura;
	private int largura;
	private int passo;
	
	public ImageIcon img = new ImageIcon ("src/resources/seiyaFront2.png");
	public JButton bloco = new JButton ();
	
	public Seiya (int l, int a, int tamBloco)
	{
		x = xIni;
		y = yIni;
		altura = a;
		largura = l;
		passo = tamBloco;
		
		bloco.setIcon(img);
		bloco.setBounds(x*tamBloco, y*tamBloco, largura , altura);
		bloco.setBorderPainted(false); 
        bloco.setContentAreaFilled(false); 
        bloco.setFocusPainted(false); 
	}
	
	public void cima ()
	{
		this.y = this.y-1;
		bloco.setBounds(x*passo, y*passo-10, largura, altura);
	}
	
	public void baixo ()
	{
		this.y = this.y+1;
		bloco.setBounds(x*passo, y*passo-10, largura, altura);
	}
	
	public void esquerda ()
	{
		this.x = this.x-1;
		bloco.setBounds(x*passo, y*passo-10, largura, altura);
	}
	
	public void direita ()
	{
		this.x = this.x+1;
		bloco.setBounds(x*passo, y*passo-10, largura, altura);
	}

	public int getX ()
	{
		return x;
	}
	
	public int getY ()
	{
		return y;
	}
	
}
