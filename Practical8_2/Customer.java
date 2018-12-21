package practicals.task8_2;

public final class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;

    private static class DefaultVals {
        private static final String FIRST_NAME= "Mercurio";
        private static final String SECOND_NAME = "Ricohard";
        private static final int AGE = 26;
        private static final Address ADDRESS = Address.EMPTY_ADDRESS;
        private static final int UNDERAGE_CUSTOMER = 14;
        private static final int ADULT_CUSTOMER = 21;

        private static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(DefaultVals.ADULT_CUSTOMER);
        private static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(DefaultVals.UNDERAGE_CUSTOMER);
    }

    public Customer() {
        this.firstName=DefaultVals.FIRST_NAME;
        this.secondName=DefaultVals.SECOND_NAME;
        this.age=DefaultVals.AGE;
        this.address=DefaultVals.ADDRESS;
    }

    public Customer(int age) {
        this.firstName=DefaultVals.FIRST_NAME;
        this.secondName=DefaultVals.SECOND_NAME;
        this.age = age;
        this.address=DefaultVals.ADDRESS;
    }

    public String getFirstName() {return firstName;}
    public String getSecondName() {return secondName;}
    public int getAge() {return age;}
    public Address getAddress() {return address;}

    @Override public String toString() {
        return "practicals.task8_2.Customer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
