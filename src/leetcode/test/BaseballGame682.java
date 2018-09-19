package Leetcode;

public class BaseballGame682 {

	public static void main(String[] args) {
		String[] ops = new String[] { "-60", "D", "-36", "30", "13", "C", "C", "-33", "53", "79" };
		System.out.println(calPoints(ops));
	}

	public static int calPoints(String[] ops) {
		if (ops == null || ops.length < 1)
			return 0;
		int result = 0;
		Integer[] rebuild = new Integer[ops.length];
		for (int i = 0; i < ops.length; i++) {
			if ("C".equals(ops[i]) && i > 0) {
				findLastValidString(i, rebuild, "C");
				rebuild[i] = null;
			} else if ("+".equals(ops[i]) && i > 1) {
				rebuild[i] = findLastTwoValidString(i, rebuild);
			} else if ("D".equals(ops[i]) && i > 0) {
				rebuild[i] = 2 * findLastValidString(i, rebuild, null);
			} else {
				rebuild[i] = Integer.parseInt(ops[i]);
			}

		}
		for (int l = 0; l < rebuild.length; l++) {
			if (rebuild[l] != null) {
				result += rebuild[l];
			}
		}
		return result;

	}

	public static Integer findLastValidString(int i, Integer[] rebuild, String s) {
		for (; i >= 0; i--) {
			if (rebuild[i] != null) {
				if (s != null && "C".equals(s)) {
					rebuild[i] = null;
				}
				return rebuild[i];
			}
		}
		return rebuild[i];
	}

	public static Integer findLastTwoValidString(int i, Integer[] rebuild) {
		Integer[] tmp = new Integer[2];
		int j = 0;
		for (; i >= 0; i--) {
			if (rebuild[i] != null && j < 2) {
				tmp[j] = rebuild[i];
				j++;
				if (j == 2)
					return tmp[0] + tmp[1];
			}
		}
		return tmp[0] + tmp[1];
	}
}
