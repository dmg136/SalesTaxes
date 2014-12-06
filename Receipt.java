import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;
import java.math.BigDecimal;

public class Receipt {
	private ArrayList receiptItems;
	private ArrayList exemptItems = new ArrayList();
	private BigDecimal totalTaxes;
	private BigDecimal totalAmount;
	private double salesTax;
	private double importTax;
	private boolean itemIsExempt;
	
	public Receipt(String items) {
		populateExemptItems();
		receiptItems = new ArrayList();
		totalTaxes = new BigDecimal("0.00");
		totalAmount = new BigDecimal("0.00");
		
		totalTaxes.setScale(2, BigDecimal.ROUND_UNNECESSARY);
		totalAmount.setScale(2, BigDecimal.ROUND_UNNECESSARY);
		
		String[] split = items.split("\n");
		String tempString;
		BigDecimal[] tempArray;
		
		for (int i = 0; i < split.length; i++) {
			
			itemIsExempt = false;
			tempString = split[i];
			Pattern p;
			Matcher m;
			
			/* Look through exempt item list and see if there is a match */
			for (int j = 0; j < exemptItems.size(); j++) {
				p = Pattern.compile(exemptItems.get(j) + "\\s");
				m = p.matcher(tempString);
				
				if (m.find()) {
					itemIsExempt = true;
					break;
				}
			}
			
			tempArray = SalesTaxes.calculateItem(tempString, itemIsExempt);
			totalTaxes = totalTaxes.add(tempArray[0]);
			totalAmount = totalAmount.add(tempArray[1]);
		}
		
	}
	
	public Receipt(File file) {
		populateExemptItems();
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
	
	private void populateExemptItems() {
		exemptItems.add("book");
		exemptItems.add("food");
		exemptItems.add("medical");
		exemptItems.add("chocolate");
		exemptItems.add("headache");
		exemptItems.add("pills");
	}
}
