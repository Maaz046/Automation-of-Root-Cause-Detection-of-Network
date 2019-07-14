import java.io.FileReader;
import java.util.ArrayList;

public class DropRateAnalysis implements KpiAnalysis{
	
	MyReader fr;
	ArrayList<String[]> al = new ArrayList<>();
	ArrayList<String[]> probCell = new ArrayList<>();
	
	public DropRateAnalysis() {
		fr = new MyReader();
		al = fr.read("CellHourly", 72);
	}
	
	@Override
	public void analyze() {
		String s = "has high TCH Drop Rate due to downtime\n";
		StringBuilder sb = new StringBuilder(s);
		for(int i=1 ; i<al.size() ; i++) {
			double dropRate = Double.parseDouble(al.get(i)[5]);
			double dT = Double.parseDouble(al.get(i)[4]);
			double dropCount = Double.parseDouble(al.get(i)[6]);
			if(dropRate>3 && dT>0 && dropCount>10) {
				System.out.println(al.get(i)[3]+ " " + s + String.format("%20s %-45s", " ", "at "+al.get(i)[2])+"\n");
			}
			
			else if (dropRate>3 && dT==0 && dropCount>10) {
				String ss = "has high TCH drop rate";
				Double[] dropPerc = {Double.parseDouble(al.get(i)[11])*100/dropCount,Double.parseDouble(al.get(i)[12])*100/dropCount,Double.parseDouble(al.get(i)[13])*100/dropCount,Double.parseDouble(al.get(i)[14])*100/dropCount};
				int pos = checkHighestDrops(dropPerc);
				System.out.println(al.get(i)[3] + " " + al.get(0)[pos] + " detected to be elevated \n" + String.format("%20s %-45s", " ", "at "+ al.get(i)[2])+"\n");
			}
		}
	}
	
	public int checkHighestDrops(Double[] dropsArray) {
		int pos=11; //11  is the column where drop types start (11-14)
		double max=0;
		for(int i=0 ; i<dropsArray.length-1 ; i++) {
			if(dropsArray[i]>max) {
				max = dropsArray[i];
				pos += i;
			}
		}
		return pos;
	}
}
