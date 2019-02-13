import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		ArrayList<String> names = new ArrayList<>();

		File file = new File("./src/names.txt"); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
		String st; 
		while ((st = br.readLine()) != null) {
			names.add(st);
		} 
		
		System.out.print("How many teams do you want to create? ");
		int NoOfTeams = scanner.nextInt();
	 
		ArrayList<ArrayList<String>> teams = new ArrayList<>();
		
		for(int i = 0; i < NoOfTeams; i++) {
			teams.add(new ArrayList<String>());
		}
		
		while (names.size() > 0) {
			for(int i = 0; i < NoOfTeams; i++) {
				if(names.size() > 0) {
					int number = generateRandomIntIntRange(0, names.size() -1);
					ArrayList<String> currentTeam = teams.get(i);
					currentTeam.add(names.get(number));
					names.remove(number);
					teams.set(i, currentTeam);
				}
			}
		}
		int teamNumber = 1;
		for(ArrayList<String> team : teams) {
			System.out.print("\n\n");
			System.out.println("Team " + teamNumber);
			System.out.println("------");
			for(String name : team) {
				System.out.println(name);
			}
			teamNumber++;
		}
	}
	
	public static int generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}

}
