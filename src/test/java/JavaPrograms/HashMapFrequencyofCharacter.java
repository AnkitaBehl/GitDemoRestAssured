package JavaPrograms;

import java.util.HashMap;

public class HashMapFrequencyofCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input ="qaqaqahjhjtytyrere";
		char[] strArray = input.toCharArray();
		 HashMap<Character,Integer> map= new HashMap<>();
		 for(char c:strArray)
		 {
			 if(map.containsKey(c))
			 {
				map.put(c, map.get(c)+1) ;
			 }
			 else
			  {
				map.put(c, 1); 
			 }
		 }
		 System.out.println(map);
	}

}
