import java.util.ArrayList;

public class Processor {

	Analyzer an;
	ArrayList<String[]> al;
	ArrayList<String[]> probCell = new ArrayList<>();

	public Processor() {
		an = new KpiAnalyzer();
	}


	public void initiateAnalysis() {
		an.performAnalysis();
	}
}
