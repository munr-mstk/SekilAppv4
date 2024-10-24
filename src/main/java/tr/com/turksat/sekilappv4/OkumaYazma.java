package tr.com.turksat.sekilappv4;

import java.io.*;
import java.util.List;

public class OkumaYazma {

    private static double toplamAlan = 0; // Toplam alan
    private static double toplamCevre = 0; // Toplam çevre

    /**
     * Dosyadan şekilleri oku ve verilen listeye ekle.
     *
     * @param dosyaAdi     Okunacak dosyanın adı.
     * @param sekilListesi Şekillerin ekleneceği liste.
     */
    public static void dosyadanSekilleriOku(String dosyaAdi, List<Sekil> sekilListesi) {
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                Sekil yeniSekil = Sekil.fromString(satir);
                if (yeniSekil != null) {
                    sekilListesi.add(yeniSekil);

                    toplamAlan += yeniSekil.alanHesapla();
                    toplamCevre += yeniSekil.cevreHesapla();
                } else {
                    LogUtil.log( satir);
                }
            }
            LogUtil.log("Şekiller başarıyla dosyadan okundu ve listeye eklendi.");
        } catch (IOException e) {
            LogUtil.log("Dosya okunurken hata oluştu: " + e.getMessage());
        }
    }

    /**
     * Verilen şekil listesindeki şekilleri belirtilen dosyaya yazar.
     *
     * @param dosyaAdi     Yazılacak dosyanın adı.
     * @param sekilListesi Yazılacak şekillerin listesi.
     */
    public static void listeyiDosyayaYaz(String dosyaAdi, List<Sekil> sekilListesi) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dosyaAdi))) {
            for (Sekil sekil : sekilListesi) {
                if (sekil != null) {
                    bw.write(sekil.toString());
                    bw.newLine();
                }
            }
            LogUtil.log("Şekil listesi başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            LogUtil.log("Dosya yazılırken hata oluştu: " + e.getMessage());
        }
    }

    /**
     * Verilen şekil listesini sıfırlayın ve toplam alan/çevre değerlerini sıfırlayın.
     *
     * @param sekilListesi Sıfırlanacak şekil listesi.
     */
    public static void listeyiSifirla(List<Sekil> sekilListesi) {
        sekilListesi.clear();
        toplamAlan = 0;
        toplamCevre = 0;
        LogUtil.log("Liste ve toplam alan/çevre başarıyla sıfırlandı.");
    }

    /**
     * Toplam alanı döndürür.
     *
     * @return Toplam alan değeri.
     */
    public static double getToplamAlan() {
        return toplamAlan;
    }

    /**
     * Toplam çevreyi döndürür.
     *
     * @return Toplam çevre değeri.
     */
    public static double getToplamCevre() {
        return toplamCevre;
    }
}
