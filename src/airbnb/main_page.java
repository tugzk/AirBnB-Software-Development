/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airbnb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tugrul
 */
public class main_page extends javax.swing.JFrame {

    public static List<String> selected = new ArrayList<String>();
    List<PropertyData> property = new ArrayList<PropertyData>();
    private Connection connection;
    Vector v;
    String propertyType;
    String roomType = "";
    String query;
    Function<String, String> addQuotes = s -> "\"" + s + "\"";

    public main_page() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        logged_user_label.setText("Logged as: " + login_page.user.getUname());
        JLabel nbLabel = new JLabel("Neighbourhood: ");
        jPanelCheck.setLayout(new BorderLayout());
        jPanelCheck.setBackground(Color.WHITE);
        v = new Vector();
        v.add("Select the Neighbourhood");
        getNeighbourhood();
        JComboCheckBox combobox = new JComboCheckBox(v);
        jPanelFilter.setLayout(new BorderLayout());
        jPanelFilter.setBackground(Color.WHITE);
        combobox.setPreferredSize(new Dimension(10, 25));
        jPanelFilter.add(nbLabel, BorderLayout.PAGE_START);
        jPanelFilter.add(combobox, BorderLayout.PAGE_START);
        combobox.setMaximumRowCount(13);
        propertyTable.setBackground(Color.WHITE);
        jPanelChart.setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propertyButtonGroup = new javax.swing.ButtonGroup();
        jPanelChart = new javax.swing.JPanel();
        jPanelFilter = new javax.swing.JPanel();
        jPanelCheck = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbHome = new javax.swing.JCheckBox();
        cbRoom = new javax.swing.JCheckBox();
        cbBoth = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        propertyTable = new javax.swing.JTable();
        search_tx = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        logged_user_label = new javax.swing.JLabel();
        logout_button = new javax.swing.JButton();
        loadChart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelChart.setLayout(new java.awt.BorderLayout());

        jPanelFilter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelFilter.setToolTipText("");
        jPanelFilter.setLayout(new java.awt.BorderLayout());

        jPanelCheck.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Property Type:");

        cbHome.setText("Entire Place");
        cbHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHomeActionPerformed(evt);
            }
        });

        cbRoom.setText("Private Room");
        cbRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomActionPerformed(evt);
            }
        });

        cbBoth.setText("Both");
        cbBoth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBothActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCheckLayout = new javax.swing.GroupLayout(jPanelCheck);
        jPanelCheck.setLayout(jPanelCheckLayout);
        jPanelCheckLayout.setHorizontalGroup(
            jPanelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRoom)
                    .addComponent(cbBoth)
                    .addComponent(cbHome)
                    .addComponent(jLabel1))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanelCheckLayout.setVerticalGroup(
            jPanelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHome)
                .addGap(18, 18, 18)
                .addComponent(cbRoom)
                .addGap(18, 18, 18)
                .addComponent(cbBoth)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        propertyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property Type", "Price", "Property name", "Host ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(propertyTable);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        logged_user_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logged_user_label.setText("User...");

        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        loadChart.setText("LOAD");
        loadChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(loadChart, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(search_tx, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logged_user_label, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadChart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_tx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logout_button)
                            .addComponent(logged_user_label))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadChartActionPerformed
        property.clear();
        propertyTable.repaint();
        createBarchart();
        createPropertyData();
        showData();
        for (int i = 0; i < selected.size(); i++) {
            System.out.print(selected.get(i));
        }
    }//GEN-LAST:event_loadChartActionPerformed

    private void cbBothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBothActionPerformed
        if (cbBoth.isSelected()) {
            cbHome.setSelected(true);
            cbRoom.setSelected(true);
        } else {
            cbHome.setSelected(false);
            cbRoom.setSelected(false);
        }
    }//GEN-LAST:event_cbBothActionPerformed

    private void cbHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHomeActionPerformed
        if (cbHome.isSelected()) {
            cbRoom.setSelected(false);
        }
    }//GEN-LAST:event_cbHomeActionPerformed

    private void cbRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomActionPerformed
        if (cbRoom.isSelected()) {
            cbHome.setSelected(false);
        }
    }//GEN-LAST:event_cbRoomActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        String search_text = search_tx.getText();
        DefaultTableModel model = (DefaultTableModel) propertyTable.getModel();
        String searchQuery = "SELECT room_type, price, property_name, hostId "
                + "FROM `Property` WHERE CONCAT(`room_type`, `price`, `property_name`, `hostId`) "
                + "LIKE'%" + search_text + "%'";
        try {
            connection = JDBC.getConnection();
            ResultSet result = connection.createStatement().executeQuery(searchQuery);
            Object[] row = new Object[4];
            property.clear();
            while (result.next()) {
                PropertyData data = new PropertyData(result.getString(1), result.getDouble(2), result.getString(3), result.getInt(4));
                property.add(data);
            }
            model.setRowCount(0);
            for (int i = 0; i < property.size(); i++) {
                row[0] = property.get(i).getPropertyType();
                row[1] = property.get(i).getPrice();
                row[2] = property.get(i).getPropertyName();
                row[3] = property.get(i).getHostId();
                model.addRow(row);
            }
        } catch (Exception ex) {
            System.out.println("Cannot connect to database...");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        login_page lp = new login_page();
        lp.setVisible(true);
        lp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logout_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_page().setVisible(true);
            }
        });
    }

    public void getNeighbourhood() {
        String query = "SELECT neighbourhood_name FROM Neighbourhood GROUP BY neighbourhood_name ";
        try {
            connection = JDBC.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                v.add(new JCheckBox(rs.getString(1), false));
            }
        } catch (Exception ex) {

        }
    }

    public void getRoomType() {
        if (cbHome.isSelected() && cbRoom.isSelected()) {
            roomType = "";
            System.out.println("Both");
        } else if (cbHome.isSelected()) {
            roomType = " AND room_type = \"Entire home/apt\" ";
            System.out.println("Entire home/apt");
        } else if (cbRoom.isSelected()) {
            roomType = " AND room_type = \"Private room\" ";
            System.out.println("Private room");
        }
    }

    public void createBarchart() {
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        getRoomType();

        String result = selected.stream().map(addQuotes).collect(Collectors.joining(", "));
        query = "SELECT AVG(price), neighbourhood_name FROM Property"
                + " WHERE neighbourhood_name IN ("
                + result + ")" + roomType + "GROUP BY neighbourhood_name ";

        try {
            connection = JDBC.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                barChartData.addValue(rs.getFloat(1), "", rs.getString(2));
            }
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Average Price by Neighbourhood", //Chart Title  
                    "", // Category axis  
                    "Price", // Value axis  
                    barChartData,
                    PlotOrientation.VERTICAL,
                    true, true, false);
            org.jfree.chart.axis.CategoryAxis axis = barChart.getCategoryPlot().getDomainAxis();
            axis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
            ChartPanel barPanel = new ChartPanel(barChart);
            jPanelChart.removeAll();
            jPanelChart.add(barPanel, BorderLayout.CENTER);
            jPanelChart.validate();

        } catch (Exception ex) {
        }

    }

    public void createPropertyData() {
        String result = selected.stream().map(addQuotes).collect(Collectors.joining(", "));
        getRoomType();
        String fetchData = "SELECT room_type, price, property_name, hostId FROM Property "
                + " WHERE neighbourhood_name IN ("
                + result + ")" + roomType;
        try {
            connection = JDBC.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(fetchData);
            while (rs.next()) {
                PropertyData data = new PropertyData(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getInt(4));
                property.add(data);
            }
        } catch (Exception ex) {

        }
    }

    public void showData() {
        DefaultTableModel model = (DefaultTableModel) propertyTable.getModel();
        Object[] row = new Object[4];
        model.setRowCount(0);
        for (int i = 0; i < property.size(); i++) {
            row[0] = property.get(i).getPropertyType();
            row[1] = property.get(i).getPrice();
            row[2] = property.get(i).getPropertyName();
            row[3] = property.get(i).getHostId();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbBoth;
    private javax.swing.JCheckBox cbHome;
    private javax.swing.JCheckBox cbRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelChart;
    private javax.swing.JPanel jPanelCheck;
    private javax.swing.JPanel jPanelFilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadChart;
    private javax.swing.JLabel logged_user_label;
    private javax.swing.JButton logout_button;
    private javax.swing.ButtonGroup propertyButtonGroup;
    private javax.swing.JTable propertyTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField search_tx;
    // End of variables declaration//GEN-END:variables
}
