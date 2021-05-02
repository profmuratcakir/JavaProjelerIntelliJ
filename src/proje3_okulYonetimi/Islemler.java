package proje3_okulYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {

    private List <Kisi> ogrenciListesi= new ArrayList <>();
    private List <Kisi> ogretmenListesi = new ArrayList<>();
    private String kisiTuru;

    public void anaMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println(" OGRENCI VE OGRETMEN YONETIM PANELI");
        System.out.println("====================================");
        System.out.println("1- OGRENCI ISLEMLERI");
        System.out.println("2- OGRETMEN ISLEMLERI");
        System.out.println("Q- CIKIS");
        String secim = scan.next().toUpperCase();

        if(secim.equals("Q")){
            cikis();
        }else if (secim.equals("1")){
            kisiTuru = "OGRENCI";
            islemMenusu();
        }else if(secim.equals("2")) {
            kisiTuru = "OGRETMEN";
            islemMenusu();
        }else {
            System.out.println("Hatali Giriş");
            anaMenu();
        }
    }

    private void islemMenusu() {

        Scanner scan = new Scanner(System.in);
        System.out.println("============= ISLEMLER =============");
        System.out.println("1-EKLEME");
        System.out.println("2-ARAMA");
        System.out.println("3-LISTELEME");
        System.out.println("4-SILME");
        System.out.println("5-ANA MENÜ");
        System.out.println("Q-CIKIS\n");
        System.out.println("SECIMINIZ:");
        String tercih = scan.next().toUpperCase();

        switch(tercih) {
            case "1":	ekle();
                break;
            case "2":	ara();
                break;
            case "3":	listele();
                break;
            case "4":	sil();
                break;
            case "5":	anaMenu();
                break;
            case "Q":	cikis();
                break;
            default: 	System.out.println("Yanlis Giris");
                islemMenusu();
                break;
        }
    }

    private void cikis() {
        System.out.println("GULE GULE ...");
    }

    private void ekle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------- "+ kisiTuru + " EKLEME ------------------");
        System.out.print("Ad Soyad:");
        String adSoyad = scan.nextLine();
        System.out.print("Kimlik No:");
        String kimlikNo = scan.next();
        System.out.print("Yas:");
        int yas = scan.nextInt();

        if(kisiTuru.equals("OGRENCI")) {
            System.out.print("Sinif:");
            String sinif = scan.next();
            System.out.print("Okul No:");
            String numara = scan.next();
            Ogrenci  ogrenci = new Ogrenci(adSoyad,kimlikNo,yas,numara,sinif);
            kisiEkle(ogrenci,ogrenciListesi);
        }else {
            System.out.print("SicilNo:");
            String sicilNo = scan.next();
            System.out.print("Bolum:");
            String bolum = scan.next();
            Ogretmen ogretmen = new Ogretmen(adSoyad,kimlikNo,yas,sicilNo,bolum);
            kisiEkle(ogretmen,ogretmenListesi);
        }
        islemMenusu();
    }

    private void ara(){

        Scanner scan = new Scanner(System.in);
        System.out.println("----------------- " + kisiTuru + " BILGILERI ------------------");
        System.out.print("Aradiginiz Kisinin Kimlik Numarasi:");
        String kimlikNo = scan.next();
        if (kisiTuru.equals("OGRENCI")) {
            kimlikNoIleKisiAra(kimlikNo, ogrenciListesi);
        }else {
            kimlikNoIleKisiAra(kimlikNo, ogretmenListesi);
        }
        islemMenusu();
    }

    private void listele () {
        List <Kisi> liste;
        if (kisiTuru.equals("OGRENCI")) {
            liste = ogrenciListesi;
        }else{
            liste = ogretmenListesi;
        }

        if(liste.isEmpty()){
            System.out.println("Belirtilen listede herhangi bir kayit yoktur");
        }else {
            System.out.println("************ "+ kisiTuru + " LISTESI ************\n");
            for(Kisi w: liste) {
                System.out.println(w);
            }
        }
        islemMenusu();
    }

    private void sil() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Silmek IstediGiniz "+ kisiTuru + " nin Kimlik Numarası:");
        String kimlikNo = scan.next();
        if (kisiTuru.equals("OGRENCI")) {
            kisiSil(kimlikNo, ogrenciListesi);
        }else {
            kisiSil(kimlikNo, ogretmenListesi);
        }
        islemMenusu();
    }
    private void kisiSil(String kimlikNo, List <Kisi> liste) {
        for(Kisi w: liste) {
            if(kimlikNo.equals(w.getKimlikNo()) ) {
                System.out.println(kimlikNo + " lu "+ kisiTuru +" Silindi");
                return;
            }
        }
        System.out.println(kimlikNo + " lu "+ kisiTuru +" Kayidi bulunamadi");
    }

    private void kisiEkle(Kisi kisi, List <Kisi> liste) {

        for(Kisi w : liste) {
            if(kisi.getKimlikNo().equals(w.getKimlikNo()) ) {
                System.out.println(kisi.getKimlikNo() + " nolu Kisi sisteme kayitli.");
                islemMenusu();
            }
        }
        liste.add(kisi);
        System.out.println(kisi.getAdSoyad() + " Sisteme Eklenmistir.");
    }

    private void kimlikNoIleKisiAra (String kimlikNo, List<Kisi> liste) {

        for(Kisi w : liste) {
            if(w.getKimlikNo().equals(kimlikNo)) {
                System.out.println(w);
                return;
            }
        }
        System.out.println("Aradiginiz kisi bulunamamistir.");
    }

    public void testKisiOlustur() {
        Ogrenci ogr1 = new Ogrenci ("Ahmet Can", "12345678",14,"123","9A");
        Ogrenci ogr2 = new Ogrenci ("Mustafa Yilmaz", "456889012",13,"456","8b");
        Ogrenci ogr3 = new Ogrenci ("Ayse Canan", "987654321",15,"567","12c");

        Ogretmen ogrt1 = new Ogretmen ("Selim Kaya", "4561236789",40,"MEKATRONIK","O1234");
        Ogretmen ogrt2 = new Ogretmen ("Melis Ozturk", "123490855",25,"BIYOLOJI","O456");

        ogrenciListesi.add(ogr1);
        ogrenciListesi.add(ogr2);
        ogrenciListesi.add(ogr3);
        ogretmenListesi.add(ogrt1);
        ogretmenListesi.add(ogrt2);
    }
}
