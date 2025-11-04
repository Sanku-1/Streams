package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<>();

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

        boolean running = true;

        while (running) {
            System.out.println("Welcome to PeopleX");
            System.out.println("Choose an option:");
            System.out.println("A) Search");
            System.out.println("B) Get Average Age");
            System.out.println("C) Get Youngest Person");
            System.out.println("D) Get Oldest Person");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> searchPersonList(scanner, people);
                case "B" -> System.out.println("The average age of the people in this list is: " + averageAge(people) + " year(s) old" + "\n");
                case "C" -> System.out.println(lowestAge(people));
                case "D" -> System.out.println(highestAge(people));
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }

//            scanner.close();
        }
        scanner.close();
    }

    static void searchPersonList(Scanner scanner, ArrayList<Person> list) {

        try {
            List<Person> filteredPeople = new ArrayList<>();
            System.out.println("What Attribute Would You Like to Search By? \n 1. First Name \n 2. Last Name \n");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    System.out.println("Please enter the first name of the person you wish to search for:");
                    String inputFirstName = scanner.nextLine();
                    for (Person person : list) {
                        if (person.getFirstName().equalsIgnoreCase(inputFirstName)) {
                            filteredPeople.add(person);
                        }
                    }
                    if (filteredPeople.isEmpty()) {
                        System.out.println("No matching people found");
                    } else {
                        for (Person person : filteredPeople) {
                            System.out.println(person.getFirstName() + " " + person.getLastName() + " , age " + person.getAge() + "\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Please enter the last name of the person you wish to search for:");
                    String inputLastName = scanner.nextLine();
                    for (Person person : list) {
                        if (person.getLastName().equalsIgnoreCase(inputLastName)) {
                            filteredPeople.add(person);
                        }
                    }
                    if (filteredPeople.isEmpty()) {
                        System.out.println("No matching people found\n");
                    } else {
                        for (Person person : filteredPeople) {
                            System.out.println(person.getFirstName() + " " + person.getLastName() + " , age " + person.getAge() + "\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Selection, Please Try Again");
            }
        } catch (Exception e) {
            System.err.println("Invalid Selection\n");
            scanner.nextLine();
        }
    }

    static double averageAge(ArrayList<Person> peopleList) {
        int ageSum = 0;
        for (Person person: peopleList) {
            ageSum += person.getAge();
            }
        return ((double) ageSum / peopleList.size());
    }

    static String highestAge(ArrayList<Person> peopleList) {
        int maxAge = 0;
        Person oldestPerson = new Person();
        for (Person person: peopleList) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
                oldestPerson.setAge(person.getAge());
                oldestPerson.setFirstName(person.getFirstName());
                oldestPerson.setLastName(person.getLastName());
            }
        }
        return "The oldest person in the collection is " + oldestPerson.getFirstName() + " " + oldestPerson.getLastName() + ", with an age of " + oldestPerson.getAge() + "\n";
    }

    static String lowestAge(ArrayList<Person> peopleList) {
        int minAge = 999999;
        Person youngestPerson = new Person();
        for (Person person: peopleList) {
            if (person.getAge() < minAge) {
                minAge = person.getAge();
                youngestPerson.setAge(person.getAge());
                youngestPerson.setFirstName(person.getFirstName());
                youngestPerson.setLastName(person.getLastName());
            }
        }
        return "The youngest person in the collection is " + youngestPerson.getFirstName() + " " + youngestPerson.getLastName() + ", with an age of " + youngestPerson.getAge() + "\n";
    }






}
