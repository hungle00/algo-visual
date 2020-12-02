package sort2;

import java.util.ArrayList;
import java.util.Collections;


public class SortingVisualizer {

	public static VisualizerFrame frame;
	public static Integer[] toBeSorted;
	public static boolean isSorting = false;
	public static int sortDataCount = 50;
	public static int sleep = 20;
	public static int blockWidth;
	// Stepped depicts whether the values are incremental or random. True is incremental.
	public static boolean stepped = false;
	
	public static void main(String[] args) {
		frame = new VisualizerFrame();
		resetArray();
		frame.setLocationRelativeTo(null);
		startSort();
	}
	
	public static void resetArray(){
		// If we are currently in a sorting method, then isSorting should be true
		// We do not want to reinitialize/reset the array mid sort.
		if (isSorting) return;
		toBeSorted = new Integer[sortDataCount];
		blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
		for(int i = 0; i< toBeSorted.length; i++){
			toBeSorted[i] = (int) (sortDataCount * Math.random());
		}
		// If we're using incremental values, they are already sorted. This shuffles it.
		if (stepped) {
			ArrayList<Integer> shuffleThis = new ArrayList<>();
			for (int i = 0; i < toBeSorted.length; i++) {
				shuffleThis.add(toBeSorted[i]);
			}
			Collections.shuffle(shuffleThis);
			toBeSorted = shuffleThis.toArray(toBeSorted);
		}
		frame.preDrawArray(toBeSorted);
	}

 	public static void startSort() {
		BubbleSort sort = new BubbleSort(toBeSorted, frame);
		sort.run();
	}
}
