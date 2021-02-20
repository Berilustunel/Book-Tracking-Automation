package kitap.takip;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class main {
    static Date day=new Date();
    public static void main(String[] args) {
        //Kitap Ekleme
        LinkedList<Kitap> kitaplar = new LinkedList<Kitap>();
        kitaplar.add(new Kitap("Fizik 1",1000001,"fizik"));
        kitaplar.add(new Kitap("Fizik 2",1000002,"fizik"));
        kitaplar.add(new Kitap("Matematik 1",1000003,"matematik"));
        kitaplar.add(new Kitap("Matematik 2",1000004,"matematik"));
        kitaplar.add(new Kitap("BMG 1",1000005,"bilgisayar mühendisliği"));
        kitaplar.add(new Kitap("BMG 2",1000006,"bilgisayar mühendisliği"));
        kitaplar.add(new Kitap("Kimya 1",1000007,"kimya"));
        kitaplar.add(new Kitap("Kimya 2",1000008,"kimya"));

        //kitaplık oluşturma
        LinkedList<Kitaplik> kitapliklar=new LinkedList<Kitaplik>();
        kitapliklar.add(new Kitaplik("fizik"));
        kitapliklar.add(new Kitaplik("matematik"));
        kitapliklar.add(new Kitaplik("bilgisayar mühendisliği"));
        kitapliklar.add(new Kitaplik("kimya"));

        //kitaplıga kitap ekleme ve raf olusturma
        int fizKitSay=0;
        int matKitSay=0;
        int bmgKitSay=0;
        int kimyaKitSay=0;
        for(int i=0;i<kitaplar.size();i++){
            if(kitaplar.get(i).kategori=="fizik"){ //her rafta 5 kitap olmak kosuluyla yeni raf ekleme
                if(fizKitSay%5==0){  //yeni rafa kitap ekleme
                    kitapliklar.get(0).rafEkle(new Raf());
                    kitapliklar.get(0).raflar.get(fizKitSay).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
                    fizKitSay++;
                }
                else //raf doluncaya kadar bir önceki rafa kitap ekleme
                    kitapliklar.get(0).raflar.get(fizKitSay-1).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
            }
            if(kitaplar.get(i).kategori=="matematik"){ //her rafta 5 kitap olmak kosuluyla yeni raf ekleme
                if(matKitSay%5==0){  //yeni rafa kitap ekleme
                    kitapliklar.get(1).rafEkle(new Raf());
                    kitapliklar.get(1).raflar.get(matKitSay).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
                    matKitSay++;
                }
                else //raf doluncaya kadar bir önceki rafa kitap ekleme
                    kitapliklar.get(1).raflar.get(matKitSay-1).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
            }
            if(kitaplar.get(i).kategori=="bilgisayar mühendisliği"){ //her rafta 5 kitap olmak kosuluyla yeni raf ekleme
                if(bmgKitSay%5==0){  //yeni rafa kitap ekleme
                    kitapliklar.get(2).rafEkle(new Raf());
                    kitapliklar.get(2).raflar.get(bmgKitSay).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
                    bmgKitSay++;
                }
                else //raf doluncaya kadar bir önceki rafa kitap ekleme
                    kitapliklar.get(2).raflar.get(bmgKitSay-1).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
            }
            if(kitaplar.get(i).kategori=="kimya"){ //her rafta 5 kitap olmak kosuluyla yeni raf ekleme
                if(kimyaKitSay%5==0){  //yeni rafa kitap ekleme
                    kitapliklar.get(3).rafEkle(new Raf());
                    kitapliklar.get(3).raflar.get(kimyaKitSay).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
                    kimyaKitSay++;
                }
                else //raf doluncaya kadar bir önceki rafa kitap ekleme
                    kitapliklar.get(3).raflar.get(kimyaKitSay-1).kitapEkle(new Kitap(kitaplar.get(i).kitap_isim,kitaplar.get(i).kitap_ISBN_NO,kitaplar.get(i).kategori));
            }
        }


        //Ogrenci Ekleme
        LinkedList<Ogrenci> ogrenciler = new LinkedList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Bill","Gates"));
        ogrenciler.add(new Ogrenci("Elon","Musk"));
        ogrenciler.add(new Ogrenci("Mark","Zuckerberg"));
        ogrenciler.add(new Ogrenci("Jeff","Bezos"));

        //kitap alma test1
        System.out.println(kitaplar.get(0).kitapAl(ogrenciler.get(2))); // 2 numaralı ogrenci kitap alıyor

        //test2
        ogrenciler.get(0).alinanKitapSayisi=5; // ilk ogrenci 6.kitabı almak istiyor ve hata alıyor
        System.out.println(kitaplar.get(5).kitapAl(ogrenciler.get(0)));

        //kitabın müsaitlik durumu kontrol ediliyor
        if(kitaplar.get(0).erisilebilirlik=="müsait"){
            System.out.println(kitaplar.get(6).kitapAl(ogrenciler.get(0)));
        }
        else
            kitaplar.get(0).sırayaEkle(ogrenciler.get(3)); //kitap ödünç alınmışsa kullanıcı sıraya ekleniyor

        //kitap teslimi testi
        kitaplar.get(0).kitapTeslim();

    }
    
}