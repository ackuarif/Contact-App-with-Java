package kontak;
public class Kontak {
    private int id;
    private String nama;
    private String nomor;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return this.nama;
    }

    public void setNomor(String nomor){
        this.nomor = nomor;
    }

    public String getNomor(){
        return this.nomor;
    }
}