
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Subject {

    private String IDsubject = "";
    private String subjectName = "";
    private byte credit = 0;
    private String category = "";

    public void setIdSubject(String idSub) {
        IDsubject = idSub;
    }

    public void setSubjectName(String nameSub) {
        IDsubject = nameSub;
    }

    public void setCredie(byte credit) {
        this.credit = credit;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubName(String idSub) {
        setIdSubject(idSub);
        ResultSet rs = getDataOfIdFromDb();
        try {
            while (rs.next()) {
                setSubjectName(rs.getString("sname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }

    public byte getCredit(String idSub) {
        setIdSubject(idSub);
        ResultSet rs = getDataOfIdFromDb();
        try {
            while (rs.next()) {
                setCredie(rs.getByte("credit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return credit;
    }

    public String getCategory(String idSub) {
        setIdSubject(idSub);
        ResultSet rs = getDataOfIdFromDb();
        try {
            while (rs.next()) {
                setCredie(rs.getByte("category"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    private ResultSet getDataOfIdFromDb() {
        return new Connect().query("table_sub", "id_sub", IDsubject);
    }

    //ว่าง ว่าง
    public ResultSet getAllSubjectFromDb() {
        return new Connect().query("table_sub");
    }

    //ไม่ว่าง ว่าง
    public ResultSet searchSubjectOfNameFromDb(String value) {
        return new Connect().searchData("table_sub", "id_sub", "sname", "credit", "category", value);
    }

    //ว่าง ไม่ว่าง
    public ResultSet searchSubjectOfCategoryFromDb(String category) {
        return new Connect().query("table_sub", "category", category);
    }

    //ไม่ว่าง ไม่ว่าง
    public ResultSet searchSubjectByYouFromDb(String colum, String value) {
        return new Connect().searchData("table_sub", colum, value);
    }
}
