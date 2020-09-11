import java.util.Date;
import java.util.List;

public class Organization {

    private String fullName;
    private String shortName;
    private String address;
    private String phoneNumber;
    private String INN;
    private String OGRN;
    private List<Bonds> bonds;
    private Date foundationDate;

    public Organization() {
    }

    public Organization(String fullName, String shortName, String address, String phoneNumber, String INN, String OGRN, List<Bonds> bonds, Date foundationDate) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.INN = INN;
        this.OGRN = OGRN;
        this.bonds = bonds;
        this.foundationDate = foundationDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    public List<Bonds> getBonds() {
        return bonds;
    }

    public void setBonds(List<Bonds> bonds) {
        this.bonds = bonds;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }
}
