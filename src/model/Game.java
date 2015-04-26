package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import service.SimpleAudioPlayer;
import service.SmartBusca;
import view.MapaView;

public class Game {
	
	MapaView mapa;
	SmartBusca estrela;
	Seiya seiya;
	ArrayList <Casa> casas;
	Casa destino;
	ArrayList <String> caminhoCompleto = new ArrayList<String>();
	
	public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		try {
			
			mapa = new MapaView("Cavaleiros do Zodiaco");
			estrela = new SmartBusca(mapa.getMapaModel());
			seiya = mapa.getSeiya();
			casas = mapa.getMapaModel().getCasas();
			SimpleAudioPlayer.play("src/resources/pegasusFantasy.wav");
			for(int i=0; i<casas.size(); i++){
				destino = escolheDestino();
				
				estrela.aEstrela(seiya.getX(), seiya.getY(), destino.getX(), destino.getY(), destino);
				mapa.animacao(estrela.caminho);
				
				estrela.resetarCaminho();
				destino.setVisitado(true);
				
			}
			estrela.aEstrela(seiya.getX(), seiya.getY(), 37, 4, null);//ir para destino dps das 12 casas
			mapa.animacao(estrela.caminho);
			estrela.resetarCaminho();
			
			
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
