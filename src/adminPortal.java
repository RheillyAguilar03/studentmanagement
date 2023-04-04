
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class adminPortal extends javax.swing.JFrame {

    public adminPortal() {
        initComponents();
        Image();
        this.lockP.setVisible(false);
    }

    public void Image() {

        ImageIcon Adminportal = new ImageIcon(getClass().getResource("/Image/software-engineer.png"));
        Image admin = Adminportal.getImage().getScaledInstance(adminPicture.getWidth(), adminPicture.getHeight(), Image.SCALE_SMOOTH);
        adminPicture.setIcon(new ImageIcon(admin));

        ImageIcon padlock = new ImageIcon(getClass().getResource("/Image/hide.png"));
        Image plock = padlock.getImage().getScaledInstance(padlockP.getWidth(), padlockP.getHeight(), Image.SCALE_SMOOTH);
        padlockP.setIcon(new ImageIcon(plock));

        ImageIcon lock = new ImageIcon(getClass().getResource("/Image/show.png"));
        Image lockp = lock.getImage().getScaledInstance(lockP.getWidth(), lockP.getHeight(), Image.SCALE_SMOOTH);
        lockP.setIcon(new ImageIcon(lockp));

    }

    public boolean Empty() {

        // if the user not input both admin username and passowrd show this 
        if (adminUsername.getText().isEmpty() && String.valueOf(passWord.getPassword()).isBlank()) {
            JOptionPane.showMessageDialog(this, "Enter a Admin Username and Password");
            return false;
        }

        // if the user not input the admin username show this
        if (adminUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a Admin Username");
            return false;
        }

        // if the user not input the password show this
        if (String.valueOf(passWord.getPassword()).isBlank()) {
            JOptionPane.showMessageDialog(this, "Enter a Password");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        adminPicture = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adminUsername = new javax.swing.JTextField();
        passWord = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        padlockP = new javax.swing.JLabel();
        lockP = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Hub");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(adminPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, 170));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Admin Username      :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 112, 191, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Password                   :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 173, 191, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin Hub");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 628, 60));

        adminUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(adminUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 115, 130, 40));

        passWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(passWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 176, 130, 40));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log In");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 233, 115, 50));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 233, 115, 50));

        padlockP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                padlockPMouseClicked(evt);
            }
        });
        jPanel1.add(padlockP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 30, 30));

        lockP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lockPMouseClicked(evt);
            }
        });
        jPanel1.add(lockP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // if the user choose the back the Jfram admin_user will be open again to choose again 
        admin_user adminuser = new admin_user();
        adminuser.setVisible(true);
        adminuser.pack();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void padlockPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_padlockPMouseClicked

        // hide password
        passWord.setEchoChar((char) 0);
        padlockP.setVisible(false);
        lockP.setVisible(true);
    }//GEN-LAST:event_padlockPMouseClicked

    private void lockPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lockPMouseClicked

        // show password
        passWord.setEchoChar('•');
        padlockP.setVisible(true);
        lockP.setVisible(false);
    }//GEN-LAST:event_lockPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Empty()) {

            //String for getting the input 
            String admin = adminUsername.getText();
            String password = String.valueOf(passWord.getPassword());

            // if the input is equals to this show the studentForm
            if (admin.equals("admin") && password.equals("1234")) {
                studentForm studentform = new studentForm();
                studentform.setVisible(true);
                studentform.pack();
                this.dispose();
            } // if not equals they have error message
            else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Username or Password");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminPicture;
    private javax.swing.JTextField adminUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lockP;
    private javax.swing.JLabel padlockP;
    private javax.swing.JPasswordField passWord;
    // End of variables declaration//GEN-END:variables
}
