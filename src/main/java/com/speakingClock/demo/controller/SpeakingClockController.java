package com.speakingClock.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.speakingClock.demo.service.SpeakingClockService;


@RestController
public class SpeakingClockController {

	private final SpeakingClockService speakingClockService;

    public SpeakingClockController(SpeakingClockService speakingClockService) {
        this.speakingClockService = speakingClockService;
    }
	
	@GetMapping("/wordTime/{time}")
	public ResponseEntity<String> timeInWords(@PathVariable String time) {
		try {
			speakingClockService.validTime(time);
		}
		catch (Exception ex)
		{
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
        return ResponseEntity.status(HttpStatus.OK).body(speakingClockService.solve());
		
	}
	
	
	@GetMapping("/clock/{time}")
	public ResponseEntity<String> timeInDayNight(@PathVariable String time) {
		try {
			speakingClockService.validTime(time);
		}
		catch (Exception ex)
		{
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
        return ResponseEntity.status(HttpStatus.OK).body(speakingClockService.findDayNight());
		
	}
	
}
