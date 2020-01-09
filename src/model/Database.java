package model;
// model/Database.java
/**********************************************
 *  P8 Admin Database.java
 **********************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import model.Host;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Database {
	private static Connection con;

	public void Connect() {
		try {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setServerName("198.57.240.40");
			ds.setPortNumber(3306);
			ds.setDatabaseName("dcolombo_p8rallyAdmin");
			ds.setUser("dcolombo_p8admin");
			ds.setPassword("PR0mans1212!");
			ds.setServerTimezone("Atlantic/South_Georgia");

			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void oldConnect() throws Exception {
		// we don't want to connect if we are alredy connected...
		if (con != null)
			return;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}
		// this following line was researched to configure the timzone error thrown when
		// using generic/basic connection string.
		// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		String serverTarget = "jdbc:mysql://198.57.240.40:3306";
		String serverConfig = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String databaseName = "dcolombo_p8rallyAdmin";
		String connectionURL = serverTarget + "/" + databaseName + serverConfig;
		String userName = "dcolombo_p8admin";
		String userPassword = "PR0mans1212!";
		con = DriverManager.getConnection(connectionURL, userName, userPassword);

		System.out.println("CONNECTED: " + con);

	}

	public void listRegistrars(String state) throws SQLException {
		String getSQL = "SELECT * from Host ORDER by ChurchState, ChurchCity";
		PreparedStatement ps = con.prepareStatement(getSQL);

		ResultSet rset = ps.executeQuery();
		rset.next();

		int regCount = rset.getInt(1);
		System.out.println("We have " + regCount + " " + state + " Georgia registrars.");
		ps.close();
	}

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("cannot close connection");
			}
		}
	}

	public void listHosts() {
		try {
			if (con != null)
				return;
			this.Connect();
			String getSQL = "SELECT  ID, ChurchName, ChurchCity, ChurchState from Host ORDER BY ChurchState, ChurchCity";
			PreparedStatement ps = con.prepareStatement(getSQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " " + rs.getString(2) + " - " + rs.getString(3) + ", " + rs.getString(4));
			}

			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getRegistrarTotals() {
		System.out.println("Running database test");

		try {
			this.Connect();
			this.listRegistrars("GA");
			this.listRegistrars("FL");

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.disconnect();
	}

	public ArrayList<Host> getHostArray() {
		// this funciton fills an ArrayList with the host info
		ArrayList<Host> host = new ArrayList<Host>();
//		Host h = new Host(null, null, null, null, null, null, null, null);
		try {
			this.Connect();
			String getSQL = "SELECT ID, ChurchName, ChurchStreet, ChurchCity, ChurchState, ChurchPostalCode, ContactName, ContactEmail, ContactPhone from Host ORDER BY ChurchState, ChurchCity";
			PreparedStatement ps = con.prepareStatement(getSQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Host h = new Host(null, null, null, null, null, null, null, null);
				h.setChurchName(rs.getString(2));
				h.setChurchStreet(rs.getString(3));
				h.setChurchCity(rs.getString(4));
				h.setChurchState(rs.getString(5));
				h.setChurchPostalCode(rs.getString(6));
				h.setContactName(rs.getString(7));
				h.setContactEmail(rs.getString(8));
				h.setContactPhone(rs.getString(9));
				host.add(h);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return host;
	}
}
