package tuning;

import java.util.HashMap;
import java.util.Map;

//用查询表代替复杂表达式
public class TableLookup {
	private static Map<String, Integer> AnimalLegs = new HashMap<String, Integer>();
	static {
		AnimalLegs.put("dog", 4);
		AnimalLegs.put("chicken", 2);
		AnimalLegs.put("you", 4);
	}
	
	public static void main(String[] args) {
		String animal = "dog";
		//before
		if ("dog".equals(animal)) {
			System.out.println(4);
		} else if ("chicken".equals(animal)){
			System.out.println(2);
		} else if ("you".equals(animal)) {
			System.out.println(4);
		}
		
		//after
		System.out.println(AnimalLegs.get(animal));
	}
}
