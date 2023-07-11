import java.util.ArrayList;

import org.testng.annotations.Test;

public class Test1 {
	
 //@Test
 public void regular()
 {
	 ArrayList<String> names = new ArrayList<String>();
	 names.add("Ankita");
	 names.add("Amrita");
	 names.add("Nitin");
	 names.add("Himanshu");
	 names.add("Anku");
	 int count =0;
	 for(int i=0; i<names.size();i++)
	 {
		 String actual = names.get(i);
		 if(actual.startsWith("A"))
		 {
			 count++;
		 }
	 }
	 System.out.println(count);
 }
  @Test 
  public void streamMap()
  {
	  //print names which have last letter as"A" with uppercase
	  //Stream.of("Ankita","Amrita","Nitin","Himanshu","Anku").filter(s->s.endswith("a")).map(s->s.toupperCase())
	  //.forEach(s->System.out.println(s));
  }

 


	}


