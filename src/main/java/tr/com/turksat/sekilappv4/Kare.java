package tr.com.turksat.sekilappv4;

/**
 * Kare sınıfı, kare nesnelerini temsil eder ve
 * karenin çizimini, alanını ve çevresini hesaplar.
 */
public class Kare implements Sekil {

    private int boyut;
    private char sembol;
    private final char DEFAULT_SYMBOL = '*';

    /**
     * Kare sınıfının yapıcı metodu.
     * @param boyut Karenin kenar uzunluğu
     * @param sembol Karenin çizileceği sembol
     */
    public Kare(int boyut, char sembol) {
        this.boyut = boyut; // Boyut ayarlanıyor
        this.sembol = sembol == 0 ? DEFAULT_SYMBOL : sembol;
    }

    @Override
    public String toString() {
        return "Kare, Boyut: " + boyut + ", Sembol: " + sembol;
    }

    /**
     * Karenin çizim metodudur. Karenin boyutunu kullanarak
     * iki boyutlu bir alan üzerinde semboller ile çizer.
     */
    @Override
    public void ciz() {
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                System.out.print(sembol + " ");
            }
            System.out.println();
        }
        LogUtil.log("Kare alanı: " + alanHesapla());
        LogUtil.log("Kare çevresi: " + cevreHesapla());
    }

    /**
     * Karenin çizim sembolünü değiştirir.
     * @param yeniSembol Yeni sembol
     */
    @Override
    public void sembolDegistir(char yeniSembol) {
        this.sembol = yeniSembol;
    }

    /**
     * Karenin alanını hesaplar.
     * @return Karenin alanı
     */
    @Override
    public double alanHesapla() {
        return boyut * boyut;
    }

    /**
     * Karenin çevresini hesaplar.
     * @return Karenin çevresi
     */
    @Override
    public double cevreHesapla() {
        return 4 * boyut;
    }
}
