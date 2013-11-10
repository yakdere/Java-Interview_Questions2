
public class PerfectPrecision {

	/**
	 * @yakdere
	 * You’re playing an RPG, and you’re about to defeat the big boss. 
	 * However, you'll only get the style bonus if you win by exactly depleting 
	 * all his hit points. Your weapon does 1 damage at first. Each time you attack,
	 * you can choose to power up your weapon, making it twice as strong as before 
	 * for the next attack. If you do not power up, you'll do the same amount of damage
	 * on your next attack. Given that the boss starts with H hit points, 
	 * find the minimum number of attacks you need to exactly equal the boss's hit points.
	 * (For example, if the boss starts with 9 hit points, you'd need to attack 4 times, 
	 * for 1, 2, 2, and 4 damage.) The first line of the input will be an integer 
	 * N (1 <= N <= 100). Each of the following N lines represents a single test case, 
	 * containing an integer H (1 <= H <= 1000000000). For each test case, 
	 * print the minimum number of attacks needed to equal the boss's hit points. 
	 * No blank line between test cases.
Input/Output
Sample input
4
1
3
5
341132412
Sample output
1
2
3
41
	 */
	public static void howManyAttackINeed( int[] hitpoints) {
		for (int i = 0; i < hitpoints.length; i++) {
			System.out.println(calculateIt(hitpoints[i]));
		}
	}
	private static int calculateIt(int hitpoint) {
		int count = 0;
		int my_currpower = 1;
		while (my_currpower <= hitpoint) {
			my_currpower += my_currpower;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int[] test_array = {1, 3, 5, 341132412};
		howManyAttackINeed(test_array);

	}

}
