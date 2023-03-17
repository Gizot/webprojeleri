package models;

import java.io.Serializable;

public class Kullanici implements Serializable {
	
	
	}
	private String kullaniciAdi;
	private String sifre;
	public Kullanici(String kullaniciAdi, String sifre) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	@Override
	public String toString() {
		return "Kullanici [kullaniciAdi=" + kullaniciAdi + ", sifre=" + sifre + "]";
	
	}

}
