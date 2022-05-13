package com.st1tchqwerty;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Student st1=new Student("Maks",20, 99);
        Student st2=new Student("Egor", 17, 67);
        Student st3=new Student("Karl", 18, 88);
        Student st4=new Student("Andrew", 17, 95);
        Student st5=new Student("Ork", 18, 69);
        Group physicGroup=new Group(0);
        physicGroup.add(st1);
        physicGroup.add(st2);
        physicGroup.add(st3);
        physicGroup.add(st4);
        physicGroup.add(st5);

        while (true){
            System.out.println("1.Sort by grade\n2.Add Student \n3.Sort by names\n4.Show all Students\n5.Add from file\n6.All data to file");
            Scanner sc=new Scanner(System.in);
            int wt=sc.nextInt();
            switch (wt){
                case 1:
                    physicGroup.sortByGrade();
                case 2:
                    physicGroup.userAdd();
                case 3:
                    physicGroup.toString();
                case 4:
                    physicGroup.showAllStudents();
                case 5:
                    physicGroup.addFromFile();
                case 6:
                    physicGroup.toFile();
                default:
                    break;
            }
        }

    }
}
