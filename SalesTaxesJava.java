import java.util.regex.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class SalesTaxesJava {

	static int salesTax = 10;
	static int importTax = 5;
	
	public static double calculateItem(String item) {
		
		Pattern p = Pattern.compile("[0-9]+[.][0-9]+");
		Matcher m = p.matcher(item);
		
		
		
		if (m.find()) {
			String strAmount = m.group();
			double amount = Double.parseDouble(strAmount);
			double sTax = (amount * salesTax / 100.0);
			
			BigDecimal b = new BigDecimal(strAmount);
			BigDecimal b2 = b.setScale(2, BigDecimal.ROUND_UNNECESSARY);
			System.out.println("BD amount: " + b2);
			
			BigDecimal t = new BigDecimal(sTax);
			BigDecimal t2 = t.setScale(2, BigDecimal.ROUND_CEILING);
			System.out.println("BD tax: " + t2);
			
			t2 = t2.add(b2);
			
			System.out.println("BD subtotal: " + t2);
			
			return t2.doubleValue();
		}
		
		else {
			return 0.00;
		}
	}
}
