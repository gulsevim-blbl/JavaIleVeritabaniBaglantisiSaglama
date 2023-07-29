
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
    
  public void calısanEkle(){
      
        try {
            statement = con.createStatement();
            
            String ad = "Semih";
            String soyad = "Aktaş";
            String email = "semihaktas@gmail.com";
             //Insert Into calısanlar (ad,soyad,email) VALUES ('Yusuf', 'Cetinkaya', 'yusufcetinkaya@gmail.com')
            String sorgu = "Insert Into calisanlar (ad,soyad,email) VALUES(" + "'" + ad + "'," + "'" + soyad + "'," + "'" + email + "')";
            
            statement.executeUpdate(sorgu);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
       
  }
  public void calisanSil(){
      
        try {
            statement = con.createStatement();
            
            
            String sorgu = "Delete from calisanlar where id > 3";
            
           int deger = statement.executeUpdate(sorgu);
            System.out.println(deger + "Kadar Veri Etkilendi...." );
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
  }
    public  void calisanGuncelle() {
        
        try {
            statement = con.createStatement();
            
            String sorgu = "Update calisanlar Set email = 'gulsevimblbl@gmail.com' where id = 1";
            
            statement.executeUpdate(sorgu);
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calisanlariGetir() {
        
        String sorgu = "Select * From calisanlar ";
      
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
      
      /*  Baglanti baglanti = new Baglanti();
        System.out.println("Eklenmeden Once...................");
        baglanti.calisanlariGetir();
        System.out.println("***********************************");
        baglanti.calısanEkle();
        baglanti.calisanlariGetir();
        */
       /* Baglanti baglanti = new Baglanti();
        System.out.println("Guncellenmeden Once............");
        baglanti.calisanlariGetir();
        System.out.println("********************************");
        System.out.println("Guncellendikten Sonra..........");
        baglanti.calisanGuncelle();
        baglanti.calisanlariGetir();
        */
       
       Baglanti baglanti = new Baglanti();
        System.out.println("Silinmeden Once..........");
        baglanti.calisanlariGetir();
        System.out.println("*************************");
        System.out.println("Silindikten Sonra");
        baglanti.calisanSil();
        baglanti.calisanlariGetir();
        
    }
    
    
}
