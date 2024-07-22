public class Cashier extends User {
    private String id;

    public Cashier(String id, String name, String email) {
        super(name, email);
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "ID Cashier: " + id + "\n" + super.toString();
    }
}
