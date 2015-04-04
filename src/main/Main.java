package main;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import view.MapaView;
import service.SimpleAudioPlayer;

public class Main {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		try {
			MapaView mapa = new MapaView("Cavaleiros do Zodiaco");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleAudioPlayer.play("src/resources/pegasusFantasy.wav");
	}

}
