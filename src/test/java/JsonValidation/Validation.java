package JsonValidation;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class Validation {
	
	
	@Test
	public void getForignPlayerDetails() {
		int indianCount=0;
		int wicketKeeper=0;
		JsonPath js=new JsonPath(jsonPayload.TeamValidation()); 
		
	
		int TeamSize=	js.getInt("player.size()");
		System.out.println();
	
	for(int i=0;i<TeamSize;i++)
	{
		if(js.getString("player["+i+"].country").equalsIgnoreCase("India"))
		{
			indianCount++;	
		}
			
	}
	int ForeignPlayer=TeamSize-indianCount;
	System.out.println("Number of ForeignPlayer:"+ForeignPlayer);
	Assert.assertEquals(4, ForeignPlayer);
	
	for(int i=0;i<TeamSize;i++)
	{
		if(js.getString("player["+i+"].role").equalsIgnoreCase("Wicket-keeper"))
		{
			wicketKeeper++;	
		}
			
	}
	System.out.println("Number of wicketKeeper:"+wicketKeeper);

	Assert.assertEquals(1, wicketKeeper);
	}
	
	
}
