
package kitap.takip;

import java.util.LinkedList;

public class Kitaplik {
        String kategori;
        int kitapSayisi=0;
        LinkedList<Raf> raflar = new LinkedList<Raf>();
        public Kitaplik(String kat){
            this.kategori=kat;
        }
        public void rafEkle(Raf r) {
            raflar.add(r);
    
        }
}