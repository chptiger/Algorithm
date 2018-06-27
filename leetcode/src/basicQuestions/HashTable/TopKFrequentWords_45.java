package basicQuestions.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions
the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words

Return
a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)

Examples
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d”]

 * @author xx65
 *
 */
public class TopKFrequentWords_45 {

	public static void main(String[] args) {
		String[] Composition = {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
		System.out.println(Arrays.toString(topKFrequentWords(Composition, 3)));
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
				(w1, w2) -> tmp.get(w1).equals(tmp.get(w2)) ? w1.compareTo(w2) : tmp.get(w2) - tmp.get(w1));

		return candidates.subList(0, k).toArray(new String[0]);
	}
}
