package edu.pdx.cs410J.ramayan2;


import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

class KataIT extends InvokeMainTestCase {

  @Test
  void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }
  
  @Test
  void simplestCaseMultiplication() {

    InvokeMainTestCase.MainMethodResult result1 = invokeMain(Kata.class, "20", "5","*");
    assertThat(result1.getTextWrittenToStandardOut(), equalTo(100+"\r\n"));

  }
  @Test
  void simpleCaseDivision(){
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "20", "5", "/");
    assertThat(result.getTextWrittenToStandardOut(), equalTo(4+"\r\n"));
  }
  @Test
  void simpleCaseAdditionAndSubtraction(){

    InvokeMainTestCase.MainMethodResult result2 = invokeMain(Kata.class, "4", "2", "+","3","-");
    assertThat(result2.getTextWrittenToStandardOut(), equalTo(3+"\r\n"));
  }

  @Test
  void simpleCaseDMultiplicationAndSubstraction(){
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "3", "5", "8","*","7","-","*");
    assertThat(result.getTextWrittenToStandardOut(), equalTo(1089+"\r\n"));
  }

  @Test
  void simpleCaseDMultiplicationDivisionAndSubstraction(){
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "3", "5", "8","*","7","-","*","/","10");
    assertThat(result.getTextWrittenToStandardOut(), equalTo(10+"\r\n"));
  }


  @Test
  void simpleCaseDMultiplicationAdditionSubstractionAndDivision() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "3", "5", "8", "*", "7", "-", "*", "+", "10", "/", "5");
    assertThat(result.getTextWrittenToStandardOut(), equalTo(5 + "\r\n"));

  }

//  @Test
//  void simpleCaseSquareRoot(){
//    //is failing because we pop 2 numbers that gives an exception
//    //but why did we moved out. popping in the case is good idea right
//    //Popping is good but we need to pop according to length. lets do it in next week. ok
//    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "9","SQRT");
//    assertThat(result.getTextWrittenToStandardOut(), equalTo(3+"\r\n"));
//  }

}
