import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

	// System objects
	Scanner in = new Scanner(System.in);
	Random rand = new Random();
	
	// Game variables
	String[] enemies = { "Skeleton", " Zombie", "Warrior", "Assasin" };
	int maxEnemyHealth = 75;
	int enemyAttackDamage = 25;
	
	// Player variables
	int health = 100;
	int attackDamage = 50;
	int numHealthPots = 3; // max number of health potions
	int healthPotionHealAmount = 30;
	int healthPotionDropChance = 50; // = percentage
	int numberOfEnemiesDefeated = 0;
	
	boolean running = true;
	
	System.out.println("Welcome to the Dungeon");
	
	// GAME is name/label of While loop
	GAME:
	while(running) {
		System.out.println("-----------------------------------------------------");
		
		int enemyHealth = rand.nextInt(maxEnemyHealth);
		String enemy = enemies[rand.nextInt(enemies.length)];
		System.out.println("\t# " + enemy + " appeared! #\n");
		//		\t = tab       
		// \n = next line
		
		while(enemyHealth > 0) {
			System.out.println("\tYour HP: " + health);
			System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
			System.out.println("\n\tWhat would you like to do (type action)");
			System.out.println("\t1. << Attack >>");
			System.out.println("\t2. << Drink >> health potion");
			System.out.println("\t3. << Run >>");
			
			String input = in.nextLine();
				
				if(input.equals("Attack")) {
					int damageDealth = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealth;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealth + " damage");
					System.out.println("\t> You receive " + damageTaken + " in retaliation");
					
					if(health < 1) {
						System.out.println("\t > You have too much damage");
						break;
					}		
				} 
				else if (input.equals("Drink")) {
					if(numHealthPots > 0) {
						health += healthPotionHealAmount;
						numHealthPots--;
						System.out.println("\t You drink a health potion for " + healthPotionHealAmount 
											+ "\n\t> you now have " + health + "HP."
											+ "\n\t> You have " + numHealthPots +  " health potions left");
					}	
					else {
						System.out.println("\t> You have no health potions left. Defeat enemies for a change to get one");
					}					
				}
				else if (input.equals("Run")) {
					System.out.println("\tYou run away from the " + enemy + "!");
					// Were inside the loop, want to go up the loop to generate new enemy
					// Without GAME we would return back to the While loop
					continue GAME;
				}	
				else {
					System.out.println("\tInvalid command");
				}
		}
		 
		// break out of while loop because health is less than 1
		if(health < 1) {
			System.out.println("you limp out of the dungeon, weak from battle");
			break;
		}
		
		System.out.println("----------------------------------------------------");
		
		System.out.println(" # " + enemy + " was defeated! #");
		System.out.println(" # You have " + health + " HP left.  #");
		numberOfEnemiesDefeated++;
		System.out.println(" # You have deafeated " + numberOfEnemiesDefeated + " enemie(s)");
		
		
		if(rand.nextInt(100) < healthPotionDropChance) {
			numHealthPots++;
			System.out.println(" @ The " + enemy + " dropped a health potion");
			System.out.println(" # You have " + numHealthPots + " health potions. #");
		}
		
		System.out.println("------------");
		System.out.println("What would you like to do now?");
		System.out.println("1. Continue");
		System.out.println("2. Exit");
		
		String input = in.nextLine();
		
		while(!input.equals("Continue") && !input.equals("Exit")) {
			System.out.println("invalid command");
			input = in.nextLine();
		}
		if(input.equals("Continue")) {
			System.out.println("You continue your adventure");
		}
		else if (input.equals("Exit")) {
			System.out.println("You exit the dungeon, successful from your adventure");
			break;
		}
				
	}
		
	System.out.println("#########");
	System.out.println(" # thanks for playing");	
	System.out.println("#########");

	}

}
