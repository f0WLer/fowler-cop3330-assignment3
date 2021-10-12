package ex42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    ArrayList<String> getRawData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Ling,Mai,55900");
        data.add("Johnson,Jim,56500");
        data.add("Jones,Aaron,46000");
        data.add("Jones,Chris,34500");
        data.add("Swift,Geoffrey,14200");
        data.add("Xiong,Fong,65000");
        data.add("Zarnecki,Sabrina,51500");

        return data;
    }

    ArrayList<Employee> getProcessedData() {
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new Employee("Mai", "Ling",55900));
        e.add(new Employee("Jim", "Johnson",56500));
        e.add(new Employee("Aaron", "Jones",46000));
        e.add(new Employee("Chris", "Jones",34500));
        e.add(new Employee("Geoffrey", "Swift",14200));
        e.add(new Employee("Fong", "Xiong",65000));
        e.add(new Employee("Sabrina", "Zarnecki",51500));

        return e;
    }

    String getTableString() {
        return "Last      First     Salary\n" +
                "--------------------------\n" +
                "Ling      Mai       55900\n" +
                "Johnson   Jim       56500\n" +
                "Jones     Aaron     46000\n" +
                "Jones     Chris     34500\n" +
                "Swift     Geoffrey  14200\n" +
                "Xiong     Fong      65000\n" +
                "Zarnecki  Sabrina   51500\n";
    }

    @Test
    @DisplayName("Read From File")
    void readEmployeeData() {
        ArrayList<String> expectedResult = getRawData();
        ArrayList<String> testResult = App.readEmployeeData("exercise42_input.txt");

        // expectedResult is the ArrayList of the input hard-coded.
        // testResult is the ArrayList return from App.readEmployeeData.
        // The arrays should have the exact same contents if App.readEmployeeData works correctly.

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), testResult.get(i));
        }
    }

    @Test
    @DisplayName("Process Strings Into Employees")
    void processEmployeeData() {
        ArrayList<Employee> expectedResult = getProcessedData();
        ArrayList<Employee> testResult = App.processEmployeeData(getRawData());

        // expectedResult is a hard-coded list of the Employee instances
        // testResult is the same list but returned from App.processEmployeeData.
        // If App.processEmployeeData works correctly, the data should all match.

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i).first, testResult.get(i).first);
            assertEquals(expectedResult.get(i).last, testResult.get(i).last);
            assertEquals(expectedResult.get(i).salary, testResult.get(i).salary);
        }
    }

    @Test
    @DisplayName("Create Table From Employees List")
    void createEmployeeTable() {
        assertEquals(App.createEmployeeTable(getProcessedData()), getTableString());
    }
}