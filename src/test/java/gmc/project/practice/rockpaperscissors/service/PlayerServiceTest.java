package gmc.project.practice.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Set;

import gmc.project.practice.rockpaperscissors.daos.PlayerDao;
import gmc.project.practice.rockpaperscissors.daos.RoomDao;
import gmc.project.practice.rockpaperscissors.entities.PlayerEntity;
import gmc.project.practice.rockpaperscissors.models.Options;
import gmc.project.practice.rockpaperscissors.models.PlayerModel;
import gmc.project.practice.rockpaperscissors.services.impl.PlayerServiceImpl;

public class PlayerServiceTest {
		
	@Mock
	PlayerDao playerDao;
	
	@Mock
	RoomDao roomDao;
	
	@InjectMocks
	PlayerServiceImpl playerService;
	
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Test
	void testCreatePlayer() {
		PlayerModel player = playerService.createPlayer("123");
		
		List<PlayerEntity> createdPlayer = playerDao.findAll();
		
		assertEquals(createdPlayer.size(), 1);
	}
	
//	@Test
//	void testEditPlayer() {
//		PlayerModel playerEdit = new PlayerModel("1", Options.ROCK, 1, true);
//		PlayerModel player = playerService.editPlayer(playerEdit);
//		assertEquals(playerEdit, player);
//	}
}
