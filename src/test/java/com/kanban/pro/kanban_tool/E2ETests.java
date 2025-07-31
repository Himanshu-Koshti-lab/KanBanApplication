package com.kanban.pro.kanban_tool;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class E2ETests {

    @Nested
    @DisplayName(" Test Box - 1 ")
    class testD1{

        @Test
        @DisplayName("Test 1")
         void test1(){
            assertTrue(true);
        }

        @Test
        @DisplayName("Test 2")
         void test2(){
            assertTrue(true);
        }
        @Test
        @DisplayName("Test 3")
         void test3(){
            assertTrue(true);
        }

    }


    @Nested
    @DisplayName(" Test Box - 2")
    class test{

        @Test
        @DisplayName("Test 1")
         void test1(){
            assertTrue(true);
        }

        @Test
        @DisplayName("Test 2")
         void test2(){
            assertTrue(true);
        }
        @Test
        @DisplayName("Test 3")
         void test3(){
            assertTrue(true);
        }

    }

}


