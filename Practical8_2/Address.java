package practicals.task8_2;

public final class Address {
    private String cityName;
    private String streetName;
    int zipCode;
    int buildingNumber;
    int apartmentNumber;
    char buildingLetter;
    public static final Address EMPTY_ADDRESS = new Address();

    private static class DefaultVals {
        private static final String CITY_NAME="Moscow";
        private static final String STREET_NAME="Okhotnyy Ryad";
        private static final int ZIP_CODE= 109012;
        private static final int BUILDING_NUMBER=2;
        private static final int APARTMENT_NUMBER=24;
        private static final char BUILDING_LETTER='A';
    }

    public Address() {
        this.cityName=DefaultVals.CITY_NAME;
        this.streetName=DefaultVals.STREET_NAME;
        this.zipCode=DefaultVals.ZIP_CODE;
        this.buildingNumber=DefaultVals.BUILDING_NUMBER;
        this.apartmentNumber=DefaultVals.APARTMENT_NUMBER;
        this.buildingLetter=DefaultVals.BUILDING_LETTER;
    }

    public String getCityName() {return cityName;}
    public int getZipCode() {return zipCode;}
    public String getStreetName() {return streetName;}
    public int getBuildingNumber() {return buildingNumber;}
    public char getBuildingLetter() {return buildingLetter;}
    public int getApartmentNumber() {return apartmentNumber;}

    @Override public String toString() {
        return "practicals.task8_2.Address{" +
                "cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", zipCode=" + zipCode +
                ", buildingNumber=" + buildingNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", buildingLetter=" + buildingLetter +
                '}';
    }
}
