package proje3_okulYonetimi;


//	BİR OKUL YÖNETİM PLATFORMU KODALYINIZ.
//
//	1.	Bu programda, Öğrenci ve Öğretmen Kayıtları ile ilgili işlemler yapılabilmelidir.
//		Kayıtlarda şu bilgiler olabilmelidir.
//
//		Öğretmen: Ad-Soyad,  kimlik No, yaş, bölüm, ve sicil No bilgileri içermelidir.
//		Öğrenci: Ad-Soyad,  kimlik No, yaş, numara, sınıf bilgileri içermelidir.
//
//	2.	Program başladığında Kullanıcıya, Öğretmen ve Öğrenci işlemlerini seçebilmesi için
//		Aşağıdaki gibi bir menü gösterilsin.
//
//	====================================
//	 ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ
//	====================================
//	 1- ÖĞRENCİ İŞLEMLERİ
//	 2- ÖĞRETMEN İŞLEMLERİ
//	 Q- ÇIKIŞ
//
//	3.	Seçilen Kişi türüne göre aşağıdaki işlemleri gösteren bir alt menü daha gösterilsin.
//
//	============= İŞLEMLER =============
//		 1-EKLEME
//		 2-ARAMA
//		 3-LİSTELEME
//		 4-SİLME
//		 5-ANA MENÜ
//		 Q-ÇIKIŞ
//
//	SEÇİMİNİZ:
//
//	4.	İşlemler menüsünde seçilen işleme göre bir önceki menüde seçilen Kişi türü ile ilgili
//	    ekleme, kimlik no ile silme ve arama, var olan tüm kişileri listeleme gibi işlemler yapılabilmelidir.
//		Bunun yanında bir üst menüye dönme veya çıkış işlemleri de yapılabilmelidir.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {

    private List<Kisi> ogrenciListesi = new ArrayList<>();
    private List<Kisi> ogretmenListesi = new ArrayList<>();
    private String kisiTuru;

    public void anaMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println(" ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ");
        System.out.println("====================================");
        System.out.println("1- ÖĞRENCİ İŞLEMLERİ");
        System.out.println("2- ÖĞRETMEN İŞLEMLERİ");
        System.out.println("Q- ÇIKIŞ");
        String secim = scan.next().toUpperCase();

        if(secim.equals("Q")){
            cikis();
        }else if(secim.equals("1")){
            kisiTuru = "OGRENCI";
            islemMenusu();
        }else if(secim.equals("2")){
            kisiTuru = "OGRETMEN";
            islemMenusu();
        }else{
            System.out.println("Yanlış giriş yaptınız..");
            anaMenu();
        }
    }

    private void islemMenusu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("============= İŞLEMLER =============");
        System.out.println("1-EKLEME");
        System.out.println("2-ARAMA");
        System.out.println("3-LİSTELEME");
        System.out.println("4-SİLME");
        System.out.println("5-ANA MENÜ");
        System.out.println("Q-ÇIKIŞ\n");
        System.out.println("SEÇİMİNİZ:");
        String tercih = scan.next().toUpperCase();
        switch(tercih){
            case "1":   ekle();
                        break;
//            case "2":   ara();
//                        break;
//            case "3":   listele();
//                        break;
//            case "4":   sil();
//                        break;
            case "5":   anaMenu();
                        break;
            case "Q":   cikis();
                        break;
            default:    System.out.println("Hatalı seçim yaptınız.");
                        islemMenusu();
                        break;
        }
    }

    private void cikis(){
        System.out.println("Programı kullandığınız için teşekkürler..");
    }

    private void ekle(){
        Scanner scan = new Scanner(System.in);
        System.out.println("------------- " + kisiTuru + " EKLEME SAYFASI ----------------");
        System.out.println("Ad Soyad Giriniz:");
        String adSoyad = scan.nextLine();
        System.out.println("Kimlik No Giriniz:");
        String kimlikNo = scan.next();
        System.out.println("Yaşınızı Giriniz:");
        int yas = scan.nextInt();

        if(kisiTuru.equals("OGRENCI")){
            System.out.println("Numaranızı giriniz:");
            String numara = scan.next();
            System.out.println("Sınıf giriniz:");
            String sinif = scan.next();
            Ogrenci ogrenci = new Ogrenci(adSoyad,kimlikNo,yas,numara,sinif);
            ogrenciListesi.add(ogrenci);
        }else {
            System.out.println("Sicil No giriniz:");
            String sicilNo = scan.next();
            System.out.println("Bölüm giriniz:");
            String bolum = scan.next();
            Ogretmen ogretmen = new Ogretmen(adSoyad,kimlikNo,yas,bolum,sicilNo);
            ogretmenListesi.add(ogretmen);
        }

        islemMenusu();
    }
}
