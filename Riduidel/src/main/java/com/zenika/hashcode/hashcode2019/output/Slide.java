package com.zenika.hashcode.hashcode2019.output;

import java.util.Set;
import java.util.TreeSet;

public interface Slide {

	String toFile();
	Set<String> tags();
	long score(Slide other);
	String getId();
}
