package service;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;


public class SimpleAudioPlayer {
	
	public static void play(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException{

		
		Clip clip = AudioSystem.getClip();
//         getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.
            getAudioInputStream( new File("src/resources/pegasusFantasy.wav") );
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // A GUI element to prevent the Clip's daemon Thread
                // from terminating at the end of the main()
//                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
		
	}
	
}
