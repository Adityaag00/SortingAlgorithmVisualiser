package projectalgorithmsortingvisualiaser.auth;

import projectalgorithmsortingvisualiaser.LeaderboardDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnToDB {

	private Connection connect = null;
	private Statement statement = null;
	// private PreparedStatement prep = null;
	private ResultSet res = null;
	HashMap<String,User> hashmap = new HashMap<>();
	public static User user;
	
	public ConnToDB(String choice) {
		
		if (choice.equalsIgnoreCase("for Login")) {
			this.config("person_DB","root","tiger");
			this.selectToLogin();
		}
		else
			this.config("person_DB","root","tiger");
		
	}
	
	private void config (String dbName,String dbUsername,String dbPassword) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"+ dbName +"?user="+ dbUsername +"&password="+ dbPassword +"");
			statement = connect.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void selectToLogin () {

		try {
			String sqll = "select * from person";
			res = statement.executeQuery(sqll);
			while (res.next()) {
				String email = res.getString("Email");
				String passwd = res.getString("Password");
				String firstName = res.getString("f_name");
				String lastName = res.getString("l_name");
				user = new User(firstName,lastName,email,passwd);
				hashmap.put(email,user);
			}
			connect.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void insertData (String fname,String lname,String email,String passwd) {
		try {
			String sqll = "insert into person (f_name,l_name,Email,Password) values ('"+ fname +"','"+ lname +"','"+ email +"','"+ passwd +"')";
			connect.prepareStatement(sqll).executeUpdate();
			
			connect.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateLeaderBoard(String email) {
		try {
			String sql ="insert into leaderboard values (\""+email+"\",1) " +
					"on duplicate key update " +
					"score = score+1";
			connect.prepareStatement(sql).executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List<LeaderboardDTO> getLeaderBoard() {
		String sql = "select * from leaderboard order by score desc";
		List<LeaderboardDTO> list = new ArrayList<>();
		selectToLogin();
		try {
			this.config("person_DB","root","tiger");
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				LeaderboardDTO leaderboardDTO = new LeaderboardDTO();
				leaderboardDTO.setScore(res.getInt("score"));
				leaderboardDTO.setEmail(res.getString("email"));
				User temp = hashmap.get(leaderboardDTO.getEmail());
				System.out.println(hashmap.get(leaderboardDTO.getEmail()));
				leaderboardDTO.setName(temp.getFirstName()+" "+temp.getLastName());
				list.add(leaderboardDTO);
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	void updateData () {
		try {
			String sqll = "";
			connect.prepareStatement(sqll).executeUpdate();

			connect.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	void deleteData () {

		try {
			String sqll = "";
			connect.prepareStatement(sqll).executeUpdate();
			
			connect.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
