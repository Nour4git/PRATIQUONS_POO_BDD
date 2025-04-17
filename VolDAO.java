package PRATIQUONS1_BDD_POO;

import java.sql.*;
import java.util.*;

public class VolDAO {

    String url ="jdbc:mysql://localhost:3306/aeroport";
    String user ="root";
    String password = "";
    Connection conn;

    public VolDAO() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connexion réussie !");
        } catch (SQLException e) {
            System.out.println("erreur jdbc :" + e.getMessage());
        }
    }
    public List<Vol> getAllVols() {
        String reqselect = "SELECT * FROM vol";
        List<Vol> Listdevols = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(reqselect)) {
            while (rs.next()) {
            	Vol vol = new Vol(
                    rs.getString("numero_vol"),
                    rs.getString("ville_depart"),
                    rs.getString("ville_arrivee")
                );
                Listdevols.add(vol);
          }

        } catch (SQLException e) {
            System.out.println("erreur" + e.getMessage());
        }
        return Listdevols;
    }
    
    public void ajouterVol(Vol vol) {
    	
        String reqInsert = "INSERT INTO vol (numero_vol, ville_depart, ville_arrivee) VALUES (?, ?, ?)";
        try (PreparedStatement ps1 = conn.prepareStatement(reqInsert)) {
            ps1.setString(1,vol.getNumeroVol());
            ps1.setString(2,vol.getVilleDepart());
            ps1.setString(3,vol.getVilleArrive());
            ps1.executeUpdate();
            System.out.println("vol ajoutée avec succéess");
           
        } catch (SQLException e) {
            System.out.println("erreur:" + e.getMessage());
        }
    }
    
    public void modifierDestination(String numeroVol, String nouvelleDestination) {
    	
        String reqUpdate = "UPDATE vol SET ville_arrivee = ? WHERE numero_vol = ?";
        try (PreparedStatement ps2 = conn.prepareStatement(reqUpdate)) {
            ps2.setString(1,numeroVol);
            ps2.setString(2,nouvelleDestination);
            ps2.executeUpdate();
            System.out.println("Destination modifiée avec succès !");
        } catch (SQLException e) {
            System.out.println("erreur: " + e.getMessage());
        }
    }
    
    public Vol chercherVol(String numeroVol) {
        String reqSelect = "SELECT * FROM vol WHERE numeroVol = ?";
        Vol vol = null;

        try (PreparedStatement ps = conn.prepareStatement(reqSelect)) {
            ps.setString(1, numeroVol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vol = new Vol(
                        rs.getString("numero_vol"),
                        rs.getString("ville_depart"),
                        rs.getString("ville_arrive")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("erreur: "+ e.getMessage());
        }

        return vol;
    }
    

}
