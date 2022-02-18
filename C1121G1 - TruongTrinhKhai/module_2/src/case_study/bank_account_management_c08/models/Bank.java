package case_study.bank_account_management_c08.models;

public abstract class Bank {
    private int id;
    private String code;
    private String name;
    private String creationDate;

    public Bank() {}

    public Bank(int id, String code, String name, String creationDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return ", id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate;
    }
}
