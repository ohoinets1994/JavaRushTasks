package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    public static void main(String[] args) {
        DataAdapter adapter = new DataAdapter(new Customer() {
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }
            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        }
                , new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }
            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        }
        );
        System.out.println(adapter.getCountryCode());
        System.out.println(adapter.getCompany());
        System.out.println(adapter.getContactFirstName());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getDialString());
    }

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String cName = customer.getCountryName();
            String result = "";
            for (Map.Entry<String, String> s:countries.entrySet()) {
                if (cName.equals(s.getValue()))
                    result = s.getKey();
            }
            return result;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = contact.getName();
            String[] arr = fullName.split(" ");
            String firstName = arr[1];
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String fullName = contact.getName();
            int coma = fullName.indexOf(",");
            String result = fullName.substring(0, coma);
            return result;
        }

        @Override
        public String getDialString() {
            return  "callto://+" + contact.getPhoneNumber().replaceAll("\\D", "");

        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}