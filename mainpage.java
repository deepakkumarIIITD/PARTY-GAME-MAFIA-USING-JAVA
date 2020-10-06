package mafia;

import java.util.*;

public class mainpage extends mafia_logos {
	public static ArrayList<player> all_players = new ArrayList<>();
	public static ArrayList<mafia> all_mafias = new ArrayList<>();
	public static ArrayList<healer> all_healers = new ArrayList<>();
	public static ArrayList<detectives> all_detectives = new ArrayList<>();
	public static ArrayList<commoner> all_commoners = new ArrayList<>();

	public static void main(String[] args) {
		LOGO();
		Scanner scn = new Scanner(System.in);
		int number_of_players;
		System.out.print("                                    ENTER NUMBER OF PLAYERS : ");
		while (true) {
			try {
				number_of_players = scn.nextInt();
				if (number_of_players < 6) {
					System.out.print("                      NUMBER OF PLAYERS SHOULD BE MORE THAN 5");
					System.out.print(" ENTER AGAIN : ");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.print("               ENTER A INTEGER TYPE NOT ANY OTHER i.e : 1 or 5 or 2 ");
				System.out.print(" ENTER AGAIN : ");
				scn.nextLine();
			}
		}
		int number_of_mafias = (number_of_players / 5);
		int number_of_detectives = number_of_mafias;
		int number_of_healers = Math.max(1, (number_of_players / 10));
		int number_of_commoners = number_of_players - (number_of_mafias + number_of_detectives + number_of_healers);
		int count = 1;
		for (int i = 0; i < number_of_mafias; i++) {
			mafia intermediate = new mafia(("PLAYER" + count));
			all_mafias.add(intermediate);
			all_players.add(intermediate);
			count++;
		}
		for (int i = 0; i < number_of_detectives; i++) {
			detectives intermediate = new detectives(("PLAYER" + count));
			all_detectives.add(intermediate);
			all_players.add(intermediate);
			count++;
		}
		for (int i = 0; i < number_of_healers; i++) {
			healer intermediate = new healer(("PLAYER" + count));
			all_healers.add(intermediate);
			all_players.add(intermediate);
			count++;
		}
		for (int i = 0; i < number_of_commoners; i++) {
			commoner intermediate = new commoner(("PLAYER" + count));
			all_commoners.add(intermediate);
			all_players.add(intermediate);
			count++;
		}
		player user = null;
		System.out.println("                                         CHOOSE A CHARACTER");
		System.out.println("                                              1) MAFIA");
		System.out.println("                                            2) DETECTIVE");
		System.out.println("                                             3) HEALER");
		System.out.println("                                            4) COMMONER");
		System.out.println("                                         5) ASSIGN RANDOMLY");
		int selection;
		while (true) {
			System.out.print("                                        ENTER COMMAND : ");
			try {
				selection = scn.nextInt();
				if (selection > 0 && selection < 6) {
					break;
				} else {
					System.out.println("                ENTER A NUMBER BETWEEN 1(INCLUDED) AND 5(INCLUDED) ");
				}
			} catch (InputMismatchException e) {
				System.out.println("                        ENTER A INTEGER TYPE NOT ANY OTHER i.e : 1 or 5 or 2 ");
				scn.nextLine();
			}
		}
		if (selection == 1) {
			user = all_mafias.get(0);
		} else if (selection == 2) {
			user = all_detectives.get(0);
		} else if (selection == 3) {
			user = all_healers.get(0);
		} else if (selection == 4) {
			user = all_commoners.get(0);
		} else if (selection == 5) {
			Random r = new Random();
			selection = r.nextInt(4) + 1;
			if (selection == 1) {
				user = all_mafias.get(0);
			} else if (selection == 2) {
				user = all_detectives.get(0);
			} else if (selection == 3) {
				user = all_healers.get(0);
			} else if (selection == 4) {
				user = all_commoners.get(0);
			}
		}
		System.out.println(
				"                                YOU ARE A " + user.getType() + " AND YOU ARE " + user.getName());
		if (user.getType().equals("MAFIA")) {
			GUN();
			if (all_mafias.size() - 1 > 0) {
				System.out.println("                                         OTHER MAFIAS ARE :");
				for (int i = 0; i < all_mafias.size(); i++) {
					if (!all_mafias.get(i).equals(user)) {
						System.out.println(
								"                                              " + all_mafias.get(i).getName());
					}
				}
			} else {
				System.out.println("                                   YOU ARE THE ONLY MAFIA IN GAME");
			}

		} else if (user.getType().equals("DETECTIVE")) {
			PIPE();
			if (all_detectives.size() - 1 > 0) {
				System.out.println("                                        OTHER DETECTIVE ARE :");
				for (int i = 0; i < all_detectives.size(); i++) {
					if (!all_detectives.get(i).equals(user)) {
						System.out.println(
								"                                              " + all_detectives.get(i).getName());
					}
				}
			} else {
				System.out.println("                                 YOU ARE THE ONLY DETECTIVE IN GAME");
			}
		} else if (user.getType().equals("HEALER")) {
			PILLS();
			if (all_healers.size() - 1 > 0) {
				System.out.println("                                         OTHER HEALER ARE :");
				for (int i = 0; i < all_healers.size(); i++) {
					if (!all_healers.get(i).equals(user)) {
						System.out.println(
								"                                              " + all_healers.get(i).getName());
					}
				}
			} else {
				System.out.println("                                  YOU ARE THE ONLY HEALER IN GAME");
			}
		} else {
			COMMONER();
		}
		user.method(user);
		boolean who_won = (all_mafias.size() != 0);
		end.face(user, who_won);
		System.out.println("                                             GAME STATS");
		System.out.println("                                       THE USER WAS : " + user.getName());
		System.out.println("                                       MAFIAS IN GAME WERE : ");
		count = 1;
		for (int i = 0; i < number_of_mafias; i++) {
			System.out.println("                                              PLAYER" + count);
			count++;
		}
		System.out.println("                                      DETECTIVES IN GAME WERE : ");
		for (int i = 0; i < number_of_detectives; i++) {
			System.out.println("                                              PLAYER" + count);
			count++;
		}
		System.out.println("                                       HEALERS IN GAME WERE : ");
		for (int i = 0; i < number_of_healers; i++) {
			System.out.println("                                              PLAYER" + count);
			count++;
		}
		System.out.println("                                      COMMONERS IN GAME WERE : ");
		for (int i = 0; i < number_of_commoners; i++) {
			System.out.println("                                              PLAYER" + count);
			count++;
		}
		LOGO();

	}
}