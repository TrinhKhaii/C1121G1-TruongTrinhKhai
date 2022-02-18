package utils.exception;

public class Exceptions {
    public static void CheckChoiceNumberFrom1To6(String chooseMenu) throws ControllerException {
        if (Integer.parseInt(chooseMenu) != 1 && Integer.parseInt(chooseMenu) != 2 && Integer.parseInt(chooseMenu) != 3 && Integer.parseInt(chooseMenu) != 4 && Integer.parseInt(chooseMenu) != 5 && Integer.parseInt(chooseMenu) != 6) {
            throw new ControllerException("Your choice must from 1 to 6");
        }
    }

    public static void CheckChoiceNumberFrom1To4(String chooseMenu) throws ControllerException {
        if (Integer.parseInt(chooseMenu) != 1 && Integer.parseInt(chooseMenu) != 2 && Integer.parseInt(chooseMenu) != 3 && Integer.parseInt(chooseMenu) != 4) {
            throw new ControllerException("Your choice must from 1 to 4");
        }
    }

    public static void CheckChoiceNumberFrom1To3(String chooseMenu) throws ControllerException {
        if (Integer.parseInt(chooseMenu) != 1 && Integer.parseInt(chooseMenu) != 2 && Integer.parseInt(chooseMenu) != 3) {
            throw new ControllerException("Your choice must from 1 to 3");
        }
    }
}
