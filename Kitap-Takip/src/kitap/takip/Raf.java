package kitap.takip;

import java.util.LinkedList;

public class Raf {

    LinkedList <Kitap> kitaplar = new LinkedList <Kitap>();
    public void kitapEkle(Kitap k) {
        kitaplar.add(k);

    }
}
