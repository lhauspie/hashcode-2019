package com.zenika.hashcode.hashcode2019.output;

import java.util.Collections;
import java.util.Set;

import com.zenika.hashcode.hashcode2019.input.Picture;

public class HorizontalSlide extends AbstractSlide implements Slide {
	private final Picture picture;
	
	private Set<String> tags;

	public HorizontalSlide(Picture picture) {
		super();
		this.picture = picture;
		tags = Collections.unmodifiableSet(picture.tags);
	}

	public String toFile() {
		return picture.index+"";
	}

	public Set<String> tags() {
		return tags;
	}
}
