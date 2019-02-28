package com.zenika.hashcode.hashcode2019;

import java.util.ArrayList;
import java.util.Collection;

public class Slideshow {
	public Collection<Slide> slides = new ArrayList<Slide>();

	public String toFile() {
		StringBuilder sOut = new StringBuilder();
		sOut.append(slides.size()).append("\n");
		for(Slide s : slides) {
			sOut.append(s.toFile()).append("\n");
		}
		return sOut.toString();
	}
}
