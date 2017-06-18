package BackEnd;
import java.util.Random;

/**
 * This class generates random user's variables.
 */
public class RandomUser {
	private User randomUser;
	
	public RandomUser(){
	    randomUser = new User();


		String firstNameRand = generateString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 10);
		String lastNameRand = generateString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 10);
		int IDRand = generateInt(1, 10);

		int howOftenUserPlaysPerWeekRand = generateInt(1,10);
		int socialnessRand = generateInt(1,10);
		
		randomUser.setName(firstNameRand, lastNameRand);
		randomUser.setID(IDRand);
		randomUser.setHowOftenUserPlaysPerWeek(howOftenUserPlaysPerWeekRand);
		randomUser.setSocialness(socialnessRand);
	}
		/**
		 * Since we don't have a actual case to study on, we need to generate random names.
		 * Generating a random string in order to store it as either first name or last name for dataset.
		 * @param characters is a string that we will choose characters from.
		 * @param length is the length of the random string that generator is supposed to give us.
         * @return a string that needed for random name.
		 */
	public static String generateString(String characters, int length){
		Random rand = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++){
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		return new String(text);
	}

    /**
     * Generating a random number for user's ID.
     * @param min the lower bound of random generator.
     * @param max the upper bound of random generator.
     * @return an int which is needed for user's ID.
     */
	public static int generateInt(int min, int max){
		Random rand = new Random();
		int result = rand.nextInt((max-min)+1)+min;
		return result;
	}

    /**
     * @return a randomUser object.
     */
	public User getUser() {
		return randomUser;
	}
}
