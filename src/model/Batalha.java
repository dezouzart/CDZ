package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;


public class Batalha {
	int dificuldadesCasas[] = new int[12];
	File arq = new File("src/resources/dificuldades.txt");
	File arq2 = new File("src/resources/poder.txt");
	float[] poder = new float[5];
	int parDeLutas[][] = {{0,1},
			{0,1},
			{0,1},
			{2,0},
			{2,1},
			{2,1},
			{2,3},
			{2,4},
			{3,4},
			{3,4},
			{3,4},
			{3,4}};
	
	
	public Batalha() {
		super();
		
			//le do arquivo as dificuldades
			try {
				Scanner s = new Scanner(arq);
				int j=0;
				while (s.hasNextLine()){
					dificuldadesCasas[j] = s.nextInt();
					j++;
				}
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				int k = 0;
				Scanner s = new Scanner(arq2);
						
				while (s.hasNextLine()){
					poder[k] = Float.parseFloat(s.nextLine());
					System.out.println(poder[k]);
					k++;
			}
			
			s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public float[] getPoder() {
		return poder;
	}
	float batalhaCasa(int index, float[] lutadores, int[] ordemLuta ){
		return (float)dificuldadesCasas[index]/this.escolherLutadores(index, lutadores, ordemLuta);
	}
	float escolherLutadores(int index, float[] lutadores, int[] ordemLuta){
		return lutadores[parDeLutas[ordemLuta[index]][0]] + lutadores[parDeLutas[ordemLuta[index]][1]];
	}
	public int[] getDificuldadesCasas() {
		return dificuldadesCasas;
	}
	
	
	
}
