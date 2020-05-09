package com.generic.list;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileManipulator<Any extends Comparable<Any>> {
    private final Class<Any> type;

    public CsvFileManipulator(Class<Any> type) {
        this.type = type;
    }

    public Class<Any> getType() {
        return this.type;
    }

    public MyList<Any> readFileToMyList(String path) throws IOException, CsvValidationException {

        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReader(reader);
        String[] records = csvReader.readNext();
        MyList myList = new MyList();
        for (String s:records) {
            try{
                switch (this.getType() + "") {
                    case "class java.lang.Integer":
                        myList.add(Integer.parseInt(s));
                        break;
                    case "class java.lang.Double":
                        myList.add(Double.parseDouble(s));
                        break;
                    case "class java.lang.Character":
                        myList.add(s.charAt(0));
                        break;
                    default:
                        myList.add(s + "");
                        break;
                }
            }catch (NumberFormatException e){
                throw new NumberFormatException("file containing multiple data types ");
            }
        }
        return myList;
    }

    public void writeMyListToFile(MyList<Any> records, String path) throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get(path));
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(records.toStringArray());
        writer.close();
    }

    public void manipulateFile(String path, Any data) throws IOException, CsvValidationException {
        MyList<Any> list = readFileToMyList(path);
        if (list.search(data))
            list.remove(data);
        else
            list.add(data);
        writeMyListToFile(list, path);
    }
}

