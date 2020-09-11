import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Organization> list = objectMapper.readValue(new File("jsonformatter.json"), new TypeReference<List<Organization>>(){});


        list.stream().forEach(organization -> System.out.println("Краткое название: " + organization.getShortName() +
                " - Дата основания " + new SimpleDateFormat("dd/MM/yy").format(organization.getFoundationDate())));


        AtomicInteger k = new AtomicInteger();
        System.out.println("\nПросроченые бумаги :");
        list.stream().forEach(organization -> {
                    organization.getBonds().forEach(bonds -> {
                        if (bonds.getExpirationDate().before(new GregorianCalendar().getTime())) {
                            System.out.println("\nКод ценной бумаги: " + bonds.getCode() +
                                    " Дата истечения: " + bonds.getExpirationDate() + "\nНазвание компании владельца: " +
                                    organization.getFullName());
                            k.getAndIncrement();
                        }
                    });
                });
        System.out.println("\nВсего: "+k);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\nВведите дату (формат ввода «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»): ");
            String str = reader.readLine();
            String[] possibleDateFormat = new String[]{"dd.MM.yyyy", "dd.MM,yy", "dd/MM/yyyy", "dd/MM/yy"};
            Date date = null;
            for (String dateString : possibleDateFormat) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateString);
                    simpleDateFormat.setLenient(false);
                    date = simpleDateFormat.parse(str);
                } catch (Exception e) {

                }
            }
            if (date != null){
                Date finalDate = date;
                list.stream().forEach(x -> {
                    if (x.getFoundationDate().after(finalDate))System.out.println("Название Компании: "
                     + x.getFullName() + " дата создания: " + x.getFoundationDate());
                });
                break;
            }
            else System.out.println("Некорректный ввод");
        }

        System.out.println("Введите код валюты (EU, USD, RUB)");
        while (true) {
            AtomicInteger l = new AtomicInteger();
            String str = reader.readLine();
            list.stream().forEach(x -> x.getBonds().forEach( bonds -> {
                if (bonds.getCurrencyCode().equals(str)){
                    System.out.println("id = " + bonds.getId() + " code = " + bonds.getCode());
                    l.getAndIncrement();
                }
            }));
            if (l.intValue() > 0){
                break;
            }
            else System.out.println("Повторите ввод");

        }
    }
}
