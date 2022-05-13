package com.st1tchqwerty;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Group {
    public static Student[]  StudentList=new Student[10];
    private  int count;
    public Group(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void add(Student stud){
        try {
            this.StudentList[count]=stud;
            this.count++;
        }catch (Exception e){
            System.out.println("more than 10 students");
        }

    }
    public void delete(String name){
        for(int i=0; i<this.count; i++){
            if(this.StudentList[i].getName().equals(name)==true){
                for(int j=i; j<this.count-1; j++){
                    this.StudentList[j]=this.StudentList[j+1];
                }
                this.count--;
                break;
            }
        }
    }

    public String toString(){
        String[] names=new String[count];
        for (int i=0; i<count; i++){
            names[i]=StudentList[i].getName();
        }
        Arrays.sort(names);
        for(int i=0; i<count;i++){
            System.out.println(names[i]);
        }
        return null;
    }

    public void sortByGrade(){
        int[] grades=new int[count];
        for (int i=0; i<count; i++){
            grades[i]=StudentList[i].getGrade();
        }
        Arrays.sort(grades);
        for(int i=0; i<count;i++){
            System.out.print(grades[i]);
            for (int j=0; j<count; j++){
                if(grades[i]==StudentList[j].getGrade()){
                    System.out.print(" ");
                    System.out.println(StudentList[i].getName());
                }
            }
        }
    }

    public void toFile(){
        System.out.println("What name and format of file do you want");
        Scanner sc=new Scanner(System.in);
        String adress= sc.nextLine();
        try(BufferedWriter f=new BufferedWriter((new FileWriter(adress)))){
            for(int i=0; i<this.count; i++){
                f.write(StudentList[i].getName()+" "+StudentList[i].getAge()+" "+StudentList[i].getGrade());
                f.newLine();
            }
        }catch (IOException e){
            System.out.println("Не получилось создать файл группы");
        }
    }
    public void addFromFile(){
        System.out.println("Adress of your file");
        Scanner sc=new Scanner(System.in);
        String adress= sc.nextLine();
        try(BufferedReader f=new BufferedReader((new FileReader(adress)))){
            String str="";
            for(; (str=f.readLine())!=null;){
                String[] stud;
                stud=str.split(" ");
                Student st=new Student(stud[0], Integer.parseInt(stud[1]), Integer.parseInt(stud[2]));
                add(st);
            }
        }catch (Exception e){
           //System.out.println("Error");
        }
    }
    public void showAllStudents(){
        for(int i=0; i<count; i++){
            System.out.print(StudentList[i].getName()+" "+StudentList[i].getAge()+" "+StudentList[i].getGrade()+"\n");
        }
    }
    public void userAdd(){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Name");
            String name=sc.nextLine();
            System.out.println("Age");
            int age= sc.nextInt();
            System.out.println("Grage");
            int grade=sc.nextInt();
            Student st1=new Student(name, age, grade);
            add(st1);
            System.out.println("Successful");
        }catch (Exception e){
            System.out.println("Error of your data");
            userAdd();
        }
    }
}
