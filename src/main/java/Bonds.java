import java.util.Date;

public class Bonds {
    Integer id;
    String code;
    Date expirationDate;
    String currencyCode;

    public Bonds() {
    }

    public Bonds(Integer id, String code, Date expirationDate, String currencyCode) {
        this.id = id;
        this.code = code;
        this.expirationDate = expirationDate;
        this.currencyCode = currencyCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
