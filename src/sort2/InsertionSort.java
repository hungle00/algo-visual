package sort2;

public class InsertionSort{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;

	public InsertionSort(Integer[] toBeSorted, VisualizerFrame frame) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
	}
	
	public void run() {
		sort();
		SortingVisualizer.isSorting=false;
	}
	
	public void sort() {
		int temp = 0;
		int insert = 0;
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0){
						break;
					}
				}else{
					break;
				}
				frame.reDrawArray(toBeSorted, i, insert);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--){
				toBeSorted[j] = toBeSorted[j-1];
			}
			toBeSorted[insert] = temp;
		}
		frame.reDrawArray(toBeSorted);
	}
}
