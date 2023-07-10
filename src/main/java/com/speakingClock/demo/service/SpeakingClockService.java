package com.speakingClock.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
@Component
public class SpeakingClockService {
	 	private int hours = 0;
	    private int minutes = 0;
	    private String result;

	    private static final String[] TENS = {
	            "oh ", "", "twenty ", "thirty ", "forty ", "fifty "
	    };

	    private static final String[] ONES = {
	            "twelve ", "one ", "two ", "three ", "four ", "five ",
	            "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
	            "twelve ", "thirteen ", "fourteen ", "fifteen ",
	            "sixteen ", "seventeen ", "eighteen ", "nineteen ","twentyone","twentytwo","twentythree","twentyfour"
	    };

	    public SpeakingClockService() {
	    	
	    }
	    
	    public SpeakingClockService(String hour) {
	    	 try {
	             hour.trim().split(":");
	         } catch (NumberFormatException e) {
	             throw new NumberFormatException("Pass a valid 24 hour format hour");
	         }

	         String[] hours = hour.trim().split(":");

	         try {
	             Integer.parseInt(hours[0]);
	             Integer.parseInt(hours[1]);
	         } catch (NumberFormatException e) {
	             throw new NumberFormatException("Pass a valid 24 hour format hour");
	         }

	         this.hours = Integer.parseInt(hours[0]);
	         this.minutes = Integer.parseInt(hours[1]);
	         this.result = "";
	     }

		public int getHours() {
	        return hours;
	    }

	    public int getMinutes() {
	        return minutes;
	    }

	    public String getResult() {
	        return result;
	    }

	    public void setResult(String result) {
	        this.result = result;
	    }

	    /**
	     * Initializes a newly created {@code SpeakingClock} object so that initializes
	     * the hours, minutes and result.
	     *
	     * @param  hour the initial string hour entered.
	     */
	    public void validTime(String hour) {

	        try {
	            hour.trim().split(":");
	        } catch (NumberFormatException e) {
	            throw new NumberFormatException("Pass a valid 24 hour format hour");
	        }

	        String[] hours = hour.trim().split(":");

	        try {
	            Integer.parseInt(hours[0]);
	            Integer.parseInt(hours[1]);
	        } catch (NumberFormatException e) {
	            throw new NumberFormatException("Pass a valid 24 hour format hour");
	        }

	        this.hours = Integer.parseInt(hours[0]);
	        this.minutes = Integer.parseInt(hours[1]);
	        this.result = "";
	    }
	    
	    
	    
	    

	    /**
	     * Calls the method {@link #convertToWords} in order to convert the {@code int}
	     * hours and minute and prints it in words.
	     */
	    public String solve() {

	        String hourInWords = convertToWords(this.getHours(), this.getMinutes());

	        if (hourInWords.equals("")) {
	            return "It was not possible to convert the hour passed to words";
	        } else {
	            this.setResult(hourInWords);
	            return hourInWords;
	            //printResult();
	        }
	    }
	    
	    
	    /**
	     * Calls the method {@link #convertToWords} in order to convert the {@code int}
	     * hours and prints it in if it is midday or midnight.
	     */
	    public String findDayNight()
	    {
	    	StringBuilder result = new StringBuilder();

	        if (this.getMinutes() == 0) {

	            if (this.getHours() == 12) {
	                 result.append("It's Midday");
	            }

	            if (this.getHours() == 24) {
	                 result.append("It's Midnight");
	            }
	            
	            if (this.getHours() != 24 && this.getHours() != 12)
		        {
	            	result.append("Pass valid hour to check Mid Day/Night");
		        }

	            //result.append("It's ").append(ONES[this.getHours() % 12]).toString();

	        }
	        else
	        {
	        	return "Pass valid hour to check Mid Day/Night";
	        }
	        this.result= result.toString();
	        return result.toString();
	    }

	    /**
	     * Converts given a {@code int} hour and minutes to a hour in words.
	     *
	     * @param hour      {@code int} hour
	     * @param minutes   {@code int} minutes
	     * @return          the {@code String} hour
	     */
	    private String convertToWords(int hour, int minutes) {

	        StringBuilder result = new StringBuilder();

	       /* if (this.getMinutes() == 0) {

	            if (this.getHours() == 12) {
	                return result.append("It's ").append(ONES[hour % 12]).toString();
	            }

	            if (this.getHours() == 24) {
	                return result.append("It's ").append(ONES[hour % 12]).toString();
	            }


	        } else*/ if (minutes % 10 == 0) {
	            result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]);
	        } else if (minutes < 10 || minutes > 20) {
	            result.append("It's ").append(ONES[hour % 12]).append(TENS[minutes / 10]).append(ONES[minutes % 10]);
	        } else {
	            // minutes > 10 && minutes < 20
	            result.append("It's ").append(ONES[hour % 12]).append(ONES[minutes]);
	        }
	        
	        return result.toString();
	    }

	    /**
	     * Prints the result of {@code SpeakingClock} class.
	     */
	    private void printResult() {
	        System.out.println(this.getResult());
	    }
}
