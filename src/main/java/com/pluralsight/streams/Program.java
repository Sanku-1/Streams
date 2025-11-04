package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        Person person1 = new Person("Stephen", "Anku", 26);
        people.add(person1);
        Person person2 = new Person("Steve", "Rogers", 104);
        people.add(person2);
        Person person3 = new Person("Clark", "Kent", 37);
        people.add(person3);
        Person person4 = new Person("Bruce", "Banner", 40);
        people.add(person4);
        Person person5 = new Person("Peter", "Parker", 19);
        people.add(person5);
        Person person6 = new Person("Bruce", "Wayne", 38);
        people.add(person6);
        Person person7 = new Person("Luffy", "Monkey", 21);
        people.add(person7);
        Person person8 = new Person("Sue", "Storm", 32);
        people.add(person8);
        Person person9 = new Person("Dick", "Grayson", 22);
        people.add(person9);
        Person person10 = new Person("Oliver", "Queen", 36);
        people.add(person10);
    }

        static Person searchPersonList(Scanner scanner, ArrayList<Person> list) {

            List<Person> filteredPeople = new ArrayList<>();
            System.out.println("What Attribute Would You Like to Search By? \n 1. First Name \n 2. Last Name \n");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    System.out.println("Please enter the first name of the person you wish to search for:");
                    String inputFirstName = scanner.nextLine();
                    for (Person person:list) {
                        if (person.getFirstName().equalsIgnoreCase(inputFirstName)) {
                            filteredPeople.add(person);
                        }
                    }
                    if (filteredPeople.isEmpty()){
                        System.out.println("No matching people found");
                    }
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Invalid Selection, Please Try Again");
            }

            return null;
        }





}
