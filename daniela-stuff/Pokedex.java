//Daniela Travieso
//95953348
//COP3502
//Project 4: Pokemon

public class Pokedex 
{
	//variable to store amount of pokemon in pokedex
	static int pokemonStored = 0;
	//array of Pokemon objects
	Pokemon[] pokerray; 
	
	public Pokedex(int size) //initializes Pokedex with the pokemon in a region
	{
		
		// amount of pokemon in a region
		pokerray = new Pokemon[size];
		
	}
	public String[] listPokemon() //lists all pokemon that are stored
	{
		
		String[] pokeNames = new String[pokemonStored];
		
		//if there are pokemon to list
		if (pokemonStored > 0)
		{
			
			for(int i = 0; i < pokemonStored; i++)
			{
				//checks if the index has a pokemon
				if(pokerray[i].getSpecies() != null)
				{

					//adds pokemon name to the array 
					pokeNames[i] = pokerray[i].getSpecies();
					
				}
				else
				{
					//checks for null
					return pokeNames;
				}
			}
		}
		
		//if the pokedex is empty
		else
		{
			pokeNames = null;
		}
		return pokeNames;
		
	}
	public boolean addPokemon(String species) //adds pokemon to the pokedex
	{	
		//Juan helped me with this
		boolean isMax = pokemonStored == pokerray.length;
		boolean isDuplicate = false;
		
		for (int i = 0; i<pokemonStored;i++)
		{
			//checks for duplicates
			if (pokerray[i].getSpecies().equalsIgnoreCase(species))
			{
				isDuplicate = true;
			}
		}
		
		if (isMax)
			System.out.println("Max"); //prints max
		
		else if (isDuplicate)
			System.out.println("Duplicate"); //prints duplicate
		
		else
		{
			//pokemon is added to pokerray
			pokerray[pokemonStored] = new Pokemon(species);
			//increment the amount of pokemon stored in the pokedex
			pokemonStored++;
		}
		
		return !isMax && !isDuplicate; //cool boolean
	}	
	public int[] checkStats(String species) //checks the stats of a given pokemon
	{
		
		//array of integers holding stats
		int[] stats = null;
		
		for (int i = 0; i < pokemonStored; i++)
		{
			
			//checks if the pokemon exists in the pokedex
			if(pokerray[i].getSpecies().compareToIgnoreCase(species) == 0)
			{
				stats = new int[3];
				//sets each index to the attack, defense, and speed
				stats[0] = pokerray[i].getAttack();
				stats[1] = pokerray[i].getDefense();
				stats[2] = pokerray[i].getSpeed();
			}
			
		}
		return stats;
		
	}
	public void sortPokemon() //uses selection sorting to alphabetically sort pokemon
	{
		
		for(int i = 0; i < pokemonStored; i++)
		{
			for(int j = i+1; j < pokemonStored; j++)
			{
				//compareTo compares the value and if it is > 0 then the values need to be switched
				if (pokerray[i].getSpecies().compareToIgnoreCase(pokerray[j].getSpecies()) > 0)
				{
					Pokemon temp = pokerray[i];
					pokerray[i] = pokerray[j];
					pokerray[j] = temp;
				}
			}
		}
		
	}

}
