package gmc.project.rockpapersissors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmc.project.rockpapersissors.models.CreateRoomModel;
import gmc.project.rockpapersissors.models.RoomModel;
import gmc.project.rockpapersissors.services.RoomServices;

@RestController
@RequestMapping(path = "/room")
public class RoomController {
	
	@Autowired
	private RoomServices roomService;
	
	@PostMapping(path = "/create")
	public ResponseEntity<RoomModel> createRoom(@RequestBody CreateRoomModel createRoomModel) {
		RoomModel createdRoom = roomService.createRoom(createRoomModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
	}
	
	@PostMapping(path = "/join")
	public ResponseEntity<RoomModel> joinRoom(@RequestBody CreateRoomModel createRoomModel) {
		RoomModel createdRoom = roomService.joinRoom(createRoomModel);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(createdRoom);
	}
	
	@GetMapping(path = "/{roomId}/delete")
	public ResponseEntity<String> deleteRoom(@PathVariable String createRoomModel) {
		roomService.deleteARoom(createRoomModel);
		return ResponseEntity.status(HttpStatus.OK).body("Room Deleted...");
	}

}
