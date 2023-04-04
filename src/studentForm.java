
import java.awt.Image;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JTable;


public class studentForm extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prepareStatement;
    ResultSet resultSet;
     File file = null;
    String path = null;
    String path2;
    public studentForm() {
        initComponents();
        Connect();
        idIncrement();
        searchStudentcode();
        displayData();
        passwordIcon();
        this.showPassword.setVisible(false);
    }

    public void Connect() {
        // connect this application to database 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/studenttable", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void idIncrement() {
        // auto sutdent code
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/studenttable", "root", "");
            String sqlQuery = "SELECT Studentcode FROM studentdata ORDER BY Studentcode DESC LIMIT 1";
            prepareStatement = connection.prepareStatement(sqlQuery);
            resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                int sCode = resultSet.getInt(1);
                int n = sCode + 1;
                studentCode.setText(Integer.toString(n));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void searchStudentcode() {

        // searching the student code 
        try {
            prepareStatement = connection.prepareStatement("SELECT Studentcode FROM studentdata");
            resultSet = prepareStatement.executeQuery();
            sStudentcode.removeAllItems();

            while (resultSet.next()) {
                sStudentcode.addItem(resultSet.getString(1));

            }

        } catch (SQLException ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayData() {

        try {
            int data;
            prepareStatement = connection.prepareStatement("SELECT * FROM studentdata");
            resultSet = prepareStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            data = metaData.getColumnCount();

            DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
            modelTable.setRowCount(0);

            while (resultSet.next()) {

                Vector vector = new Vector();

                // display the data in the table 
                for (int table = 1; table <= data; table++) {
                    vector.add(resultSet.getString("studentCode"));
                    vector.add(resultSet.getString("Username"));
                    vector.add(resultSet.getString("Password"));
                    vector.add(resultSet.getString("Name"));
                    vector.add(resultSet.getString("Address"));
                    vector.add(resultSet.getString("YearLevel"));
                    vector.add(resultSet.getString("Course"));
                }
                modelTable.addRow(vector);

            }

        } catch (SQLException ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void passwordIcon() {

        ImageIcon show = new ImageIcon(getClass().getResource("/Image/lockWhite.png"));
        Image showP = show.getImage().getScaledInstance(showPassword.getWidth(), showPassword.getHeight(), Image.SCALE_SMOOTH);
        showPassword.setIcon(new ImageIcon(showP));

        ImageIcon hide = new ImageIcon(getClass().getResource("/Image/hideWhite.png"));
        Image hideP = hide.getImage().getScaledInstance(hidePassword.getWidth(), hidePassword.getHeight(), Image.SCALE_SMOOTH);
        hidePassword.setIcon(new ImageIcon(hideP));
    }

    public void reset() {

        userName.setText("");
        passWord.setText("");
        studentName.setText("");

        studentAddress.setText("");
        Year.setText("");
        studentCourse.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        studentCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        studentName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        studentAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Year = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        studentCourse = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        printTable = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        passWord = new javax.swing.JPasswordField();
        hidePassword = new javax.swing.JLabel();
        showPassword = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        sStudentcode = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student School Management");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT SCHOOL MANAGEMENT");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Code   :");

        studentCode.setEditable(false);
        studentCode.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        studentCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentCode.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Full Name        :");

        studentName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        studentName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentName.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address           :");

        studentAddress.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        studentAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentAddress.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Year Level        :");

        Year.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Year.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Year.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Course             :");

        studentCourse.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        studentCourse.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentCourse.setBorder(null);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.setBorder(null);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        printTable.setBackground(new java.awt.Color(255, 0, 0));
        printTable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        printTable.setForeground(new java.awt.Color(255, 255, 255));
        printTable.setText("PRINT");
        printTable.setBorder(null);
        printTable.setFocusable(false);
        printTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTableActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username         :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Password         :");

        userName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userName.setBorder(null);

        passWord.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        passWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passWord.setBorder(null);

        hidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePasswordMouseClicked(evt);
            }
        });

        showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPasswordMouseClicked(evt);
            }
        });

        logOut.setBackground(new java.awt.Color(255, 0, 0));
        logOut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        logOut.setForeground(new java.awt.Color(255, 255, 255));
        logOut.setText("Log Out");
        logOut.setBorder(null);
        logOut.setFocusable(false);
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Reset");
        jButton4.setBorder(null);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(studentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hidePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(studentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(printTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(studentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hidePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 390, 540));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Code", "Username", "Password", "Name", "Address", "Year", "Course"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(170);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(230);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(230);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(230);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(450);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 960, 420));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel8.setText("Student Code   :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, -1, 35));

        sStudentcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sStudentcode.setBorder(null);
        jPanel1.add(sStudentcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 118, 35));

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.setBorder(null);
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 270, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (studentCode.getText().isEmpty() || userName.getText().isEmpty() || String.valueOf(passWord.getPassword()).isBlank() || studentName.getText().isEmpty() || studentAddress.getText().isEmpty() || Year.getText().isEmpty() || studentCourse.getText().isEmpty()) {
            // if the user is not complete the data form would be a error 
            JOptionPane.showMessageDialog(this, "Please Complete the Data ");

        } else {

            try {

                //String variable to get the user input
                String Studentcode = studentCode.getText();
                String username = userName.getText();
                String password = String.valueOf(passWord.getPassword());
                String Name = studentName.getText();
                String Address = studentAddress.getText();
                String YearLevel = Year.getText();
                String Course = studentCourse.getText();
                

                // Insert data to the sql 
                prepareStatement = connection.prepareStatement("INSERT INTO studentdata (Studentcode, Username, Password, Name, Address, YearLevel, Course) VALUE (?, ?, ?, ? , ? , ? , ?) ");
                prepareStatement.setString(1, Studentcode);
                prepareStatement.setString(2, username);
                prepareStatement.setString(3, password);
                prepareStatement.setString(4, Name);
                prepareStatement.setString(5, Address);
                prepareStatement.setString(6, YearLevel);
                prepareStatement.setString(7, Course);
           
                
                
                int data = prepareStatement.executeUpdate();
                if (data == 1) {
                    JOptionPane.showMessageDialog(this, "Data Add Successfully");
                    studentName.setText("");
                    userName.setText("");
                    passWord.setText("");
                    studentAddress.setText("");
                    Year.setText("");
                    studentCourse.setText("");
                    idIncrement();
                    displayData();
                    searchStudentcode();
                }

            } catch (SQLException ex) {
                Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
          
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            // show the data in the combo box 
            String StudentcodE = sStudentcode.getSelectedItem().toString();
            prepareStatement = connection.prepareStatement("SELECT * FROM studentdata WHERE Studentcode= ?");
            prepareStatement.setString(1, StudentcodE);
            resultSet = prepareStatement.executeQuery();

            // show the data if they exist
            if (resultSet.next() == true) {
                studentCode.setText(resultSet.getString(1));
                userName.setText(resultSet.getString(2));
                passWord.setText(resultSet.getString(3));
                studentName.setText(resultSet.getString(4));
                studentAddress.setText(resultSet.getString(5));
                Year.setText(resultSet.getString(6));
                studentCourse.setText(resultSet.getString(7));

            } // if the data not exist
            else {
                JOptionPane.showMessageDialog(this, "No Record Found");
            }

        } catch (SQLException ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String code = sStudentcode.getSelectedItem().toString();
        String student = studentCode.getText();

        if (!code.equals(student)) {
            // if they want to update the data but the true is adding this data
            JOptionPane.showMessageDialog(this, "Add this data");
        } else {
            try {

                // new variable for the update of data
                String sUsername = userName.getText();
                String sPassword = String.valueOf(passWord.getPassword());
                String sName = studentName.getText();

                String sAddress = studentAddress.getText();
                String sYear = Year.getText();
                String sCourse = studentCourse.getText();
                String sCode = sStudentcode.getSelectedItem().toString();

                prepareStatement = connection.prepareStatement("UPDATE studentdata SET  Username = ? , Password = ? , Name = ? ,  Address = ? , YearLevel = ? , Course = ? WHERE Studentcode = ? ");

                prepareStatement.setString(1, sUsername);
                prepareStatement.setString(2, sPassword);
                prepareStatement.setString(3, sName);
                prepareStatement.setString(4, sAddress);
                prepareStatement.setString(5, sYear);
                prepareStatement.setString(6, sCourse);
                prepareStatement.setString(7, sCode);

                int data = prepareStatement.executeUpdate();

                // if the update is successfull 
                if (data == 1) {
                    JOptionPane.showMessageDialog(this, "Update Successfully");
                    userName.setText("");
                    passWord.setText("");
                    studentName.setText("");
                    studentAddress.setText("");
                    Year.setText("");
                    studentCourse.setText("");
                    studentName.requestFocus();
                    searchStudentcode();
                    displayData();
                    idIncrement();

                }

            } catch (SQLException ex) {
                Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String delete = sStudentcode.getSelectedItem().toString();
        String code = studentCode.getText();

        if (!delete.equals(code)) {
            JOptionPane.showMessageDialog(this, "Search the data that you want to delete");
        } else {
            try {

                String Searchstudentcode = sStudentcode.getSelectedItem().toString();
                prepareStatement = connection.prepareStatement("DELETE FROM studentdata WHERE Studentcode = ?");
                prepareStatement.setString(1, Searchstudentcode);
                int data = prepareStatement.executeUpdate();
                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure to delete this?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirmation == 0) {
                    if (data == 1) {
                        JOptionPane.showMessageDialog(this, "Delete Data Successfully");
                        studentCode.setText("");
                        userName.setText("");
                        passWord.setText("");
                        studentName.setText("");
                        studentAddress.setText("");
                        Year.setText("");
                        studentCourse.setText("");
                        searchStudentcode();
                        displayData();
                        idIncrement();
                    }
                }

                // delete a data 
            } catch (SQLException ex) {
                Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void printTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTableActionPerformed
        try {

            // enable to print the table or the data
            int data;
            prepareStatement = connection.prepareStatement("SELECT * FROM studentdata");
            resultSet = prepareStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            data = metaData.getColumnCount();

            DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
            modelTable.getRowCount();

            // if the table is not empty will be successfull print the data
            if (resultSet.next()) {
                MessageFormat Header = new MessageFormat(" STUDENT DATA ");
                MessageFormat Footer = new MessageFormat("Page {0,number , integer}");
                try {
                    jTable1.print(JTable.PrintMode.FIT_WIDTH, Header, Footer);
                } catch (PrinterException ex) {
                    Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } // if the table is empty they have a error in the printing
            else {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            }

        } catch (SQLException ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_printTableActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed

        int asking = JOptionPane.showConfirmDialog(this, "Are you sure to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (asking == 0) {
            // if the user choose the logout the Jfram admin_user will be open 
            admin_user adminuser = new admin_user();
            adminuser.setVisible(true);
            adminuser.pack();
            this.dispose();

        }


    }//GEN-LAST:event_logOutActionPerformed

    private void showPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordMouseClicked

        // show password
        passWord.setEchoChar('•');
        hidePassword.setVisible(true);
        showPassword.setVisible(false);


    }//GEN-LAST:event_showPasswordMouseClicked

    private void hidePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePasswordMouseClicked

        passWord.setEchoChar((char) 0);
        hidePassword.setVisible(false);
        showPassword.setVisible(true);

    }//GEN-LAST:event_hidePasswordMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        reset();


    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Year;
    private javax.swing.JLabel hidePassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logOut;
    private javax.swing.JPasswordField passWord;
    private javax.swing.JButton printTable;
    private javax.swing.JComboBox<String> sStudentcode;
    private javax.swing.JLabel showPassword;
    private javax.swing.JTextField studentAddress;
    private javax.swing.JTextField studentCode;
    private javax.swing.JTextField studentCourse;
    private javax.swing.JTextField studentName;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
