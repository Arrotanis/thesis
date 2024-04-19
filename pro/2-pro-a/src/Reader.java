import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Reader implements Serializable {
    private String name;
    private String lastName;
    private String email;

    private List<Loan> loanList;

    public Reader(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        loanList = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }
}
