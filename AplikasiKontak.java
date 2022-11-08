import java.util.ArrayList;
import javax.swing.JOptionPane;
import kontak.*;

public class AplikasiKontak {
    ArrayList<Pengguna> pengguna = new ArrayList<Pengguna>();
    private Pengguna myLog;

    public boolean login(String username,String password){
        for (int i = 0; i < pengguna.size(); i++)
            if (pengguna.get(i).getUsername().equals(username) && pengguna.get(i).getPassword().equals(password)){
                this.myLog = pengguna.get(i);
                return true;
            }
        return false;
    }

    public boolean cekPengguna(String username){
        for (int i = 0; i < pengguna.size(); i++)
            if (pengguna.get(i).getUsername().equals(username))
                return true;
        return false;
    }

    public boolean cekKontak(String nama,String nomor){
        for (int i = 0; i < myLog.getKontak().size(); i++)
            if (myLog.getKontak().get(i).getNama().equals(nama) || myLog.getKontak().get(i).getNomor().equals(nomor))
                return true;
        return false;
    }

    public void menuAwal(){
        String menuAwal = JOptionPane.showInputDialog(""+
            "1.Login\n"+
            "2.Register\n"+
            "Silahkan masukkan pilihan"+
        ""); 
        switch(menuAwal){
            case "1" :
                menuLogin();
                break;
            case "2" :
                menuRegister();
                break;
            default:
                menuAwal();
        }
    }  

    public void menuLogin(){
        String username = JOptionPane.showInputDialog("Masukkan username");
        String password = JOptionPane.showInputDialog("Masukkan password");
        if(login(username,password))
            menuUtama();
        else{
            JOptionPane.showConfirmDialog(null, "Akun tidak ditemukan", "Login", JOptionPane.DEFAULT_OPTION);
            menuAwal();
        }
    }

    public void menuRegister(){
        String nama = JOptionPane.showInputDialog("Masukkan nama");
        String username = JOptionPane.showInputDialog("Masukkan username");
        String password = JOptionPane.showInputDialog("Masukkan password");

        if(nama.equals("")){
            JOptionPane.showConfirmDialog(null, "Nama harus diisi.", "Register", JOptionPane.DEFAULT_OPTION);
            menuRegister();
        }

        if(username.equals("")){
            JOptionPane.showConfirmDialog(null, "Username harus diisi.", "Register", JOptionPane.DEFAULT_OPTION);
            menuRegister();
        }

        if(password.equals("")){
            JOptionPane.showConfirmDialog(null, "Password harus diisi.", "Register", JOptionPane.DEFAULT_OPTION);
            menuRegister();
        }

        if(cekPengguna(username)){
            JOptionPane.showConfirmDialog(null, "Username telah digunakan pengguna lain.", "Register", JOptionPane.DEFAULT_OPTION);
            menuRegister();
        }
            
        Pengguna penggunaBaru = new Pengguna();
        String idPengguna = "3120510814-"+pengguna.size();
        penggunaBaru.setId(idPengguna);        
        penggunaBaru.setNama(nama);      
        penggunaBaru.setUsername(username); 
        penggunaBaru.setPassword(password);
        pengguna.add(penggunaBaru);
        JOptionPane.showConfirmDialog(null, "Data berhasil disimpan.", "Register", JOptionPane.DEFAULT_OPTION);
        menuAwal();
    }

    public void menuUtama(){
        String menuUtama = JOptionPane.showInputDialog(""+
            "ID Register : "+this.myLog.getId()+"\n"+
            "Username : "+this.myLog.getUsername()+"\n"+
            "Nama : "+this.myLog.getNama()+"\n"+
            "================================\n"+
            "1.Tambah Kontak\n"+
            "2.Daftar Kontak\n"+
            "3.Ubah Kontak\n"+
            "4.Hapus Kontak\n"+
            "5.Logout\n"+
            "Silahkan masukkan pilihan"+
        "");
        switch(menuUtama){
            case "1":
                menuTambahKontak();
            case "2":
                menuDaftarKontak();
            case "3":
                menuUbahKontak();
            case "4":
                menuHapusKontak();
            case "5":
                menuAwal();
            default:
                menuUtama();
        }
    }

    public void menuTambahKontak(){
        String nama = JOptionPane.showInputDialog("Masukkan nama");
        String nomor = JOptionPane.showInputDialog("Masukkan nomor");

        if(nama.equals("")){
            JOptionPane.showConfirmDialog(null, "Nama harus diisi.", "Kontak", JOptionPane.DEFAULT_OPTION);
            menuTambahKontak();
        }

        if(nomor.equals("")){
            JOptionPane.showConfirmDialog(null, "Nomor harus diisi.", "Kontak", JOptionPane.DEFAULT_OPTION);
            menuTambahKontak();
        }

        if(cekKontak(nama,nomor)){
            JOptionPane.showConfirmDialog(null, "Nama atau nomor telah tersedia di kontak.", "Kontak", JOptionPane.DEFAULT_OPTION);
            menuTambahKontak();
        }
            
        Kontak kontakBaru = new Kontak();
        int idKontak = (myLog.getKontak().size()+1);
        kontakBaru.setId(idKontak);        
        kontakBaru.setNama(nama);      
        kontakBaru.setNomor(nomor); 
        myLog.setKontak(kontakBaru);
        JOptionPane.showConfirmDialog(null, "Kontak berhasil disimpan.", "Register", JOptionPane.DEFAULT_OPTION);
        menuUtama();
    }

    public void menuDaftarKontak(){
        if(myLog.getKontak().size() > 0){
            String daftarKontak = "";
            for (int i = 0; i < myLog.getKontak().size(); i++){
                daftarKontak += ""+
                    "ID Kontak : "+myLog.getKontak().get(i).getId()+"\n"+
                    "Nama : "+myLog.getKontak().get(i).getNama()+"\n"+
                    "Nomor : "+myLog.getKontak().get(i).getNomor()+"\n"+
                    "=================================\n"
                ;
            }
            JOptionPane.showConfirmDialog(null, daftarKontak, "Daftar Kontak", JOptionPane.DEFAULT_OPTION);
        }
        else
            JOptionPane.showConfirmDialog(null, "Daftar kontak tidak tersedia.", "Daftar Kontak", JOptionPane.DEFAULT_OPTION);
        menuUtama();
    }

    public void menuUbahKontak(){
        String idKontakString = JOptionPane.showInputDialog("Masukkan ID Kontak :");
        int idKontak = Integer.parseInt(idKontakString);
        boolean tersedia = false;
        int index = 0;
        for (int i = 0; i < myLog.getKontak().size(); i++)
            if(myLog.getKontak().get(i).getId() == idKontak){
                tersedia = true;
                index = i;
                break;
            }
        
        if(tersedia){
            String nama = JOptionPane.showInputDialog("Masukkan nama");
            String nomor = JOptionPane.showInputDialog("Masukkan nomor");

            if(nama.equals("")){
                JOptionPane.showConfirmDialog(null, "Nama harus diisi.", "Kontak", JOptionPane.DEFAULT_OPTION);
                menuUbahKontak();
            }

            if(nomor.equals("")){
                JOptionPane.showConfirmDialog(null, "Nomor harus diisi.", "Kontak", JOptionPane.DEFAULT_OPTION);
                menuUbahKontak();
            }

            myLog.getKontak().get(index).setNama(nama);
            myLog.getKontak().get(index).setNomor(nomor);
            JOptionPane.showConfirmDialog(null, "Kontak berhasil diubah.", "Register", JOptionPane.DEFAULT_OPTION);
        }
        else
            JOptionPane.showConfirmDialog(null, "Kontak tidak ditemukan.", "Register", JOptionPane.DEFAULT_OPTION);
        menuUtama();       
    }

    public void menuHapusKontak(){
        String idKontakString = JOptionPane.showInputDialog("Masukkan ID Kontak :");
        int idKontak = Integer.parseInt(idKontakString);
        boolean tersedia = false;
        for (int i = 0; i < myLog.getKontak().size(); i++){
            if(myLog.getKontak().get(i).getId() == idKontak){
                myLog.removeKontak(i);
                tersedia = true;
                break;
            }
                
        }
        if(tersedia)
            JOptionPane.showConfirmDialog(null, "Kontak berhasil dihapus.", "Register", JOptionPane.DEFAULT_OPTION);
        else
            JOptionPane.showConfirmDialog(null, "Kontak tidak ditemukan.", "Register", JOptionPane.DEFAULT_OPTION);
        menuUtama();       
    }

    public static void main(String args[]){
        AplikasiKontak aplikasiKontak = new AplikasiKontak();
        aplikasiKontak.menuAwal();
    }
}