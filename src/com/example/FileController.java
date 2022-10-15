package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    private FileController(){};

    public static void saveData(String fileName, String result){
        writeToFile(fileName, result);
    }

    public static void saveSize(String fileName, ArrayList<Integer> size){
        String str = String.format("%d %d\n", size.get(0), size.get(1));
        writeToFile(fileName, str, false);
    }

    public static void saveGeometricMean(String fileName, double result){
        String str = String.format("%.3f\n", result);
        writeToFile(fileName, str, true);
    }

    public static ArrayList<Integer> loadSize(String fileName){
        ArrayList<Integer> arrayList = new ArrayList<>();

        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            if((text = reader.readLine()) != null){
                String[] parts = text.split(" ");
                for (String part : parts) {
                    arrayList.add(Integer.parseInt(part));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (arrayList.size() != 2) return null;
        return arrayList;
    }

//    public static Matrix loadMatrix(String fileName){
//        ArrayList<ArrayList<Double>> auxMatrix = new ArrayList<>();
//        File file = new File(fileName);
//        // read data
//        int actualSize = 0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String text;
//            int i = 0;
//            text = reader.readLine();
//            while ((text = reader.readLine()) != null) {
////                split "1.1 0.1"
//                String[] parts = text.split(" ");
//
//                auxMatrix.add(new ArrayList<>());
//                for (String part : parts) {
//                    auxMatrix.get(i).add(Double.parseDouble(part));
//                    actualSize++;
//                }
//                i++;
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.printf("File %s not found ", fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // check input size
//        int m = auxMatrix.size();
//        int n = auxMatrix.get(0).size();
//        if (m * n != actualSize) return null;
//
//        Double[][] matrix;
//        matrix = auxMatrix.stream().map(x->x.toArray(new Double[0])).toArray(Double[][]::new);
//
//
//        return new Matrix(matrix);
//    }

    public static ArrayList<Double> loadData(String fileName){
        ArrayList<Double> arrayList = new ArrayList<>();
        File file = new File(fileName);
        // read data
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = reader.readLine()) != null) {
//                split "1.1 0.1"
                String[] parts = text.split(" ");
                for (String part : parts) {
                    arrayList.add(Double.parseDouble(part));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<Double> loadDoubles(String s) {
        ArrayList<Double> doubles = loadData(s);

        if (doubles.size() != 5) return null;

        return doubles;
    }

//    private static ArrayList<Double> loadData(String fileName){
//        ArrayList<Double> arrayList = new ArrayList<>();
//        File file = new File(fileName);
//        // read data
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String text;
//            while ((text = reader.readLine()) != null) {
////                split "1.1 0.1"
//                String[] parts = text.split(" ");
//                for (String part : parts) {
//                    arrayList.add(Double.parseDouble(part));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.printf("File %s not found ", fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return arrayList;
//    }

    public static List<Employee> loadEmployees(String fileName){

        List<Employee> employees = new ArrayList<>();

        File file = new File(fileName);
        // read data
        int actualSize = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            int i = 0;
            while ((text = reader.readLine()) != null) {
//                split "1.1; 0.1"
                String[] parts = text.split("; ");

                Employee auxEmployee = createEmployee(parts);
                if (auxEmployee != null) {
                    employees.add(auxEmployee);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private static Employee createEmployee(String[] data){
        if (data.length != 6) return null;

        try {
            double yearsOfService = Double.parseDouble(data[3]);
            double salary = Double.parseDouble(data[5]);
            int yearOfBirth = Integer.parseInt(data[2]);
            return new Employee(
                    data[0], data[1], data[4], yearsOfService, yearOfBirth, salary
            );
        } catch (Exception e){
            return null;
        }
    }

//    public static ArrayList<Matrix> loadMatrices(String fileName){
//        ArrayList<ArrayList<Double>> auxMatrix = new ArrayList<>();
//
//        ArrayList<Matrix> matrices = new ArrayList<>();
//
//        File file = new File(fileName);
//        // read data
//        int actualSize = 0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String text;
//            int i = 0;
//            while ((text = reader.readLine()) != null) {
////                split "1.1 0.1"
//                String[] parts = text.split(" ");
//
//                if (text.equals("")){
//                    // check actual matrix size
//                    int m = auxMatrix.size();
//                    int n = auxMatrix.get(0).size();
//                    if (m * n != actualSize) return null;
//
//                    Double[][] matrix = new Double[m][];
//                    matrix = auxMatrix.stream().map(x->x.toArray(new Double[0])).toArray(Double[][]::new);
//                    matrices.add(new Matrix(matrix));
//
//                    actualSize = 0;
//                    i = 0;
//                    auxMatrix.clear();
//                    continue;
//                }
//
//                auxMatrix.add(new ArrayList<>());
//                for (String part : parts) {
//                    auxMatrix.get(i).add(Double.parseDouble(part));
//                    actualSize++;
//                }
//                i++;
//            }
//
//            if (auxMatrix != null){
//                matrices.add(createMatrix(auxMatrix));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.printf("File %s not found ", fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return matrices;
//    }

//    private static Matrix createMatrix(ArrayList<ArrayList<Double>> auxMatrix){
//        Double[][] matrix;
//        matrix = auxMatrix.stream().map(x->x.toArray(new Double[0])).toArray(Double[][]::new);
//        return new Matrix(matrix);
//    }

    private static void writeToFile(String fileName, String str, boolean a){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, a))) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to a file");
        }
    }

    private static void writeToFile(String fileName, String str){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to a file");
        }
    }


}
