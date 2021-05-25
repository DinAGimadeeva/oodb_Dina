/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import lab7.DAO.DBScanner;
import lab7.MetaClass.EntityMeta;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        CustomJPAAnnotationProcessor annotationProcessor=new CustomJPAAnnotationProcessor("lab7.Entities");
        List<EntityMeta> metaClasses=annotationProcessor.builtMetaClasses();
        DBScanner scanner=new DBScanner("org.postgresql.Driver","jdbc:postgresql://localhost:5432/lab7", "admin", "123");
        HashMap<String,HashSet<String>> tables=scanner.getTablesInfo();
        HashMap<String,HashSet<String>> fields=scanner.getTablesInfo();
        for (EntityMeta entityMeta:metaClasses)
            if (entityMeta.checkDB(tables))
                System.out.println(entityMeta.getName()+" was succesfully checked");
            else
                System.out.println(entityMeta.getName()+" failed validation");

        for(EntityMeta entityMeta:metaClasses)
            if (entityMeta.checkDB(fields))
                System.out.println(entityMeta.getAttributes()+" was succesfully checked");
            else
                System.out.println(entityMeta.getAttributes()+" failed validation");
    }

    public static void writeToFile(String str){
        File file =new File("lab7/metaClasses.txt");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println("Can not create file cause:"+ex );
            }
        try(FileWriter writer=new FileWriter(file,false)){
            writer.write(str);
        } catch (IOException ex) {
            System.err.println("Can not write file cause:"+ex );
        }
    }

}

