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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

/**
 * IO.java
 * Purpose: Input/Output Methods.
 *
 * @author Gabriel Sanchez
 * @version 1.0
 */
public class IO{
	
	/**
	 * Imports the data contained in a text file
	 * and converts it into an object. 
	 * 
	 * @param 	name		name of the .txt file.
	 * @return 	SpearFile	returns a SpearFile Object.
	 */
	public SpearFile importSpearFile(String name){
		
		SpearFile s = new SpearFile();
		
		try{
			
			Scanner in = new Scanner(new FileReader(name));
			in.nextLine();
			in.nextLine();
			in.next();
			int npartials = in.nextInt();
			s.setNumberOfPartials(npartials);
			in.next();
			in.nextLine();
			
			for(int i = 0; i < npartials; i++){	
				
				int partial = in.nextInt();
				int npoints = in.nextInt();
				double start = Double.parseDouble(in.next());
				double end = Double.parseDouble(in.next());
				
				Partial p = new Partial(partial, npoints, start, end);

				for(int j = 0; j < npoints; j++){
					double time = Double.parseDouble(in.next());
					double frequency = Double.parseDouble(in.next());
					double amplitude = Double.parseDouble(in.next());
					
					Point point = new Point(time, frequency, amplitude);
					p.addPoint(point);
					
				}
				
				s.addPartial(p);
			}
		
		}catch(FileNotFoundException e){
			System.out.println("error! :'( no such file!");
			e.printStackTrace();
		}
	
		return s;
	}
	
	/**
	 * Exports the data contained in a SpearFile Object
	 * and converts it into text file.
	 * 
	 * @param 	sf			SpearFile object to output.
	 * @param	output		Name of the output
	 */
	public void exportSpearFile(SpearFile sf, String output){
		try{
			Locale l = Locale.US;
			
			BufferedWriter out = new BufferedWriter(new FileWriter(output));

			out.write("par-text-partials-format");
			out.newLine();
			out.write("point-type time frequency amplitude");
			out.newLine();
			out.write("partials-count " + sf.getNumberOfPartials());
			out.newLine();
			out.write("partials-data");
			out.newLine();
			
			for(int i = 0; i < sf.getNumberOfPartials(); i++){

				out.write(sf.getPartials().get(i).getPartial() + " ");
				out.write(sf.getPartials().get(i).getNumberOfPoints() + " ");
				out.write(String.format(l,"%.6f ",sf.getPartials().get(i).getStart()));
				out.write(String.format(l,"%.6f",sf.getPartials().get(i).getEnd()));
				out.newLine();
	
				for(int j = 0; j < sf.getPartials().get(i).getNumberOfPoints(); j++){

					out.write(String.format(l,"%.6f ",sf.getPartials().get(i).getPoints().get(j).getTime()));
					out.write(String.format(l,"%.6f ",sf.getPartials().get(i).getPoints().get(j).getFrequency()));
			
					if(j == sf.getPartials().get(i).getNumberOfPoints()-1)
						out.write(String.format(l,"%.6f",sf.getPartials().get(i).getPoints().get(j).getAmplitude()));
					else
						out.write(String.format(l,"%.6f ",sf.getPartials().get(i).getPoints().get(j).getAmplitude()));
				}
				
				out.newLine();
			}
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void saveMidiFile(Sequence sequence, String filename){
  	  
    	int[] allowedTypes = MidiSystem.getMidiFileTypes(sequence);
        if (allowedTypes.length == 0) {
            System.err.println("Midi Output Error");
        }
        else {
            try {
				MidiSystem.write(sequence, allowedTypes[0], new File(filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
            System.exit(0);
        } 	  
    }
	
}