import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;
import java.math.BigDecimal;

public class Receipt {
	private ArrayList receiptItems;
	private BigDecimal totalTaxes;
	private BigDecimal totalAmount;
	private double salesTax;
	private double importTax;
	
	public Receipt(String items) {
		receiptItems = new ArrayList();
		totalTaxes = new BigDecimal("0.00");
		totalAmount = new BigDecimal("0.00");
		
		totalTaxes.setScale(2, BigDecimal.ROUND_UNNECESSARY);
		totalAmount.setScale(2, BigDecimal.ROUND_UNNECESSARY);
		
		String[] split = items.split("\n");
		
		for (int i = 0; i < split.length; i++) {
			totalTaxes = totalTaxes.add((SalesTaxes.calculateItem(split[i]))[0]);
			totalAmount = totalAmount.add((SalesTaxes.calculateItem(split[i])[1]));
		}
		
	}
	
	public Receipt(File file) {
		
	}
	
	public BigDecimal getTaxes() {
		return totalTaxes;
	}
	
	public BigDecimal getAmount() {
		return totalAmount;
	}
	
	public void setSalesTax(double st) {
		salesTax = st;
	}
	
	public void setImportTax(double it) {
		importTax = it;
	}
}
