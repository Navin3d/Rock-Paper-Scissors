package gmc.project.practice.rockpaperscissors.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmc.project.practice.rockpaperscissors.models.RoomModel;
import gmc.project.practice.rockpaperscissors.services.MatchRoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {
	
	private final MatchRoomService matchRoomService;

	public RoomController(MatchRoomService matchRoomService) {
		super();
		this.matchRoomService = matchRoomService;
	}
	
	@GetMapping("/{roomId}/show")
	private ResponseEntity<RoomModel> getARoom(@PathVariable String roomId) {
		RoomModel returnValue = matchRoomService.getRoom(roomId);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@GetMapping("/{roomId}/create")
	private ResponseEntity<RoomModel> createRoom(@PathVariable String roomId) {
		RoomModel returnValue = matchRoomService.createRoom(roomId);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@GetMapping("/{roomId}/join")
	private ResponseEntity<RoomModel> joinRoom(@PathVariable String roomId) {
		RoomModel returnValue = matchRoomService.joinRoom(roomId);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@GetMapping("/{roomId}/destroy")
	private ResponseEntity<String> deleteRoom(@PathVariable String roomId) {
		matchRoomService.deleteRoom(roomId);
		return ResponseEntity.status(HttpStatus.OK).body("Room with Id: " + roomId + " Deleted...");
	}
	
}
