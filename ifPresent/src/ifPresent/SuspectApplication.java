package ifPresent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuspectApplication {

	private static ArrayList<SuspectLocation> susLoc = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		
		SuspectApplication susApp = new SuspectApplication();
		
		susApp.readFile("InterpolWatchReport-Week1.csv");
		susApp.readSuspects();
	}
	public void readFile(String file) throws IOException, FileNotFoundException, NullPointerException{
		BufferedReader fr = null;
		
		try {
			fr = new BufferedReader(new FileReader(file));
			
			String line;
			String[] lines;
			
			@SuppressWarnings("unused")
			String hl = fr.readLine();
			
			while ((line = fr.readLine()) != null) {
				lines = line.split(",");
				SuspectLocation suspectLocation = new SuspectLocation(lines[0], lines[1]);
				susLoc.add(suspectLocation);
			}
		} finally {
			if(fr != null) {
			fr.close();
			}
		}
		
	}
	
	public void readSuspects() {

		susLoc.stream()
			.filter(s -> s != null)
			  .filter(suspect -> suspect.getName().equalsIgnoreCase("CARMEN SANDIEGO"))
			  .map(suspect -> suspect.getCountry())
			  .forEach(country -> System.out.println("Carmen Sandiego is in " + country));
			  
		
	}
}
