package com.voya.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	@Autowired
	private IInstrument violin;
	
	@Autowired
	private IInstrument keyboard;
	
	@Autowired
	private IInstrument guitar;
	
	void playMusic(String choice, String song) {
		if(choice.equals("v")) {
			violin.play(song);
		}
		if(choice.equals("k")) {
			keyboard.play(song);
		}
		if(choice.equals("g")) {
			guitar.play(song);
		}
	}
}
