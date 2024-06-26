/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UIAdmin;

import MODEL.Schedule;
import MODEL.Teacher;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ScheduleAdmin extends javax.swing.JFrame {

    boolean checkLoadColumnSchedule=false;
    DefaultTableModel modelSchedule=new DefaultTableModel();
    Schedule schedule=new Schedule();
    List<Schedule> listSchedule=new ArrayList<>();
    int idCourseSchedule;
    /**
     * Creates new form ScheduleAdmin
     */
    public ScheduleAdmin() {
        initComponents();
        loadSchedule();
    }
    public ScheduleAdmin(int id) {
        initComponents();
        loadSchedule();
        idCourseSchedule=id;
    }
    public boolean checkDate(String s){
        String pattern="^\\d{4}-\\d{2}-\\d{2}$";
        if(s.matches(pattern))
            return true;
        return false;
    }
    public boolean checkTime(String s){
        String regex = "^([01]\\d|2[0-3]):([0-5]\\d)$";
        return s.matches(regex);
    }
    public static boolean checkInt(String s) {
        try {
            Integer.parseInt(s);
            return true; // Chuỗi s là dạng số int
        } catch (NumberFormatException e) {
            return false; // Chuỗi s không phải là dạng số int
    }
}
    void loadSchedule(){
        listSchedule=schedule.getScheduleByIDCourseSchedule(idCourseSchedule);
        modelSchedule=(DefaultTableModel) tblSchedule.getModel();
        modelSchedule.setRowCount(0);
        if(checkLoadColumnSchedule==false){
            modelSchedule.addColumn("ID");
            modelSchedule.addColumn("Day");
            modelSchedule.addColumn("Time");
            modelSchedule.addColumn("Number Of Schedule");
            modelSchedule.addColumn("ID Course Schedule");
            checkLoadColumnSchedule=true;
        }
        
        for(Schedule schedule: listSchedule){
            Object []row=new Object[]{schedule.getId(),schedule.getDate(),schedule.getTime(),schedule.getNumerOfShift(),schedule.getIdCourseSchedule()};
            modelSchedule.addRow(row);
        }
        tblSchedule.setModel(modelSchedule);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDaySchedule = new javax.swing.JTextField();
        txtNumerSchedule = new javax.swing.JTextField();
        btnCreateSchedule = new javax.swing.JButton();
        btnDeleteSchedule = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTimeSchedule = new javax.swing.JTextField();
        lblIDSchedule = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblNameClass = new javax.swing.JLabel();
        txtSearchSchedule = new javax.swing.JTextField();
        btnFindSchedule = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScheduleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSchedule);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setText("Day:");

        jLabel15.setText("Time:");

        btnCreateSchedule.setBackground(new java.awt.Color(51, 51, 255));
        btnCreateSchedule.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateSchedule.setText("CREATE");
        btnCreateSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateScheduleActionPerformed(evt);
            }
        });

        btnDeleteSchedule.setBackground(new java.awt.Color(51, 51, 255));
        btnDeleteSchedule.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteSchedule.setText("DELETE");
        btnDeleteSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteScheduleActionPerformed(evt);
            }
        });

        jLabel2.setText("Number of Shift");

        lblIDSchedule.setText("ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel2)
                            .addComponent(lblIDSchedule))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumerSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(txtTimeSchedule)
                            .addComponent(txtDaySchedule)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCreateSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtDaySchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimeSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumerSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblIDSchedule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblNameClass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNameClass.setText("Day");

        txtSearchSchedule.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnFindSchedule.setBackground(new java.awt.Color(255, 51, 51));
        btnFindSchedule.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFindSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnFindSchedule.setText("Find");
        btnFindSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindScheduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblNameClass)
                .addGap(18, 18, 18)
                .addComponent(txtSearchSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFindSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameClass)
                    .addComponent(txtSearchSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked
        int index=tblSchedule.getSelectedRow();
        Schedule schedule=listSchedule.get(index);
        lblIDSchedule.setText(""+schedule.getId());
        txtDaySchedule.setText(schedule.getDate().toString());
        txtTimeSchedule.setText(schedule.getTime());
        txtNumerSchedule.setText(""+schedule.getNumerOfShift());
    }//GEN-LAST:event_tblScheduleMouseClicked

    private void btnCreateScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateScheduleActionPerformed
        if(txtTimeSchedule.getText().trim().isEmpty() || txtNumerSchedule.getText().trim().isEmpty() || txtDaySchedule.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
        }else if(!checkDate(txtDaySchedule.getText())){
            JOptionPane.showMessageDialog(rootPane, "Nhập đúng định dạng yyyy-mm-dd");
        }else if(!checkTime(txtTimeSchedule.getText())){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập đúng định dạng hh:mm");
        }else if(!checkInt(txtNumerSchedule.getText())){
            JOptionPane.showMessageDialog(rootPane, "Nhập đúng kiểu int");
        }else try {
            if(schedule.checkSchedule(idCourseSchedule, Date.valueOf(txtDaySchedule.getText()))){
                JOptionPane.showMessageDialog(rootPane, "Trùng lịch!!! Chọn lịch khác");          
            }else{
                schedule.insertSchedule(Date.valueOf(txtDaySchedule.getText()), txtTimeSchedule.getText(), Integer.parseInt(txtNumerSchedule.getText()), idCourseSchedule);
                JOptionPane.showMessageDialog(rootPane, "Thêm lịch thành công");
                loadSchedule();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateScheduleActionPerformed

    private void btnDeleteScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteScheduleActionPerformed
        if(!lblIDSchedule.getText().isEmpty()){
            if(Integer.parseInt(lblIDSchedule.getText())>0){
                try {
                    schedule.deleteSchedule(Integer.parseInt(lblIDSchedule.getText()));
                    loadSchedule();
                } catch (SQLException ex) {
                    Logger.getLogger(ScheduleAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Xáo lịch thành công");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn lịch cần xóa" );
        }
        
    }//GEN-LAST:event_btnDeleteScheduleActionPerformed

    private void btnFindScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindScheduleActionPerformed
        if(txtSearchSchedule.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập ngày cần tìm");
            loadSchedule();
        }
        else if(!checkDate(txtSearchSchedule.getText())){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập định dạng yyyy-mm-dd");
            loadSchedule();
        }else{
            listSchedule=schedule.getScheduleByIDCourseSchedule(idCourseSchedule);
            modelSchedule=(DefaultTableModel) tblSchedule.getModel();
            modelSchedule.setRowCount(0);
            System.out.println("Test "+txtSearchSchedule.getText());
            for(Schedule schedule: listSchedule){
                System.out.println(schedule.getDate().toString());
                if(schedule.getDate().toString().equals(txtSearchSchedule.getText())){
                    Object []row=new Object[]{schedule.getId(),schedule.getDate(),schedule.getTime(),schedule.getNumerOfShift(),schedule.getIdCourseSchedule()};
                    modelSchedule.addRow(row);
                }
            }
            tblSchedule.setModel(modelSchedule);
        }
            
    }//GEN-LAST:event_btnFindScheduleActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateSchedule;
    private javax.swing.JButton btnDeleteSchedule;
    private javax.swing.JButton btnFindSchedule;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblIDSchedule;
    private javax.swing.JLabel lblNameClass;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtDaySchedule;
    private javax.swing.JTextField txtNumerSchedule;
    private javax.swing.JTextField txtSearchSchedule;
    private javax.swing.JTextField txtTimeSchedule;
    // End of variables declaration//GEN-END:variables
}
