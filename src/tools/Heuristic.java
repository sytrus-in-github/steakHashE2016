package tools;

import java.util.*;

/* this is sort of a natural selection to the algorithms 
 * to use this class, define a new type of algorithm extending the class Algorithm
 * and create a subclass of Heuristic implementing the methods mutate, birthRate and deathRate.
 * To execute the program, call initialise first and then use evolve.
 */
public abstract class Heuristic {
	public List<Algorithm> algoPool = null;
	public int poolLimit = 0;
	public int getPopulation() {
		return algoPool.size();
	}

	public Algorithm bestAlgo = null;
	public float bestScore = 0f;

	protected Random random = new Random();

	private Comparator<Algorithm> algoComparator = new Comparator<Algorithm>(){
		@Override
		public int compare(Algorithm a1, Algorithm a2) {
			if (a1.score - a2.score > 0) {
				return -1;
			} else if (a1.score - a2.score == 0) {
				return 0;
			} else {
				return 1;
			}
		}
	};
	
	Heuristic() {}
	public Heuristic(int poolLimit) {
		this.poolLimit = poolLimit;
	}

	//the order of natural selection is: give birth - newborns mutate - be selected(death) - over again
	public abstract Algorithm mutate(Algorithm algo);

	public abstract float[] birthRate(float score, int rank); //birthRate[i] = chance to have > i children.

	public abstract float deathRate(float score, int rank);

	public void initialise(Collection<Algorithm> initialAlgos) {
		algoPool = new ArrayList<Algorithm>();
		for (Algorithm algo:initialAlgos) {
			algo.run();
			algoPool.add(algo);
		}
		algoPool.sort(algoComparator);
		calculateRanks();
	}

	public void evolve(int generation) {
		float r;
		for (int t=1; t<=generation; t++) {
			ArrayList<Algorithm> newBirth = new ArrayList<Algorithm>();
			ArrayList<Algorithm> survivors = new ArrayList<Algorithm>();
			for (Algorithm algo:algoPool) {
				r = random.nextFloat();
				float[] chance = birthRate(algo.score, algo.rank);
				int i = 0;
				while (i<chance.length && r<chance[i]) {
					i++;
				}
				for (int j=0; j<i; j++) {
					Algorithm child = mutate(algo);
					child.run();
					newBirth.add(child);
				}
			}
			algoPool.addAll(newBirth);
			algoPool.sort(algoComparator);
			calculateRanks();
			
			Algorithm first = algoPool.get(0);
			if (first.score > bestScore) {
				bestAlgo = first;
				bestScore = first.score;
			}

			int survivorCount = 0;
			for (Algorithm algo:algoPool) {
				r = random.nextFloat();
				if (r>deathRate(algo.score, algo.rank)) {
					survivorCount++;
					if (survivorCount <= poolLimit) {
						survivors.add(algo);
					}
				}
			}
			algoPool = survivors;
			calculateRanks();
		}
	}

	private void calculateRanks() {
		int rank = 1;
		for (Algorithm algo:algoPool) {
			algo.rank = rank;
			rank++;
		}
	}


}

