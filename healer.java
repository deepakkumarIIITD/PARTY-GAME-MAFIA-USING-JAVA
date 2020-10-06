package mafia;

class healer extends player {
	healer(String NAME) {
		super(NAME, "HEALER");
	}

	@Override
	void method(player user) {
		int count = 1;
		while (true) {
			System.out.println("                                           ROUND NUMBER " + count);
			System.out.println(" PLAYERS PRESENT IN GAME : ");
			player_printer();
//			MAFIA TARGET
			int combined_hp = 0;
			int mafias_with_hp_more_than_zero = 0;
			for (int i = 0; i < mainpage.all_mafias.size(); i++) {
				combined_hp += mainpage.all_mafias.get(i).getHp();
				if (mainpage.all_mafias.get(i).getHp() > 0) {
					mafias_with_hp_more_than_zero++;
				}
			}
			int random = 0;
			boolean target_or_not = true;
			if (mainpage.all_commoners.size() > 0 && target_or_not) {
				int random_commoner = (int) (Math.random() * mainpage.all_commoners.size());
				double random_hp = mainpage.all_commoners.get(random_commoner).getHp();
				if (random_hp > combined_hp) {
					mainpage.all_commoners.get(random_commoner).setHp(random_hp - combined_hp);
				} else {
					mainpage.all_commoners.get(random_commoner).setHp(0);
				}
				double reductant_hp = random_hp / mafias_with_hp_more_than_zero;
				for (int i = 0; i < mainpage.all_mafias.size(); i++) {
					double mafia_hp = mainpage.all_mafias.get(i).getHp();
					if (mafia_hp > reductant_hp) {
						mainpage.all_mafias.get(i).setHp(mafia_hp - reductant_hp);
					} else {
						mainpage.all_mafias.get(i).setHp(0);
					}
				}
				target_or_not = false;
				System.out.println("                                      MAFIAS CHOOSED A TARGET");
			}
			if (mainpage.all_healers.size() > 0 && target_or_not) {
				int random_healer = (int) (Math.random() * mainpage.all_healers.size());
				double random_hp = mainpage.all_healers.get(random_healer).getHp();
				if (random_hp > combined_hp) {
					mainpage.all_healers.get(random_healer).setHp(random_hp - combined_hp);
				} else {
					mainpage.all_healers.get(random_healer).setHp(0);
				}
				double reductant_hp = random_hp / mafias_with_hp_more_than_zero;
				for (int i = 0; i < mainpage.all_mafias.size(); i++) {
					double mafia_hp = mainpage.all_mafias.get(i).getHp();
					if (mafia_hp > reductant_hp) {
						mainpage.all_mafias.get(i).setHp(mafia_hp - reductant_hp);
					} else {
						mainpage.all_mafias.get(i).setHp(0);
					}
				}
				target_or_not = false;
				System.out.println("                                      MAFIAS CHOOSED A TARGET");
			}
			if (mainpage.all_detectives.size() > 0 && target_or_not) {
				int random_detective = (int) (Math.random() * mainpage.all_detectives.size());
				double random_hp = mainpage.all_detectives.get(random_detective).getHp();
				if (random_hp > combined_hp) {
					mainpage.all_detectives.get(random_detective).setHp(random_hp - combined_hp);
				} else {
					mainpage.all_detectives.get(random_detective).setHp(0);
				}
				double reductant_hp = random_hp / mafias_with_hp_more_than_zero;
				for (int i = 0; i < mainpage.all_mafias.size(); i++) {
					double mafia_hp = mainpage.all_mafias.get(i).getHp();
					if (mafia_hp > reductant_hp) {
						mainpage.all_mafias.get(i).setHp(mafia_hp - reductant_hp);
					} else {
						mainpage.all_mafias.get(i).setHp(0);
					}
				}
				target_or_not = false;
				System.out.println("                                      MAFIAS CHOOSED A TARGET");
			}
//			DETECTIVE TEST
			boolean default_vote = false;
			String player_for_test = "";
			if (mainpage.all_detectives.size() > 0) {
				System.out.println("                                 DETECTIVES CHOOSED PLAYER FOR TEST");
				random = (int) (Math.random() * 3);
				if (random == 0) {
					System.out.println("                                CHOOSEN PLAYER TO TEST IS NOT MAFIA");
				} else if (random == 1) {
					System.out.println("                                CHOOSEN PLAYER TO TEST IS NOT MAFIA");
				} else if (random == 2) {
					int random_mafia = (int) (Math.random() * mainpage.all_mafias.size());
					System.out.println("                                        "
							+ mainpage.all_mafias.get(random_mafia).getName() + " IS A MAFIA");
					default_vote = true;
					player_for_test = mainpage.all_mafias.get(random_mafia).getName();
				}
			}
//			HEALER
			if (mainpage.all_healers.size() > 0) {
				if (mainpage.all_players.contains(user)) {
					String selection;
					while (true) {
						System.out.print("                         HEALER PLEASE SELECT PLAYER FOR HEALING : ");
						selection = (scn.next()).toUpperCase();
						if (!player_present(selection)) {
							System.out.println(
									"                           THE PLAYER IS NOT PRESENT OR THE NAME IS WRONG");
							System.out.println("                                    ENTER THE NAMES GIVEN ABOVE");
						} else {
							break;
						}
					}
					for (int i = 0; i < mainpage.all_players.size(); i++) {
						if (mainpage.all_players.get(i).getName().equals(selection)) {
							mainpage.all_players.get(i).hpadder();
							System.out.println("                                    HEALERS HAVE HEALED "
									+ mainpage.all_players.get(i).getName());
							break;
						}
					}
				} else {
					int random_of_all_players = (int) (Math.random() * mainpage.all_players.size());
					mainpage.all_players.get(random_of_all_players).hpadder();
					System.out.println("                                    HEALERS HAVE HEALED "
							+ mainpage.all_players.get(random_of_all_players).getName());
				}
			}
//		VOTING
			if (default_vote) {
				for (int i = 0; i < mainpage.all_players.size(); i++) {
					if (mainpage.all_players.get(i).getName().equals(player_for_test)) {
						mainpage.all_players.remove(i);
					}
				}
				for (int i = 0; i < mainpage.all_mafias.size(); i++) {
					if (mainpage.all_mafias.get(i).getName().equals(player_for_test)) {
						mainpage.all_mafias.remove(i);
					}
				}
			} else {
				while (true) {
//				HEALERS VOTE
					if (mainpage.all_healers.size() > 0) {
						if (mainpage.all_players.contains(user)) {
							String selection;
							while (true) {
								System.out
										.print("                          HEALERS PLEASE SELECT PLAYER FOR VOTEOUT : ");
								selection = (scn.next()).toUpperCase();
								if (!player_present(selection)) {
									System.out.println(
											"                           THE PLAYER IS NOT PRESENT OR THE NAME IS WRONG");
									System.out
											.println("                                    ENTER THE NAMES GIVEN ABOVE");
								} else {
									break;
								}
							}
							for (int i = 0; i < mainpage.all_players.size(); i++) {
								if (mainpage.all_players.get(i).getName().equals(selection)) {
									mainpage.all_players.get(i).votesadder();
									break;
								}
							}
						} else {
							while (true) {
								int random_of_all_players = (int) (Math.random() * mainpage.all_players.size());
								if (!mainpage.all_players.get(random_of_all_players).getType().equals("HEALER")) {
									mainpage.all_players.get(random_of_all_players).votesadder();
									break;
								}
							}
							System.out.println("                                  HEALERS CHOOSED PLAYERS TO VOTE");
						}
					}
//				MAFIAS VOTE
					while (true) {
						int random_of_all_players = (int) (Math.random() * mainpage.all_players.size());
						if (!mainpage.all_players.get(random_of_all_players).getType().equals("MAFIA")) {
							mainpage.all_players.get(random_of_all_players).votesadder();
							break;
						}
					}
					System.out.println("                                   MAFIAS CHOOSED PLAYERS TO VOTE");
//				DETECTIVE VOTE
					if (mainpage.all_detectives.size() > 0) {
						while (true) {
							int random_of_all_players = (int) (Math.random() * mainpage.all_players.size());
							if (!mainpage.all_players.get(random_of_all_players).getType().equals("DETECTIVE")) {
								mainpage.all_players.get(random_of_all_players).votesadder();
								break;
							}
						}
						System.out.println("                                 DETECTIVES CHOOSED PLAYERS TO VOTE");
					}
//				COMMONERS VOTE
					if (mainpage.all_commoners.size() > 0) {
						while (true) {
							int random_of_all_players = (int) (Math.random() * mainpage.all_players.size());
							mainpage.all_players.get(random_of_all_players).votesadder();
							break;
						}
						System.out.println("                                 COMMONERS CHOOSED PLAYERS TO VOTE");
					}
//					VOTE TIE
					int breakout = players_tie();
					if (breakout != -1) {
						player_reducer(breakout);
						vote_reducer();
						break;
					}
					vote_reducer();
					System.out.println("                        THERE WAS A TIE IN VOTING ROUND VOTING BEGINS AGAIN");

				}
			}
			if (game_ender()) {
				break;
			} else {
				count++;
			}
		}
	}
}