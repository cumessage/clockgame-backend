package com.prosper.clockgame.service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.service.GameService;
import com.prosper.clockgame.service.view.GameView;
import com.prosper.clockgame.service.view.View;

@Controller
@RequestMapping(value="/game")
public class GameController { 
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public View create(@RequestBody Map<String, String> requestMap) { 
		long time = Long.parseLong(requestMap.get("time"));
		long userId = Long.parseLong(requestMap.get("userId"));
		int templateId = Integer.parseInt(requestMap.get("templateId"));
		// TODO validate time&userid
		gameService.create(time, userId, templateId);
		return new View();
	}
	
	@RequestMapping(value="/{gameId}/member", method=RequestMethod.POST)
	@ResponseBody
	public View join(
			@PathVariable("gameId") long gameId,
			@RequestBody Map<String, String> requestMap) {
		long userId = Long.parseLong(requestMap.get("userId"));
		// TODO validate userid
		gameService.join(gameId, userId);
		return new View();
	}
	
	@RequestMapping(value="/{gameId}/member", method=RequestMethod.DELETE)
	@ResponseBody
	public View quit(
			@PathVariable("gameId") long gameId,
			@RequestBody Map<String, String> requestMap) { 
		long userId = Long.parseLong(requestMap.get("userId"));
		// TODO validate userid
		gameService.quit(gameId, userId);
		return new View();
	}
	
	@RequestMapping(value="/{gameId}/info", method=RequestMethod.GET)
	@ResponseBody
	public View getInfo(
			@PathVariable("gameId") long gameId) {
		// TODO validate gameId
		Game game = gameService.getInfo(gameId);
		return new GameView(game);
	}
	
	@RequestMapping(value="/{gameId}/result", method=RequestMethod.GET)
	@ResponseBody
	public View getResults(
			@PathVariable("gameId") long gameId) { 
		// TODO 
		return new View();
	}
	
	@RequestMapping(value="/{gameId}/result/{userid}", method=RequestMethod.POST)
	@ResponseBody
	public View postResult(
			@PathVariable("gameId") long gameId,
			@PathVariable("userid") long userId) { 
		// TODO 
		return new View();
	}
	
}
