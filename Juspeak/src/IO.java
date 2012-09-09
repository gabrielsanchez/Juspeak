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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
			
			BufferedWriter out = new BufferedWriter(new FileWriter(output));
			
			for(int i = 0; i < sf.getNumberOfPartials(); i++){
				
				sf.getPartials().get(i).getPartial();
				sf.getPartials().get(i).getNumberOfPoints();
				sf.getPartials().get(i).getStart();
				sf.getPartials().get(i).getEnd();
				
				for(int j = 0; j < sf.getPartials().get(i).getNumberOfPoints(); j++){
					
					sf.getPartials().get(i).getPoints().get(j).getTime();
					sf.getPartials().get(i).getPoints().get(j).getFrequency();
					sf.getPartials().get(i).getPoints().get(j).getAmplitude();
					
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		//System.out.format("%.6f%n", Double.parseDouble(in.next()));

	}
	
}