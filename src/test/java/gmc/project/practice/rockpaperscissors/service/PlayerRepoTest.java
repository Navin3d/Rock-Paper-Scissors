package gmc.project.practice.rockpaperscissors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import gmc.project.practice.rockpaperscissors.daos.PlayerDao;
import gmc.project.practice.rockpaperscissors.entities.PlayerEntity;

@DataJpaTest
public class PlayerRepoTest {
	
	@Autowired
	PlayerDao playerDao;
	
	@Test
	@DirtiesContext
	void testFindOne() {
		Optional<PlayerEntity> found = playerDao.findByPlayerId("123");
		assertEquals(found.get().getPlayerId(), "123");
		
	}
}
