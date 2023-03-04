package com.searchwit;
import net.datafaker.Faker;

import java.util.Random;

public class Main {



    public static void main(String[] args) {
        System.out.println("Hello world!");
//        String test="O'Kon";
//        int x = test.indexOf("'");
//        test =test.replace("'", "''");
//        System.out.println(x + " " + test);
//        if(true) return;

        Faker faker = new Faker(new Random(100));
        for(int i=0; i<100; i++) {
            String tin = faker.idNumber().ssnValid().replace("-","");
            System.out.println(tin);
        }
        if(true) return;
//        String name = faker.name().fullName(); // Miss Samanta Schmidt
//        String firstName = faker.name().firstName(); // Emory
//        String lastName = faker.name().lastName(); // Barton
//
//        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
//        String cityName = faker.address().cityName();
//        String city = faker.address().city();
//        String countryName = faker.country().name();
//        String countryCode = faker.country().countryCode2();
//        String state = faker.address().state();
//        String stateAbbr = faker.address().stateAbbr();
//        String postCode = faker.address().postcode();
//        String zipCode = faker.address().zipCode();
//
//        System.out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
//                firstName, lastName, streetAddress, cityName, city, countryName, countryCode, state,
//                stateAbbr, postCode, zipCode);
//        for(int i=0; i<10; i++) {
//            String stateAbbr1 = faker.address().stateAbbr();
//            String zipCode1 = faker.address().zipCode();
//            String id1 = faker.idNumber().ssnValid();
//            String id2 = faker.idNumber().validEsMXSsn();
//
//            System.out.printf("%s,%s , %s, %s \r\n",
//                    stateAbbr1, zipCode1, id1, id2);
//
//            System.out.println(faker.name().name());
//
//
//        }

     String[] firmSuffixs = {
             " Tech LLC",
             " Service LLC",
             " Research and Dev LLC"
     };


     for(int i=0; i<2001; i++) {
         int isEntity = 0;

         String firstName = faker.name().firstName();
//         if(firstName.indexOf("'")!=-1) {
             firstName = firstName.replace("'", "''");
//         }
         String lastName = faker.name().lastName();
//         if(lastName.indexOf("'")!=-1) {
             lastName = lastName.replace("'", "''");
//         }
         String streetAddress = faker.address().streetAddress();
         streetAddress = streetAddress.replace("'", "");
         String cityName = faker.address().cityName();
         cityName = cityName.replace("'", "");
         String stateAbbr = faker.address().stateAbbr();
         String zipCode = faker.address().zipCode();
         String tinType ="SSN";
         String tin = faker.idNumber().ssnValid().replace("-","");
         String phone = faker.phoneNumber().phoneNumber().replaceAll("[^\\d]", "");
         if(phone.length() > 10) phone = phone.substring(0, 10);

         if(i%5==1) {
             isEntity = 1;
             firstName = firstName + firmSuffixs[i%3];
             lastName = null;
             tinType ="EIN";
             String gender = null;
             String occp = null;

         }

         //ID_ISSUED_BY_COUNTRY   =='US'
         //ID_ISSUED_BY_STATE
         // String.format(ENGLISH, "P%09d", rowNumber)


         System.out.printf("update stg_party set is_entity = %d, first_name='%s', last_name='%s', address ='%s' , city='%s', "
                         +  "state_code='%s', zip_code='%s', tin='%s', tin_type='%s', phone_number='%s', ID_ISSUED_BY_STATE='%s' where  party_id ='P%09d'; \r\n",
                 isEntity, firstName, lastName, streetAddress, cityName, stateAbbr, zipCode, tin, tinType, phone, stateAbbr, (i+1));

     }

     //update stg_party set last_name = null, gender =null, OCCUPATION  = null where is_entity = 1;



    }
}
