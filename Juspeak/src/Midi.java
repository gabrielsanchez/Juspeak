/*
 *  This file is part of Juspeak.
 *
 *  Juspeak is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Juspeak is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Juspeak.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * Midi.java
 * Purpose: Midi Methods.
 *
 * @author Gabriel Sanchez
 * @version 1.0
 */
public class Midi {

	public Track track;
    public Sequencer sequencer;
    public Sequence sequence;

    /**
     * Constructor
     */
    public Midi() {
    	try {
    		sequencer = MidiSystem.getSequencer();
    		sequencer.open();
        } catch (MidiUnavailableException e) {
        	e.printStackTrace();
        }
        sequence = createSequence(8);
        track = sequence.createTrack();
        startSequencer();
    }

    /**
     * Start the Sequencer
     */
    public void startSequencer() {
    	try {
    		sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
        	e.printStackTrace();
        }
        sequencer.setTempoInBPM(60);
        sequencer.start();
    }

    /**
     * Create a sequence
     * @param ppq
     * @return
     */
    public Sequence createSequence(int ppq){
    	//int ppq = 8;
    	try{
			Sequence s = new Sequence(Sequence.PPQ, ppq);
			return s;
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return null;
    }

    /**
     * Create a track
     * @param seq
     * @return t
     */
    public Track createTrack(Sequence seq){
    	Track t = seq.createTrack();
    	return t;
    }
    
    /**
     * Create a track
     * @return t
     */
    public Track createTrack(){
    	Track t = sequence.createTrack();
    	return t;
    }
    
/*    
    public void createTrack() {
        try {
          sequence = new Sequence(Sequence.PPQ, 8);
        } catch (InvalidMidiDataException e) {
          e.printStackTrace();
        }
        track = sequence.createTrack();
    }
*/
    /**
     * Send a Start Note Message
     * @param tr
     * @param note
     * @param ch
     * @param tick
     * @param vel
     */
    public void startNote(Track tr, int note, int ch, int tick, int vel) {
    	  addShortMessage(tr, ShortMessage.NOTE_ON, note, ch, tick, vel);
    }

    /**
     * Send a Stop Note Message
     * @param tr
     * @param note
     * @param ch
     * @param tick
     * @param vel
     */
    public void stopNote(Track tr, int note, int ch, int tick, int vel) {
    	  addShortMessage(tr, ShortMessage.NOTE_OFF, note, ch, tick, vel);
    }

    /**
     * Send a Start Note Message
     * @param note
     * @param ch
     * @param tick
     * @param vel
     */
    public void startNote(int note, int ch, int tick, int vel) {
    	  addShortMessage(ShortMessage.NOTE_ON, note, ch, tick, vel);
    }

    /**
     * Send a Stop Note Message
     * @param note
     * @param ch
     * @param tick
     * @param vel
     */
    public void stopNote(int note, int ch, int tick, int vel) {
    	  addShortMessage(ShortMessage.NOTE_OFF, note, ch, tick, vel);
    }
    
    /**
     * Add a Short Message to a track
     * @param tr
     * @param onOrOff
     * @param ch
     * @param note
     * @param tick
     * @param vel
     */
    public void addShortMessage(Track tr, int onOrOff, int ch, int note, int tick, int vel) {
    	ShortMessage message = new ShortMessage();
        try {
        	message.setMessage(onOrOff, ch, note, vel);
        	MidiEvent event = new MidiEvent(message, tick);
        	tr.add(event);
        } catch (InvalidMidiDataException e) {
        	e.printStackTrace();
        }
    }
    
    /**
     * Add a Short Message to a track
     * @param onOrOff
     * @param ch
     * @param note
     * @param tick
     * @param vel
     */
    public void addShortMessage(int onOrOff, int note, int ch, int tick, int vel) {
    	ShortMessage message = new ShortMessage();
        try {
        	message.setMessage(onOrOff, ch, note, vel);
        	MidiEvent event = new MidiEvent(message, tick);
        	track.add(event);
        } catch (InvalidMidiDataException e) {
        	e.printStackTrace();
        }
    }
      
    
    /**
     * Add keys with respective durations.
     * @param key
     * @param dur
     */
    public void Add(int[]key, int[]dur){
    	  int k;
      		int d;
      	int i = 0;
      	
      	for(int x = 0; x < key.length; x++){
      		
      		k = key[x];
      		d = dur[x];	
      		
      		if(k==-1){
      			i = i+d;
      		
      		}else{
      		
      			//startNote(k, i, 11, 0);
        	  	//stopNote(k, i+d,11, 0);
        	  		i = i+d;
      		
      		}
      	}	
      }
      
      
      
    /**
     * Converts a String to a Byte Array
     * @param str
     * @return bA
     */
    public byte [] stringToByteArray(String str){

    	byte [] bA = new byte [str.length()];
    	byte bV;
    	for(int k = 0; k < str.length(); k++){
    		char c = str.charAt(k);
        	//Mac extended Ascii:    
			switch(c){ 
				case '‡': bV = (byte) 135; break;
				case 'Ž': bV = (byte) 142; break;
				case '’': bV = (byte) 146; break;
				case '—': bV = (byte) 151; break;
				case 'œ': bV = (byte) 156; break;
				case '–': bV = (byte) 150; break;
				case 'ç': bV = (byte) 231; break;
				case 'ƒ': bV = (byte) 131; break;
				case 'ê': bV = (byte) 234; break;
				case 'î': bV = (byte) 238; break;
				case 'ò': bV = (byte) 242; break;
				case '„': bV = (byte) 132; break;
	
			    default: bV = (byte) c;
				}
				bA[k] = bV;
    	}    	    
    	return bA;    	  
    }
      
    /**
     * Set the text at the specified position.
     * @param s
     * @param position
     */
    public void setText(String s, int position){
    	byte [] m = stringToByteArray(s);
    	metaMessage((byte)0x01,m, position);
    }
      
    /**
     * Sets lyrics at the specified position.
     * @param s
     * @param position
     */
    public void setLyrics(String s, int position){
    	byte [] m = stringToByteArray(s);
    	metaMessage((byte)0x05,m, position);
    }
      
    /**
     * Sets a Marker at the specified position.
     * @param s
     * @param position
     */
    public void setMarker(String s, int position){
    	byte [] m = stringToByteArray(s);
  	  	metaMessage((byte)0x06,m, position);
  	}
      
    /**
     * Sets a Cue Point at the specified position.
     * @param s
     * @param position
     */
    public void setCuePoint(String s, int position){
    	byte [] m = stringToByteArray(s);
    	metaMessage((byte)0x07,m, position);
    }
      
    /**
     * Sets tempo at the specified position. (DEBUG)
     * @param BPM
     * @param position
     */
    public void setTempo(int BPM, int position){
    	int ms = 60000000/BPM;
    	String hx = Integer.toHexString(ms);
    	//  Byte.decode(hx);
    	Byte.parseByte(hx, 8);
    	
    	System.out.println(ms);
    	// metaMessage((byte)0x07,m, position);
    }
      
    /**
     * Adds a Meta Message to the track.
     * @param type
     * @param m
     * @param pos
     */
    public void metaMessage(byte type, byte[] m, int pos) {
		MetaMessage message = new MetaMessage();	  
		try {
			message.setMessage(type, m, m.length);
		    MidiEvent event = new MidiEvent(message, pos);
		    track.add(event);
			  
		} catch (InvalidMidiDataException e) {
		    e.printStackTrace();
		}
	}



    /**
     * Saves a file with the given filename.  
     * @param filename
     */
    public void saveFile(String filename){
    	startSequencer();
        try {
			MidiSystem.write(sequence, MidiSystem.getMidiFileTypes(sequence)[0], new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
