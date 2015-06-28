package pokerHands;


public class iloscWygranychPrzezGraczaPierwszego {
	public int ileWygranych(String filename) throws Exception{
		int result = 0;
		for (String s : odcztZpliku.readLines(filename))
		{
			if (new Hand(s).iloscWygranychGraczaPierwszego())
			{
				result++;
			}
		}

		return result;
	}
	
}
