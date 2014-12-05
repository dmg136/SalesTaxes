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
			
			
			/* See if item is imported or not */
			Pattern p2 = Pattern.compile("import[A-Za-z]*\\s");
			Matcher m2 = p2.matcher(item);
			
			if (m2.find()) {
				System.out.println(m2.group());
				
				double iTax = (amount * importTax) / 100.0;
				
				BigDecimal t3 = new BigDecimal(iTax);
				BigDecimal t4 = t3.setScale(2, BigDecimal.ROUND_CEILING);
				System.out.println("import tax: " + t4);
				
				t4 = t4.add(t2);
				System.out.println("Subtotal 2: " + t4);
				
				return t4.doubleValue();
			}
			
			System.out.println("-------------------");
			return t2.doubleValue();
		}
		
		else {
			return 0.00;
		}
	}
}
