// Develop an implementation of LSD string sort 
// that works for variable-length strings.

class LSDForVariableLengthStrings {

    private int findLongestLength(String[] a) {
        int longest = 0;

        for (String s : a) {
            if (s.length() > longest) {
                longest = s.length();
            }
        }
        return longest;
    }

    private int findCharAtInString(int i, int d, String[] a) {
        if (d < 0 || d >= a[i].length()) {
            return 0;
        }
        return a[i].charAt(d);
    }

    public String[] sort(String[] a) {
        int n = a.length;
        int R = 256;
        String[] aux = new String[n];
        int w = findLongestLength(a);
        for (int d = w - 1; d >= 0; d--) {

            int[] count = new int[R + 1];
            for (int i = 0; i < n; ++i) {
                int c = findCharAtInString(i, d, a);
                count[c + 1]++;
            }

            for (int r = 0; r < R; ++r) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < n; ++i) {
                int c = findCharAtInString(i, d, a);
                aux[count[c]++] = a[i];
            }

            System.arraycopy(aux, 0, a, 0, n);
        }
        return a;
    }

    public StringArrayWithInfo sortWithInfo(String[] a) {
        int n = a.length;
        int R = 256;
        int iterations = 0;
        String[] aux = new String[n];
        int w = findLongestLength(a);
        for (int d = w - 1; d >= 0; d--) {

            int[] count = new int[R + 1];
            for (int i = 0; i < n; ++i) {
                int c = findCharAtInString(i, d, a);
                count[c + 1]++;
                iterations++;
            }

            for (int r = 0; r < R; ++r) {
                count[r + 1] += count[r];
                iterations++;
            }

            for (int i = 0; i < n; ++i) {
                int c = findCharAtInString(i, d, a);
                aux[count[c]++] = a[i];
                iterations++;
            }
            iterations++;

            System.arraycopy(aux, 0, a, 0, n);
        }
        return new StringArrayWithInfo(a, iterations);
    }
}