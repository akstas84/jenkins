package akstas84.qa.tests.simple;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTests {
  @Test
  void test1() {assertTrue(false);}
  @Tag("smoke")
  @Test
  void test2() {assertTrue(false);}
  @Test
  void test3() {assertTrue(false);}
  @Test
  void test4() {assertTrue(false);}
  @Test
  void test5() {assertTrue(false);}
}

