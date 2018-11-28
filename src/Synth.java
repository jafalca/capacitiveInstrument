

import java.io.File;
import javax.sound.sampled.*;

/**
 * @author Javier Falca
 * This class is made to be used as a note synthesizer
 * It holds logic to play the note and has a handful number of note sequences
 */
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
        System.out.println("Now playing: piano...");
        String[] notes = new String[10];
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

        return notes;
    }
    /**
     * Instrument set for acousticDrum
     * */
    public String[] getDrumNotes(){
        System.out.println("Now playing: drums...");
        String[] notes = new String[10];
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
        return notes;
    }

    /**
     * Instrument set for seven nation army
     */
    public String[] getSeven(){
        System.out.println("Now playing: Seven Nation Army...");
        String[] notes = new String[10];
        notes[0] = "sevenn/7WS1.wav";
        notes[1] = "sevenn/7WS2.wav";
        notes[2] = "sevenn/7WS0.wav";
        notes[3] = "sevenn/7WS3.wav";
        notes[4] = "sevenn/7WS4.wav";
        notes[5] = "sevenn/7WS5.wav";
        notes[6] = "sevenn/7WSD1.wav";
        notes[7] = "sevenn/7WSD2.wav";
        notes[8] = "sevenn/7WSD3.wav";
        notes[9] = "sevenn/7WSD3.wav";
        return notes;
    }

    /**
     * Intstrument set for daft punk part 1
     */
    public String[] daftPunk1(){
        System.out.println("Now playing: Daft Punk part 1...");
        String[] notes = new String[10];
        notes[0] = "HBFS1/1.wav";
        notes[1] = "HBFS1/2.wav";
        notes[2] = "HBFS1/3.wav";
        notes[3] = "HBFS1/4.wav";
        notes[4] = "DFA/Daft Punk/DPB1.wav";
        notes[5] = "DFA/Daft Punk/DPB2.wav";
        notes[6] = "DFA/Daft Punk/DPB3.wav";
        notes[7] = "DFA/Daft Punk/DPB4.wav";
        notes[8] = "DFA/Daft Punk/DPB5.wav";
        notes[9] = "DFA/Daft Punk/DPB5.wav";
        return notes;
    }

    /**
     * Instrument set for daft punk part 2
     */
    public String[] daftPunk2(){
        System.out.println("Now playing: Daft Punk part 2...");
        String[] notes = new String[10];
        notes[0] = "HBFS2/1.wav";
        notes[1] = "HBFS2/2.wav";
        notes[2] = "HBFS2/3.wav";
        notes[3] = "HBFS2/4.wav";
        notes[4] = "HBFS2/5.wav";
        notes[5] = "HBFS2/6.wav";
        notes[6] = "HBFS2/7.wav";
        notes[7] = "HBFS2/8.wav";
        notes[8] = "DFA/Daft Punk/DPBB1.wav";
        notes[9] = "DFA/Daft Punk/DPBB2.wav";
        return notes;
    }

}