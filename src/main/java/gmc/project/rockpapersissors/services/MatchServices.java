package gmc.project.rockpapersissors.services;

import gmc.project.rockpapersissors.models.ChangeOption;
import gmc.project.rockpapersissors.models.MatchModel;

public interface MatchServices {
	MatchModel addPlayer1Option(ChangeOption options);
	MatchModel addPlayer2Option(ChangeOption options);
}
