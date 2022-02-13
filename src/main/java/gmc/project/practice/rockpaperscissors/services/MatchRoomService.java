package gmc.project.practice.rockpaperscissors.services;

import gmc.project.practice.rockpaperscissors.entities.RoomEntity;
import gmc.project.practice.rockpaperscissors.models.RoomModel;

public interface MatchRoomService {
	RoomEntity findOne(String roomId);
	RoomModel getRoom(String roomId);
	RoomModel createRoom(String roomId);
	RoomModel joinRoom(String roomId);
	void deleteRoom(String roomId);
}
