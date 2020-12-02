package sort2;

public class BubbleSort {
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	
	public BubbleSort(Integer[] toBeSorted, VisualizerFrame frame) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
	}
	
	public void run() {
		sort();
		SortingVisualizer.isSorting=false;
	}
	
	public void sort() {
		int temp = 0;
		boolean swapped = false;
		for(int i = 0; i<toBeSorted.length-1; i++){
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}
				frame.reDrawArray(toBeSorted, j, j+1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (!swapped) break;
		}
	}

}
