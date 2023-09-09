package controller;

import common.Algorithm;
import common.Library;
import model.Element;

import view.Menu;

public class SearchProgramming extends Menu<String> {

    static String[] mc = {"Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SearchProgramming(Element element, Library library, Algorithm algorithm) {
        super("Search Programming", mc);
        this.library = library;
        this.algorithm = algorithm;
        this.array = element.getArray();
        this.size_array = element.getSize_array();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                search();
                break;
            case 2:
                System.exit(0);
        }
    }

    public void search() {
        final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public synchronized void execute(int n) {
                algorithm.bubbleSort(array);
                library.display(array);
                int value = library.getInt("\nEnter number to find: ", 1, 100);
                switch (n) {
                    case 1:
                        if (algorithm.linearSearch(array, value) != -1) {
                            System.out.println("Found value: " + value + " at index: " + algorithm.linearSearch(array, value));
                        } else {
                            System.out.println("Value " + value + " not found in the array.");
                        }

                        break;
                    case 2:
                        if (algorithm.binarySearch(array, value) != -1) {
                            System.out.println("Found value: " + value + " at index: " + algorithm.binarySearch(array, value));
                        } else {
                            System.out.println("Value " + value + " not found in the array.");
                        }

                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
    }
}