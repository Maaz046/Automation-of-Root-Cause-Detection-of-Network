import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MyReader {
	
	public ArrayList<String[]> read(String fN, int nCells) {
//		int nCol = 11;
//		int nRow = nCells*24;
		ArrayList<String[]> arrrayLst = new ArrayList<>();
		try {
			FileReader fr = new FileReader(fN+".csv");
			Scanner scan = new Scanner(fr);
			while(scan.hasNext()) {
				String s = scan.nextLine();
				String[] store = s.split(",");
				arrrayLst.add(store);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrrayLst;
	}
}
