package algo;

public class Algo {
    private static int[] array = {34, 1, 5, 10, 3};

    public static void main(String[] args) {
        simpleNumber(100);
    }

    String stringToSort(String numbers) {
        String[] strings = numbers.split(" "); //parse string;
        int[] array = new int[strings.length];
        int weight = 0;

        for (int i = 0; i < strings.length; i++) { //find weight;
            for (int j = 0; j < strings[i].length(); j++) {
                if (strings[i].length() > 1) {
                    weight += Integer.parseInt(strings[i].substring(j, j + 1));
                }
            }
            array[i] = weight;
            weight = 0;
        }

        for (int i = 0; i < array.length; i++) { //remove duplicate
            loop:
            for (int j = i; j < array.length - 1; j++) {
                if(array[i] == array[j + 1]){
                    if(!strings[i].equals(strings[j + 1])){
                        strings[i] = "";
                        array[i] = 0;
                        continue loop;
                    }
                }
            }
        }

        for (int j = array.length - 1; j > 0; j--) { // sort weight string
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int tempWeight = array[i];
                    String tempString = strings[i];
                    array[i] = array[i + 1];
                    strings[i] = strings[i + 1];
                    array[i + 1] = tempWeight;
                    strings[i + 1] = tempString;
                }
            }
        }

        return String.join(" ",strings);

    }

    static void simpleNumber(int n) {
        next:
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue next;
                }
            }

            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Burning Buttons!");
            }else if (i % 3 == 0) {
                System.out.println("Burning");
            }else if (i % 5 == 0) {
                System.out.println("Buttons");
            }
        }
    }


    int[] bubbleSort(int[] arrays) {
        for (int j = arrays.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arrays[i] > arrays[i + 1]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                }
            }
        }
        return arrays;
    }

    int binarySearch(int number, int[] array) {

        int start = 0;
        int end = array.length;
        int mid = 0;

        while (!(start >= end)) {
            mid = start + (end - start) / 2;

            if (array[mid] == number) {
                return mid;
            } else if (array[mid] > number) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    boolean findSumNumber(int[] array, int number) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[i] + array[j + 1] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    int multiplyLength(int n) {
        String number = String.valueOf(n);
        if (n > 0 && n > 9) {
            while (number.length() > 1) {

                for (int i = 0; i < number.length(); i++) {

                    for (int j = 0; j < i; j++) {

                        number = String.valueOf(Integer.parseInt(String.valueOf(number.charAt(i))) * Integer.parseInt(String.valueOf(number.charAt(j))));
                    }

                    if (number.length() == 1) {
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(number);
    }
}
