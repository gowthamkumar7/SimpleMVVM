package gtm.com.mvvm;

/**
 * @author gowtham pr on 4/18/2018.
 */
public class Constants {

  public static String LABEL_NAMES[] = { "Details", "Features", "Images" };

  public interface SharedPrefConstants {

    String CAR_MAKE = "CAR_MAKE";
    String CAR_MODEL = "CAR_MODEL";
    String CAR_VARIANT = "CAR_VARIANT";
    String CAR_MAKE_YEAR = "CAR_MAKE_YEAR";
    String CAR_EXPECTED_PRICE = "CAR_EXPECTED_PRICE";
    String CAR_INTERIOR_COLOR = "CAR_INTERIOR_COLOR";
    String CAR_EXTERIOR_COLOR = "CAR_EXTERIOR_COLOR";
    String CAR_TRANSMISSION = "CAR_TRANSMISSION";
    String CAR_CONDITION = "CAR_CONDITION";
    String CAR_BODY_TYPE = "CAR_BODY_TYPE";
    String CAR_INSURANCE = "CAR_INSURANCE";
    String CAR_NO_OF_OWNERS = "CAR_NO_OF_OWNERS";
    String CAR_FUEL_TYPE_ONE = "CAR_FUEL_TYPE_ONE";
    String CAR_FUEL_TYPE_TWO = "CAR_FUEL_TYPE_TWO";
    String CAR_VEHICLE_TYPE = "CAR_VEHICLE_TYPE";
    String CAR_KMS_DRIVEN = "CAR_KMS_DRIVEN";
    String CAR_FUEL_ECONOMY = "CAR_FUEL_ECONOMY";
    String CAR_REGISTRED_AT = "CAR_REGISTRED_AT";
    String CAR_LIFE_TIME_TAX = "CAR_LIFE_TIME_TAX";
    String CAR_OWNER_PINCODE = "CAR_OWNER_PINCODE";
    String CAR_OWNER_STATE = "CAR_OWNER_STATE";
    String CAR_OWNER_CITY = "CAR_OWNER_CITY";
    String CAR_OWNER_CONTACT_NUM = "CAR_OWNER_CONTACT_NUM";
    String CAR_ADDED_BY = "CAR_ADDED_BY";
    String CAR_OWNER_COMMENTS = "CAR_OWNER_COMMENTS";
    String LISTING_ID = "LISTING_ID";
    String IS_LOGIN = "IS_LOGIN";
    String CLIENT_ID = "CLIENT_ID";
    String SELECTED_FEATURES = "SELECTED_FEATURES";
    String FIRST_NAME = "FIRST_NAME";
    String IS_LISTING_POSTED = "IS_LISTING_POSTED";
    String BASIC_INFO="BASIC_INFO";
    String ADDRESS_INFO="ADDRESS_INFO";
  }

  public interface NetworkConstants {

    int CONNECTION_TIME_OUT_PERIOD = 60;

    //-- POST --//
    int SIGNUP = 101;
    int UPDATE_PASSWORD = 102;
    int RE_SEND = 103;
  }

  public interface JsonKeys {
    String SUCCESS = "success";
  }

  public interface IntentKeys {
    String CLIENT_ID = "client_id";
    String OTP = "otp";
    String PIN_CODE_DATA = "pincode_data";
    String INSTANCE = "instance";
    String LIST_ID = "list_id";
    String MOBILE_NUM = "mobile_num";
  }
}
