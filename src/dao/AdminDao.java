package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AdminModel;
import utility.ConnectionManager;
public class AdminDao extends GetConnection{

	   Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}
		////////Insert/////

		
		public void storeAdminRecord(ArrayList<AdminModel> adminlist) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String INSERT = "INSERT  INTO theater(MovieId,MovieName,ActorName,ActressName,TheaterName,Location,Time) values(?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = dbConn.prepareStatement(INSERT);
				for(AdminModel admin:adminlist) {
					ps.setInt(1, admin.getMovieId());
					ps.setString(2, admin.getMovieName());
					ps.setString(3, admin.getActorName());
					ps.setString(4, admin.getActressName());
					ps.setString(5, admin.getTheaterName());
					ps.setString(6, admin.getLocation());
					ps.setString(7, admin.getTime());
					ps.executeUpdate();
					System.out.println(" Record Added Sucessfully");
				}
				
			}catch (SQLException e) {
				System.out.println("Failed");
			}
		}
    ///////view customer //////

		public void ViewAdminModel() throws ClassNotFoundException {
			dbConn = getDbConnection();
			String VIEW = "SELECT * FROM theater";
			try {
			Statement stmt =  dbConn.createStatement();
			 ResultSet rs = ((java.sql.Statement) stmt).executeQuery(VIEW);
			 System.out.println("MovieId,Movie_Name,ActorName,ActressName,TheaterName,Location,Time");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			 } 
			 }catch(SQLException e) {
				 System.out.println("Failed to view");
			 }
			}
   ////////Update/////////

		public void UpdateAdminModel(int update, int updateMovieId, String newMovieName) throws ClassNotFoundException {
		
			dbConn = getDbConnection();
			String UPDATE = null;
			if(update ==1)
				UPDATE = "UPDATE theater SET MovieName = ? WHERE MovieId=?";
			else if(update == 2)
				UPDATE = "UPDATE theater SET ActorName = ? WHERE MovieId=?";
			else if(update == 3)
				UPDATE = "UPDATE theater SET ActressName = ? WHERE MovieId=?";
			else if(update == 4)
				UPDATE = "UPDATE theater SET TheaterName = ? WHERE MovieId=?";
			else if(update == 5)
				UPDATE = "UPDATE theater SET Location = ? WHERE MovieId=?";
			else if(update == 6)
				UPDATE = "UPDATE theater SET Time = ? WHERE MovieId=?";

          try {
        	  PreparedStatement ps = dbConn.prepareStatement(UPDATE);
	
			ps.setString(1,newMovieName);
        	  ps.setInt(2, updateMovieId);
        	  int result = ps.executeUpdate();
        	  if(result==1) {
        		  System.out.println("Record Upadted");
        	  }
        	  
          }catch(SQLException e) {
    		  System.out.println("Fail to Upadte");

          }


		}
///////////Delete/////////

		public void DeleteAdminModel(int deleteMovieId) throws ClassNotFoundException {
			dbConn = getDbConnection();
		String DELETE = "DELETE FROM theater WHERE MovieId = "+ deleteMovieId;
		
			try {
				Statement stmt =dbConn.createStatement();
				int RowAffected = stmt.executeUpdate(DELETE);
				System.out.println("Rows Affected :"+RowAffected);
				System.out.println("Record deleted Sucessfully");

			}catch(SQLException e) {
				System.out.println("\n Failed to delete the Record");
                e.printStackTrace();
			}
		}
		}

	
     
	