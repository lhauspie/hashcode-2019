package com.zenika.hashcode.hashcode2019.output;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.zenika.hashcode.hashcode2019.input.Picture;

public class VerticalSlide extends AbstractSlide implements Slide {
	private final Picture first;
	private final Picture second;
	private Set<String> tags = null;
	public VerticalSlide(Picture first, Picture second) {
		super();
		this.first = first;
		this.second = second;
	}
	public String toFile() {
		return first.index+ " "+second.index;
	}
	public Set<String> tags() {
		if(tags==null) {
			tags = new TreeSet<String>();
			tags.addAll(first.tags);
			tags.addAll(second.tags);
			tags = Collections.unmodifiableSet(tags);
		}
		return tags;
	}
	
}
