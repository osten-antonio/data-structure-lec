import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactBook contact_book = new ContactBook();
        String name, email;
        while(true){
            System.out.print(
                    """
                    
                    **********************************************************
                    (A)dd
                    (D)elete
                    (E)mail Search
                    (P)rint List
                    (S)earch
                    (Q)uit
                    **********************************************************
                    Please Enter a Command:
                    """

            );
            String operation = input.next();
            switch (operation.toUpperCase()) {
                case "A":
                    System.out.println("Add entry\nName: ");
                    name = input.next();

                    System.out.println("Email: ");
                    email = input.next();

                    System.out.println("Phone Number (08xxxxxxxxxx): ");
                    String phone_num = input.next();

                    contact_book.add(name, email, phone_num);
                    System.out.println();
                    break;

                case "D":
                    if(contact_book.isEmpty()){
                        System.out.println("Contact book is empty");
                        break;
                    }
                    System.out.println("Delete entry\nName of contact to delete:");
                    name = input.next();

                    contact_book.delete(name);
                    System.out.println();
                    break;

                case  "E":
                    if(contact_book.isEmpty()){
                        System.out.println("Contact book is empty");
                        break;
                    }
                    System.out.println("Search by Email\nEmail:");
                    email = input.next();
                    contact_book.emailSearch(email);
                    break;

                case "P":
                    if(contact_book.isEmpty()){
                        System.out.println("Contact book is empty");
                        break;
                    }
                    contact_book.printContacts();
                    break;

                case "S":
                    if(contact_book.isEmpty()){
                        System.out.println("Contact book is empty");
                        break;
                    }
                    System.out.println("Search by name\nName:");
                    name = input.next();
                    contact_book.search(name);
                    break;

                case "Q":
                    System.out.println("Quiting..");
                    break;

                default:
                    System.out.println("Invalid Entry");
                    break;
            }
        }

    }
}
