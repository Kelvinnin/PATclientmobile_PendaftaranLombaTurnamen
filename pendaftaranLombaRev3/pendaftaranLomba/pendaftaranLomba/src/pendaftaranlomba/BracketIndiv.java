/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pendaftaranlomba;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ROG ZEPHYRUS
 */
public class BracketIndiv extends javax.swing.JFrame {
private DefaultTableModel tableModel1;
private DefaultTableModel tableModel2;
public String idpeserta;
public String idpeserta1;
    /**
     * Creates new form BracketIndiv
     */
    public BracketIndiv() {
        initComponents();
        
            tableModel2 = (DefaultTableModel) jTablePesertaIndiv.getModel();
     tableModel1 = (DefaultTableModel) jTablePesertaIndiv1.getModel();
        
          jTablePesertaIndiv1.addMouseListener(new java.awt.event.MouseAdapter() {
          
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = jTablePesertaIndiv1.getSelectedRow();
            idpeserta1 = jTablePesertaIndiv1.getValueAt(selectedRow, 11).toString();
               System.out.println("ID peserta 2: " + idpeserta1);
        }
    });
    
      jTablePesertaIndiv.addMouseListener(new java.awt.event.MouseAdapter() {
          
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = jTablePesertaIndiv.getSelectedRow();
            idpeserta = jTablePesertaIndiv.getValueAt(selectedRow, 11).toString();

            System.out.println("ID peserta: " + idpeserta);

        }
    });
        
        
        
    }
       public void viewPesertaIndiv(JSONArray jsonArray) {
           tableModel1.setRowCount(0);
        String kondisi ="";
        for (Object object : jsonArray) {
            JSONObject data = (JSONObject) object;
            String nama = (String) data.get("nama");
            String alamat = (String) data.get("alamat");
            String tanggal_lahir = (String) data.get("tanggal_lahir");
            String no_handphone = (String) data.get("no_handphone");
            String nrp = (String) data.get("nrp");
            String program_studi = (String) data.get("program_studi");
            String angkatan = (String) data.get("angkatan");
            Long win = (Long) data.get("win");
            Long lose = (Long) data.get("lose");
            String game = (String) data.get("nama_game");
            Long status = (Long) data.get("status");
            Long idpeserta = (Long) data.get("idpeserta");
            if (status == 0) {
                  kondisi = "pending";
              } else if (status == 1) {
                  kondisi = "Diterima";
              } else {
                  kondisi = "ditolak";
              }
            
            Object[] rowData = {nama,alamat,tanggal_lahir,no_handphone,nrp,program_studi,angkatan,game,win,lose,kondisi,idpeserta};
            tableModel1.addRow(rowData);
            tableModel2.addRow(rowData);
        }
         jTablePesertaIndiv.setModel(tableModel1);
         jTablePesertaIndiv1.setModel(tableModel2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesertaIndiv = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonBracketTeam = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePesertaIndiv1 = new javax.swing.JTable();
        jTextFieldTanggalBracket = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablePesertaIndiv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Peserta", "Alamat", "Tanggal Lahir", "No Telfon", "NRP", "Program Studi", "Angkatan", "Nama Game", "Win", "Lose", "Status", "idPeserta"
            }
        ));
        jScrollPane1.setViewportView(jTablePesertaIndiv);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Daftar Peserta Individu");

        jButtonBracketTeam.setText("Tandingkan");
        jButtonBracketTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBracketTeamActionPerformed(evt);
            }
        });

        jTablePesertaIndiv1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Peserta", "Alamat", "Tanggal Lahir", "No Telfon", "NRP", "Program Studi", "Angkatan", "Nama Game", "Win", "Lose", "Status", "idPeserta"
            }
        ));
        jScrollPane2.setViewportView(jTablePesertaIndiv1);

        jLabel1.setText("Tanggal");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextFieldTanggalBracket, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBracketTeam)
                        .addGap(36, 36, 36))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTanggalBracket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBracketTeam)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(253, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBracketTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBracketTeamActionPerformed
        // TODO add your handling code here:
                    String url = "http://localhost:7000/insertBracketIndividu";
    String date = jTextFieldTanggalBracket.getText();
    String postData = "{\"idpeserta\": " + idpeserta + ", \"idpeserta1\": " + idpeserta1 + ", \"date\": \"" + date + "\"}";

                try {
                            
                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                    // Set the request method to POST
                    con.setRequestMethod("POST");

                    // Set the request headers
                    con.setRequestProperty("Content-Type", "application/json");

                    // Enable the output stream and write the POST data
                    con.setDoOutput(true);
                    OutputStream os = con.getOutputStream();
                    os.write(postData.getBytes());
                    os.flush();
                    os.close();

                    // Get the response from the server (if needed)
                    int responseCode = con.getResponseCode();
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Handle the response (if needed)
                    System.out.println(response.toString());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            try {
            listPending form = new listPending();
            
      
            String url2 = "http://localhost:7000/PesertaGameIndividuDiterima";

      
            URL obj = new URL(url2);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

        
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("response");



            if (jsonArray.size() > 0) {
               form.viewPesertaTeam(jsonArray); 
             

             viewPesertaIndiv(jsonArray);
            } else {
                System.out.println("No data found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonBracketTeamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        index game = new index();
        String[] args = {};
        game.main(args);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BracketIndiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BracketIndiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BracketIndiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BracketIndiv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         BracketIndiv form = new BracketIndiv();
        try {
     

            String url = "http://localhost:7000/PesertaGameIndividuDiterima";

            // Buat objek URL dan HttpURLConnection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
      
            System.out.println(response.toString());
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("response");


            if (jsonArray.size() > 0) {
               form.viewPesertaIndiv(jsonArray); 
   
          
            } else {
                System.out.println("No data found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(BracketTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BracketTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BracketTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BracketTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
 form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBracketTeam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePesertaIndiv;
    private javax.swing.JTable jTablePesertaIndiv1;
    private javax.swing.JTextField jTextFieldTanggalBracket;
    // End of variables declaration//GEN-END:variables
}
