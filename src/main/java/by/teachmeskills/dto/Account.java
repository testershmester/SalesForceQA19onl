package by.teachmeskills.dto;

import java.util.Objects;

public class Account {

    private String accountName;
    private String type;
    private String industry;
    private String phone;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public Account(String accountName, String type, String industry, String phone) {
        this.accountName = accountName;
        this.type = type;
        this.industry = industry;
        this.phone = phone;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getType() {
        return type;
    }

    public String getIndustry() {
        return industry;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getAccountName(), account.getAccountName()) && Objects.equals(getType(), account.getType())
                && Objects.equals(getIndustry(), account.getIndustry()) && Objects.equals(getPhone(), account.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountName(), getType(), getIndustry(), getPhone());
    }
}
