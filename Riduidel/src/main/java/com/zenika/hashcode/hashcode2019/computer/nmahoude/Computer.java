package com.zenika.hashcode.hashcode2019.computer.nmahoude;

import java.util.Collection;
import java.util.Random;

import com.zenika.hashcode.hashcode2019.input.Input;
import com.zenika.hashcode.hashcode2019.input.Picture;
import com.zenika.hashcode.hashcode2019.output.HorizontalSlide;
import com.zenika.hashcode.hashcode2019.output.Slide;
import com.zenika.hashcode.hashcode2019.output.Slideshow;
import com.zenika.hashcode.hashcode2019.output.VerticalSlide;

public class Computer extends com.zenika.hashcode.hashcode2019.computer.Computer{
  private static final Picture[] PICTURE = new Picture[0];
  public static Random rand = new Random(0) ; //ThreadLocalRandom.current();
  private long maxScore = -1;
  private Slideshow bestSS = null;
  
  public Slideshow compute(Input inputStructure) {
    Slideshow bestSS = new Slideshow();
    bestSS.getSlides().add(new HorizontalSlide(inputStructure.pictures.get(0)));
    bestSS.getSlides().add(new HorizontalSlide(inputStructure.pictures.get(3)));
    bestSS.getSlides().add(new VerticalSlide(inputStructure.pictures.get(1), inputStructure.pictures.get(2)));
    
    System.out.println("BEST SCORE EVER " + bestSS.score());
    
    long start = System.currentTimeMillis();
    while (System.currentTimeMillis() - start < 5*60*100) {
      Collection<Picture> vertical = inputStructure.getVertical();
      Collection<Picture> horizontal = inputStructure.getHorizontal();

      Slideshow ss = new Slideshow();
      while (! (horizontal.isEmpty() && vertical.isEmpty())) {
        Slide slide;
        boolean choice = rand.nextBoolean();
        if (choice && vertical.isEmpty()) choice = false;
        if (!choice && horizontal.isEmpty()) choice = true;
        
        if (choice) {
          Picture first  = vertical.toArray(PICTURE)[rand.nextInt(vertical.size()-1)];
          vertical.remove(first);
          Picture second;
          if (vertical.size() == 1) {
            second = vertical.toArray(PICTURE)[0];
          } else {
            second = vertical.toArray(PICTURE)[rand.nextInt(vertical.size()-1)];
          }
          vertical.remove(second);
          
          slide = new VerticalSlide(first, second);
        } else {
          Picture first;
          if (horizontal.size() == 1) {
            first = horizontal.toArray(PICTURE)[0];
          } else {
            first = horizontal.toArray(PICTURE)[rand.nextInt(horizontal.size()-1)];
          }
          horizontal.remove(first);
          slide = new HorizontalSlide(first);
        }
        ss.getSlides().add(slide);
      }
      long score = ss.score();
      System.out.println("Score : "+score);
      if (score > maxScore) {
        maxScore = score;
        bestSS = ss;
      }
    }
    
    
    return bestSS;
  }
}
