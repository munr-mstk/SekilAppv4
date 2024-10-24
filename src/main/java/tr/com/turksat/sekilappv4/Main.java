package tr.com.turksat.sekilappv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String java_calismalarim = "sekiller.txt";
    private static List<Sekil> sekilListesi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sekil seciliSekil = null;
        char sembol = '*';

        while (true) {
            LogUtil.log("");
            LogUtil.log("Seçenekler:");
            LogUtil.log("1: Küçük Kare çiz");
            LogUtil.log("2: İstediğin boyutta kare çiz");
            LogUtil.log("3: Dikdörtken çiz");
            LogUtil.log("4: Üçgen çiz");
            LogUtil.log("5: Daire çiz");
            LogUtil.log("6: Toplam alan ve çevre bilgilerini göster");
            LogUtil.log("7: Alan ve çevre hesaplamalarını sıfırla");
            LogUtil.log("8: Yeni Sembol ");
            LogUtil.log("9: Şekilleri dosyadan oku ve listeye ekle");
            LogUtil.log("10: Listedeki şekilleri dosyaya yaz");
            LogUtil.log("11: Listedeki şekilleri sıfırla");
            LogUtil.log("12: Çıkış");
            LogUtil.log("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    seciliSekil = new Kare(3, sembol);
                    sekilListesi.add(seciliSekil);
                    seciliSekil.ciz();
                    break;
                case 2:
                    LogUtil.log("Kare boyutunu girin: ");
                    int kareBoyut = scanner.nextInt();
                    seciliSekil = new Kare(kareBoyut, sembol);
                    sekilListesi.add(seciliSekil);
                    seciliSekil.ciz();
                    break;
                case 3:
                    LogUtil.log("Dikdörtgen genişliğini girin: ");
                    int genislik = scanner.nextInt();
                    LogUtil.log("Dikdörtgen yüksekliğini girin: ");
                    int yukseklik = scanner.nextInt();
                    seciliSekil = new Dikdortgen(genislik, yukseklik, sembol);
                    sekilListesi.add(seciliSekil);
                    seciliSekil.ciz();
                    break;
                case 4:
                    LogUtil.log("Üçgenin yüksekliğini girin:");
                    int yukselik = scanner.nextInt();
                    seciliSekil = new Ucgen(yukselik, sembol);
                    sekilListesi.add(seciliSekil);
                    seciliSekil.ciz();
                    break;
                case 5:
                    LogUtil.log("Dairenin çapını girin: ");
                    int cap = scanner.nextInt();
                    seciliSekil = new Daire(cap, sembol);
                    sekilListesi.add(seciliSekil);
                    seciliSekil.ciz();
                    break;
                case 6:
                    hesaplaToplamAlanVeCevre();
                    break;
                case 7:
                    sekilListesi.clear();
                    LogUtil.log("Şekil listesi sıfırlandı.");
                    break;
                case 8:
                    System.out.print("Yeni sembolü girin: ");
                    sembol = scanner.next().charAt(0);
                    if (seciliSekil != null) {
                        seciliSekil.sembolDegistir(sembol);
                        seciliSekil.ciz();
                    }
                    break;
                case 9:
                    OkumaYazma.dosyadanSekilleriOku(java_calismalarim, sekilListesi);
                    break;
                case 10:
                    OkumaYazma.listeyiDosyayaYaz(java_calismalarim, sekilListesi);
                    break;
                case 11:
                    sekilListesi.clear();
                    LogUtil.log("Şekil listesi sıfırlandı.");
                    break;
                case 12:
                    LogUtil.log("Programdan çıkılıyor...");

                    break;
                default:
                    LogUtil.log("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    private static void hesaplaToplamAlanVeCevre() {
        double toplamAlan = 0;
        double toplamCevre = 0;

        for (Sekil sekil : sekilListesi) {
            toplamAlan += sekil.alanHesapla();
            toplamCevre += sekil.cevreHesapla();
        }

        LogUtil.log("Toplam alan: " + toplamAlan);
        LogUtil.log("Toplam çevre: " + toplamCevre);
    }
}
