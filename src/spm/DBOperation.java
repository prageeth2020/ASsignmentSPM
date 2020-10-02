/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author PIYUMI
 */
public class DBOperation {
    String url = "jdbc:mysql://localhost:3306/spm";
    String username = "root";
    String password = "root";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st;
    private ResultSet dataSet = null;

    public static Connection connect(){
        
        Connection con=null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "root");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return con;
        
    }
    
    public String maxSesionID() {
        String ID = null;
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            
            String sql1 = "select MAX(id) from sessions";
            PreparedStatement statement1 = con.prepareStatement(sql1);
            
            rs = statement1.executeQuery();
            
            
            while(rs.next())
            {
                ID = String.valueOf(rs.getInt(1));
                
            }
            int ID2 = Integer.valueOf(ID);
            ID2 = ID2 + 1;
            
            ID = String.valueOf(ID2);
            
            return ID;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }
       
    public ResultSet getLecturers() {
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM lecturers";
            pst = (PreparedStatement) con.prepareStatement(query);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getTagsForSession() {
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getSebjects() {
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM subjects";
            pst = (PreparedStatement) con.prepareStatement(query);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getSubCode(String s) {
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM subjects where Subjectname = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, s);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getStudents() {
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM student";
            pst = (PreparedStatement) con.prepareStatement(query);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
     public ResultSet getSessions() {
        try {
            ResultSet rs = null ;
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sessions";
            pst = (PreparedStatement) con.prepareStatement(query);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     
    //Add Student Details
    boolean addSubject(Subject s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into student values (?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getSid());
            pst.setString(2, s.getAcademicYear());
            pst.setString(3, s.getSemester());
            pst.setString(4, s.getProgram());
            pst.setString(5, s.getGroupNo());
            pst.setString(6, s.getSubGroupNo());
            pst.setString(7, s.getAcademicYear()+ "." + s.getSemester() + "." + s.getProgram() + "." + s.getGroupNo());
            pst.setString(8, s.getAcademicYear()+ "." + s.getSemester() + "." + s.getProgram() + "." + s.getGroupNo() + "." + s.getSubGroupNo());

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
    
    //Get all Student Details
    ArrayList<Subject> getSubjects() {
        try {
            ArrayList<Subject> list = new ArrayList<Subject>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM student";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Subject s = new Subject();
                s.setSid(rs.getInt(1));
                s.setAcademicYear(rs.getString(2));
                s.setSemester(rs.getString(3));
                s.setProgram(rs.getString(4));
                s.setGroupNo(rs.getString(5));
                s.setSubGroupNo(rs.getString(6));
               
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
  
     
     //Execute SQL
     public void executeSQLQuery(String query, String message){
         try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            st = con.createStatement();

            if((st.executeUpdate(query)) == 1){
                JOptionPane.showMessageDialog(null, "Data " +message+" Successfully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not " +message+" Successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
     }
     
     //Add Tag Details
    boolean addTag(Tag t) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into tag values (?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, t.getTid());
            pst.setString(2, t.getTag());
            pst.setString(3, t.getDescription());
           
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
    
    //Get all Tag Details
    ArrayList<Tag> getTags() {
        try {
            ArrayList<Tag> list = new ArrayList<Tag>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Tag t = new Tag();
                t.setTid(rs.getInt(1));
                t.setTag(rs.getString(2));
                t.setDescription(rs.getString(3));
                
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
    ///////DURANKA
        boolean addBuilding(BuildingModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into building values (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            
    

            pst.setInt(1, b.getBid());
            pst.setString(2, b.getbName());
            pst.setString(3, b.getCenter());
            pst.setString(4, b.getLocation());
            pst.setString(5, b.getNoOfFloors());
            pst.setString(6, b.getDepartment());

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
    
    
     ArrayList<BuildingModel> getBuildingDetails() {
        try {
            ArrayList<BuildingModel> list = new ArrayList<BuildingModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM building";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                BuildingModel buildingModel = new BuildingModel();
                buildingModel.setBid(rs.getInt(1));
                buildingModel.setCenter(rs.getString(3));
                buildingModel.setbName(rs.getString(2));
                buildingModel.setLocation(rs.getString(4));
                buildingModel.setNoOfFloors(rs.getString(5));
                buildingModel.setDepartment(rs.getString(6));
               
                list.add(buildingModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
     
      boolean addRoom(AddRoomModel r) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into room values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            
    

            pst.setInt(1, r.getRid());
            pst.setString(2, r.getrName());
            pst.setString(3, r.getRoomType());
            pst.setString(4, r.getFloorNo());
            pst.setString(5, r.getSection());
            pst.setString(6, r.getRoomNo());
             pst.setInt(7, r.getrBid());

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }  
      
      ArrayList<AddRoomModel> getRoomDetails() {
        try {
            ArrayList<AddRoomModel> list = new ArrayList<AddRoomModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM room";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                AddRoomModel addRoomModel = new AddRoomModel();
                addRoomModel.setRid(rs.getInt(1));
                addRoomModel.setrName(rs.getString(2));
                addRoomModel.setRoomType(rs.getString(3));
                addRoomModel.setFloorNo(rs.getString(4));
                addRoomModel.setSection(rs.getString(5));
                addRoomModel.setRoomNo(rs.getString(6));
                addRoomModel.setrBid(rs.getInt(7));
               
                list.add(addRoomModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

      ArrayList<AsubjectStacModel> getSubStac() {
        try {
            ArrayList<AsubjectStacModel> list = new ArrayList<AsubjectStacModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM subjects";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
            
          

            while (rs.next()) {
                AsubjectStacModel asubjectStacModel = new AsubjectStacModel();
                asubjectStacModel.setId(rs.getInt(1));
                asubjectStacModel.setYears(rs.getString(2));
                asubjectStacModel.setSem(rs.getString(3));
                asubjectStacModel.setSubName(rs.getString(4));
                asubjectStacModel.setSubCode(rs.getString(5));
                asubjectStacModel.setLecHr(rs.getString(6));
                asubjectStacModel.setTuteHr(rs.getString(7));
                asubjectStacModel.setLabHr(rs.getString(8));
                 asubjectStacModel.setEvlHr(rs.getString(9));
               
                list.add(asubjectStacModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

 ArrayList<AlecStacModel> getLecStac() {
        try {
            ArrayList<AlecStacModel> list = new ArrayList<AlecStacModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM lecturers";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
          
            while (rs.next()) {
                AlecStacModel alecStacModel = new AlecStacModel();
                alecStacModel.setEmployeeID(rs.getInt(1));
                alecStacModel.setName(rs.getString(2));
                alecStacModel.setFaculty(rs.getString(3));
                alecStacModel.setDept(rs.getString(4));
                alecStacModel.setCenter(rs.getString(5));
                alecStacModel.setBuilding(rs.getString(6));
                alecStacModel.setLevel(rs.getString(7));
                alecStacModel.setLevel(rs.getString(8));
              
               
                list.add(alecStacModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
 
  ArrayList<AstudentStacModel> getStuStac() {
        try {
            ArrayList<AstudentStacModel> list = new ArrayList<AstudentStacModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT program,academicYear,semester ,count(DISTINCT groupNo), COUNT(subGroupNo),COUNT(sid) as NoOFStudent FROM `student`GROUP BY program,academicYear";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                AstudentStacModel astudentStacModel = new AstudentStacModel();
                astudentStacModel.setSprogram(rs.getString(1));
                 astudentStacModel.setAcadamicYear(rs.getString(2));
                astudentStacModel.setSsenester(rs.getString(3));
                astudentStacModel.setNoOfStu(rs.getString(6));
                astudentStacModel.setNoOfGroup(rs.getString(4));
                astudentStacModel.setNoOfSubGroup(rs.getString(5));
                
               
                list.add(astudentStacModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
  
  //Not available times for lecturers
  boolean addNotAvailableTimesForLecturers(NotAvailableTimesForLecturers s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into not_available_times_for_lecturers values (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getName());
            pst.setString(3, s.getOn());
            pst.setString(4, s.getAt());
          
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
  
  //Not available times for groups
  boolean addNotAvailableTimesForLGroups(NotAvailableTimesForGroups s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into not_available_times_for_groups values (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getGroup());
            pst.setString(3, s.getOn());
            pst.setString(4, s.getAt());
          
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }

  
  //Not available times for groups
  boolean addNotAvailableTimesForSubGroups(NotAvailableTimesForSubGroups s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into not_available_times_fo_sub_groups values (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getSubGroup());
            pst.setString(3, s.getOn());
            pst.setString(4, s.getAt());
          
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
  
  //Consecutive Sessions
  boolean addConsecutiveSessions(ConsecutiveSessionsAdd s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into consecutive_sessions values (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getSession1());
            pst.setString(3, s.getSession2());
            pst.setString(4, s.getSession3());
          
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
  
  //Overlapping Sessions
  boolean addOverlappingSessions(OverlappingSessionsAdd s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into overlapping_sessions values (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getSession1());
            pst.setString(3, s.getSession2());
            pst.setString(4, s.getSession3());
            pst.setString(5, s.getSession4());
            pst.setString(6, s.getSession5());
          
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
  
  //Parallel Sessions
  boolean addParallelSessions(ParallelSessionsAdd s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into parallel_session values (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getId());
            pst.setString(2, s.getSession1());
            pst.setString(3, s.getSession2());
            pst.setString(4, s.getSession3());
            pst.setString(5, s.getSession4());
            pst.setString(6, s.getSession5());
          
            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }

  
  
    boolean assignRoomTag(AllocationsModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into allocation values (?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
         
    

            pst.setInt(1, b.getRoomTid());
            pst.setString(2, b.getName());
            pst.setString(3, b.getTag());
            pst.setInt(4, b.getaRid());
            pst.setInt(5, b.getaTid());
           

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
    
    
    ArrayList<Tag> getTagfRoom(String strQUERY) {
        try {
            ArrayList<Tag> list = new ArrayList<Tag>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = strQUERY;//"SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
          
            while (rs.next()) {
                Tag tag = new Tag();
                tag.setTid(rs.getInt(1));
                tag.setTag(rs.getString(2));
               
              
               
                list.add(tag);
                
                
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
     ResultSet getMySqlDataset(String strQUERY) {
        try {
          //  ArrayList<Tag> list = new ArrayList<Tag>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = strQUERY;//"SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);

            setDataSet(pst.executeQuery());
          
         /*   while (rs.next()) {
                Tag tag = new Tag();
                tag.setTid(rs.getInt(1));
                tag.setTag(rs.getString(2));
               
              
               
                list.add(tag);
            }*/
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
     
     
     
     boolean assignRoomSub(AllocationsModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into allocationsub values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
         
    

            pst.setInt(1, b.getRoomSubID());
             pst.setString(2, b.getName());
            pst.setString(3, b.getSubName());
            pst.setString(4, b.getTag());
            pst.setInt(5, b.getaRid());
            pst.setInt(6, b.getaTid());
             pst.setInt(7, b.getSubID());
           

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
     
     
      ArrayList<AddSubRoomModel> getSubDataRoom() {
        try {
            ArrayList<AddSubRoomModel> list = new ArrayList<AddSubRoomModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM `subjects`";
             pst = (PreparedStatement) con.prepareStatement(query);
             
             rs = pst.executeQuery();
             
            // DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
             
             while(rs.next())
            {
                AddSubRoomModel allocationModel=new AddSubRoomModel();
              int subID=rs.getInt(1);
                String Subjectname = rs.getString(4);
               
                allocationModel.setSubID(subID);
                allocationModel.setSubName(Subjectname);
             //   String Row[] = {Offeredyear , Offeredsemester , Subjectname , Subjectcode , lecturehours , tutorialhours , labhours , evaluationhours};
                System.out.println(allocationModel.toString());
               // tb.addRow(Row);
                list.add(allocationModel);
              
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
      
      boolean assignRoomLec(AllocationsModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into allocationLec values (?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
         
    

            pst.setInt(1, b.getRoomEidID());
            pst.setString(2, b.getName());
            pst.setString(3, b.getEmpName());
            pst.setInt(4, b.getaRid());
            pst.setInt(5, b.getEid());
           
           

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
      
      
      ArrayList<AllocationsModel> getLecDataRoom() {
        try {
            ArrayList<AllocationsModel> list = new ArrayList<AllocationsModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM `lecturers`";
             pst = (PreparedStatement) con.prepareStatement(query);
             
             rs = pst.executeQuery();
             
            // DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
             
             while(rs.next())
            {
                AllocationsModel allocationModel=new AllocationsModel();
              int eid=rs.getInt(1);
                String lecName = rs.getString(3);
               
                allocationModel.setEid(eid);
                allocationModel.setEmpName(lecName);
             //   String Row[] = {Offeredyear , Offeredsemester , Subjectname , Subjectcode , lecturehours , tutorialhours , labhours , evaluationhours};
                System.out.println(allocationModel.toString());
               // tb.addRow(Row);
                list.add(allocationModel);
              
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
      
      
       boolean assignRoomSubGrNo(AllocationsModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into allocationsubGroup values (?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
         
    

            pst.setInt(1, b.getRoomSubGroupId());
             pst.setString(2, b.getName());
            pst.setString(3, b.getSubGroupNo());
            pst.setInt(4, b.getaRid());
            pst.setInt(5, b.getaSid());
           
           

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
       
       
       ArrayList<AllocationsModel> getGroupDataRoom() {
        try {
            ArrayList<AllocationsModel> list = new ArrayList<AllocationsModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM `student`";
             pst = (PreparedStatement) con.prepareStatement(query);
             
             rs = pst.executeQuery();
             
            // DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
             
             while(rs.next())
            {
                AllocationsModel allocationModel=new AllocationsModel();
              int groupid=rs.getInt(1);
                String groupNo = rs.getString(7);
               
                allocationModel.setaSid(groupid);
                allocationModel.setSubGroupNo(groupNo);
             //   String Row[] = {Offeredyear , Offeredsemester , Subjectname , Subjectcode , lecturehours , tutorialhours , labhours , evaluationhours};
                System.out.println(allocationModel.toString());
               // tb.addRow(Row);
                list.add(allocationModel);
              
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
       private static ArrayList detailList = new ArrayList<>();
       public static ArrayList getDetails() {
           return detailList;
       }
       public static void setDetails(ArrayList aDetailsList) {
           detailList = aDetailsList;
       }
       
       ArrayList<AllocationsModel> getSessionDataRoom() {
        try {
            ArrayList<AllocationsModel> list = new ArrayList<AllocationsModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM `session`";
             pst = (PreparedStatement) con.prepareStatement(query);
             
             rs = pst.executeQuery();
             
            // DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
             Map<Integer, String> dmap = null;
             
             while(rs.next())
            {
                AllocationsModel allocationModel=new AllocationsModel();
                int sid=rs.getInt(1);
                String ename = rs.getString(2);
                String subname=rs.getString(3);
                String subcode=rs.getString(4);
                String tag=rs.getString(5);
                String sGrNo=rs.getString(5);
               
                allocationModel.setSessionRID(sid);
                allocationModel.setEmpName(ename);
                allocationModel.setSubName(subname);
                allocationModel.setSubCode(subcode);
                allocationModel.setTag(tag);
                allocationModel.setSubGroupNo(sGrNo);
             //   String Row[] = {Offeredyear , Offeredsemester , Subjectname , Subjectcode , lecturehours , tutorialhours , labhours , evaluationhours};
               // System.out.println(allocationModel.toString());
               // tb.addRow(Row);
                String details = null;
                dmap = new HashMap();
                details = ename + " " +  subname + " " + subcode + " " + tag + " " + sGrNo;
               // setDetails(details);
               
                list.add(allocationModel);
              //   System.out.println("sid "+ sid);
                //System.out.println("details "+ details);
                dmap.put(sid, details);
                detailList.add(dmap);
             // System.out.println(dmap);
            }
             
             
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
       
       
       
        boolean assignRoomSession(AllocationsModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into allocationsession values (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
         
    

            pst.setInt(1, b.getSessionRID());
             pst.setString(2, b.getName());
            pst.setString(3, b.getSessionDetails());
            pst.setString(4, b.getConsessName1());
            pst.setString(5, b.getConsessName2());
            pst.setString(6, b.getConsessName3());
            pst.setInt(7, b.getaRid());
            pst.setInt(8, b.getAsessionID());
             pst.setString(9, b.getAtime());
           
           

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
        
        
         ArrayList<AllocationsModel> getConSessionfRoom(String strQUERY) {
        try {
            ArrayList<AllocationsModel> list = new ArrayList<AllocationsModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = strQUERY;//"SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
          
            while (rs.next()) {
                AllocationsModel amodel = new AllocationsModel();
               // amodel.setTid(rs.getInt(1));
                amodel.setConsessName1(rs.getString(2));
                 amodel.setConsessName2(rs.getString(3));
                  amodel.setConsessName3(rs.getString(4));
               
              
               
                list.add(amodel);
                
                
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
      
     ArrayList<AllocationsModel> getTimeSlotRoom(String strQUERY) {
        try {
            ArrayList<AllocationsModel> list = new ArrayList<AllocationsModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = strQUERY;//"SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
          
            while (rs.next()) {
                AllocationsModel amodel = new AllocationsModel();
               // amodel.setTid(rs.getInt(1));
                amodel.setAtime(rs.getString(1));
                
               
              
               
                list.add(amodel);
                
                
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
      

    /**
     * @return the dataSet
     */
    public ResultSet getDataSet() {
        return dataSet;
    }

    /**
     * @param dataSet the dataSet to set
     */
    public void setDataSet(ResultSet dataSet) {
        this.dataSet = dataSet;
    }
    
    


   
}
