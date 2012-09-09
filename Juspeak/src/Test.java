public class Test {
	
	public static void main(String[] args){
		
		IO in = new IO();
		SpearFile sf = in.importSpearFile("partials.txt");
		
		for(int i = 0; i<sf.getNumberOfPartials(); i++)
			System.out.println(sf.getPartials().get(i).getStart());
	}

}