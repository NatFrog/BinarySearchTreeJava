package assign08;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import assign05.TimerTemplate;

public class BinarySearchTreeTimer extends TimerTemplate {
	Random rng;
	BinarySearchTree<Integer> sorted;
	BinarySearchTree<Integer> random;
	List<Integer> permuted;
	TreeSet<Integer> balanced;
	BinarySearchTree<Integer> unBalanced;
	private final static int TIMES_TO_LOOP = 1000;
	private final static int NSTART = 1000;
	private final static int NINCREMENT = 1000;
	private final static int NSTEPS = 14;

	public BinarySearchTreeTimer(int[] problemSizes, int timesToLoop) {
		super(problemSizes, timesToLoop);
		rng = new Random(33);
		permuted = new ArrayList<Integer>();
		sorted = new BinarySearchTree<Integer>();
		random = new BinarySearchTree<Integer>();

		balanced = new TreeSet<Integer>();
		unBalanced = new BinarySearchTree<Integer>();
	}

	protected void setup(int n) {
		// needed for #3.1
		for (int i = 0; i < n; i++) {
			sorted.add(i);
			permuted.add(i);
		}

		Collections.shuffle(permuted);

		for (int i = 0; i < n; i++) {
			random.add(permuted.get(i));
		}

		// needed for #4.2, 4.4
		for (int i = 0; i < n; i++) {
			balanced.add(permuted.get(i));    //comment out for add
			unBalanced.add(permuted.get(i));
		}
	}

	protected void timingIteration(int n) {
		// #3.1
//		for (int i = 0; i < n; i++) {
//			sorted.contains(i);
//		}

//		// #3.2
		for (int i = 0; i < n; i++) {
			
			random.contains(i);
		}
//
//		// #4.1
//		for (int i = 0; i < n; i++) {
//			balanced.add(permuted.get(i));
//		}
//
////		// #4.2
//		for (int i = 0; i < n; i++) {
//			// how would you perform this multiple times & record avg run time?
//			balanced.contains(i);
//		}
//
//		// #4.3
//		for (int i = 0; i < n; i++) {
//			unBalanced.add(permuted.get(i));
//		}
//
		// #4.4
//		for (int i = 0; i < n; i++) {
//			unBalanced.contains(i);
//		}

	}

	protected void compensationIteration(int n) {
		
	}

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("00000E00");

		System.out.println("\nN\t|  T(N)/1\tT(N)/logN/N\tT(N)/N\t\tT(N)/N^2");
		System.out.println("-----------------------------------------------------------------------------------");

		int[] problemSizes = new int[NSTEPS];
		problemSizes[0] = NSTART;
		for (int i = 1; i < NSTEPS; i++)
			problemSizes[i] = problemSizes[i - 1] + NINCREMENT;

		BinarySearchTreeTimer checker = new BinarySearchTreeTimer(problemSizes, TIMES_TO_LOOP);
		var results = checker.run();

		for (var result : results) {
			int N = result.n();
			double time = result.avgNanoSecs();
			System.out.print(N + "\t|  ");

			System.out.println(formatter.format(time) + "\t" + formatter.format(time / (Math.log10(N)/Math.log10(2)/N))
					+ "\t" + formatter.format(time / N) + "\t" + formatter.format((time / N) / N));
		}

//		int timesToLoop = 1000;
//		int problemSizes[] = //{500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500, 9000, 9500, 10000};
//			{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000};
//		//	{ 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 
//			//	100000, 110000, 120000, 130000, 140000, 150000, 160000, 170000, 180000, 190000, 200000};
//		//{10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000, 55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000, 100000};
//		BinarySearchTreeTimer timer = new BinarySearchTreeTimer(problemSizes, timesToLoop);
//
//		var results = timer.run();
//		System.out.println("n, time");
//		for (var result : results) {
//			System.out.println(result.avgNanoSecs());
//		}
	}
// 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000, 16000, 17000, 18000, 19000, 20000
// 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 110000, 120000, 130000, 140000, 150000, 160000, 170000, 180000, 190000	}

}

