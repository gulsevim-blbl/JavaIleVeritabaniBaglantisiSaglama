
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class Baglanti {
    
    private String kullanici_adi = "root";
    private String parola = "";
    
    private String db_ismi = "demo";
    
    private String host =  "localhost";
    
    private int port = 3306;
    
    private Connection con = null;
    
    private Statement statement = null; //sql sorgusunu çalıştırmak için olan bir class
    
    
 
    
    public void calisanlariGetir() {
        
        String sorgu = "Select * From calisanlar where id > 2";
      
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String email = rs.getString("email");
                
                System.out.println(" Id : " + id + " Ad: " + ad + " Soyad : " + soyad + " Email : " + email);
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public Baglanti() {
        
        // "jbdc:mysql://localhost:3306/demo" 
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
         
        try {
            con = DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("Baglanti Basarili...");
            
            
        } catch (SQLException ex) {
            System.out.println("Baglanti Basarisiz...");
            //ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Baglanti baglanti = new Baglanti();
        baglanti.calisanlariGetir();
        
      
        
        
    }
    
    
}
