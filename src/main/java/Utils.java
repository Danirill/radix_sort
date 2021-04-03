import java.util.Random;

public class Utils {
    public String[] generateArray(int size){

        String[] arr= new String[size];

        for (int i=0; i<arr.length; i++) {
            arr[i] = generateString((int)(100 * Math.random()));
        }

        return arr;
    }

    public String generateString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}

class StringArrayWithInfo{
    String[] array;
    int iterations;

    StringArrayWithInfo(String[] array, int iterations){
        this.array = array;
        this.iterations = iterations;
    }

    public String[] getArray() {
        return array;
    }

    public int getIterations() {
        return iterations;
    }
}
