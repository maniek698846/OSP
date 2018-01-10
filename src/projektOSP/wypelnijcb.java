package projektOSP;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JFrame;


public class wypelnijcb extends JFrame {

	private static final long serialVersionUID = 4L;

	public static void wypComboBox(JComboBox<String> comboBoxName2) {
		Connection connection=sqliteConnection.dbConnector();

		try {
			
			String query="select distinct Imie, Nazwisko from zaloga ORDER BY Nazwisko, Imie ASC";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();		
			while(rs.next())
			{
				comboBoxName2.addItem(rs.getString("Imie")+" "+rs.getString("Nazwisko"));		
			}
			
		}catch(Exception exc)
		{
			exc.printStackTrace();		 
		}
		
	}
	
	public static void wypComboBoxKier(JComboBox<String> comboBoxName2) {
		Connection connection=sqliteConnection.dbConnector();

		try {
			String kierowcaQuery = "tak";
			String query="select distinct Imie, Nazwisko from zaloga where kierowca=? ORDER BY Nazwisko, Imie ASC";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setString(1,  kierowcaQuery);
			ResultSet rs=pst.executeQuery();		
			while(rs.next())
			{
				comboBoxName2.addItem(rs.getString("Imie")+" "+rs.getString("Nazwisko"));		
			}
			
		}catch(Exception exc)
		{
			exc.printStackTrace();		 
		}
		
	}
	
}


