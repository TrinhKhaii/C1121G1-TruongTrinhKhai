package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;

public class NumbersIntoString {

    public static String oneNum(int num) {
        String result = "";
        switch (num) {
            case 0:
                result += "zero";
                break;
            case 1:
                result += "one";
                break;
            case 2:
                result += "two";
                break;
            case 3:
                result += "three";
                break;
            case 4:
                result += "four";
                break;
            case 5:
                result += "five";
                break;
            case 6:
                result += "six";
                break;
            case 7:
                result += "seven";
                break;
            case 8:
                result += "eight";
                break;
            case 9:
                result += "nine";
                break;
            case 10:
                result += "ten";
                break;
            default:
                result += "out of ability";
                break;
        }
        return result;
    }

    public static String twoNum(int num) {
        String result = "";
        if (num > 10 && num < 20) {
            switch (num) {
                case 11:
                    result += "eleven";
                    break;
                case 12:
                    result += "twelve";
                    break;
                case 13:
                    result += "thirteen";
                    break;
                case 14:
                    result += "fourteen";
                    break;
                case 15:
                    result += "fifteen";
                    break;
                case 16:
                    result += "sixteen";
                    break;
                case 17:
                    result += "seventeen";
                    break;
                case 18:
                    result += "eighteen";
                    break;
                case 19:
                    result += "nineteen";
                    break;
                default:
                    result += "out of ability";
                    break;
            }
            return result;
        } else {
            int unitNum = num % 10;
            int tensNum = num - (num % 10);
            switch (tensNum) {
                case 20:
                    result += "twenty";
                    break;
                case 30:
                    result += "thirty";
                    break;
                case 40:
                    result += "fourty";
                    break;
                case 50:
                    result += "fifty";
                    break;
                case 60:
                    result += "sixty";
                    break;
                case 70:
                    result += "seventy";
                    break;
                case 80:
                    result += "eighty";
                    break;
                case 90:
                    result += "ninety";
                    break;
                default:
                    result += "out of ability";
                    break;
            }
            if (unitNum == 0) {
                return result;
            } else {
                result += " " + oneNum(unitNum);
                return result;
            }
        }
    }

    public static String threeNum(int num) {
        int hundredNum = num - (num % 100);
        int tensNum = num % 100;
        String result = "";
        switch (hundredNum) {
            case 100:
                result += "one hundred";
                break;
            case 200:
                result += "two hundred";
                break;
            case 300:
                result += "three hundred";
                break;
            case 400:
                result += "four hundred";
                break;
            case 500:
                result += "five hundred";
                break;
            case 600:
                result += "six hundred";
                break;
            case 700:
                result += "seven hundred";
                break;
            case 800:
                result += "eight hundred";
                break;
            case 900:
                result += "nine hundred";
                break;
            default:
                result += "out of ability";
                break;
        }
        result += " and " + twoNum(tensNum);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;

        String result = "";

        if (num >= 0 && num <= 10) {
            check1 = true;
            result = oneNum(num);
        } else if (num > 10 && num < 100) {
            check2 = true;
            result = twoNum(num);
        } else if (num >= 100 && num < 1000) {
            check3 = true;
            result = threeNum(num);
        }

        if (check1) {
            System.out.println(result);
        } else if (check2) {
            System.out.println(result);
        } else if (check3) {
            System.out.println(result);
        }
    }

}
