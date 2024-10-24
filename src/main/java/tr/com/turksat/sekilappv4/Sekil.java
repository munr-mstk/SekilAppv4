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
        try {
            String[] parts = sekilStr.split(", ");
            String type = parts[0].trim();
            String values = parts[1].trim();

            switch (type) {
                case "Kare":
                    int boyut = Integer.parseInt(values.split(":")[1].trim());
                    return new Kare(boyut, '*');
                case "Dikdortgen":
                    String[] dimensions = values.split(":")[1].trim().split(",");
                    int genislik = Integer.parseInt(dimensions[0].trim());
                    int yukseklik = Integer.parseInt(dimensions[1].trim());
                    return new Dikdortgen(genislik, yukseklik, '*');
                case "Daire":
                    int cap = Integer.parseInt(values.split(":")[1].trim());
                    return new Daire(cap, '*');
                case "Üçgen":
                    int yukseklikUcgen = Integer.parseInt(values.split(":")[1].trim());
                    return new Ucgen(yukseklikUcgen, '*');
                default:
                    LogUtil.log("Geçersiz şekil tipi: " + type);
            }
        } catch (Exception e) {
            LogUtil.log("Hata oluştu: " + e.getMessage() + " için satır: " + sekilStr);
        }

        return null;
    }

}