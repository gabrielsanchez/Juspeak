import java.io.*;
import java.util.*;

public class SpearRW {

	public static void main(String[] args) throws IOException {
		
		String partials;
		int npartials;
		String points;
		int npoints;
		double partialStart;
		double partialEnd;
		double time;
		double frequency;
		double amplitude;
		
		/*********************IO*********************/
		Scanner in = new Scanner(new FileReader("cat1-partials.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
		/*********************IO*********************/
		                   
		/*******************Header*******************/
		out.write(in.nextLine()); out.newLine();
		out.write(in.nextLine()); out.newLine();
		out.write(in.next() + " ");
		partials = in.next();
		out.write(partials);
		out.write(in.nextLine()); out.newLine();
		out.write(in.nextLine()); out.newLine();
		/*******************Header*******************/
		
		npartials = Integer.parseInt(partials);
		
		for(int i = 0; i<npartials; i++){
			out.write(in.next() + " ");
			points = in.next();
			out.write(points + " ");
			out.write(in.next() + " ");
			out.write(in.next()); out.newLine();
			npoints = Integer.parseInt(points);
			
			for(int j = 0; j<npoints; j++){
				time = Double.parseDouble(in.next());
				frequency = Double.parseDouble(in.next());
				amplitude = Double.parseDouble(in.next());
				out.write(time + " ");
				out.write(frequency + " ");
				out.write(amplitude + " ");
				
			}
			
		}
		
		out.close();
	
	}

}
