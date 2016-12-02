//Name: Daniela Travieso
//UFL ID: 95953348
//Section: 6909
//Project Number: 3
//Brief description of file contents: Currency Exchange Kiosk


import java.util.*;
public class CurrencyExchange
{
	private static double balance = 0;
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		int currencyType;
		double amount;
		int var;

		printConversionTable();

		do{
			
			var = mainMenuOptionSelector(input);

			if(var == 1)
			{
				//check balance

				System.out.println("Your current balance is: " + getBalance());

			}
			
			else if (var == 2)
			{
				
				//deposit
				
				currencyType = currencyMenuOptionSelector(input);
				System.out.println("Please enter the deposit amount: ");
				amount = input.nextDouble();
				
				//checks for negative and 0 input
				if (amount > 0)
				{
					deposit(amount, currencyType);
				}
				else
				{
					System.out.print("Logging Error");
					continue;
				}
				
			}
			
			else if (var == 3)
			{
				
				//withdraw
				
				currencyType = currencyMenuOptionSelector(input);
				System.out.println("Please enter the withdraw amount: ");
				amount = input.nextDouble();
				
				//checks for negative and 0 input
				if (amount > 0)
				{
					withdraw(amount, currencyType);
				}
				else
				{
					System.out.print("Logging Error");
					continue;
				}

			}
			
			else
			{
				
				//end session
				
				if (balance == 0)
				{
					//if they have nothing left
					System.out.println("Your remaining balance is 0.0 U.S. dollars");
					System.out.println("Goodbye");
					System.exit(0);
				}
				
				if (withdraw(balance, 1) == true)
				{
					//withdraw remaining amount
					logTransaction(balance, 1, false);
					System.out.println("Goodbye");
					System.exit(0);
				}

			}

		} while (var != 4); // do while loop


	}
	public static void printConversionTable() // prints currency exchange rates
	{

		//Prints the conversion table at the start of the program (see the output examples).

		System.out.println("Welcome to CurrencyExchange 2.0\n");

		System.out.println("Current rates are as follows:\n");

		System.out.println("1 -  U.S. Dollar - 1.00\n2 - Euro - 0.89\n3 - British Pound - 0.78\n4 - Indian Rupee - 66.53\n5 - Australian Dollar - 1.31\n6 - Canadian Dollar - 1.31\n7 - Singapore Dollar - 1.37\n8 - Swiss Franc - 0.97\n9 - Malaysian Ringgit - 4.12\n10 - Japanese Yen - 101.64\n11 - Chinese Yuan Renminbi - 6.67");

	}
	public static int mainMenuOptionSelector(Scanner input) //prints main menu and returns the option user selected
	{

//		Prints the main menu (see output examples), allows the user to make a selection from available operations
//
//		@param input the Scanner object you created at the beginning of the main method. Any value other than the 4 valid selections should generate an invalid value prompt. Print the list again and prompt user to select a valid value from the list.
//		@return an integer from 1-4 inclusive representing the user’s selection.

		int option;

		System.out.println("\nPlease select an option from the list below:");
		System.out.println("1. Check the balance of your account");
		System.out.println("2. Make a deposit");
		System.out.println("3. Withdraw an amount in a specific currency");
		System.out.println("4. End your session (and withdraw all remaining currency in U.S. Dollars)");
		option = input.nextInt();

		while (option < 1 || option > 4)
		{
			System.out.println("Input failed validation. Please try again.");

			System.out.println("\nPlease select an option from the list below:");
			System.out.println("1. Check the balance of your account");
			System.out.println("2. Make a deposit");
			System.out.println("3. Withdraw an amount in a specific currency");
			System.out.println("4. End your session (and withdraw all remaining currency in U.S. Dollars)");
			option = input.nextInt();
		}

		return option;
	}
	public static int currencyMenuOptionSelector(Scanner input) //prints currency selection menu and returns the option user selected
	{
		/*
		* Prints the currency menu (see output examples), allows the user to make a selection from available currencies
		*
		* @param input     the Scanner object you created at the beginning of the main method. Any value other than the 11 valid valid currency types should generate an invalid value prompt. Print the list again and prompt user to select a valid value from the list. the currency type will be the same as the type number used in {@link #convertCurrency(double, int, boolean)}
		* @return an integer from 1-11 inclusive representing the user’s selection.
		*/

		System.out.println("Please select the currency type:\n 1. U.S. Dollars\n 2. Euros\n 3. British Pounds\n 4. Indian Rupees\n 5. Australian Dollars\n 6. Canadian Dollars\n 7. Singapore Dollars\n 8. Swiss Francs\n 9. Malaysian Ringgits\n10. Japanese Yen\n11. Chinese Yuan Renminbi");
		int option = input.nextInt();
		while (option < 1 || option > 11)
		{
			System.out.println("Input failed validation. Please try again.");
			System.out.println("\nPlease select the currency type:\n 1. U.S. Dollars\n 2. Euros\n 3. British Pounds\n 4. Indian Rupees\n 5. Australian Dollars\n 6. Canadian Dollars\n 7. Singapore Dollars\n 8. Swiss Francs\n 9. Malaysian Ringgits\n10. Japanese Yen\n11. Chinese Yuan Renminbi");
			option = input.nextInt();
		}

		return option;

	}
	public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD) //converts currency to usd or foreign and returns converted amount
	{
		/*
		* Convert the value amount between U.S. dollars and a specific currency.
		*
		* @param amount         The amount of the currency to be converted.
		* @param currencyType   The integer currencyType works as follows:
		*                       1 for usd (U.S. Dollars)
		*                       2 for eur (Euros)
		*                       3 for bri (British Pounds)
		*                       4 for inr (Indian Rupees)
		*                       5 for aus (Australian Dollars)
		*                       6 for cnd (Canadian Dollars)
		*                       7 for sid (Singapore Dollars)
		*                       8 for swf (Swiss Francs)
		*                       9 for mar (Malaysian Ringgits)
		*                       10 for jpy (Japanese Yen)
		*                       11 for cyr (Chinese Yuan Renminbi)
		* @param isConvertToUSD Tells the direction of the conversion. If the value is true, then the conversion is from a foreign currency to USD. If the value is false, then the conversion is from USD to the foreign currency
		* @return the converted amount
		*/
		double currencyTypeDb = 0;

		switch (currencyType)
		{
			case 1: currencyTypeDb = 1.00; break;
			case 2: currencyTypeDb = 0.89; break;
			case 3: currencyTypeDb = 0.78; break;
			case 4: currencyTypeDb = 66.53; break;
			case 5: currencyTypeDb = 1.31; break;
			case 6: currencyTypeDb = 1.31; break;
			case 7: currencyTypeDb = 1.37; break;
			case 8: currencyTypeDb = 0.97; break;
			case 9: currencyTypeDb = 4.12; break;
			case 10: currencyTypeDb = 101.64; break;
			case 11: currencyTypeDb = 6.67; break;
		}

		double convertedAmount;

		if (isConvertToUSD == true)
		{
			//foreign to usd
			convertedAmount = amount/currencyTypeDb;
		}
		else
		{
			//usd to foreign
			convertedAmount = amount*currencyTypeDb;
		}

		return convertedAmount;

	}
	public static boolean deposit(double amount, int currencyType) //checks for valid deposits and converts to usd, returns true if valid
	{
		boolean successfulDeposit = false; //edit: changed true to false//
		double convertedAmount;

		if (currencyType != 1)
		{
			//if foreign to USD
			boolean isConvertToUSD = true;
			convertedAmount = convertCurrency(amount, currencyType, isConvertToUSD);
			successfulDeposit = updateBalance(balance + convertedAmount);
			System.out.print(logTransaction(amount,currencyType,true));
		}
		else
		{
			//if amount is in USD
			successfulDeposit = updateBalance(balance + amount);
			System.out.print(logTransaction(amount,currencyType,true));
		}

		return successfulDeposit;
	}
	public static boolean withdraw(double amount, int currencyType) //checks for valid withdrawals and converts to currency type, returns true if valid
	{
		boolean successfulWithdrawal = true;
		double convertedAmount;
		double feeAmount;


		if (currencyType != 1) //if they withdraw something that is not USD
		{
			boolean isConvertToUSD = true;
			convertedAmount = convertCurrency(amount, currencyType, isConvertToUSD);
			
			//apply fee for foreign withdrawals
			feeAmount = convertedAmount * 1.005;
			
			//check overdraft
			if (checkOverdraft(feeAmount) == false)
			{
				logTransaction(balance-feeAmount,currencyType,false);
				return false;
			}
			else
			{
				successfulWithdrawal = updateBalance(balance - feeAmount);
				System.out.println(logTransaction(amount,currencyType,false)); 
			}

		}
		else //if amount to be withdrawn is in dollars
		{
			//check overdraft
			if (checkOverdraft(amount) == false)
			{
				logTransaction(balance-amount,currencyType,false);
				return false; //
			}

			successfulWithdrawal = updateBalance(balance - amount);
			System.out.println(logTransaction(amount,currencyType,false));

		}

		return successfulWithdrawal;

	}
	public static String logTransaction(double amount, int currencyType, boolean isDeposit) //returns string containing information about deposit/withdrawal
	{

		String response = "";
		
		//invalid inputs
		if ( amount <= 0 || currencyType > 11 || currencyType < 1)
		{
			response = "Logging Error\n";
		}

		String currencyTypeString = "";
		switch (currencyType)
		{
			case 1: currencyTypeString = " U.S. Dollars"; break;
			case 2: currencyTypeString = " European Euro"; break;
			case 3: currencyTypeString = " British Pound"; break;
			case 4: currencyTypeString = " Indian Rupee"; break;
			case 5: currencyTypeString = " Australian Dollar"; break;
			case 6: currencyTypeString = " Canadian Dollar"; break;
			case 7: currencyTypeString = " Singapore Dollar"; break;
			case 8: currencyTypeString = " Swiss Francs"; break;
			case 9: currencyTypeString = " Malaysian Ringgit"; break;
			case 10: currencyTypeString = " Japanese Yen"; break;
			case 11: currencyTypeString = " Chinese Yuan Renminbi"; break;
		}

		//deposits
		if (isDeposit == true)
		{
			String amt = Double.toString(amount);
			response = "You successfully deposited " + amt + currencyTypeString;
		}
		//withdrawals
		else
		{
			String amt = Double.toString(amount);
			response = ("You successfully withdrew " + amt + currencyTypeString);
		}

		return response;
	}
	public static double getBalance() //gets balance
	{
		//returns the balance
		return balance;
	}
	private static boolean updateBalance(double newBalance) //rounds balance and returns true if it worked

	{
		balance = Math.round(newBalance * 100) / 100.0;
		if (balance >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkOverdraft(double amountToWithdraw) // personal method to check if there is an overdraft
	{
		double newBalance = balance - amountToWithdraw;
		//if it has overdrafted
		if (newBalance < 0)
		{
			System.out.println("Error: Insufficient funds.");
			System.out.println("Logging Error");
			return false;
		}
		else
		{
			return true;
		}
	}
}

