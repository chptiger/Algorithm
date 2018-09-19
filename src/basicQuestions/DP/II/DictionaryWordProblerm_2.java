package basicQuestions.DP.II;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Description
	Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions
	The given word is not null and is not empty
	The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

Examples
	Dictionary: {“bob”, “cat”, “rob”}
	Word: “robob” return false
	Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/

public class DictionaryWordProblerm_2 {

	@Test
	public void test_dictWord() {
		String[] dict = { "bob", "cat", "rob" };
		Assert.assertEquals(false, canBreak("robob", dict));
		Assert.assertEquals(true, canBreak("robcatbob", dict));
	}

	private static boolean canBreak(String input, String[] dict) {

		boolean[] M = new boolean[input.length() + 1];

		Set<String> container = new HashSet<>();

		for (int i = 0; i < dict.length; i++) {
			container.add(dict[i]);
		}

		M[0] = container.contains(input.charAt(0)) ? true : false;

		for (int i = 1; i <= input.length(); i++) {
			if (container.contains(input.substring(0, i))) { // case 0: no cut, if contains the input, return true.
				M[i] = true;
				continue;
			}

			for (int j = 1; j < i; j++) {// other cases: cut from 1 to i
				if (M[j] && container.contains(input.substring(j, i))) {
					M[i] = true;
					break;
				}
			}
		}
		return M[input.length()];
	}
}
