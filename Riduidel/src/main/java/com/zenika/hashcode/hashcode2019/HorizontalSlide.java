package com.zenika.hashcode.hashcode2019;

import com.zenika.hashcode.hashcode2019.input.Picture;

public class HorizontalSlide implements Slide {
	private final Picture picture;

	public HorizontalSlide(Picture picture) {
		super();
		this.picture = picture;
	}

	public String toFile() {
		return picture.index+"";
	}
}
