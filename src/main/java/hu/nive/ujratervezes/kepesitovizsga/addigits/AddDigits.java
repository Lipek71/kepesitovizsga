package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String input){
        if (input == null || input.isEmpty()){
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sum += Integer.parseInt(input.substring(i, i + 1));
            }
        }
        return sum;
    }
}
