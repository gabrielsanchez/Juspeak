import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class Test {
	
	public static double random(double max, double min){
		return min + (Math.random() * ((max - min) + 1));	
	}
	
	public static double[] getFrequencies(SpearFile sf, int partial){
		return sf.getPartials().get(partial).getFrequencies();
	}
	
	public static void main(String[] args){
		
        Midi m = new Midi();
        String filename = "prueba6.mid";
       // m.setLyrics("La-", 3);
        //m.setTempo(120,0);
       //480 -> 240 -> 120 -> 60 -> 30 ->15
        m.startNote(60, 1, 1, 90);
        m.stopNote(60, 1, 480, 90);

        

        
     //   Track nt = m.createTrack();
     //   m.startNote(nt, 90, 1, 4, 120);
     //   m.stopNote(nt, 90, 1, 12, 120);
        
        m.saveFile(filename);

        
		/*
		SpearFile sf = in.importSpearFile("53241_Corsica_S_disco_bitch2.txt");
		
		//double [] newFreqs = getFrequencies(sf,0);
		
		//sf.getPartials().get(0).
		
		//System.out.println(sf.getPartials().get(0).getAverageFrequency());
					
		for (int i = 0; i < sf.getNumberOfPartials(); i ++){
			for (int j = 0; j < sf.getPartials().get(i).getNumberOfPoints(); j++){
				sf.getPartials().get(i).getPoints().get(j).setFrequency(sf.getPartials().get(i).getPoints().get(j).getFrequency()+random(0,1000));
			}
		}
		//in.exportSpearFile(sf, "partialsout.txt");
	}
	*/
		

	}
}