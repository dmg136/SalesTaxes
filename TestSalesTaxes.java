import org.junit.Test;
import org.junit.Assert;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestSalesTaxes {

	@Test
	public void testBlank() {
		
	}
	
	/*
	@Test
	public void testOneItemNonExempt() {
		String oneItem = "1 music CD at 14.99";
		BigDecimal[] bd = SalesTaxes.calculateItem(oneItem);
		
		Assert.assertEquals(bd[0].doubleValue(), 1.50, 0.00);
		Assert.assertEquals(bd[1].doubleValue(), 16.49, 0.00);
		
	}
	*/
	
	@Test
	public void testOneItemNonExempt() {
		System.out.println("testOneItemNonExempt");
		String oneItem = "1 music CD at 14.99";
		Receipt r1 = new Receipt(oneItem);
		
		Assert.assertEquals(r1.getTaxes().doubleValue(), 1.50, 0.00);
		Assert.assertEquals(r1.getAmount().doubleValue(), 16.49, 0.00);
	}
	
	@Test
	public void testOneItemExempt() {
		//String oneItem = "1 book at 12.49";
		//Assert.assertEquals(SalesTaxesJava.calculateItem(oneItem), 12.49, 0.00);
	}
	
	
	/* 
	 * Input: 1 music CD at 29.99\n1 PS4 at 399.99
	 * Output: 1 music CD: 32.99
	 * 		   1 PS4: 439.99
	 *         Sales Taxes: 43.00
	 *         Total: 472.98
	 */
	@Test
	public void testMultItemsNonExempt() {
		System.out.println("testMultItemsNonExempt");
		String multItems = "1 music CD at 29.99\n1 PS4 at 399.99";
		Receipt r1 = new Receipt(multItems);
		
		Assert.assertEquals(r1.getTaxes().doubleValue(), 43.00, 0.00);
		Assert.assertEquals(r1.getAmount().doubleValue(), 472.98, 0.00);
	}
	
	@Test
	public void testMultItemsExemptNonExempt() {
		
	}
	
	@Test
	public void testOneItemImport() {
		System.out.println("testOneItemImport");
		String oneItem = "1 imported bottle of perfume at 27.99";
		Receipt r1 = new Receipt(oneItem);
		
		Assert.assertEquals(r1.getTaxes().doubleValue(), 4.20, 0.00);
		Assert.assertEquals(r1.getAmount().doubleValue(), 32.19, 0.00);
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
