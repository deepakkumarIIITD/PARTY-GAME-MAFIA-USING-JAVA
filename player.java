package mafia;

import java.util.Scanner;

class player extends end {
	String name;
	double hp;
	int votes = 0;
	String type;
	Scanner scn = new Scanner(System.in);

	player(String NAME, String TYPE) {
		this.type = TYPE;
		this.name = NAME;
		if (type.equals("MAFIA")) {
			this.hp = 2500;
		} else if (type.equals("DETECTIVE")) {
			this.hp = 800;
		} else if (type.equals("HEALER")) {
			this.hp = 800;
		} else {
			this.hp = 1000;
		}
	}

	void player_printer() {
		for (player thisone : mainpage.all_players) {
			System.out.println("                                              " + thisone.getName());
		}
	}

	boolean player_present(String name) {
		for (int i = 0; i < mainpage.all_players.size(); i++) {
			if (mainpage.all_players.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	void votesadder() {
		setVotes(getVotes() + 1);
	}

	void hpadder() {
		setHp(getHp() + 500);
	}

	void votesremover() {
		setVotes(0);
	}

	void method(player user) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}