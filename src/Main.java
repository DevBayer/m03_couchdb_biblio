import database.DBManager;
import database.Database;
import models.Book;
import models.Catalogue;
import models.Loan;
import models.Member;
import utils.GetPropertyValues;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Main {
    static Scanner sc;
    static Catalogue catalogue;
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.lightcouch.CouchDbClient").setLevel(Level.SEVERE);
        sc = new Scanner(System.in);
        GetPropertyValues properties = new GetPropertyValues();
        DBManager manager = new DBManager(properties);
        Database db = manager.connection;
        catalogue = new Catalogue(db);

        while(true){
            System.out.println("#### The Library ####");
            System.out.println("# 1. List           #");
            System.out.println("# 2. Add            #");
            System.out.println("# 3. Remove         #");
            System.out.println("# 4. Find           #");
            System.out.println("# 5. Exit library   #");
            System.out.print("# Option:   ");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    menuList();
                    break;

                case 2:
                    menuAdd();
                    break;

                case 3:
                    menuRemove();
                    break;

                case 4:
                    menuFind();
                    break;

                case 5:
                    System.exit(1);
                    break;
            }
        }

        /*
        if(f) {
            Book b1 = new Book();
            b1.setISBN("holas123");
            b1.setTitle("Title123461");
            b1.setAuthor("Luiggis");
            b1.setCategory("Acció");
            b1.setEditionYear(2017);
            catalogue.insert(b1);


            Member m1 = new Member();
            m1.setDNI("23878411V");
            m1.setName("Lluís");
            m1.setSurname("Bayer Soler");
            catalogue.insert(m1);

            Loan l1 = new Loan();
            l1.setBook(b1);
            l1.setMember(m1);
            l1.setStartDate(new Date());
            catalogue.insert(l1);

            for (Book test : catalogue.books.books) {
                System.out.println(test.toString());
                System.out.println(test.getISBN());
                System.out.println(test.getTitle());
            }

            //catalogue.get(Book.class, "holas123");
            List<Loan> loans = catalogue.members.loans(m1);
            for (Loan l: loans) {
                System.out.println(l.getPrimaryKey());
            }

        }
        */
    }

    private static void menuList() {
        char optionc;
        boolean run = true;
        while(run) {
            System.out.println("          ##### 1. LIST ####");
            System.out.println("          # 1. List Books  #");
            System.out.println("          # 2. List Members#");
            System.out.println("          # 3. List Loans  #");
            System.out.println("          # 4. Return        #");
            System.out.print("          # Option:   ");
            int option = sc.nextInt();
            sc.nextLine(); // clear Scanner..
            switch (option) {
                case 1:
                    List<Book> books = catalogue.books.get();
                    for (int i = 0; i < books.size(); i++) {
                        Book b = books.get(i);
                        System.out.println("["+i+"] " +b.getISBN()+" - "+b.getTitle()+" ("+b.getAuthor()+"), "+b.getEditionYear()+" - "+b.getEditorial());
                    }
                    System.out.print("Do you want loans by book_id? (y/n) ");
                    optionc = sc.nextLine().toLowerCase().charAt(0);
                    if(optionc == 'y'){
                        System.out.print("Insert id [X]: ");
                        option = sc.nextInt();
                        System.out.print("\n");
                        if(option >= 0 && option <= books.size()){
                            List<Loan> loans = catalogue.books.loans(books.get(option));
                            for (int i = 0; i < loans.size(); i++) {
                                Loan loan = loans.get(i);
                                System.out.println("["+i+"]" + loan.getPrimaryKey() + " " + loan.getStartDate()+"-"+ loan.getDelivered());
                                System.out.println("Member: "+ loan.getMember().getDNI());
                            }
                        }else{
                            System.out.println("Invalid id.");
                        }
                    }
                    break;

                case 2:
                    List<Member> members = catalogue.members.get();
                    for (int i = 0; i < members.size(); i++) {
                        Member m = members.get(i);
                        System.out.println("["+i+"] "+m.getName()+", "+m.getSurname()+" DNI: "+m.getDNI()+" Telephone: "+m.getTelephone()+" Address: "+m.getAddress());
                    }
                    System.out.print("Do you want loans by member_id? (y/n) ");
                    optionc = sc.nextLine().toLowerCase().charAt(0);
                    if(optionc == 'y') {
                        System.out.print("Insert id [X]: ");
                        option = sc.nextInt();
                        System.out.print("\n");
                        if (option >= 0 && option <= members.size()) {
                            List<Loan> loans = catalogue.members.loans(members.get(option));
                            for (int i = 0; i < loans.size(); i++) {
                                Loan loan = loans.get(i);
                                System.out.println("[" + i + "]" + loan.getPrimaryKey() + " " + loan.getStartDate() + "-" + loan.getDelivered());
                                System.out.println("Book: " + loan.getBook().getISBN());
                            }
                        } else {
                            System.out.println("Invalid id.");
                        }
                    }
                    break;

                case 3:
                    List<Loan> loans = catalogue.loans.get();
                    for (int i = 0; i < loans.size(); i++) {
                        Loan loan = loans.get(i);
                        System.out.println("["+i+"]" + loan.getPrimaryKey() + " " + loan.getStartDate()+"-"+ loan.getDelivered());
                        System.out.println("Member: "+ loan.getMember().getDNI());
                        System.out.println("Book: "+ loan.getBook().getISBN());
                    }
                    break;
                case 4:
                    run = false;
                    break;
            }

        }
    }

    private static void menuAdd() {
        char optionc;
        boolean run = true;
        while(run) {
            System.out.println("          ##### 2. ADD ####");
            System.out.println("          # 1. Book       #");
            System.out.println("          # 2. Member     #");
            System.out.println("          # 3. Loan       #");
            System.out.println("          # 4. Return     #");
            System.out.print("          # Option:   ");
            int option = sc.nextInt();
            sc.nextLine(); // clear Scanner..
            switch (option) {
                case 1:
                    Book b = new Book();
                    System.out.print("- ISBN: ");
                    b.setISBN(sc.nextLine());
                    System.out.print("- Title: ");
                    b.setTitle(sc.nextLine());
                    System.out.print("- Author: ");
                    b.setAuthor(sc.nextLine());
                    System.out.print("- Categories (per comma): ");
                    b.setCategory(sc.nextLine());
                    System.out.print("- Editorial: ");
                    b.setEditorial(sc.nextLine());
                    System.out.print("- Year: ");
                    b.setEditionYear(Integer.parseInt(sc.nextLine()));
                    catalogue.insert(b);
                    System.out.println("New book added");
                    break;

                case 2:
                    Member m = new Member();
                    System.out.print("- Dni: ");
                    m.setDNI(sc.nextLine());
                    System.out.print("- Surname: ");
                    m.setSurname(sc.nextLine());
                    System.out.print("- Address: ");
                    m.setAddress(sc.nextLine());
                    System.out.print("- Telephone: ");
                    m.setTelephone(sc.nextLine());
                    catalogue.insert(m);
                    System.out.println("New member added");
                    break;

                case 3:
                    Loan l = new Loan();
                    l.setStartDate(new Date());
                    System.out.println("Enter book ISBN ");
                    String ISBN = sc.nextLine();
                    b = (Book) catalogue.books.get(ISBN);
                    if(b != null){
                        l.setBook(b);
                    }
                    System.out.println("Enter member DNI");
                    String dni = sc.nextLine();
                    m = (Member) catalogue.members.get(dni);
                    if(m !=null){
                        l.setMember(m);
                    }
                    catalogue.insert(l);
                    break;

                case 4:
                    run = false;
                    break;
            }

        }
    }

    private static void menuRemove() {
        String strEntry;
        Book b = new Book();
        Member m = new Member();
        List<Loan> loans = new ArrayList<>();
        boolean run = true;
        while(run) {
            System.out.println("          ##### 3. Remove ####");
            System.out.println("          # 1. Book       #");
            System.out.println("          # 2. Member     #");
            System.out.println("          # 3. Loan       #");
            System.out.println("          # 4. Return     #");
            System.out.print("          # Option:   ");
            int option = sc.nextInt();
            sc.nextLine(); // clear Scanner..
            switch (option) {
                case 1:
                    System.out.print("Find Book by ISBN: ");
                    strEntry = sc.nextLine();
                    b = (Book) catalogue.books.get(strEntry);
                    if(b != null){
                        catalogue.delete(b);
                    }else{
                        System.out.println("Not found");
                    }
                    break;
                case 2:
                    strEntry = sc.nextLine();
                    System.out.print("Find Member by DNI: ");
                    m = (Member) catalogue.members.get(strEntry);
                    if(b != null){
                        catalogue.delete(m);
                    }else{
                        System.out.println("Not found");
                    }
                    break;
                case 3 :
                    Loan loan = new Loan();
                    System.out.println("## Find Loan by.. ##");
                    System.out.println("# 1. Book ISBN     #");
                    System.out.println("# 2. Member DNI    #");
                    System.out.print("Option: ");
                    int optionb = sc.nextInt();
                    sc.nextLine(); // reset Scanner
                    switch(optionb){
                        case 1:
                            System.out.print("ISBN: ");
                            strEntry = sc.nextLine();
                            b = (Book) catalogue.books.get(strEntry);
                            if(b != null){
                                loans = catalogue.books.loans(b);
                                for (int i = 0; i < loans.size(); i++) {
                                    loan = loans.get(i);
                                    System.out.println("["+i+"]" + loan.getPrimaryKey() + " " + loan.getStartDate()+"-"+ loan.getDelivered());
                                    System.out.println("Member: "+ loan.getMember().getDNI());
                                    System.out.println("Book: "+ loan.getBook().getISBN());
                                }
                            }else{
                                System.out.println("ISBN not found");
                            }
                            break;

                        case 2:
                            System.out.print("DNI: ");
                            strEntry = sc.nextLine();
                            m = (Member) catalogue.members.get(strEntry);
                            if(m != null){
                                loans = catalogue.members.loans(m);
                                for (int i = 0; i < loans.size(); i++) {
                                    loan = loans.get(i);
                                    System.out.println("["+i+"]" + loan.getPrimaryKey() + " " + loan.getStartDate()+"-"+ loan.getDelivered());
                                    System.out.println("Member: "+ loan.getMember().getDNI());
                                    System.out.println("Book: "+ loan.getBook().getISBN());
                                }
                            }else{
                                System.out.println("DNI not found");
                            }
                            break;
                    }
                    System.out.println("Enter number");
                        int idborrar = Integer.parseInt(sc.nextLine());
                        if(idborrar >= 0 && idborrar <= loans.size()) {
                            catalogue.delete(loans.get(idborrar));
                        }else{
                        System.out.println("ISBN not found");
                        }

                    break;
            }
        }
    }

    private static void menuFind(){
        char optionc;
        String strEntry;
        Member m;
        Book b;
        List<Loan> loans;
        boolean run = true;
        while(run) {
            System.out.println("          ##### 4. FIND ####");
            System.out.println("          # 1. Book        #");
            System.out.println("          # 2. Member      #");
            System.out.println("          # 3. Loan        #");
            System.out.println("          # 4. Return      #");
            System.out.print("          # Option:   ");
            int option = sc.nextInt();
            sc.nextLine(); // clear Scanner..
            switch (option) {
                case 1:
                    System.out.print("Find Book by ISBN: ");
                    strEntry = sc.nextLine();
                    b = (Book) catalogue.books.get(strEntry);
                    if(b != null){
                        System.out.println(b.getISBN()+" - "+b.getTitle()+" ("+b.getAuthor()+"), "+b.getEditionYear()+" - "+b.getEditorial());
                    }else{
                        System.out.println("Not found");
                    }
                    break;

                case 2:
                    System.out.print("Find Member by DNI: ");
                    strEntry = sc.nextLine();
                    m = (Member) catalogue.members.get(strEntry);
                    if(m != null){
                        System.out.println(m.getName()+", "+m.getSurname()+" DNI: "+m.getDNI()+" Telephone: "+m.getTelephone()+" Address: "+m.getAddress());
                    }else{
                        System.out.println("Not found");
                    }
                    break;

                case 3:
                    System.out.println("## Find Loan by.. ##");
                    System.out.println("# 1. Book ISBN     #");
                    System.out.println("# 2. Member DNI    #");
                    System.out.print("Option: ");
                    int optionb = sc.nextInt();
                    sc.nextLine(); // reset Scanner
                    switch(optionb){
                        case 1:
                            System.out.print("ISBN: ");
                            strEntry = sc.nextLine();
                            b = (Book) catalogue.books.get(strEntry);
                            if(b != null){
                                loans = catalogue.books.loans(b);
                                for (int i = 0; i < loans.size(); i++) {
                                    Loan loan = loans.get(i);
                                    System.out.println("["+i+"]" + loan.getPrimaryKey() + " " + loan.getStartDate()+"-"+ loan.getDelivered());
                                    System.out.println("Member: "+ loan.getMember().getDNI());
                                    System.out.println("Book: "+ loan.getBook().getISBN());
                                }
                            }else{
                                System.out.println("ISBN not found");
                            }
                            break;

                        case 2:
                            System.out.print("DNI: ");
                            strEntry = sc.nextLine();
                            m = (Member) catalogue.members.get(strEntry);
                            if(m != null){
                                loans = catalogue.members.loans(m);
                                for (int i = 0; i < loans.size(); i++) {
                                    Loan loan = loans.get(i);
                                    System.out.println("["+i+"]" + loan.getPrimaryKey() + " " + loan.getStartDate()+"-"+ loan.getDelivered());
                                    System.out.println("Member: "+ loan.getMember().getDNI());
                                    System.out.println("Book: "+ loan.getBook().getISBN());
                                }
                            }else{
                                System.out.println("DNI not found");
                            }
                            break;
                    }
                    break;
                case 4:
                    run = false;
                    break;
            }

        }
    }

}
