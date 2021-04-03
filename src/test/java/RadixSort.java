import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSort {
    LSDForVariableLengthStrings radixSort = new LSDForVariableLengthStrings();

    @Test
    public void TestEmpty() {
        String[] a = {};
        assertArrayEquals(radixSort.sort(a), new String[]{});
    }

    @Test
    public void TestOneElementArray() {
        String[] a = {"38A"};
        assertArrayEquals(radixSort.sort(a), new String[]{"38A"});
    }

    @Test
    public void TestSimpleStrings() {
        String[] a = {"b", "a", "c"};
        assertArrayEquals(radixSort.sort(a), new String[]{"a", "b", "c"});
    }

    @Test
    public void TestNumbers() {
        String[] a = {"3", "1", "2"};
        assertArrayEquals(radixSort.sort(a), new String[]{"1", "2", "3"});
    }

    @Test
    public void TestSimpleStringsDifferentCases() {
        String[] a = {"a", "A", "B", "b"};
        assertArrayEquals(radixSort.sort(a), new String[]{"A", "B", "a", "b"});
    }

    @Test
    public void TestSimpleStringsSpecialCharacters() {
        String[] a = {"a","A","!","B"};
        assertArrayEquals(radixSort.sort(a), new String[]{"!", "A", "B", "a"});
    }

    @Test
    public void TestSimpleStringsSpecialCharactersNumberCases() {
        String[] a = {"a", "5", "!", "B"};
        assertArrayEquals(radixSort.sort(a), new String[]{"!", "5", "B", "a"});
    }

    @Test
    public void TestLongStrings() {
        String[] a = {"aaa", "aba", "aab", "bba"};
        assertArrayEquals(radixSort.sort(a), new String[]{"aaa", "aab", "aba", "bba"});
    }

    @Test
    public void TestLongStringsDiffirentCases1() {
        String[] a = {"Aaa", "aba", "Bab", "bba"};
        assertArrayEquals(radixSort.sort(a), new String[]{"Aaa", "Bab", "aba", "bba"});
    }

    @Test
    public void TestLongStringsDiffirentCases2() {
        String[] a = {"bbF", "Aaa", "ABA", "Cba", "Bab", "bba"};
        assertArrayEquals(radixSort.sort(a), new String[]{"ABA", "Aaa", "Bab", "Cba", "bbF", "bba"});
    }

    @Test
    public void TestLongStringsSpecial() {
        String[] a = {"!a", "a!", "@a!"};
        assertArrayEquals(radixSort.sort(a), new String[]{"!a", "@a!", "a!"});
    }

    @Test
    public void TestLongStringsSpecialCharactersDifferentCases() {
        String[] a = {"A!", "a!", "@a!"};
        assertArrayEquals(radixSort.sort(a), new String[]{"@a!", "A!", "a!"});
    }

    @Test
    public void TestEqualElements() {
        String[] a = {"a", "a", "a"};
        assertArrayEquals(radixSort.sort(a), new String[]{"a", "a", "a"});
    }
}