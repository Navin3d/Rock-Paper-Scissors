package gmc.project.practice.rockpaperscissors.services;

import gmc.project.practice.rockpaperscissors.entities.PlayerEntity;
import gmc.project.practice.rockpaperscissors.entities.RoomEntity;
import gmc.project.practice.rockpaperscissors.models.PlayerModel;

public interface PlayersService {
	PlayerEntity findOne(String playerId);
	RoomEntity findOneRoom(String roomId);
	PlayerModel getAUser(String userId);
	PlayerModel createPlayer(String roomId);
	PlayerModel editPlayer(PlayerModel playerEditModel);
}
