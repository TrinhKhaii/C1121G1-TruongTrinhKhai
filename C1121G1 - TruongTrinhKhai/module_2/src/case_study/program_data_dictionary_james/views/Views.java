package case_study.program_data_dictionary_james.views;

import case_study.program_data_dictionary_james.controllers.DictionaryControllers;

public class Views {
    public static void main(String[] args) {
        DictionaryControllers dictionaryControllers = new DictionaryControllers();
        dictionaryControllers.displayMainMenu();
    }
}
