package StudentTest;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StudentTest {
	
	Tests test =null;
	
	//Tesing Insert
	@Test
	public void insert()
	{
		test =new Tests(1,"jaga","Villupuram",23575465);
		assertTrue(test.insertvalue());
		
		test=new Tests(2,"azeem","Thirunalveli",65844345);
		assertTrue(test.insertvalue());
		
	}
	
	//Testing update
	@Test
	public void update()
	{
		test = new Tests(1,"mozu","Villupuram",123454656);
		assertTrue(test.update());
	}
	
	//Testing retrive
	@Test
	public void retrive()
	{
		test=new Tests();
		int values = test.retrive();
		assertTrue(values > 0);
				
	}
	
	//Testing Delete
	@Test
	public void delete()
	{
		test=new Tests();
		assertTrue(test.delete(1));
	}
	
	
	
}
  