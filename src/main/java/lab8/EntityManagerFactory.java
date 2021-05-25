package lab8;


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

import lab7.MetaClass.EntityMeta;
import lab7.CustomJPAAnnotationProcessor;
import lab7.DAO.DBScanner;
import lab7.MetaClass.EntityMeta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class EntityManagerFactory {
  private Properties props;
  private List classes;

  public EntityManagerFactory(Properties properties, String classPath) {
    try {
      this.props = properties;
      LinkedHashMap<String, LinkedHashMap<String, String>> tablesPackage = ScanClasses.getInfoAboutClasses();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public EntityManager create() {

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

    return new EntityManagerImpl(props, classes);

  }

  public void close() {
     new EntityManagerImpl(props, classes).close();
  }


}