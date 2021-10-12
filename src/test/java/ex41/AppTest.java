package ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    ArrayList<Name> getTestNames() {
        ArrayList<Name> testNames = new ArrayList<>();
        testNames.add(new Name("Mai", "Ling"));
        testNames.add(new Name("Jim", "Johnson"));
        testNames.add(new Name("Sabrina", "Zarnecki"));
        testNames.add(new Name("Chris", "Jones"));
        testNames.add(new Name("Aaron", "Jones"));
        testNames.add(new Name("Geoffrey", "Swift"));
        testNames.add(new Name("Fong", "Xiong"));
        return testNames;
    }

    ArrayList<Name> getExpectedNames() {
        ArrayList<Name> testNames = getTestNames();
        ArrayList<Name> expectedNames = new ArrayList<>();
        expectedNames.add(testNames.get(1));
        expectedNames.add(testNames.get(4));
        expectedNames.add(testNames.get(3));
        expectedNames.add(testNames.get(0));
        expectedNames.add(testNames.get(5));
        expectedNames.add(testNames.get(6));
        expectedNames.add(testNames.get(2));

        return expectedNames;
    }

    @Test
    void TestFileInput() {
        ArrayList<Name> testNames = getTestNames();
        ArrayList<Name> result = App.readNames("exercise41_input.txt");
        for (int i = 0; i < result.size(); i++) {
            // First Name
            assertEquals(testNames.get(i).first, result.get(i).first);
            // Last Name
            assertEquals(testNames.get(i).last, result.get(i).last);
        }
    }

    @Test
    void TestSortNames() {
        ArrayList<Name> testNames = getTestNames();

        ArrayList<Name> expectedNames = getExpectedNames();

        App.sortNames(testNames);
        for (int i = 0; i < testNames.size(); i++) {
            assertEquals(testNames.get(i).first, expectedNames.get(i).first);
            assertEquals(testNames.get(i).last, expectedNames.get(i).last);
        }
    }
}