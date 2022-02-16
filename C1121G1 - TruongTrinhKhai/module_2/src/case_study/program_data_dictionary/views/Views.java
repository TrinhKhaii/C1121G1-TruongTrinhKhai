package case_study.program_data_dictionary.views;

import case_study.program_data_dictionary.controllers.DictionaryControllers;

public class Views {
    public static void main(String[] args) {
        DictionaryControllers dictionaryControllers = new DictionaryControllers();
        dictionaryControllers.displayMainMenu();
    }
}
