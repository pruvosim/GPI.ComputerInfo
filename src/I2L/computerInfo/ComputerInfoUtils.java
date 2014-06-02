package I2L.computerInfo;

public class ComputerInfoUtils {

	public static String q(String mes)
	{
		//Fonction qui change les \ en /
		//et ajoute des quotes
		String copy = "";
		for (int i = 0; i < mes.length(); i++) {
			if(mes.charAt(i) == '\\')
			{
				copy += "/";
			}
			else
			{
				copy += mes.charAt(i);
			}

		}

		String res = "'" + copy + "'";
		return res;
	}

}
