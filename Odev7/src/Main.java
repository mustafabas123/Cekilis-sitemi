import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		User user;
		boolean kontrol1=true;
		boolean kontrol2=false;
		boolean kontrol3=false;
		String CekilisIsmi = null;
		
		Person.KullaniciAdd();
				
		
		while(kontrol1) {
			System.out.println("Sisteme hoşgeldiniz");
			System.out.println("*******************");
			
			System.out.print("Bir kullanıcı adı giriniz:");
			String kla=scanner.nextLine();
			
			System.out.print("Bir password giriniz:");
			String passw=scanner.nextLine();
			
			for(User kullanicilar:Person.kullanicilar) {
				if(kullanicilar.KullaniciAdi.equals(kla) && kullanicilar.passaword.equals(passw)) {
					System.out.println(kullanicilar.Name +" "+ kullanicilar.Surname + " isimli kullanıcı başarılı bir şekilde giriş yaptı");
					kontrol2=true;
				}
			}
			while(kontrol2) {
				String islem="Kullaniciları listeleme (1) \n"+
			                  "Kullaniciları eklem için (2)\n"+
	             		     "Çıkış için (3) \n"+
						     "Sistemi kapat (4)\n"+
	             		     " Çekiliş sistemine girmek için (5) tuşlayın";
				System.out.println(islem);
				System.out.print("Yapmak istediğiniz işlemi giriniz:");
				String isl=scanner.nextLine();
				if(isl.equals("1")) {
					System.out.println("Sistemede bulunan kullanıcılar");
					for(User a:Person.kullanicilar) {
						System.out.println("Kullanıcı adı:"+a.KullaniciAdi);
						System.out.println("Şifre:"+a.passaword);
						System.out.println("Isim:"+a.Name);
						System.out.println("Soyisim:"+a.Surname);
						System.out.println("*******************");
					}
				}
				else if(isl.equals("2")) {
					Person.KullaniciAdd();
				}
				else if(isl.equals("3")) {
					System.out.println("Sistemden çıkış yapılıyor...");
					kontrol2=false;
					
				}		 
				else if(isl.equals("4")) {
					System.out.println("Sistem kapatılıyor....");
					kontrol1=false;
					kontrol2=false;
					
				}
				else if(isl.equals("5")) {
					System.out.println("Çekiliş sistemine giriş yapılıyor");
					System.out.println("Çekiliş sistemine Hoşgeldiniz....");
					System.out.print("Çekilişe bir isim veriniz :");
					CekilisIsmi=scanner.nextLine();
					kontrol3=true;
				}
				else {
					System.out.println("Geçersiz işlem");
				}
				while(kontrol3) {
					System.out.print("Katılımcı ismini giriniz: ");
					String Katilimci=scanner.nextLine();
					if(Katilimci.equals("Bitti")) {
						System.out.print("Çekiliş yapmak için (1) katılımcı eklemek için(2) yazınız :");
						String Islem=scanner.nextLine();
						if(Islem.equals("1")) {
							System.out.print("Çekilişte kaç kişi secilecek: ");
							int sayi=scanner.nextInt();
							scanner.nextLine();
							if(sayi>Person.katilimcilar.size()) {
								System.out.println("Çekilişte çekilen kişi katılımcı sayısından fazla");
								continue;
							}
							else {
								System.out.println(CekilisIsmi +" Cekilişini kazananlar");
								for(int i=0;i<sayi;i++) {
									int index=random.nextInt(0,Person.katilimcilar.size());
									System.out.println("Kazananlar:"+Person.katilimcilar.get(index));
									Person.KaldirilanKatilimcilar.add(Person.katilimcilar.get(index));
									Person.katilimcilar.remove(index);
								}
								System.out.print("Çekiliş tekrarlanması için (1) Yeniden çekılış oluşturmak  için (2) tuşlayın Sistemi kapatmak için (3) tuşlayın");
								String islm=scanner.nextLine();
								if(islm.equals("1")) {
									Person.katilimcilar.addAll(Person.KaldirilanKatilimcilar);
									
									for(int i=0;i<Person.KaldirilanKatilimcilar.size();i++) {
										Person.katilimcilar.add(Person.KaldirilanKatilimcilar.get(i));
										Person.KaldirilanKatilimcilar.remove(i);										
									}
									continue;
								}
								else if(islm.equals("2")) {
								   System.out.println("Çekilişi tekralıyoruz");
								   Person.katilimcilar.clear();
								   Person.KaldirilanKatilimcilar.clear();
								   System.out.print("Çekiliş ismini tekrar giriniz:");
								   CekilisIsmi=scanner.nextLine();
								   continue;
								   
								}
								else if(isl.equals("3")) {
									System.out.println("Çekiliş sistemi kapatılıyor");
									kontrol3=false;
									kontrol2=false;
									kontrol1=false;								
									
								}
							}
						}
						else if(Islem.equals("2")) {
							continue;
						}
						else {
							System.out.println("Geçersiz işlem");
						}
					}
					Person.katilimcilar.add(Katilimci);
					

					
				}
			}
			
		}

	}

}
