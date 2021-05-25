package lab8;
/*Импoртируем классы из 7*/
import lab7.CustomJPAAnnotationProcessor;
import lab7.DAO.DBScanner;
import lab7.MetaClass.EntityMeta;


import lab8.classes.Author;
import lab8.classes.Book;
import lab8.classes.Person;
import lab8.classes.Sectionstitles;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;


public class Test {


  public static void main(String[] args) {
    Properties props = new Properties();

    props.setProperty("url", "jdbc:postgresql://localhost:5432/libraries");
    props.setProperty("username", "admin");
    props.setProperty("password", "123");
    props.setProperty("driverName", "org.postgresql.Driver");
    String classPath = "lab8.classes";
/*Тут связь для дб сканера и для процессора анотаций*/
/*    CustomJPAAnnotationProcessor annotationProcessor=new CustomJPAAnnotationProcessor("lab7.Entities");
    List<EntityMeta> metaClasses=annotationProcessor.builtMetaClasses();
    DBScanner scanner=new DBScanner("org.postgresql.Driver","jdbc:postgresql://localhost:5432/lab7", "admin", "123");*/
   //Дальше идет HashMap для таблиц и для строк



//    EntityManagerImpl entityManager = new EntityManagerImpl();
    EntityManagerFactory entityManagerFactory = new EntityManagerFactory(props, classPath);
    EntityManager entityManager = entityManagerFactory.create();

    Person author = new Author();
    author.setName("Николай");
    author.setPatronymic("Васильевич");
    author.setLastname("Гоголь");
    ((Author) author).setInfo("писатель");

    Person author2 = new Author();
    author2.setName("Тест");
    author2.setPatronymic("Уже");
    author2.setLastname("Просто");
    ((Author) author2).setInfo("стихотворец");

    entityManager.persist(author);
    entityManager.persist(author2);





    Sectionstitles sectionsTitles = new Sectionstitles();
    sectionsTitles.setSectionstitles("Повесть");
    entityManager.persist(sectionsTitles);

//
    Book book = new Book();
    book.setTitle("Работай уже!!!");
    book.setAuthor((Author) author);
    book.setSectionstitles(sectionsTitles);
    book.setDateofpublishing("24.05.2008");
    book.setPrice(23.0);
    entityManager.persist(book);


    System.out.println("\n");
    System.out.println("Объект класса Author до обновления - " + author);
    ((Author) author).setInfo("Писатель и поэт");
    entityManager.merge(author);
    System.out.println("Объект класса Author после обновления - " + author);

    System.out.println("\n");
    System.out.println("Объект класса Book до обновления - " + book);
    book.setDateofpublishing("30.05.2015");
    book.setAuthor((Author) author2);
    entityManager.merge(book);
    System.out.println("Объект класса Book после обновления - " + book);
    System.out.println("\n");

    entityManager.remove(book);
    entityManager.remove(sectionsTitles);


    System.out.println("\n");
    System.out.println("Объект класса Book до обновления - " + book);
    book.setDateofpublishing("20.03.2020");
    entityManager.merge(book);
    System.out.println("Объект класса Book после обновления - " + book);
    System.out.println("\n");

    System.out.println("\n");
    Object object = entityManager.find(Book.class, 1);
    System.out.println("Найденный объект класса Book с id=1 - " + object);

    entityManagerFactory.close();


  }
}

