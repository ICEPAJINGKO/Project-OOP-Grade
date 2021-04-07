
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grade {

    private String idSubject = "";
    private String idStudent = "";
    private short year = 0;
    private byte term = 0;
    private String grade = "";

    private void setIdSubject(String idSub) {
        idSubject = idSub;
    }

    private void setIdStudent(String idStu) {
        idStudent = idStu;
    }

    private void setYear(short year) {
        this.year = year;
    }

    private void setTerm(byte term) {
        this.term = term;
    }

    private void setGrade(String grade) {
        this.grade = grade;
    }

    //เกรดของนักเรียนทั้งหมด
    public ResultSet getGrade(String idStu) {
        setIdStudent(idStu);
        return getGradeOfStudentFromDb();
    }

    private ResultSet getGradeOfStudentFromDb() {
        return new Connect().query("table_grade", "id_student", idStudent);
    }

    //เกรดของนักเรียนแต่ละเทอม
    public ResultSet getGrade(String idStu, short year, byte term) {
        setIdStudent(idStu);
        setYear(year);
        setTerm(term);
        return getGradeOfStudentByTermFromDb();
    }

    private ResultSet getGradeOfStudentByTermFromDb() {
        return new Connect().query("table_grade", "id_student", idStudent, "year", Short.toString(year), "term", Byte.toString(term));
    }

    //เกรดของนักเรียนแต่ละวิชาแต่ละเทอม
    public String getGrade(String idSub, String idStu, short year, byte term) {
        setIdSubject(idSub);
        setIdStudent(idStu);
        setYear(year);
        setTerm(term);
        ResultSet rs = getGradeFromDb();
        try {
            while (rs.next()) {
                setGrade(rs.getString("grade"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grade;
    }

    private ResultSet getGradeFromDb() {
        return new Connect().query("table_grade", "id_sub", idSubject, "id_student", idStudent,
                "year", Short.toString(year), "term", Byte.toString(term));
    }

    public void addGrade(String idSub, String idStu, short year, byte term, String grade) {
        setIdSubject(idSub);
        setIdStudent(idStu);
        setYear(year);
        setTerm(term);
        setGrade(grade);
        addGradeToDb();
    }

    private void addGradeToDb() {
        new Connect().save("table_grade", "id_sub", "id_student", "year", "term", "grade",
                idSubject, idStudent, Short.toString(year), Byte.toString(term), grade);
    }

    public ResultSet getYearAddFromDb(String idStu) {
        return new Connect().groupBy("table_grade", "year", "id_student", idStu);
    }

    public ResultSet getTermAddFromDb(String idStu) {
        return new Connect().groupBy("table_grade", "term", "id_student", idStu);
    }

    public void deleteGrad(String idSub, String idStu, short year, byte term) {
        setIdSubject(idSub);
        setIdStudent(idStu);
        setYear(year);
        setTerm(term);
        deleteGradInDb();
    }

    private void deleteGradInDb() {
        new Connect().delete("table_grade", "id_sub", idSubject, "id_student", idStudent,
                "year", Short.toString(year), "term", Byte.toString(term));
    }

}
