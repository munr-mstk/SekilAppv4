package tr.com.turksat.sekilappv4;

public interface Sekil {
    /**
     * Şekli ekrana çizer.
     */
    void ciz();

    /**
     * Şeklin sembolünü değiştirir.
     * @param yeniSembol Yeni sembol
     */
    void sembolDegistir(char yeniSembol);

    /**
     * Şeklin alanını hesaplar.
     * @return Alan değeri
     */
    double alanHesapla();

    /**
     * Şeklin çevresini hesaplar.
     * @return Çevre değeri
     */
    double cevreHesapla();

    /**
     * Şekli string olarak ifade eder.
     * @return String ifadesi
     */
    String toString();

    /**
     * String ifadesinden şekil nesnesi oluşturur.
     * @param sekilStr Şekil verisi içeren string
     * @return Şekil nesnesi
     */
    static Sekil fromString(String sekilStr) {
        if (sekilStr.startsWith("Kare:")) {
            int boyut = Integer.parseInt(sekilStr.split(":")[1]);
            return new Kare(boyut, '*');
        } else if (sekilStr.startsWith("Dikdortgen:")) {
            String[] parts = sekilStr.split(":")[1].split(",");
            int genislik = Integer.parseInt(parts[0]);
            int yukseklik = Integer.parseInt(parts[1]);
            return new Dikdortgen(genislik, yukseklik, '*');
        }

        return null;
    }
}


