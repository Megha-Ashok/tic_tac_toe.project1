package player;

public class Player {
    String name;
    private int age;
    private String address;
    private String emailid;
    private long contactno;
    char symbol;

    public void playerDetails(String name, int age, String address, String emailid, long contactno, char symbol) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.emailid = emailid;
        this.contactno = contactno;
        this.symbol = symbol;
    }

    public void setNameandSymbol(String name, char symbol) {
        this.symbol = symbol;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameaddressandage(String name, String address, int age) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void getnameandsymbol() {
        System.out.println("Player name :" + this.name);
        System.out.println("Player Symbol :" + this.symbol);
    }

    public void getplayerDetails() {
        System.out.println("Player name :" + this.name);
        System.out.println("Player Symbol :" + this.symbol);

        System.out.println("Player contactno :" + this.contactno);
        System.out.println("Player address :" + this.address);

        System.out.println("Player age :" + this.age);
        System.out.println("Player emailid :" + this.emailid);
    }
}
