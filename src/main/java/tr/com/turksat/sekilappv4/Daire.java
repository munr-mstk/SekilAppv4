package tr.com.turksat.sekilappv4;

public class Daire implements Sekil{
    private int cap;
    private char sembol;
    private final char DEFAULT_SYMBOL = '*';

    /**
     * Daire sınıfının yapıcı metodu.
     * @param cap Dairenin çapı
     * @param sembol Dairenin çizileceği sembol
     */
    public Daire(int cap, char sembol) {
        this.cap = cap;
        this.sembol = sembol == 0 ? DEFAULT_SYMBOL : sembol;
    }
    @Override
    public String toString() {
        return "Daire, Çap: " + cap + ", Sembol: " + sembol;
    }

    /**
     * Dairenin çizim metodudur. Dairenin çarpını kullanarak
     * iki boyutlu bir alan üzerinde semboller ile çizer.
     */
    @Override
    public void ciz() {
        double r = cap / 2.0;
        for (int i = 0; i <= cap; i++) {
            for (int j = 0; j <= cap; j++) {
                double distance = Math.sqrt(Math.pow(i - r, 2) + Math.pow(j - r, 2));
                if (distance > r - 0.5 && distance < r + 0.5) {
                    System.out.print(sembol + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        LogUtil.log("Daire alanı: " + alanHesapla());
        LogUtil.log("Daire çevresi: " + cevreHesapla());
    }

    /**
     * Dairenin çizim sembolünü değiştirir.
     * @param yeniSembol Yeni sembol
     */
    @Override
    public void sembolDegistir(char yeniSembol) {
        this.sembol = yeniSembol;
    }

    /**
     * Dairenin alanını hesaplar.
     * @return Dairenin alanı
     */
    @Override
    public double alanHesapla() {
        double r = cap / 2.0;
        return Math.PI * r * r;
    }

    /**
     * Dairenin çevresini hesaplar.
     * @return Dairenin çevresi
     */
    @Override
    public double cevreHesapla() {
        return Math.PI * cap;
    }
}




