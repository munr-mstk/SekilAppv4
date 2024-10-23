package tr.com.turksat.sekilappv4;

/**
 * ToplamAlanCevre sınıfı, birden fazla geometrik şeklin alan ve çevre
 * bilgilerini toplamak için kullanılan bir yardımcı sınıftır.
 */

public class ToplamAlanCevre {


    private double toplamAlan = 0;
    private double toplamCevre = 0;

    /**
     * Belirtilen alanı toplam alana ekler.
     * @param alan Eklenmek istenen alan değeri
     */
    public void alanEkle(double alan) {
        toplamAlan += alan;
    }

    /**
     * Belirtilen çevre değerini toplam çevreye ekler.
     * @param cevre Eklenmek istenen çevre değeri
     */
    public void cevreEkle(double cevre) {
        toplamCevre += cevre;
    }

    /**
     * Toplam alan ve çevre değerlerini sıfırlar.
     */
    public void reset() {
        toplamAlan = 0;
        toplamCevre = 0;
    }

    /**
     * Toplam alan ve çevre bilgilerini loglar.
     */
    public void toplamBilgisi() {
        LogUtil.log("Toplam alan: " + toplamAlan);
        LogUtil.log("Toplam çevre: " + toplamCevre);
    }


}
