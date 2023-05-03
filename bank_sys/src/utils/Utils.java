package utils;

import java.text.*;

public class Utils {
	static NumberFormat formatandoVal = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(Double valor) {
		return formatandoVal.format(valor);
	}
}
