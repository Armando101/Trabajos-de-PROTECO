import java.util.ArrayList;

class Contador
{
	public static void kakuzu(ArrayList<String> binarios)
	{
		int max = 0;
		for(int i = 0; i < binarios.size(); i++)
		{
			if(binarios.get(i).length() > max)
			{
				max = binarios.get(i).length();
			}
		}
		int count;
		for (int i = 0; i < max; i++) 
		{
			System.out.println("-------------" + i);
			for (int j = 0; j < binarios.size(); j++) 
			{
				count = binarios.get(j).replace("0", "").length();
				if(count == i)
				{
					System.out.println(" " + binarios.get(j));
				}
			}	
		}
	}
}