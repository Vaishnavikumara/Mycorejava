

import static org.junit.Assert.fail;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Entities {
	
	

	private static DatastoreService datastore;
	public static Key key;
	static Entity e3 = null;
	 public static boolean kindExample_writesEntity(String n,String a,String i) throws Exception {
		    // [START kind_example]
		    Entity employee = new Entity("Employee", i);
		    employee.setProperty("Name", n);
		    employee.setProperty("Age", a);
		    //employee.setProperty("lastName", "Salieri");
		    //employee.setProperty("hireDate", new Date());
		    //employee.setProperty("attendedHrTraining", true);
		    

		     datastore = DatastoreServiceFactory.getDatastoreService();
		    datastore.put(employee);
		    key = KeyFactory.createKey("Employee", i);
		    
		    String j = KeyFactory.keyToString(key);
		    
		    
		    
		   // key = employee.getKey();
		    
		    System.out.println("key is :"+employee.getKey());
		    System.out.println("String value is :"+j);
		    
		    
		    System.out.println("Key from String is :"+KeyFactory.stringToKey(j));
		   // datastore.delete(key);
		    
		    
		    return true;
}

	/*  public static void retrieve(String i) {
		  try {
			Entity e = datastore.get(key);
			System.out.println(e);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }*/
	  
	

	public static  void delete(String i) throws Exception   {
		 System.out.println("To be deleted id is :"+i);
		  
		Key  k = KeyFactory.createKey("Employee",i);
		   
		 //Entity e3= datastore.get(k);
		 System.out.println(k);
		
		 datastore.delete(k);
		// fail("Entity not found exception");
	
		 
		 }
	
	
	//retrieve a record

	public static Entity retrieve(String i) {
		
		Key k = KeyFactory.createKey("Employee", i);
		try {
			 e3 = datastore.get(k);
			System.out.println(e3);
			//Object name = e3.getProperty("user");
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e1) {
			e1.printStackTrace();
		}
		//System.out.println("Name is :"+e3.getProperty("Name"));
		//return (e3.getProperty("Name"));
		
		return e3;
		
	}
		
	  }

	

	 