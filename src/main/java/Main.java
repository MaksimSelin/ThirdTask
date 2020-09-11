import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
//        Bonds bonds1 = new Bonds(1, "123456", new GregorianCalendar(1970,0,25).getTime(), "RU");
//        Bonds bonds2 = new Bonds(2, "654321", new GregorianCalendar(1980,3,16).getTime(), "EU");
//        List<Bonds> list = new ArrayList<Bonds>();
//        list.add(bonds1);
//        list.add(bonds2);
//        Organization organization = new Organization("organization1", "org1", "street1",
//                "132654", "159753", "852963741", list,
//                new GregorianCalendar(1870,0,11).getTime() );

//        String json = objectMapper.writeValueAsString(organization);
//        System.out.println(json);
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
        System.out.println("\nВведите дату (формат ввода «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»): ");
        String str = reader.readLine();

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toLocalDate());
    }
}
