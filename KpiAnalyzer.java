
public class KpiAnalyzer extends Analyzer{

	KpiAnalysis kpia;;
	
	public KpiAnalyzer() {
		kpia = new DropRateAnalysis();
	}
	
	public void performAnalysis() {
		kpia.analyze();
	}
	
}
