import common.Algorithm;
import common.Library;

import controller.SearchProgramming;
import model.Element;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Algorithm algorithm = new Algorithm();
        Element element = new Element();

        element.setSize_array(library.getInt("Enter number of array", 1, 100));
        element.setArray(library.createArray(element.getSize_array()));

        SearchProgramming searchProgramming = new SearchProgramming(element, library, algorithm);
        
        searchProgramming.run();
    }
}
