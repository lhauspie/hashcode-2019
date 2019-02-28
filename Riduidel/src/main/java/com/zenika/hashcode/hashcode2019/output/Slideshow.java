package com.zenika.hashcode.hashcode2019.output;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Slideshow {
	public Collection<Slide> slides = new ArrayList<Slide>();
	private long score = -1;

	public String toFile() {
		StringBuilder sOut = new StringBuilder();
		sOut.append(slides.size()).append("\n");
		for(Slide s : slides) {
			sOut.append(s.toFile()).append("\n");
		}
		return sOut.toString();
	}

	public long score() {
		if(score<0) {
			score = computeScore();
		}
		return score;
	}

	private long computeScore() {
		long score = 0;
		Slide previous = null;
		Iterator<Slide> iter = slides.iterator();
		while(iter.hasNext()) {
			Slide s = iter.next();
			if(previous!=null) {
				score = previous.score(s);
			}
			previous = s;
		}
		return score;
	}
}
