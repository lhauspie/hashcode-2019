package com.zenika.hashcode.hashcode2019.computer.riduidel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.zenika.hashcode.hashcode2019.input.Input;
import com.zenika.hashcode.hashcode2019.input.Picture;
import com.zenika.hashcode.hashcode2019.output.HorizontalSlide;
import com.zenika.hashcode.hashcode2019.output.Slideshow;

public class Computer {
	public static class ByScoreComparator implements Comparator<Slideshow> {

		@Override
		public int compare(Slideshow o1, Slideshow o2) {
			return (int) (o2.score()-o1.score());
		}
		
	}
	public Slideshow compute(Input inputStructure) {
		return compute(inputStructure.pictures);
	}

	private Slideshow compute(List<Picture> pictures) {
		Collection<Slideshow> slideshows = generate(new Slideshow(), pictures);
		Set<Slideshow> sorted = new TreeSet<>(new ByScoreComparator());
		sorted.addAll(slideshows);
		return sorted.iterator().next();
	}

	private Collection<Slideshow> generate(Slideshow parent, List<Picture> pictures) {
		Collection<Slideshow> returned = new ArrayList<>();
		if(pictures.isEmpty()) {
			returned.add(parent);
		} else {
			for(Picture p : pictures) {
				List<Picture> others = new ArrayList<>();
				others.addAll(pictures);
				others.remove(p);
				returned.addAll(generate(createSlideshowWith(parent, p), others));
			}
		}
		return returned;
	}

	private Slideshow createSlideshowWith(Slideshow s, Picture p) {
		Slideshow returned = new Slideshow();
		returned.slides.addAll(s.slides);
		returned.slides.add(new HorizontalSlide(p));
		return returned;
	}

}
