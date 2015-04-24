package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Mapa {

	private Terreno[][] mapa = new Terreno[42][42];
	File arq = new File("src/resources/mapa.txt");
	ArrayList <Casa> posCasas = new ArrayList <Casa> ();
	
	public Mapa (){
		
		try {
			Scanner s = new Scanner(arq);
			
			for (int i=0;i<42;i++){
				String leitura = s.nextLine();
				String dados = "";
				
				for (int j=0;j<42;j++){
					dados += leitura.charAt(j);
				
					if (dados.equals("m"))
						mapa[i][j] = new Terreno("MONTANHA");
					else if (dados.equals(" "))
						mapa[i][j] = new Terreno("PLANO");
					else if (dados.equals("r"))
						mapa[i][j] = new Terreno("ROCHA");
					else if (dados.equals("C")){
						mapa[i][j] = new Terreno("CASA");
						Casa a = new Casa(j,i);
						posCasas.add(a);
					}
					else if (dados.equals("D"))
						mapa[i][j] = new Terreno("DESTINO");
					else if (dados.equals("A"))
						mapa[i][j] = new Terreno("ATENA");
					else if (dados.equals("I"))
						mapa[i][j] = new Terreno("INICIO");
					
					dados = "";
				}
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean terrenoValido (int x, int y){
		if (x < 42 && y < 42 && x >= 0 && y >= 0)
			return mapa[y][x].valido;
		return false;
	}
	
	public int getCusto (int x, int y){
		return mapa[y][x].custo;
	}
	
	public Terreno[][] getMapa (){
		return mapa;
	}
	
	public ArrayList <Casa> getCasas(){
		return this.posCasas;
	}
}
