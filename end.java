package mafia;

import java.util.ArrayList;

public class end extends mafia_logos {
	public static boolean game_ender() {
		for (int i = 0; i < mainpage.all_players.size(); i++) {
			if (mainpage.all_players.get(i).getHp() == 0) {
				if (!mainpage.all_players.get(i).getType().equals("MAFIA")) {
					System.out.println("                                          "
							+ mainpage.all_players.get(i).getName() + " HAS DIED");
					player_reducer(i);
				}
			}
		}
		if (mainpage.all_mafias.size() == 0) {
			System.out.println("                                       MAFIA LOSE , GAME OVER");
			return true;
		}
		if ((mainpage.all_mafias.size() / (mainpage.all_players.size() - mainpage.all_mafias.size())) == 1) {
			System.out.println("                                       MAFIA WON , GAME OVER");
			return true;
		}
		return false;
	}

	public static void face(player user, boolean winloss) {
		if (winloss) {
			if (user.getType().equals("MAFIA")) {
				WIN();
			} else {
				LOSS();
			}
		} else {
			if (user.getType().equals("MAFIA")) {
				LOSS();
			} else {
				WIN();
			}
		}
	}

	public static int players_tie() {
		int max_votes_index = 0;
		int current_max = 0;
		for (int i = 0; i < mainpage.all_players.size(); i++) {
			if (mainpage.all_players.get(i).getVotes() > current_max) {
				current_max = mainpage.all_players.get(i).getVotes();
				max_votes_index = i;
			}
		}
		for (int i = 0; i < mainpage.all_players.size(); i++) {
			if ((i != max_votes_index) && (mainpage.all_players.get(i).getVotes() == current_max)) {
				if (mainpage.all_players.get(i).getVotes() == current_max) {
					return -1;
				}
			}
		}
		return max_votes_index;
	}

	public static void player_reducer(int index) {
		String player_type = mainpage.all_players.get(index).getType();
		if (player_type.equals("MAFIA")) {
			mainpage.all_mafias.remove(mainpage.all_players.get(index));
		} else if (player_type.equals("COMMONER")) {
			mainpage.all_commoners.remove(mainpage.all_players.get(index));
		} else if (player_type.equals("DETECTIVE")) {
			mainpage.all_detectives.remove(mainpage.all_players.get(index));
		} else if (player_type.equals("HEALER")) {
			mainpage.all_healers.remove(mainpage.all_players.get(index));
		}
		mainpage.all_players.remove(index);
	}

	public static void vote_reducer() {
		for (int i = 0; i < mainpage.all_players.size(); i++) {
			mainpage.all_players.get(i).votesremover();
		}
	}
}