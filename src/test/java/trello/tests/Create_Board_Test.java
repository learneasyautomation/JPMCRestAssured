package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import trello.common.Base;
import trello.functions.CreateBoard;

public class Create_Board_Test extends Base{
	
	@Test(enabled=false)
	public void testCreateBoard() {
		int statuscode = CreateBoard.createNewBoard("Board_JPMC_1");
		Assert.assertEquals(statuscode, 200);
	}
}
