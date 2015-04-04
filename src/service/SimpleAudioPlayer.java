package service;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SimpleAudioPlayer {
	
	public static void play(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

	    File soundFile = new File(name);
		//File soundFile = new File("src/resources/pegasusFantasy.wav");
		final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( soundFile );
		final Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.loop(-1);
		clip.start();
		
	}
	
}
