package tr.com.turksat.sekilappv4;

/**
 * Ucgen sınıfı, üçgen geometrik şeklinin özelliklerini tanımlar ve
 * çizim, alan ve çevre hesaplamaları yapar.
 */
public class Ucgen implements Sekil {

    private int yukseklik; // Üçgenin yüksekliği
    private char sembol; // Üçgeni temsil eden sembol
    private final char DEFAULT_SYMBOL = '*';

    /**
     * Ucgen sınıfının yapıcısı.
     * @param yukseklik Üçgenin yüksekliği
     * @param sembol Üçgenin sembolü
     */
    public Ucgen(int yukseklik, char sembol) {
        this.yukseklik = yukseklik; // Yüksekliği ayarla
        this.sembol = sembol == 0 ? DEFAULT_SYMBOL : sembol; // Sembolü ayarla, eğer sıfır ise varsayılan sembolü kullan
    }

    @Override
    public String toString() {
        return "Üçgen, Yükseklik: " + yukseklik + ", Sembol: " + sembol;
    }

    /**
     * Üçgeni çizen metot.
     * Üçgenin yüksekliğine göre uygun sayıda boşluk ve sembol basarak
     * üçgenin şekli ekrana çizilir.
     */
    @Override
    public void ciz() {
        for (int i = 0; i < yukseklik; i++) {
            // Boşlukları yazdır
            for (int j = 0; j < yukseklik - i - 1; j++) {
                System.out.print("  "); // Üst kısımda boşluk bırak
            }
            // Üçgenin sembollerini yazdır
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(sembol + " "); // Sembolü yazdır
            }
            System.out.println(); // Satır sonu
        }
        // Üçgenin alanını ve çevresini logla
        LogUtil.log("Üçgen alanı: " + alanHesapla());
        LogUtil.log("Üçgen çevresi: " + cevreHesapla());
    }

    /**
     * Üçgenin sembolünü değiştiren metot.
     * @param yeniSembol Yeni sembol
     */
    @Override
    public void sembolDegistir(char yeniSembol) {
        this.sembol = yeniSembol; // Yeni sembolü ayarla
    }

    /**
     * Üçgenin alanını hesaplar.
     * Üçgen alanı = (taban uzunluğu * yükseklik) / 2 formülü ile hesaplanır.
     * @return Üçgenin alanı
     */
    @Override
    public double alanHesapla() {
        int taban = 2 * (yukseklik - 1) + 1; // Üçgenin tabanı
        return (taban * yukseklik) / 2.0; // Alan hesaplama
    }

    /**
     * Üçgenin çevresini hesaplar.
     * @return Üçgenin çevresi
     */
    @Override
    public double cevreHesapla() {
        int taban = 2 * (yukseklik - 1) + 1; // Üçgenin tabanı
        // Çevre = taban + 2 * (kenar uzunluğu) formülü ile hesaplanır
        return taban + 2 * Math.sqrt(Math.pow(taban / 2.0, 2) + Math.pow(yukseklik, 2));
    }
}
