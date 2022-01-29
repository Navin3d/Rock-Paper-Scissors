package gmc.project.rockpapersissors.services;

import gmc.project.rockpapersissors.entities.RoomEntity;
import gmc.project.rockpapersissors.models.CreateRoomModel;
import gmc.project.rockpapersissors.models.RoomModel;

public interface RoomServices {
	RoomEntity findOne(String roomId);
	
	RoomModel createRoom(CreateRoomModel createRoomModel);
	RoomModel joinRoom(CreateRoomModel joinRequest);
	void deleteARoom(String roomId);
}
