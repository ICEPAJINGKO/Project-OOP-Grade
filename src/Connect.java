
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connect {

    private Connection con = ConnectDB();
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    private Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/grade_csit";
            Connection con1 = DriverManager.getConnection(url, "root", "");
            return con1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet query(String tbName) {
        String sql = "SELECT * FROM " + tbName;
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet query(String tbName, String colName, String where) {
        String sql = "SELECT * FROM " + tbName + " WHERE " + colName + " = '" + where + "'";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet query(String tbName, String colName1, String where1,
            String colName2, String where2,
            String colName3, String where3) {
        String sql = "SELECT * FROM " + tbName + " WHERE " + colName1 + " = " + where1 + " "
                + "AND " + colName2 + " = " + where2 + " AND " + colName3 + " = " + where3 + "";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet query(String tbName, String colName1, String where1,
            String colName2, String where2,
            String colName3, String where3,
            String colName4, String where4) {
        String sql = "SELECT * FROM " + tbName + " WHERE " + colName1 + " = " + where1 + " "
                + "AND " + colName2 + " = " + where2 + " AND " + colName3 + " = " + where3 + " "
                + "AND " + colName4 + " = " + where4;
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //insert ข้อมูล3ค่า เช่น table_studen
    public void save(String tbName, String colName1, String colName2, String colName3,
            String value1, String value2, String value3) {
        String sql = "INSERT INTO `" + tbName + "` (`" + colName1 + "`, `" + colName2 + "`, `" + colName3 + "`) "
                + "VALUES ('" + value1 + "', '" + value2 + "', '" + value3 + "');";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //insert ข้อมูล4ค่า เช่น table_sub
    public void save(String tbName, String colName1, String colName2, String colName3, String colName4,
            String value1, String value2, String value3, String value4) {
        String sql = "INSERT INTO `" + tbName + "` "
                + "(`" + colName1 + "`, `" + colName2 + "`, `" + colName3 + "`, `" + colName4 + "`) "
                + "VALUES ('" + value1 + "', '" + value2 + "', '" + value3 + "', '" + value4 + "');";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //insert ข้อมูล5ค่า เช่น table_grade
    public void save(String tbName, String colName1, String colName2, String colName3, String colName4, String colName5,
            String value1, String value2, String value3, String value4, String value5) {
        String sql = "INSERT INTO `" + tbName + "` "
                + "(`" + colName1 + "`, `" + colName2 + "`, `" + colName3 + "`, `" + colName4 + "`, `" + colName5 + "`) "
                + "VALUES ('" + value1 + "', '" + value2 + "', '" + value3 + "', '" + value4 + "', '" + value5 + "');";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String tbName, String colName1, String colName2, String value1, String value2,
            String whereCol, String whereValue) {
        String sql = "UPDATE `" + tbName + "` SET `" + colName1 + "` = '" + value1 + "', "
                + "`" + colName2 + "` = '" + value2 + "' "
                + "WHERE `" + whereCol + "` = '" + whereValue + "'";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String tbName, String colName, String where) {
        String sql = "DELETE FROM " + tbName + " WHERE " + colName + " = " + where;
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            if (pst.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(null, "ลบข้อมูลเรียบร้อย");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String tbName, String colName1, String where1,
            String colName2, String where2,
            String colName3, String where3,
            String colName4, String where4) {
        String sql = "DELETE FROM " + tbName + " WHERE " + colName1 + " = " + where1 + " "
                + "AND " + colName2 + " = " + where2 + " "
                + "AND " + colName3 + " = " + where3 + " "
                + "AND " + colName4 + " = " + where4 + " ";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            if (pst.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(null, "ลบข้อมูลเรียบร้อย");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkData(String tbName, String colName, String value) {
        rs = query(tbName);
        try {
            while (rs.next()) {
                if (rs.getString(colName).equalsIgnoreCase(value)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //คล้ายกับMethod Query แต่อันนี้เหมาะกับการหาข้อมูลเฉพาะบางส่วนของคำ
    public ResultSet searchData(String tbName, String colName, String value) {
        String sql = "SELECT * FROM " + tbName + " WHERE " + colName + " LIKE '%" + value + "%'";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //หา1ข้อมูลใน4คอลลัม
    public ResultSet searchData(String tbName, String colName1, String colName2, String colName3, String colName4, 
            String value1) {
        String sql = "SELECT * FROM " + tbName + " WHERE " + colName1 + " LIKE '%" + value1 + "%' "
                + "OR " + colName2 + " LIKE '%" + value1 + "%' "
                + "OR " + colName3 + " LIKE '%" + value1 + "%' "
                + "OR " + colName4 + " LIKE '%" + value1 + "%'";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet groupBy(String tbName, String colName, String where, String value){
        String sql = "SELECT * FROM `"+tbName+"` WHERE `"+where+"` = " + value + " GROUP BY `"+colName+"`";
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            return rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet queryCustom(String sql){
        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
