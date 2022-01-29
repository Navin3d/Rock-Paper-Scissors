package gmc.project.rockpapersissors.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.project.rockpapersissors.daos.MatchDao;
import gmc.project.rockpapersissors.daos.RoomDao;
import gmc.project.rockpapersissors.entities.MatchEntity;
import gmc.project.rockpapersissors.entities.RoomEntity;
import gmc.project.rockpapersissors.models.ChangeOption;
import gmc.project.rockpapersissors.models.MatchModel;
import gmc.project.rockpapersissors.models.Options;
import gmc.project.rockpapersissors.services.MatchServices;
import gmc.project.rockpapersissors.services.RoomServices;

@Service
public class MatchServiceImpl implements MatchServices {
	
	@Autowired
	private RoomServices roomServices;
	
	@Autowired
	private MatchDao matchDao;

	@Autowired
	private RoomDao roomDao;
	
	@Override
	public MatchModel addPlayer1Option(ChangeOption options) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RoomEntity foundRoom = roomServices.findOne(options.getRoomId());
		
		MatchEntity foundMatch = foundRoom.getMatches();
		
		foundMatch.setPlayer1Option(options.getOption());
		
		if(foundMatch.getPlayer2Option() == null)
			foundMatch.setIsWaiting(true);
		else {
			Options player1 = options.getOption();
			Options player2 = foundMatch.getPlayer2Option();
			
			if(player1.equals(player2)) {
				
			} else if (player1.equals(Options.Scissors) && player2.equals(Options.Rock)) {
				
				foundMatch.setPlayer2Score(foundMatch.getPlayer2Score() + 1);
			
			} else if (player1.equals(Options.Rock) && player2.equals(Options.Paper)) {
				
				foundMatch.setPlayer2Score(foundMatch.getPlayer2Score() + 1);
			
			} else if (player1.equals(Options.Paper) && player2.equals(Options.Scissors)) {
				
				foundMatch.setPlayer2Score(foundMatch.getPlayer2Score() + 1);
			
			} else if (player1.equals(Options.Scissors) && player2.equals(Options.Paper)) {
				
				foundMatch.setPlayer1Score(foundMatch.getPlayer1Score() + 1);
			
			}  else if (player1.equals(Options.Paper) && player2.equals(Options.Rock)) {
				
				foundMatch.setPlayer1Score(foundMatch.getPlayer1Score() + 1);
			
			}  else {
				
				foundMatch.setPlayer1Score(foundMatch.getPlayer1Score() + 1);
			
			} 
			
			foundMatch.setIsWaiting(false);
			
			foundMatch.setPlayer1Option(null);
			foundMatch.setPlayer2Option(null);

		}
		
		MatchEntity savedMatch = matchDao.save(foundMatch);		
		foundRoom.setMatches(savedMatch);
		roomDao.save(foundRoom);
		
		MatchModel returnValue = modelMapper.map(savedMatch, MatchModel.class);
		
		return returnValue;
	}

	@Override
	public MatchModel addPlayer2Option(ChangeOption options) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RoomEntity foundRoom = roomServices.findOne(options.getRoomId());
		
		MatchEntity foundMatch = foundRoom.getMatches();
		
		foundMatch.setPlayer2Option(options.getOption());
		
		if(foundMatch.getPlayer1Option() == null)
			foundMatch.setIsWaiting(true);
		else {
			Options player2 = options.getOption();
			Options player1 = foundMatch.getPlayer1Option();
			
			if(player1.equals(player2)) {
				
			} else if (player1.equals(Options.Scissors) && player2.equals(Options.Rock)) {
				
				foundMatch.setPlayer2Score(foundMatch.getPlayer2Score() + 1);
			
			} else if (player1.equals(Options.Rock) && player2.equals(Options.Paper)) {
				
				foundMatch.setPlayer2Score(foundMatch.getPlayer2Score() + 1);
			
			} else if (player1.equals(Options.Paper) && player2.equals(Options.Scissors)) {
				
				foundMatch.setPlayer2Score(foundMatch.getPlayer2Score() + 1);
			
			} else if (player1.equals(Options.Scissors) && player2.equals(Options.Paper)) {
				
				foundMatch.setPlayer1Score(foundMatch.getPlayer1Score() + 1);
			
			}  else if (player1.equals(Options.Paper) && player2.equals(Options.Rock)) {
				
				foundMatch.setPlayer1Score(foundMatch.getPlayer1Score() + 1);
			
			}  else {
				
				foundMatch.setPlayer1Score(foundMatch.getPlayer1Score() + 1);
			
			} 
			
			foundMatch.setIsWaiting(false);
			
			foundMatch.setPlayer1Option(null);
			foundMatch.setPlayer2Option(null);

		}
		
		MatchEntity savedMatch = matchDao.save(foundMatch);		
		foundRoom.setMatches(savedMatch);
		roomDao.save(foundRoom);
		
		MatchModel returnValue = modelMapper.map(savedMatch, MatchModel.class);
		
		return returnValue;
	}

}
