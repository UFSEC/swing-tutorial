//Daniela Travieso
//95953348
//COP3502
//Project 4: Pokemon

public class Pokemon 
{
	private int attack;
	private int defense;
	private int speed;
	private String species;
	
	public Pokemon(String species)
	{
		//intialize Pokemon
		
		setSpecies(species);
		setAttack((species.length() * 4 ) + 2);
		setDefense((species.length() * 2 ) + 7);
		setSpeed((species.length() * 3) + 5);
		
	}
	public void grow(int boost)
	{
		//increment attack by boost
		attack = attack += boost;
	}
	public void harden(int boost)
	{
		//increment defense by boost
		defense = defense += boost;
	}
	public void haste(int boost)
	{
		//increment speed by boost
		speed = speed += boost;
	}
	public String getSpecies()
	{
		//get species
		return species;
	}
	public void setSpecies(String spc)
	{
		//change species
		species = spc;
	}
	public int getAttack()
	{
		//get attack
		return attack;
	}
	public void setAttack(int atk)
	{
		//change attack
		attack = atk;
	}
	public int getDefense()
	{	
		//get defense
		return defense;
	}
	public void setDefense(int def)
	{
		//change defense
		defense = def;
	}
	public int getSpeed()
	{
		//get speed
		return speed;
	}
	public void setSpeed(int spd)
	{
		//change speed
		speed = spd;
	}


}
