package com.speakingClock.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.speakingClock.demo.service.SpeakingClockService;


@SpringBootTest
class DemoApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	
	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenEnteredLettersInsteadOfIntegers_thenShouldReturnException() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("You need to pass a valid 24 hour format hour");
        SpeakingClockService speakingClock = new SpeakingClockService("12:aa");
        speakingClock.solve();
    }

    @Test
    public void whenEnteredSemicolonInsteadOfColon_thenShouldReturnException() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("You need to pass a valid 24 hour format hour");
        SpeakingClockService speakingClock = new SpeakingClockService("12;13");
        speakingClock.solve();
    }

    @Test
    public void whenEnteredMidday_thenShouldReturnItsMidday() {
        SpeakingClockService speakingClock = new SpeakingClockService("12:00");
        speakingClock.findDayNight();
        assertEquals("It's Midday", speakingClock.getResult());
    }

    @Test
    public void whenEnteredMidnight_thenShouldReturnItsMidnight() {
        SpeakingClockService speakingClock = new SpeakingClockService("24:00");
        speakingClock.findDayNight();
        assertEquals("It's Midnight", speakingClock.getResult());
    }

    @Test
    public void whenEnteredTwelveFifty_thenShouldReturnItsTwelveFifty() {
        SpeakingClockService speakingClock = new SpeakingClockService("12:50");
        speakingClock.solve();
        assertEquals("It's twelve fifty ", speakingClock.getResult());
    }

    @Test
    public void whenEnteredOne_thenShouldReturnItsOne() {
        SpeakingClockService speakingClock = new SpeakingClockService("13:00");
        speakingClock.solve();
        assertEquals("It's one oh", speakingClock.getResult());
    }

    @Test
    public void whenEnteredTwoOhSix_thenShouldReturnItsTwoOhSix() {
        SpeakingClockService speakingClock = new SpeakingClockService("14:06");
        speakingClock.solve();
        assertEquals("It's two oh six ", speakingClock.getResult());
    }

    @Test
    public void whenEnteredFiveFifteen_thenShouldReturnItsFiveFifteen() {
        SpeakingClockService speakingClock = new SpeakingClockService("17:15");
        speakingClock.solve();
        assertEquals("It's five fifteen ", speakingClock.getResult());
    }

}
