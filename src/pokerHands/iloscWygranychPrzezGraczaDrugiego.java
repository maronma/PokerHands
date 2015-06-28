package pokerHands;

public class iloscWygranychPrzezGraczaDrugiego {
	public int ileWygranych(String filename) throws Exception{
		int result = 0;
		for (String s : odcztZpliku.readLines(filename))
		{
			if (new Hand(s).iloscWygranychGraczaDrugiego())
			{
				result++;
			}
		}

		return result;
	}
}
