/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project.attempt.pkg1.views.admin;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import pkgfinal.project.attempt.pkg1.model.Movie;

/**
 *a
 * @author Yosua
 */
public class AdminView_EditMovie extends javax.swing.JFrame {

    /**
     * Creates new form AddMovie
     */
    public AdminView_EditMovie() {
        initComponents();
    }
    
    public void addEditMoviesActionListeners(ActionListener a){
        btnEditMovie.addActionListener(a);
    }
    
    public Movie getMovie() {
        String name = txtMovieName.getText();
        String genre1 = (String) cbxGenre1.getSelectedItem();
        String genre2 = (String) cbxGenre2.getSelectedItem();
        String genre3 = (String) cbxGenre3.getSelectedItem();
        String allGenre = genre1 +","+ genre2 + ","+genre3;
        String director = txtDirector.getText();
        int hour =  (Integer) sprHours.getValue();
        int minute = (Integer)  sprMinutes.getValue();
        Time duration = new Time(hour,minute,0);
        String trailer_url = txtTrailerUrl.getText();
        File poster = choosenFilePoster;
        double rating =  (Double) sprRating.getValue();
        Movie m = new Movie(name,genre1,genre2,genre3,duration,director,trailer_url,poster,rating);
        return m;
    }

    public boolean complete() {
        Movie m = getMovie();
        if (m.getName().equals("")) return false;
        if (m.getGenre1().equals("")) return false;
        if (m.getGenre2().equals("")) return false;
        if (m.getGenre3().equals("")) return false;
        if (m.getDirector().equals("")) return false;
        if (m.getDuration().equals("")) return false;
        if (m.getTrailerurl().equals("")) return false;
        if (m.getPoster() == null) return false;
        if (m.getRating() < 0) return false;
        else return true;
    }

    public void setMovie(ResultSet rs) {
        try {
            if (rs.next()){
                txtMovieName.setText(rs.getString("Name"));
                cbxGenre1.setSelectedItem(rs.getString("G1"));
                cbxGenre2.setSelectedItem(rs.getString("G2"));
                cbxGenre3.setSelectedItem(rs.getString("G3"));
                Time duration = rs.getTime("Duration");
                int hour = duration.getHours();
                int minutes = duration.getMinutes();
                System.out.println(hour + "eheheheheheheheheheheheheehehhe");
                
                
                sprHours.setValue(hour);
                sprMinutes.setValue(minutes);
                txtDirector.setText(rs.getString("Director"));
                txtTrailerUrl.setText(rs.getString("Trailer_URL"));
                sprRating.setValue(rs.getDouble("Rating"));
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminView_EditMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(AdminView_EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView_EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView_EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView_EditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView_EditMovie().setVisible(true);
            }
        });
    }
    
    private File choosenFilePoster = null;
    private int choosenIndex = -1; 

    public int getChoosenIndex() {
        return choosenIndex;
    }

    public void setChoosenIndex(int choosenIndex) {
        this.choosenIndex = choosenIndex;
    }

    public File getChoosenFilePoster() {
        return choosenFilePoster;
    }

    public void setChoosenFilePoster(File choosenFilePoster) {
        this.choosenFilePoster = choosenFilePoster;
    }
    public void addChooseFileListener(ActionListener a){
        this.btnPoster.addActionListener(a);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMovieName = new javax.swing.JLabel();
        txtMovieName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cbxGenre1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        cbxGenre2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxGenre3 = new javax.swing.JComboBox<>();
        lblDuration = new javax.swing.JLabel();
        lblDirector = new javax.swing.JLabel();
        sprHours = new javax.swing.JSpinner();
        lblHours = new javax.swing.JLabel();
        lblMinutes = new javax.swing.JLabel();
        txtDirector = new javax.swing.JTextField();
        lblTrailerUrl = new javax.swing.JLabel();
        txtTrailerUrl = new javax.swing.JTextField();
        lblPoster = new javax.swing.JLabel();
        btnPoster = new javax.swing.JButton();
        sprMinutes = new javax.swing.JSpinner();
        btnEditMovie = new javax.swing.JButton();
        lblRating = new javax.swing.JLabel();
        sprRating = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("CINEMA 21");

        lblMovieName.setText("Movie Name: ");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 200));
        jLabel4.setText("Genre");

        jLabel1.setText("Genre 1:");

        cbxGenre1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action ", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family ", "Fantasy", "Film-noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance", "Sci-fi", "Sport", "Thriller", "War", "Western" }));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 200));
        jLabel6.setText("Details");

        jLabel8.setText("Genre 2:");

        cbxGenre2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action ", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family ", "Fantasy", "Film-noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance", "Sci-fi", "Sport", "Thriller", "War", "Western" }));

        jLabel9.setText("Genre 3:");

        cbxGenre3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action ", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family ", "Fantasy", "Film-noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance", "Sci-fi", "Sport", "Thriller", "War", "Western" }));

        lblDuration.setText("Duration:   ");

        lblDirector.setText("Director:  ");

        sprHours.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblHours.setText("Hours");

        lblMinutes.setText("Minutes");

        lblTrailerUrl.setText("Trailer URL:");

        lblPoster.setText("Poster:       ");

        btnPoster.setText("Choose File");

        sprMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnEditMovie.setText("Edit Movie");

        lblRating.setText("Rating");

        sprRating.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxGenre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDuration)
                                            .addComponent(lblDirector)
                                            .addComponent(lblTrailerUrl)
                                            .addComponent(lblPoster))
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnPoster)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblRating)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(sprRating))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(sprHours, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblHours)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sprMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblMinutes))
                                            .addComponent(txtTrailerUrl, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDirector, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(88, 88, 88)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(cbxGenre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(cbxGenre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblMovieName)
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel3))))))
                            .addComponent(btnEditMovie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMovieName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxGenre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxGenre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxGenre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuration)
                    .addComponent(sprHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHours)
                    .addComponent(lblMinutes)
                    .addComponent(sprMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirector)
                    .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrailerUrl)
                    .addComponent(txtTrailerUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPoster)
                    .addComponent(btnPoster)
                    .addComponent(lblRating)
                    .addComponent(sprRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEditMovie)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditMovie;
    private javax.swing.JButton btnPoster;
    public javax.swing.JComboBox<String> cbxGenre1;
    public javax.swing.JComboBox<String> cbxGenre2;
    public javax.swing.JComboBox<String> cbxGenre3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDirector;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblMinutes;
    private javax.swing.JLabel lblMovieName;
    private javax.swing.JLabel lblPoster;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblTrailerUrl;
    private javax.swing.JSpinner sprHours;
    private javax.swing.JSpinner sprMinutes;
    private javax.swing.JSpinner sprRating;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtMovieName;
    private javax.swing.JTextField txtTrailerUrl;
    // End of variables declaration//GEN-END:variables

}
