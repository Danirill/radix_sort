import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        int limit = 150;
        int repeat = 1;
        Utils utils = new Utils();
        LSDForVariableLengthStrings sorter = new LSDForVariableLengthStrings();
        SortResultsWriter sortResultsWriter = new SortResultsWriter();
        for (int i = 0; i <= limit; i++){
            for (int j = 0; j < repeat; j++){
                StringArrayWithInfo sortedArrayWithInfo = sorter.sortWithInfo(utils.generateArray(i));
                sortResultsWriter.writeResult(sortedArrayWithInfo.array.length, sortedArrayWithInfo.iterations);
            }
        }
    }
}
