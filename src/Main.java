import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static int FIELDS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        String[] arrData = inputData.split(" ");

        if (arrData.length != FIELDS) {
            System.err.println("Неверное количество полей!");
        }

        String lastName = arrData[0];
        String firstName = arrData[1];
        String otherName = arrData[2];

        LocalDate birthDay = null;
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthDay = LocalDate.parse(arrData[3], dateTimeFormatter);
        } catch (DateTimeParseException e) {
            System.err.println("Неверный формат даты!");
        }

        Long numberPhone = null;
        try {
            numberPhone = Long.parseLong(arrData[4]);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат телефона!");
        }

        String gender = arrData[5];
        if(!gender.equals("m") && !gender.equals("f")) {
            System.err.println("Неверно указан пол!");
        }

        String fileName = lastName + ".txt";
        try  (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(lastName + " " + firstName + " " + otherName +
                    "   phone number: " + numberPhone + " birth day: " +
                    birthDay + " gender: " + gender);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Контакт не записан!");
        }


    }
}