package Leetcode;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance690 {

	public static void main(String[] args) {
		Employee a = new Employee(1, 5, Arrays.asList(2, 3));
		Employee b = new Employee(2, 3, Arrays.asList(4));
		Employee c = new Employee(3, 4, Arrays.asList());
		Employee d = new Employee(4, 1, Arrays.asList());
		List<Employee> emps = Arrays.asList(a, b, c, d);
		System.out.println(getImportance(emps, 1));
	}

	public static int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> tmp = new HashMap();
		for (Employee e : employees) {
			tmp.put(e.id, e);
		}

		return getImportanceHelper(tmp, id);

	}

	public static int getImportanceHelper(Map<Integer, Employee> tmp, int id) {
		int result = tmp.get(id).importance;
		List<Integer> subs = tmp.get(id).subordinates;
		for (Integer s : subs) {
			result += getImportanceHelper(tmp, s);
		}
		return result;
	}

}

class Employee {
	int id;
	int importance;
	List<Integer> subordinates;

	public Employee(int id, int importance, List<Integer> subordinates) {
		super();
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
}
