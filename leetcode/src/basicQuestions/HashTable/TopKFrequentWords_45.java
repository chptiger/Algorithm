package basicQuestions.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a composition with different kinds of words, return a list of the top K
 * most frequent words in the composition.
 * 
 * Assumptions the composition is not null and is not guaranteed to be sorted K
 * >= 1 and K could be larger than the number of distinct words in the
 * composition, in this case, just return all the distinct words
 * 
 * Return a list of words ordered from most frequent one to least frequent one
 * (the list could be of size K or smaller than K)
 * 
 * Examples Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"],
 * top 2 frequent words are [“b”, “c”] 
 * 
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], 
 * top 4 frequent words are [“b”, “c”, "a", "d"]
 * 
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], 
 * top 5 frequent words are [“b”, “c”, "a", "d”]
 * 
 * @author xx65
 *
 */
public class TopKFrequentWords_45 {

	public static void main(String[] args) {
		String[] Composition = { "a", "a", "b", "b", "b", "b", "c", "c", "c", "d" };
		// System.out.println(Arrays.toString(topKFrequentWords(Composition, 3)));
		System.out.println(Arrays.toString(topKFrequent(Composition, 3)));
	}

	public static String[] topKFrequent(String[] combo, int k) {
		if (combo.length == 0) {
			return new String[0];
		}

		Map<String, Integer> freqMap = new HashMap<>();
		for (String s : combo) {
			freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						if (e1.getValue() == e2.getValue()) {
							return 0;
						} else if (e1.getValue() > e2.getValue()) {
							return 1;
						} else {
							return -1;
						}
					}
				});

		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		return freqArray(minHeap);
	}

	private static String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] result = new String[minHeap.size()];
		for (int i = minHeap.size() - 1; i >= 0; i--) {
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}

	public static String[] topKFrequentWords(String[] Composition, int k) {
		if (Composition == null || Composition.length < k) {
			return new String[0];
		}

		Map<String, Integer> tmp = new HashMap<>();
		for (String word : Composition) {
			tmp.put(word, tmp.getOrDefault(word, 0) + 1);
		}

		List<String> candidates = new ArrayList(tmp.keySet());

		Collections.sort(candidates,
				(w1, w2) -> tmp.get(w1).equals(tmp.get(w2)) ? w1.compareTo(w2) : tmp.get(w2) - tmp.get(w1)); // O(N*log(N))

		return candidates.subList(0, k).toArray(new String[0]);
	}

}
