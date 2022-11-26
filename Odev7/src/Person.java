import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
	
	static Scanner scanner=new Scanner(System.in);
	public static List<User>kullanicilar=new ArrayList<>();
	public static ArrayList<String>katilimcilar=new ArrayList<>();
	public static ArrayList<String> KaldirilanKatilimcilar=new ArrayList<>();
	

	
	public static void KullaniciAdd() {
		System.out.print("Bir kullanıcı ismi yazınız:");
	    String KullaniciAdi=scanner.nextLine();
		
		System.out.print("Bir kullanıcı şifreyi yazınız:");
		String Passaword=scanner.nextLine();
		
		System.out.print("Bir isim yazınız:");
		String isim=scanner.nextLine();
		
		System.out.print("Bir soyIsim yazınız:");
		String soyIsim=scanner.nextLine();
		User newUser=new User(KullaniciAdi, Passaword, isim, soyIsim);
		kullanicilar.add(newUser);	
	}
}
