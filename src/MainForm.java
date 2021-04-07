
import com.sun.glass.events.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class MainForm extends javax.swing.JFrame {

//    private Connect condb = new Connect();
    private Student cStu = new Student();

    public MainForm() {
        initComponents();
        showDataToFormRight();
    }

    private void addItemYear(String idStu) {
        jCB_yearl.removeAllItems();
        ResultSet rs = new Grade().getYearAddFromDb(idStu);
        try {
            while (rs.next()) {
                String name = rs.getString("year");
                jCB_yearl.addItem(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addItemTerm(String idStu) {
        jCB_terml.removeAllItems();
        ResultSet rs = new Grade().getTermAddFromDb(idStu);
        try {
            while (rs.next()) {
                String name = rs.getString("term");
                jCB_terml.addItem(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addItemSub() {
        jCB_yearr.removeAllItems();
        int year = 2500 + Integer.parseInt(cStu.getID().substring(0, 2));
        for (int i = 1; i <= 8; i++) {
            jCB_yearr.addItem(String.valueOf(year++));
        }
    }

    private void search() {
        String subName = jTB_search.getText();
        String subCategory = jCB_search.getSelectedItem().toString();

        if (subName.equals("") && subCategory.equalsIgnoreCase("All")) {
            showDataToFormRight();
        } else if (subName.equals("")) {

        }
    }

    private void showDataToFormLeft() {
        String sql = "SELECT table_grade.id_sub, table_sub.sname, table_grade.year, table_grade.term, table_grade.grade FROM table_grade "
                + "INNER JOIN table_sub ON table_grade.id_sub = table_sub.id_sub WHERE table_grade.id_student = '" + cStu.getID() + "'";
        jTB_l.setModel(DbUtils.resultSetToTableModel(new Connect().queryCustom(sql)));
    }

    private void showDataToFormRight() {
        jTB_r.setModel(DbUtils.resultSetToTableModel(new Subject().getAllSubjectFromDb()));
    }

    private void showDataToLableSub() {
        int row = jTB_r.getSelectedRow();
        jLB_sid.setText(jTB_r.getValueAt(row, 0).toString());
        jLB_sname.setText(jTB_r.getValueAt(row, 1).toString());
        jLB_scategory.setText(jTB_r.getValueAt(row, 3).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTF_id1 = new javax.swing.JTextField();
        jTF_id2 = new javax.swing.JTextField();
        jTF_id3 = new javax.swing.JTextField();
        jTF_id4 = new javax.swing.JTextField();
        jTF_id5 = new javax.swing.JTextField();
        jTF_id6 = new javax.swing.JTextField();
        jTF_id7 = new javax.swing.JTextField();
        jTF_id8 = new javax.swing.JTextField();
        jTF_id9 = new javax.swing.JTextField();
        jTF_id10 = new javax.swing.JTextField();
        jTF_id11 = new javax.swing.JTextField();
        jTF_id12 = new javax.swing.JTextField();
        jBT_enter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTF_fname = new javax.swing.JTextField();
        jTF_lname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_l = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTB_r = new javax.swing.JTable();
        jBT_su = new javax.swing.JButton();
        jCB_yearl = new javax.swing.JComboBox<>();
        jCB_terml = new javax.swing.JComboBox<>();
        jBT_calculate = new javax.swing.JButton();
        jCB_all = new javax.swing.JCheckBox();
        jLB_grade = new javax.swing.JLabel();
        jTB_search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCB_search = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLB_sid = new javax.swing.JLabel();
        jLB_sname = new javax.swing.JLabel();
        jLB_scategory = new javax.swing.JLabel();
        jCB_yearr = new javax.swing.JComboBox<>();
        jCB_termr = new javax.swing.JComboBox<>();
        jCB_grade = new javax.swing.JComboBox<>();
        jBT_add = new javax.swing.JButton();
        jBT_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1600, 900));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("-");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("รหัสนักศึกษา");

        jTF_id1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id1KeyTyped(evt);
            }
        });

        jTF_id2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id2KeyTyped(evt);
            }
        });

        jTF_id3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id3KeyTyped(evt);
            }
        });

        jTF_id4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id4KeyTyped(evt);
            }
        });

        jTF_id5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id5KeyTyped(evt);
            }
        });

        jTF_id6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id6KeyTyped(evt);
            }
        });

        jTF_id7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id7KeyTyped(evt);
            }
        });

        jTF_id8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id8KeyTyped(evt);
            }
        });

        jTF_id9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id9KeyTyped(evt);
            }
        });

        jTF_id10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id10KeyTyped(evt);
            }
        });

        jTF_id11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id11KeyTyped(evt);
            }
        });

        jTF_id12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTF_id12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_id12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_id12KeyTyped(evt);
            }
        });

        jBT_enter.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jBT_enter.setText("Enter");
        jBT_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBT_enterActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("ชื่อ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("นามสกุล");

        jTF_fname.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jTF_lname.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jTB_l.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTB_l.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTB_l.setRowHeight(24);
        jTB_l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_lMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_l);

        jTB_r.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTB_r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_rMouseClicked(evt);
            }
        });
        jTB_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTB_rKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTB_r);

        jBT_su.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jBT_su.setText("Update");
        jBT_su.setEnabled(false);
        jBT_su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBT_suActionPerformed(evt);
            }
        });

        jCB_yearl.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jCB_terml.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jBT_calculate.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jBT_calculate.setText("Calculate");
        jBT_calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBT_calculateActionPerformed(evt);
            }
        });

        jCB_all.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jCB_all.setText("ALL");

        jLB_grade.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLB_grade.setText("ข้อความแสดงตรงนี้");

        jTB_search.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTB_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTB_searchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("ค้นหารายวิชา");

        jCB_search.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jCB_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "id_sub", "sname", "credit", "category" }));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("รหัสวิชา");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("ชื่อวิชา");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("หมวด");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setText(":");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setText(":");

        jLB_sid.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLB_sid.setText("-----------");

        jLB_sname.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLB_sname.setText("-----------");

        jLB_scategory.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLB_scategory.setText("-----------");

        jCB_yearr.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jCB_termr.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jCB_termr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jCB_grade.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jCB_grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B+", "B", "C+", "C", "D+", "D", "F", "W" }));

        jBT_add.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jBT_add.setText("Add");
        jBT_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBT_addActionPerformed(evt);
            }
        });

        jBT_delete.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jBT_delete.setText("Delete");
        jBT_delete.setEnabled(false);
        jBT_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBT_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCB_yearl, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jCB_terml, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jCB_all)
                                .addGap(6, 6, 6)
                                .addComponent(jBT_calculate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBT_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLB_grade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTF_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_id11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(jTF_id12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jBT_enter))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(220, 220, 220)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTF_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTF_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jBT_su, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jTB_search, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jCB_search, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)
                                .addGap(6, 6, 6)
                                .addComponent(jLB_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(6, 6, 6)
                                .addComponent(jLB_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel8)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel11)
                                .addGap(6, 6, 6)
                                .addComponent(jLB_scategory, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jCB_yearr, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jCB_termr, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCB_grade, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBT_add))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jTF_id12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBT_enter))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBT_su)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTF_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTF_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jCB_yearl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jCB_terml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jCB_all))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBT_calculate)
                                .addComponent(jLB_grade)
                                .addComponent(jBT_delete))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTB_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCB_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLB_sid))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLB_sname))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLB_scategory))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCB_termr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCB_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBT_add)
                            .addComponent(jCB_yearr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        setSize(new java.awt.Dimension(1616, 939));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_id1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id1KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id1.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id2.grabFocus();
        }
    }//GEN-LAST:event_jTF_id1KeyTyped

    private void jTF_id2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id2KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id2.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id3.grabFocus();
        }
    }//GEN-LAST:event_jTF_id2KeyTyped

    private void jTF_id3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id3KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id3.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id4.grabFocus();
        }
    }//GEN-LAST:event_jTF_id3KeyTyped

    private void jTF_id4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id4KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id4.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id5.grabFocus();
        }
    }//GEN-LAST:event_jTF_id4KeyTyped

    private void jTF_id5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id5KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id5.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id6.grabFocus();
        }
    }//GEN-LAST:event_jTF_id5KeyTyped

    private void jTF_id6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id6KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id6.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id7.grabFocus();
        }
    }//GEN-LAST:event_jTF_id6KeyTyped

    private void jTF_id7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id7KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id7.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id8.grabFocus();
        }
    }//GEN-LAST:event_jTF_id7KeyTyped

    private void jTF_id8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id8KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id8.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id9.grabFocus();
        }
    }//GEN-LAST:event_jTF_id8KeyTyped

    private void jTF_id9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id9KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id9.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id10.grabFocus();
        }
    }//GEN-LAST:event_jTF_id9KeyTyped

    private void jTF_id10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id10KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id10.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id11.grabFocus();
        }
    }//GEN-LAST:event_jTF_id10KeyTyped

    private void jTF_id11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id11KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id11.getText().length() >= 1) {
            evt.consume();
        } else {
            jTF_id12.grabFocus();
        }
    }//GEN-LAST:event_jTF_id11KeyTyped

    private void jTF_id12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id12KeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)) || vChar == KeyEvent.VK_BACKSPACE || vChar == KeyEvent.VK_DELETE) {
            evt.consume();
        } else if (jTF_id12.getText().length() >= 1) {
            evt.consume();
        } else {
            jBT_enter.grabFocus();
        }
    }//GEN-LAST:event_jTF_id12KeyTyped

    private void jBT_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBT_enterActionPerformed
        if (jTF_id1.getText().isEmpty() || jTF_id2.getText().isEmpty() || jTF_id3.getText().isEmpty() || jTF_id4.getText().isEmpty()
                || jTF_id5.getText().isEmpty() || jTF_id6.getText().isEmpty() || jTF_id7.getText().isEmpty() || jTF_id8.getText().isEmpty()
                || jTF_id9.getText().isEmpty() || jTF_id10.getText().isEmpty() || jTF_id11.getText().isEmpty() || jTF_id12.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "กรุณาใส่รหัสนักศึกษาให้ครบทุกช่อง", "แจ้งเตือน", JOptionPane.WARNING_MESSAGE);
        } else {
            jBT_su.setEnabled(true);
            String id = jTF_id1.getText() + jTF_id2.getText() + jTF_id3.getText() + jTF_id4.getText() + jTF_id5.getText() + jTF_id6.getText()
                    + jTF_id7.getText() + jTF_id8.getText() + jTF_id9.getText() + jTF_id10.getText() + jTF_id11.getText() + "-" + jTF_id12.getText();

            cStu.setID(id);
            if (cStu.checkStudentFromDb()) {
                cStu.setAttribute();
                jTF_fname.setText(cStu.getFirstName());
                jTF_lname.setText(cStu.getLastName());
                showDataToFormLeft();
            } else {
                JOptionPane.showMessageDialog(this, "ยินดีต้อนรับสมาชิกใหม่\nกรุณากรอกชื่อ!!");
                cStu.addStudentToDb();
            }
            addItemSub();
            addItemYear(cStu.getID());
            addItemTerm(cStu.getID());
        }
    }//GEN-LAST:event_jBT_enterActionPerformed

    private void jBT_suActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBT_suActionPerformed
        if (jTF_fname.getText().isEmpty() || jTF_lname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "กรุณาใส่ชื่อ-นามสกุลนักศึกษาให้ครบ", "แจ้งเตือน", JOptionPane.WARNING_MESSAGE);
        } else {
            cStu.setFirstName(jTF_fname.getText());
            cStu.setLastName(jTF_lname.getText());
            cStu.updateStudentToDb();
            JOptionPane.showMessageDialog(this, "บันทึกเรียบร้อย", "บันทึก", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jBT_suActionPerformed

    private void jBT_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBT_calculateActionPerformed
        if (jCB_all.isSelected()) {
            jLB_grade.setText("เกรดเฉลี่ยรวม" + String.valueOf(cStu.getGPA()));
        } else {
            String year = String.valueOf(jCB_yearl.getSelectedItem());
            String term = String.valueOf(jCB_terml.getSelectedItem());
            jLB_grade.setText("เกรดเฉลี่ย" + String.valueOf(cStu.getGPA(Short.parseShort(year), Byte.parseByte(term))));
        }
    }//GEN-LAST:event_jBT_calculateActionPerformed

    private void jTB_lMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_lMouseClicked
        jBT_delete.setEnabled(true);
    }//GEN-LAST:event_jTB_lMouseClicked

    private void jBT_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBT_deleteActionPerformed
        Grade g = new Grade();
        int row = jTB_l.getSelectedRow();
        String idSub = jTB_l.getValueAt(row, 0).toString();
        String year = jTB_l.getValueAt(row, 2).toString();
        String term = jTB_l.getValueAt(row, 3).toString();
        g.deleteGrad(idSub, cStu.getID(), Short.valueOf(year), Byte.valueOf(term));
        jBT_delete.setEnabled(false);
        showDataToFormLeft();
    }//GEN-LAST:event_jBT_deleteActionPerformed

    private void jTB_rMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_rMouseClicked
        showDataToLableSub();
    }//GEN-LAST:event_jTB_rMouseClicked

    private void jTB_rKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTB_rKeyReleased
        showDataToLableSub();
    }//GEN-LAST:event_jTB_rKeyReleased

    private void jBT_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBT_addActionPerformed
        new Grade().addGrade(jLB_sid.getText(), cStu.getID(), Short.valueOf(jCB_yearr.getSelectedItem().toString()),
                Byte.valueOf(jCB_termr.getSelectedItem().toString()), jCB_grade.getSelectedItem().toString());
        showDataToFormLeft();
        addItemYear(cStu.getID());
        addItemTerm(cStu.getID());
    }//GEN-LAST:event_jBT_addActionPerformed

    private void jTB_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTB_searchKeyReleased
        ResultSet rs = null;
        if(jTB_search.getText().equals("")&&jCB_search.getSelectedItem().toString().equalsIgnoreCase("All")){
            showDataToFormRight();
        }else if(jCB_search.getSelectedItem().toString().equalsIgnoreCase("All")){
            rs = new Subject().searchSubjectOfNameFromDb(jTB_search.getText());
        }else if(jTB_search.getText().isEmpty()&&jCB_search.getSelectedItem().toString().equalsIgnoreCase("All")){
            rs = new Subject().searchSubjectOfCategoryFromDb(jCB_search.getSelectedItem().toString());
        }else if(jTB_search.getText().isEmpty()&&jCB_search.getSelectedItem().toString().equalsIgnoreCase("All")){
            rs = new Subject().searchSubjectByYouFromDb(jCB_search.getSelectedItem().toString(), jTB_search.getText());
        }
        
        if(rs != null){
        jTB_r.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }//GEN-LAST:event_jTB_searchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBT_add;
    private javax.swing.JButton jBT_calculate;
    private javax.swing.JButton jBT_delete;
    private javax.swing.JButton jBT_enter;
    private javax.swing.JButton jBT_su;
    private javax.swing.JCheckBox jCB_all;
    private javax.swing.JComboBox<String> jCB_grade;
    private javax.swing.JComboBox<String> jCB_search;
    private javax.swing.JComboBox<String> jCB_terml;
    private javax.swing.JComboBox<String> jCB_termr;
    private javax.swing.JComboBox<String> jCB_yearl;
    private javax.swing.JComboBox<String> jCB_yearr;
    private javax.swing.JLabel jLB_grade;
    private javax.swing.JLabel jLB_scategory;
    private javax.swing.JLabel jLB_sid;
    private javax.swing.JLabel jLB_sname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTB_l;
    private javax.swing.JTable jTB_r;
    private javax.swing.JTextField jTB_search;
    private javax.swing.JTextField jTF_fname;
    private javax.swing.JTextField jTF_id1;
    private javax.swing.JTextField jTF_id10;
    private javax.swing.JTextField jTF_id11;
    private javax.swing.JTextField jTF_id12;
    private javax.swing.JTextField jTF_id2;
    private javax.swing.JTextField jTF_id3;
    private javax.swing.JTextField jTF_id4;
    private javax.swing.JTextField jTF_id5;
    private javax.swing.JTextField jTF_id6;
    private javax.swing.JTextField jTF_id7;
    private javax.swing.JTextField jTF_id8;
    private javax.swing.JTextField jTF_id9;
    private javax.swing.JTextField jTF_lname;
    // End of variables declaration//GEN-END:variables
}
