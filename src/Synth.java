import sun.audio.AudioStream;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class Synth {

    /**
     * @param filename the .wav file containing sound to be played
     *
     */
    public void playSound(String filename){
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream((new File(filename).getAbsoluteFile())));
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Instrument set for Piano
     * */
    public String[] getPianoNotes(){
        String[] notes = new String[12];
        notes[0] = "piano/D3.wav";
        notes[1] = "piano/F3.wav";
        notes[2] = "piano/A3.wav";
        notes[3] = "piano/C4.wav";
        notes[4] = "piano/D4.wav";
        notes[5] = "piano/F4.wav";
        notes[6] = "piano/A4.wav";
        notes[7] = "piano/C5.wav";
        notes[8] = "piano/D5.wav";
        notes[9] = "piano/F5.wav";
        notes[10] = "piano/A5.wav";
        notes[11] = "piano/C6.wav";

        return notes;

    }
    /**
     * Instrument set for acousticDrum
     * */
    public String[] getDrumNotes(){
        String[] notes = new String[12];
        notes[0] = "drumAcoustic/BD.wav";
        notes[1] = "drumAcoustic/CB.wav";
        notes[2] = "drumAcoustic/CB3.wav";
        notes[3] = "drumAcoustic/CC.wav";
        notes[4] = "drumAcoustic/CHH.wav";
        notes[5] = "drumAcoustic/CS.wav";
        notes[6] = "drumAcoustic/F.wav";
        notes[7] = "drumAcoustic/FD2.wav";
        notes[8] = "drumAcoustic/KC.wav";
        notes[9] = "drumAcoustic/RM.wav";
        notes[10] = "drumAcoustic/SD.wav";
        notes[11] = "drumAcoustic/H.wav";



        return notes;
    }

}