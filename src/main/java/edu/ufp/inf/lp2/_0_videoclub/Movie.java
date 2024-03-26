package edu.ufp.inf.lp2._0_videoclub;

import java.util.ArrayList;
import java.util.List;

public class Movie {

  private String title;

  private int year;
    /**
    * 
    *
   */
  public List<Actor> actors = new ArrayList();
    /**
    * 
    *
   */
  public List<Genre> genres = new ArrayList();

  public Genre addGenre(Genre g) {
  return null;
  }

  public Genre deleteGenre(Genre g) {
  return null;
  }

  public ArrayList<Genre> listGenres() {
  return null;
  }

  public Actor addActor(Actor a) {
  return null;
  }

  public Actor deleteActor(Actor a) {
  return null;
  }

  public ArrayList<Actor> listActors() {return null;}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}