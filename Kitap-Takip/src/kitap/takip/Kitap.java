package kitap.takip;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;
import static kitap.takip.main.day;

class Kitap{

        String kategori;
        String kitap_isim;
        int kitap_ISBN_NO;
        int alinmaGun;
        String erisilebilirlik="müsait";
        Queue<Ogrenci> kitapSira  = new LinkedList<Ogrenci>();
        int siradakiKisiSayisi=0;
        public Kitap(String isim,int no,String kategori){
            this.kitap_isim=isim;
            this.kitap_ISBN_NO=no;
            this.kategori=kategori;
        }
        public String kitapAl(Ogrenci o){
            if(o.alinanKitapSayisi>4) { //ogrenci kitap sayısı index olarak 5 e erişilirse uyarı verir
                o.gunHesapla();
                return (o.ad + ", daha fazla kitap alabilmen için eski kitaplarını bitirip teslim etmelisin.");
            }
            else{
                o.alinanKitapSayisi++;
                o.alinan.add(this);
                alinmaGun=day.getDay();
                erisilebilirlik="ödünç alındı";
                return ("Kitap başarıyla alındı.");
            }
        }
        public void sırayaEkle(Ogrenci o){
            kitapSira.add(o);
            siradakiKisiSayisi++;
            System.out.println("Bu kitap şuanda müsait değildir. Sırada "+siradakiKisiSayisi+" kişi vardır. Sıra size geldiğinde alabilirsiniz.");

        }
        public void kitapTeslim(){
            erisilebilirlik="müsait";
            System.out.println( "Kitabı başarılı bir şekilde teslim ettiniz.");
        }
    }