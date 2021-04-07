
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private String idStudent = "";
    private String firstName = "";
    private String lastName = "";

    public void setID(String id) {
        idStudent = id;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public void setLastName(String lName) {
        lastName = lName;
    }

    public String getID() {
        return idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getGPA() {
        float gpa = 0.0f;
        short credit = 0;
        ResultSet rs = new Grade().getGrade(idStudent);
        try {
            while (rs.next()) {
                if (rs.getString("grade").equalsIgnoreCase("W")) {
                } else {
                    byte subCredit = new Subject().getCredit(rs.getString("id_sub"));
                    if (rs.getString("grade").equalsIgnoreCase("A")) {
                        gpa += 4.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("B+")) {
                        gpa += 3.5f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("B")) {
                        gpa += 3.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("C+")) {
                        gpa += 2.5f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("C")) {
                        gpa += 2.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("D+")) {
                        gpa += 1.5f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("D")) {
                        gpa += 1.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("F")) {
                        gpa += 0.0f * subCredit;
                    }
                    credit += subCredit;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpa = gpa / credit;
    }

    public float getGPA(short year, byte term) {
        float gpa = 0.0f;
        short credit = 0;
        ResultSet rs = new Grade().getGrade(idStudent, year, term);
        try {
            while (rs.next()) {
                if (rs.getString("grade").equalsIgnoreCase("W")) {
                } else {
                    byte subCredit = new Subject().getCredit(rs.getString("id_sub"));
                    if (rs.getString("grade").equalsIgnoreCase("A")) {
                        gpa += 4.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("B+")) {
                        gpa += 3.5f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("B")) {
                        gpa += 3.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("C+")) {
                        gpa += 2.5f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("C")) {
                        gpa += 2.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("D+")) {
                        gpa += 1.5f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("D")) {
                        gpa += 1.0f * subCredit;
                    } else if (rs.getString("grade").equalsIgnoreCase("F")) {
                        gpa += 0.0f * subCredit;
                    }
                    credit += subCredit;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gpa / credit;
    }

    //เช็คว่ามีรหัสนักเรียนอยู่แล้วหรือไม่
    public boolean checkStudentFromDb() {
        return new Connect().checkData("table_student", "id_student", idStudent);
    }

    public void addStudentToDb() {
        new Connect().save("table_student", "id_student", "fname_student", "lname_student", 
                idStudent, firstName, lastName);
    }
    
    public void setAttribute(){
        ResultSet rs = getDataFromDbForSetAttribute();
        try {
            while(rs.next()){
                setFirstName(rs.getNString("fname_student"));
                setLastName(rs.getNString("lname_student"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ResultSet getDataFromDbForSetAttribute(){
        return new Connect().query("table_student", "id_student", idStudent);
    }
    
    public void updateStudentToDb(){
        new Connect().update("table_student", "fname_student", "lname_student", 
                firstName, lastName, "id_student", idStudent);
    }
}
