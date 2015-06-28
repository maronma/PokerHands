package pokerHands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class odcztZpliku
{
	
	public static List<String> readLines(String filename) throws IOException
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(filename));

		List<String> result = new ArrayList<String>();

		while (inputFile.ready())
		{
			result.add(inputFile.readLine());
		}

		return result;
	}

	public static int[][] readFile(String filename, int wiersze, int kolumny) throws Exception
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(filename));

		int[][] result = new int[wiersze][kolumny];
		for (int i = 0; i < wiersze; i++)

		 
		 {
			String line = inputFile.readLine();
			String[] splitLine = line.split(" ");
			for (int j = 0; j < kolumny; j++)
			{
				result[i][j] = Integer.parseInt(splitLine[j]);
			}
		}

		return result;
	}

}
