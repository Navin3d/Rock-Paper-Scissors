package gmc.project.practice.rockpaperscissors.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmc.project.practice.rockpaperscissors.entities.PlayerEntity;
import gmc.project.practice.rockpaperscissors.models.PlayerModel;
import gmc.project.practice.rockpaperscissors.services.PlayersService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
	
	private final PlayersService playersService;

	public PlayerController(PlayersService playersService) {
		super();
		this.playersService = playersService;
	}
	
	@GetMapping("/{playerId}/show")
	private ResponseEntity<PlayerModel> getAPlayer(@PathVariable String playerId) {
		PlayerModel returnValue = playersService.getAUser(playerId);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@PostMapping
	private ResponseEntity<PlayerModel> editPlayer(@RequestBody PlayerModel editPlayerModel) {
		PlayerModel returnValue = playersService.editPlayer(editPlayerModel);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}

}
