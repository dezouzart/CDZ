package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {

	private Terreno[][] mapa = new Terreno[42][42];
	File arq = new File("src/resources/mapa.txt");
	
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
					else if (dados.equals("C"))
						mapa[i][j] = new Terreno("CASA");
					else if (dados.equals("D"))
						mapa[i][j] = new Terreno("DESTINO");
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
	
	public int getCusto (int x, int y){
		return mapa[y][x].custo;
	}
	
	public Terreno[][] getMapa (){
		return mapa;
	}
}
