import org.junit.Test;
import org.junit.Assert;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestSalesTaxesJava {

	@Test
	public void testBlank() {
		
	}
	
	@Test
	public void testOneItemNonExempt() {
		String oneItem = "1 music CD at 14.99";
		BigDecimal[] bd = SalesTaxesJava.calculateItem(oneItem);
		
		Assert.assertEquals(bd[0].doubleValue(), 1.50, 0.00);
		Assert.assertEquals(bd[1].doubleValue(), 16.49, 0.00);
		
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
		BigDecimal[] bd = SalesTaxesJava.calculateItem(oneItem);
		
		Assert.assertEquals(bd[0].doubleValue(), 4.20, 0.00);
		Assert.assertEquals(bd[1].doubleValue(), 32.19, 0.00);
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
