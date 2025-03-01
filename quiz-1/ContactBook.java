public class ContactBook {
    Contact head;
    Contact tail;
    class Contact {
        // Node for the linked list
        String name;
        String email;
        String phone_number;
        Contact next;
        Contact(){
            // Acts as a dummy node for initializing the linked list
            this.next=null;
        }
        Contact(String name, String email, String phone_number){
            // Real node for the linked list, which is initialized as the second node
            this.name = name;
            this.email=email;
            this.phone_number=phone_number;
            this.next=null;
        }
    }
    ContactBook(){
        // Create a new linked list
        head = new Contact();
        tail = head;
    }
    public void add(String name, String email, String phone_number){
        System.out.printf("\nAdding %s || %s || %s%n",name,email,phone_number);

        // Validation for phone number, checks if its exactly 12 numbers long and starts with 08
        if(phone_number.length() != 12 || !phone_number.startsWith("08")){
            System.out.println("Invalid phone number");
            return; // Exit out of the function, doesnt add new contact
        }
        // Checks each character of the phone number if it's a digit or not
        for(char num:phone_number.toCharArray()){
            if(!Character.isDigit(num)){
                System.out.println("Invalid phone number");
                return;
            }
        }
        tail.next = new Contact(name, email, phone_number); // Instantiates a new node
        tail=tail.next; // MOves the tail pointer to the newly created node
    }
    public void delete(String name){
        System.out.println("\nDeleting " + name);
        /*
        Create two pointer to the linked list,
        with one being slower pointer to reference
        the previous node
         */

        Contact cur = head.next;
        Contact slow = head;
        while(cur!=null){ // Loops until it reaches the end of the linked list
            if(cur.name.equals(name)){
                /*
                If the faster node finds a match in the name
                the previous node will skip to the next of the faster node,
                effectively removing it from the linked list
                 */
                slow.next = cur.next;
                return; // Breaks teh loop and exits out of the function
            }
            slow=slow.next;
            cur=cur.next;
        }
        System.out.println(name + " is not in contact book"); // Will only run if the loop reaches the end
    }
    public void emailSearch(String email){
        System.out.println("\nSearching for " + email);
        Contact cur = head.next;
        while(cur!=null){ // Loops through all the nodes in the linked list
            if(cur.email.equals(email)){ // If found a match
                System.out.printf(
                        // Formatting is used to have a consistent terminal output
                        "\nName = %-15s || Email = %-15s || Phone number = %s\n%n",
                        cur.name,cur.email,cur.phone_number
                ); // Prints out this
                return; // Breaks the loop and exits out of the function
            }
            cur=cur.next; // Moves to the next node
        }
        System.out.println(email + " not in contact book"); // Will only run if the loop reaches the end
    }
    public void printContacts(){
        Contact cur = head.next;
        System.out.println("\nContact Book: ");
        System.out.printf("%-15s || %-15s || %s%n","Name","Email","Phone number");
        System.out.println("----------------------------------------------------");
        while(cur!=null){ // Loops through the all the nodes in the linked list, then printing it
            System.out.printf("%-15s || %-15s || %s%n",cur.name,cur.email,cur.phone_number);
            cur=cur.next; // Moves to the next node
        }
    }
    public void search(String name){
        // SAme logic to emailSearch
        Contact cur = head.next;
        System.out.println("\nSearching for " + name);
        while(cur!=null){
            if(cur.name.equals(name)){
                System.out.printf(
                        "\nName = %-15s || Email = %-15s || Phone number = %s\n%n",
                        cur.name,cur.email,cur.phone_number
                );
                return;
            }
            cur=cur.next; // Moves to the next node
        }
        System.out.println(name + " not in contact book");
    }
    public boolean isEmpty(){
        // Check if the node beside the dummy node is initialized, if it's not, linked list is empty
        return head.next==null;
    }
}



