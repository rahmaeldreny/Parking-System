/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author Essra
 */
import java.sql.*;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
//import java.util.GregorianCalendar;
public class db {

    Connection c;
    Statement st;
    SimpleDateFormat entry_time;
    SimpleDateFormat exit_time;
    Date date;
//        GregorianCalendar date=new GregorianCalendar();
//        String time =date.get(Calendar.HOUR_OF_DAY)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
//        String d=""+(date.get(Calendar.YEAR))+"-"+(date.get(Calendar.MONTH))+"-"+date.get(Calendar.DAY_OF_WEEK);
    public db() {
        try {
            String ConnectionUrl = "jdbc:sqlserver://localhost\\DESKTOP-I67E0V8\\SQLEXPRESS:1433;databaseName=parking" + ";username=sa" + ";password=12345";
            c = DriverManager.getConnection(ConnectionUrl);
            st = c.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ResultSet Login(String Name, String Pass) throws SQLException {
        String sql = "Select role_id from users where username='" + Name + "' and password = '" + Pass + "'";
        return st.executeQuery(sql);
        
    }
    public void add(operator plate,Date date,SimpleDateFormat entry_time) throws SQLException  {
            this.entry_time=entry_time;
            this.date=date;
       String sql ="insert into tickets(plat_number,date,entry_time) values ('" + plate.getPlate_number() +"','"+date+"','"+entry_time.format(date)+"');";
         st.executeUpdate(sql);
    }
    public ResultSet veiwSpots() throws SQLException {
        String sql= "select * from spots order by spot_name asc";
        return st.executeQuery(sql);
    }
    public void exit(int ticket_id,Date date,SimpleDateFormat exit_time) throws SQLException  {
     this.exit_time=exit_time;
        this.date=date;
        
        String sql="update tickets set exit_time='"+exit_time.format(date)+"' where ticket_id='"+ticket_id+"';";
          st.executeUpdate(sql);
    }
    
     public void setSpot(int room,String status) throws SQLException  {
         String sql="insert into spots values('"+room+"','"+status+"');";
          st.executeUpdate(sql);
     }
     public void removeSpot(int room) throws SQLException  {
         String sql="delete from spots where spot_name ="+room+";";
          st.executeUpdate(sql);
     }
     public ResultSet veiwTicket() throws SQLException {
        String sql= "select * from tickets ";
        return st.executeQuery(sql);
    }
     public ResultSet payment() throws SQLException {
        String sql= "select ticket_id,price_cost from tickets ";
        return st.executeQuery(sql);
    }
    public void editSpot(int room,String status) throws SQLException  {
         String sql="update spots set spot_statue= '"+status+"' where spot_name='"+room+"';";
          st.executeUpdate(sql);
     }
    

    public void CloseConnection() throws SQLException {
        st.close();
        c.close();
    }
 
    
}
