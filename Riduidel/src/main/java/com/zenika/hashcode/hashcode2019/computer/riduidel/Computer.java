package com.zenika.hashcode.hashcode2019.computer.riduidel;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import com.zenika.hashcode.hashcode2019.input.Input;
import com.zenika.hashcode.hashcode2019.input.Picture;
import com.zenika.hashcode.hashcode2019.output.Slideshow;

public class Computer {
	private static class ByScoreComparator implements Comparator<Slideshow>{

		@Override
		public int compare(Slideshow o1, Slideshow o2) {
			o1.score();
			return 0;
		}
		
	}

	public Slideshow compute(Input inputStructure) {
		Collection<Slideshow> solutions = new TreeSet<Slideshow>(new ByScoreComparator());
		for (Picture p : inputStructure.pictures) {
			
		}
	}

}
