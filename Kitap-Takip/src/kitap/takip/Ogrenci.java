package kitap.takip;
import java.util.Date;
import java.util.LinkedList;
import static kitap.takip.main.day;
        
public class Ogrenci{
        String ad;
        String soyad;
        int alinanKitapSayisi=0;
        LinkedList<Kitap> alinan = new LinkedList<Kitap>();
        public Ogrenci(String ad,String soyad){
            this.ad=ad;
            this.soyad=soyad;
        }

        void gunHesapla(){
            int bugun= day.getDay();
            for(int i=0;i<alinan.size();i++){
                if(bugun-alinan.get(i).alinmaGun>14){
                    System.out.println( alinan.get(i).kitap_isim+" adlı kitabı teslim etmeniz gerekiyor.");
                }
            }

        }
        
    }