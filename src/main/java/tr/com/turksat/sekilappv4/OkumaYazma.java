package tr.com.turksat.sekilappv4;

import java.io.*;
import java.util.List;

public class OkumaYazma {

    /**
     *
     * @param dosyaAdi     Okunacak dosyanın adı.
     * @param sekilListesi Şekillerin ekleneceği liste.
     */
    public static void dosyadanSekilleriOku(String dosyaAdi, List<Sekil> sekilListesi) {
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                Sekil yeniSekil = Sekil.fromString(satir);
                sekilListesi.add(yeniSekil);
            }
            LogUtil.log("Şekiller başarıyla dosyadan okundı ve listeye eklendi.");
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
            // Liste üzerindeki her şekil için yazma işlemo yapılıyor
            for (Sekil sekil : sekilListesi) {
                if (sekil != null) {
                    bw.write(sekil.toString());
                    bw.newLine();
                }
            }
            LogUtil.log("Şekil listesi başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            // Dosya yazma sırasında hata oluşursa buradan yakelaniyor.
            LogUtil.log("Dosya yazılırken hata oluştu: " + e.getMessage());
        }
    }

    /**
     * Verilen şekil listesini sıfırlar.
     *
     * @param sekilListesi Sıfırlanacak şekil listesi.
     */
    public static void listeyiSifirla(List<Sekil> sekilListesi) {
        sekilListesi.clear();
        System.out.println("Liste başarıyla sıfırlandı.");
    }


}
