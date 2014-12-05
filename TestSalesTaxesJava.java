import org.junit.Test;
import org.junit.Assert;
import java.io.*;

public class TestSalesTaxesJava {

	@Test
	public void testBlank() {
		
	}
	
	@Test
	public void testOneItemNonExempt() {
		String oneItem = "1 music CD at 14.99";
		Assert.assertEquals(SalesTaxesJava.calculateItem(oneItem), 16.49, 0.00);
		
	}
	
	@Test
	public void testOneItemExempt() {
		//String oneItem = "1 book at 12.49";
		//Assert.assertEquals(SalesTaxesJava.calculateItem(oneItem), 12.49, 0.00);
	}
	
	@Test
	public void testMultItemsExemptNonExempt() {
		
	}
	
	@Test
	public void testOneItemImport() {
		String oneItem = "1 imported bottle of perfume at 27.99";
		Assert.assertEquals(SalesTaxesJava.calculateItem(oneItem), 32.19, 0.00);
	}
	
	@Test
	public void testMultItemsImport() {
		
	}
	
	@Test
	public void testMultItemsExemptNonExemptImport() {
		
	}
	
	@Test
	public void testFileOneItem() {
		
	}
	
	@Test
	public void testFileMultItems() {
		
	}
}
