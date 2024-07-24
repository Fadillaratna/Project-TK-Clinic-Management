public final class AdministrationStaff extends User {
    private String id;

    public AdministrationStaff(String id, String name, String email) {
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
        return "ID Adm Staff: " + id + "\n" + super.toString();
    }
    
}
