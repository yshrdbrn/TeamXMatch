package BackEnd;
import java.util.Random;

public class RandomUser {
	private User randomUser;
	
	public RandomUser(){
	    randomUser = new User();

		String firstNameRand = generateString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 10);
		String lastNameRand = generateString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 10);
		int IDRand = generateInt(1, 10);
		boolean freeRand = generateBoolean();
		int howOftenUserPlaysPerWeekRand = generateInt(1,10);
		int socialnessRand = generateInt(1,10);
		
		randomUser.setName(firstNameRand, lastNameRand);
		randomUser.setID(IDRand);
		randomUser.setFree(freeRand);
		randomUser.setHowOftenUserPlaysPerWeek(howOftenUserPlaysPerWeekRand);
		randomUser.setSocialness(socialnessRand);
	}
	
	public static String generateString(String characters, int length){
		Random rand = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++){
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		return new String(text);
	}
	public static int generateInt(int min, int max){
		Random rand = new Random();
		int result = rand.nextInt((max-min)+1)+min;
		return result;
	}
	public static boolean generateBoolean(){
		Random rand = new Random();
		boolean result = rand.nextBoolean();
		return result;
	}

	public User getUser() {
		return randomUser;
	}
}
