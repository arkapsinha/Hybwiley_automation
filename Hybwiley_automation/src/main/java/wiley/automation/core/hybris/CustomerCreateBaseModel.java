package wiley.automation.core.hybris;

import wiley.automation.core.hybris.HybrisBaseModel;
import wiley.automation.core.hybris.ModelDefaultValue;
import wiley.automation.core.hybris.ModelImpexPath;

@ModelImpexPath(path = "/impex/customer/customer.create.impex")
public class CustomerCreateBaseModel extends HybrisBaseModel {

    private String uid;

    private String customerID;

    @ModelDefaultValue(value = "autoTestFm")
    private String firstName;

    @ModelDefaultValue(value = "autoTestFm")
    private String lastName;

    @ModelDefaultValue(value = "Customer created with UI auto test")
    private String description;

    @ModelDefaultValue(value = "en")
    private String sessionLanguage;

    @ModelDefaultValue(value = "USD")
    private String sessionCurrency;

    @ModelDefaultValue(value = "customergroup")
    private String groups;

    @ModelDefaultValue(value = "TeST1paSS23woRd")
    private String password;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSessionLanguage(String sessionLanguage) {
        this.sessionLanguage = sessionLanguage;
    }

    public void setSessionCurrency(String sessionCurrency) {
        this.sessionCurrency = sessionCurrency;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
