package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;

import java.util.Scanner;

public class Batalha {
	int dificuldadesCasas[] = new int[12];
	File arq = new File("src/resources/dificuldades2.txt");
	File arq2 = new File("src/resources/poder2.txt");
	float[] poder = new float[5];
	String nomeCasa[] = new String[12];
	String nomeCavaleiro[] = new String[5];
	int parDeLutas[][] = { { 0, 1 }, { 0, 1 }, { 0, 1 }, { 2, 0 }, { 2, 1 },
			{ 2, 1 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 4 }, { 3, 4 },
			{ 3, 4 } };
	int[] vidas = {5,5,5,5,5};
	public Batalha() {
		super();
		int tam = 0;
		String dificuldade = new String();
		String strPoder = new String();
		
		// le do arquivo as dificuldades
		try {
			Scanner s = new Scanner(arq);
			int j = 0;
			while (s.hasNextLine()) {
				String str = s.nextLine();
				while (tam < str.length()) {
					try {
						Integer.parseInt(Character.toString(str.charAt(tam)));

						dificuldade = dificuldade
								+ Character.toString(str.charAt(tam));
					} catch (Exception e) {
						if(nomeCasa[j] == null){
							nomeCasa[j] = Character.toString(str.charAt(tam));
						}
						else{
							nomeCasa[j] = nomeCasa[j]
											+ Character.toString(str.charAt(tam));
						}
					}
					tam++;
				}
				
				tam=0;
				dificuldadesCasas[j] = Integer.parseInt(dificuldade);
				dificuldade = "";
				j++;
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tam =0;
			int k = 0;
			Scanner s = new Scanner(arq2);
			while (s.hasNextLine()) {
				String str2 = s.nextLine();
				while (tam < str2.length()) {
					try {
						if (str2.charAt(tam) == '.') {
							strPoder = strPoder
									+ Character.toString(str2.charAt(tam));
						} else {
							Integer.parseInt(Character.toString(str2.charAt(tam)));
							//System.out.println(strPoder);
							strPoder = strPoder+ Character.toString(str2.charAt(tam));
						}
					} catch (Exception e) {
						if(nomeCavaleiro[k] == null){
							nomeCavaleiro[k] = Character.toString(str2.charAt(tam));
						}else{
						nomeCavaleiro[k] = nomeCavaleiro[k]
								+ Character.toString(str2.charAt(tam));
						}
					}
					tam++;
				}
				
				tam=0;
				poder[k] = Float.parseFloat(strPoder);
				strPoder = "";
				k++;

			}

			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ii = 0;
		for (int arr : dificuldadesCasas) {
			System.out.printf("%s : %d\n", nomeCasa[ii], arr);
			ii++;
		}
		System.out.printf("\n\n");
		ii = 0;
		for (float arr2 : poder) {
			System.out.printf("%s : %f\n", nomeCavaleiro[ii], arr2);
			ii++;
		}
		System.out.printf("\n\n");
	}

	public float[] getPoder() {
		return poder;
	}

	float batalhaCasa(int index, float[] lutadores, int[] ordemLuta) {
		return (float) dificuldadesCasas[index]
				/ this.escolherLutadores(index, lutadores, ordemLuta);
	}

	float escolherLutadores(int index, float[] lutadores, int[] ordemLuta) {
		vidas[parDeLutas[ordemLuta[index]][0]]--;
		vidas[parDeLutas[ordemLuta[index]][1]]--;
		return lutadores[parDeLutas[ordemLuta[index]][0]]
				+ lutadores[parDeLutas[ordemLuta[index]][1]];
	}

	public int[] getDificuldadesCasas() {
		return dificuldadesCasas;
	}
	public String[] getNomeCavaleiros() {
		return nomeCavaleiro;
	}
	public String[] getNomeCasa() {
		return nomeCasa;
	}
	public String mensagem(int index, int[] ordemLuta){
		String str = new String(); 
		if(index==-1){		
				str = 
				"Lutadores: "+nomeCavaleiro[parDeLutas[ordemLuta[index]][0]]+" e "+nomeCavaleiro[parDeLutas[ordemLuta[index]][1]]
				+ "\nvidas dos Cavaleiros:\n"
				+nomeCavaleiro[0]+": "+vidas[0]+"\n"
				+nomeCavaleiro[1]+": "+vidas[1]+"\n"
				+nomeCavaleiro[2]+": "+vidas[2]+"\n"
				+nomeCavaleiro[3]+": "+vidas[3]+"\n"
				+nomeCavaleiro[4]+": "+vidas[4]
						;
		}
		else
		{
			str = "Casa de "+nomeCasa[index]+"\n"
					+ "Lutadores: "+nomeCavaleiro[parDeLutas[ordemLuta[index]][0]]+" e "+nomeCavaleiro[parDeLutas[ordemLuta[index]][1]]
					+ "\nvidas dos Cavaleiros:\n"
					+nomeCavaleiro[0]+": "+vidas[0]+"\n"
					+nomeCavaleiro[1]+": "+vidas[1]+"\n"
					+nomeCavaleiro[2]+": "+vidas[2]+"\n"
					+nomeCavaleiro[3]+": "+vidas[3]+"\n"
					+nomeCavaleiro[4]+": "+vidas[4]
							;
		}
		return str;
	}
}
