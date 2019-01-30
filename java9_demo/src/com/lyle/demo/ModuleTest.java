package com.lyle.demo;

import com.lyle.test.Person;
import java.util.logging.Logger;
import org.junit.Test;

public class ModuleTest {

  private static final Logger LOGGER = Logger.getLogger("java9test");

  public static void main(String[] args) {
    Person p = new Person("嘟嘟姐", 28);
    System.out.println(p);
    LOGGER.info("this is test java9 Modularity");
  }

  @Test
  public void test1() {
    System.out.println("hello");
  }
}