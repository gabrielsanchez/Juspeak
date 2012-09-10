import java.util.Iterator;

public class Test {
	
	public static void main(String[] args){
		
		IO in = new IO();
		SpearFile sf = in.importSpearFile("partials2.txt");
		
		//for(Partial p : sf.getPartials())
		//	System.out.println(p.getNumberOfPoints());
		
		/*
		for (int i = 0; i < sf.getNumberOfPartials(); i ++){
			System.out.println(sf.getPartials().get(0).getNumberOfPoints());
			for (int j = 0; j < sf.getPartials().get(i).getNumberOfPoints(); j++){
				System.out.println(sf.getPartials().get(i).getPoints().get(j).getTime());
			}
		}*/
		in.exportSpearFile(sf, "partialsout.txt");
	}

}