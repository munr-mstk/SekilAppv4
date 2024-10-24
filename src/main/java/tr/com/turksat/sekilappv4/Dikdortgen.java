package tr.com.turksat.sekilappv4;
/**
 * Dikdortgen sınıfı, dikdörtgen nesnelerini temsil eder ve
 * dikdörtgenin çizimini, alanını ve çevresini hesaplar.
 */

public class Dikdortgen implements Sekil{

    private int genislik;
    private int yukseklik;
    private char sembol;
    private final char DEFAULT_SYMBOL = '*';

    /**
     * Dikdörtgen sınıfının yapıcı metodu.
     * @param genislik Dikdörtgenin genişliği
     * @param yukseklik Dikdörtgenin yüksekliği
     * @param sembol Dikdörtgenin çizileceği sembol
     */
    public Dikdortgen(int genislik, int yukseklik, char sembol) {
        this.genislik = genislik;
        this.yukseklik = yukseklik;
        this.sembol = sembol == 0 ? DEFAULT_SYMBOL : sembol;
    }


    @Override
    public String toString() {
        return "Dikdörtgen, Genişlik: " + genislik + ", Yükseklik: " + yukseklik + ", Sembol: " + sembol;
    }

    /**
     * Dikdörtgenin çizim metodudur. Dikdörtgenin genişliğini
     * ve yüksekliğini kullanarak iki boyutlu bir alan üzerinde
     * semboller ile çizer.
     */
    @Override
    public void ciz() {

        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                System.out.print(sembol + " ");
            }
            System.out.println();
        }

        LogUtil.log("Dikdörtgen alanı: " + alanHesapla());
        LogUtil.log("Dikdörtgen çevresi: " + cevreHesapla());
    }

    /**
     * Dikdörtgenin çizim sembolünü değiştirir.
     * @param yeniSembol Yeni sembol
     */
    @Override
    public void sembolDegistir(char yeniSembol) {
        this.sembol = yeniSembol;
    }

    /**
     * Dikdörtgenin alanını hesaplar.
     * @return Dikdörtgenin alanı
     */
    @Override
    public double alanHesapla() {
        return genislik * yukseklik;
    }

    /**
     * Dikdörtgenin çevresini hesaplar.
     * @return Dikdörtgenin çevresi
     */
    @Override
    public double cevreHesapla() {
        return 2 * (genislik + yukseklik);
    }
}





