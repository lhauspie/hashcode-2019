package com.zenika.hashcode.hashcode2019.output;

import com.zenika.hashcode.hashcode2019.input.Picture;

public class VerticalSlide implements Slide {
	private final Picture first;
	private final Picture second;
	public VerticalSlide(Picture first, Picture second) {
		super();
		this.first = first;
		this.second = second;
	}
	public String toFile() {
		return first.index+ " "+second.index;
	}
}
