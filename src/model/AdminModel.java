package model;

public class AdminModel{
	
	private int MovieId;
	private String MovieName,ActorName,ActressName,TheaterName,Location,Time;
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminModel(int movieId, String movieName, String actorName, String actressName, String theaterName,
			String location,String time) {
		super();
		MovieId = movieId;
		MovieName = movieName;
		ActorName = actorName;
		ActressName = actressName;
		TheaterName = theaterName;
		Location = location;
		Time = time;
	}
	public int getMovieId() {
		return MovieId;
	}
	public void setMovieId(int movieId) {
		MovieId = movieId;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getActorName() {
		return ActorName;
	}
	public void setActorName(String actorName) {
		ActorName = actorName;
	}
	public String getActressName() {
		return ActressName;
	}
	public void setActressName(String actressName) {
		ActressName = actressName;
	}
	public String getTheaterName() {
		return TheaterName;
	}
	public void setTheaterName(String theaterName) {
		TheaterName = theaterName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getTime() {
		return Time;
	}
	
}