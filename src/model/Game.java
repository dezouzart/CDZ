package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import service.SimpleAudioPlayer;
import service.SmartBusca;
import view.MapaView;
import service.Sorts;
public class Game {
	
	Batalha batalhas;
	MapaView mapa;
	SmartBusca estrela;
	Sorts sorts;
	Seiya seiya;
	ArrayList <Casa> casas;
	Casa destino;
	ArrayList <String> caminhoCompleto = new ArrayList<String>();
	String nomeCasa[];
	String nomeCavaleiros[];
	int ordemNovaLutas[];
	float[] poder;
	int[] dificuldadesCasas;
	float custoCasa;
	
	public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		try {
			Long start = System.currentTimeMillis();
			Long endTime;
			Long totalTime;
			mapa = new MapaView("Cavaleiros do Zodiaco");
			estrela = new SmartBusca(mapa.getMapaModel());
			batalhas = new Batalha();
			sorts = new Sorts();
			
			dificuldadesCasas = batalhas.getDificuldadesCasas();
			nomeCasa = batalhas.getNomeCasa();
			nomeCavaleiros = batalhas.getNomeCavaleiros();
			poder = batalhas.getPoder();
			seiya = mapa.getSeiya();
			casas = mapa.getMapaModel().getCasas();
			
			sorts.setNomeCavaleiros(nomeCavaleiros);
			poder = sorts.sortPoderCosmico(poder);
			
			ordemNovaLutas = sorts.sortDificuldadeCasas(batalhas.dificuldadesCasas);
	
			
			
			SimpleAudioPlayer.play("src/resources/pegasusFantasy.wav");

			for(int i=0; i<casas.size(); i++){
				destino = escolheDestino();
				
				estrela.aEstrela(seiya.getX(), seiya.getY(), destino.getX(), destino.getY(), destino);
				endTime = System.currentTimeMillis();
				totalTime = (endTime - start);
				if (i == 0){
					System.out.println("=================");
					System.out.println("TEMPO: " + totalTime.toString());
					System.out.println("=================");
				}
				mapa.animacao(estrela.caminho);
				destino.setDificuldade(batalhas.dificuldadesCasas[i]);
				System.out.println("Dificuldade da casa = "+ batalhas.dificuldadesCasas[i]);
				//entrar batalha
				custoCasa = batalhas.batalhaCasa(i, poder, ordemNovaLutas);
				//JOptionPane.showMessageDialog(null, batalhas.mensagem(i, ordemNovaLutas));
				System.out.println(batalhas.mensagem(i, ordemNovaLutas));
				mapa.custoTotalMaisCasas(custoCasa);
				System.out.println("Custo da casa = " + custoCasa);
				System.out.println("----------//----------//----------");
				System.out.printf("\n");
				estrela.resetarCaminho();
				destino.setVisitado(true);
				
			}
			estrela.aEstrela(seiya.getX(), seiya.getY(), 37, 4, null);//ir para destino dps das 12 casas
			mapa.animacao(estrela.caminho);
			JOptionPane.showMessageDialog(null, "Athenas salva em: "+ mapa.getCustoTotal() + " minutos.");
			estrela.resetarCaminho();
			System.out.printf("Athenas salva em: "+ mapa.getCustoTotal() + " minutos.");
			System.out.println("\nFIM");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Casa escolheDestino() {
		Casa destino = null;
		boolean primeiraVez = true;
		
		for (Casa item : casas) {
			if(item.isVisitado() == false){
				estrela.aEstrela(seiya.getX(), seiya.getY(), item.getX(), item.getY(), item);
			
				if(primeiraVez == true){
					destino = item;
				}else{
					if(destino.getCusto() > item.getCusto()){
						destino = item;
					}
				}	
				estrela.resetarCaminho();
				primeiraVez = false;
			}
		}
		
		return destino;
		
	}
	
	public void concatArray(ArrayList <String> array1, ArrayList <String> array2){
		for (String item : array2) {
		    array1.add(item);
		}
	}
	
}
