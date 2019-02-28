package com.zenika.hashcode.hashcode2019.input;

import java.util.Collection;
import java.util.LinkedList;

public class Input {
	private Collection<Picture> pictures = new LinkedList<Picture>();
	public void addPictureFrom(String string) {
		String[] data = string.split(" ");
		Picture newPicture = new Picture();
		newPicture.orientation = Orientation.valueOf(data[0]);
		for (int i = 2; i < data.length; i++) {
			newPicture.tags.add(data[i]);
		}
		pictures.add(newPicture);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Input [pictures=");
		for (Picture picture : pictures) {
			builder.append(picture).append("\n");
		}
		builder.append("]");
		return builder.toString();
	}
	
}