package kontak;
import java.util.ArrayList;
public class Pengguna {
    private String id;
    private String nama;
    private String username;
    private String password;
    ArrayList<Kontak> kontak = new ArrayList<Kontak>();

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return this.nama;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setKontak(Kontak kontak){
        this.kontak.add(kontak);
    }

    public void removeKontak(int index){
        this.kontak.remove(index);
    }

    public ArrayList<Kontak> getKontak(){
        return this.kontak;
    }
}