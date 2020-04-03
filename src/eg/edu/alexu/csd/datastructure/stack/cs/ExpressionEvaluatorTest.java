package eg.edu.alexu.csd.datastructure.stack.cs;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    /**
     * test the infixToPostfix method
     */
    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        ExpressionEvaluator test = new ExpressionEvaluator();
        /////////////////////////////////////////Given tests////////////////////////////////////////////////////////////
        String s0 ="3 2 * ";
        assertEquals(s0,test.infixToPostfix("3*2"));
        String s = "2 3 4 * + ";
        assertEquals(s,test.infixToPostfix("2+3*4"));
        String s1 ="a b * 5 + ";
        assertEquals(s1,test.infixToPostfix("a*b+5"));
        String s2 ="0 21 - 7 * ";
        assertEquals(s2,test.infixToPostfix("(0-21)*7"));
        String s3 = "a b * c / ";
        assertEquals(s3,test.infixToPostfix("a*b/c"));
        String s4 = "a b c - d + / e a - * c * ";
        assertEquals(s4,test.infixToPostfix("(a/(b-c+d))*(e-a)*c"));
        String s5 = "a b / c - d e * + a c * - ";
        assertEquals(s5,test.infixToPostfix("a/b-c+d*e-a*c"));
        String s6 = "4 3 + 2 7 * - ";
        assertEquals(s6,test.infixToPostfix("(4+3)-(2*7)"));
        String s66 ="20 0 2 - 7 - 0 5 - 4 + 8 1 - - + / ";
        assertEquals(s66,test.infixToPostfix("20/-(2-7+-(5+4-(8-1)))"));

        //////////////////////////////////////////more tests////////////////////////////////////////////////////////////
        String s7 = "300 23 + 43 21 - * 84 7 + / ";
        assertEquals(s7,test.infixToPostfix( "(300+23)*(43-21)/(84+7)"));
        String s8 = "4 8 + 6 5 - * 3 2 - 2 2 + * / ";
        assertEquals(s8,test.infixToPostfix("(4+8)*(6-5)/((3-2)*(2+2))"));

        /////////////////////////////////test 2 empty expression////////////////////////////////////////////////////////
        try {
            String s9 =" ";
            assertEquals(s9,test.infixToPostfix(" "));
        }catch (NullPointerException t){
            System.out.println(t.toString());
        }

       /////////////////////////////////////test 3 null expression//////////////////////////////////////////////////////
        try {
            String s10 = " ";
            assertEquals(s10,test.infixToPostfix(null));
        }catch (NullPointerException t){
            System.out.println(t.toString());
        }

        //////////////////////////////test 4 only one symbole as + - * /////////////////////////////////////////////////
        try {
            String s11 = " ";
            assertEquals(s11,test.infixToPostfix("+"));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }

        /////////////////////////////////////////////test 5 only one variable or number////////////////////////////////
        String s12 = "500 ";
        assertEquals(s12,test.infixToPostfix("500"));

       ///////////// //////////////////test 6 end with + - * ///////////////////////////////////////////////////////////
        try {
            String s13 = " ";
            assertEquals(s13,test.infixToPostfix("106+565*"));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }

        /////////////////////////////////////////////test 7 special characters/////////////////////////////////////////
        try {
            String s14 = " ";
            assertEquals(s14,test.infixToPostfix("10+a+$"));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        //////////////////////////////////////////////test 8 wrong parentheses//////////////////////////////////////////
        try {
            String s15 = " ";
            assertEquals(s15,test.infixToPostfix("10+(5+2"));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        ////////////
        try {
            String s15 = " ";
            assertEquals(s15,test.infixToPostfix("10+5*2)"));
        }catch (NullPointerException t){
            System.out.println(t.toString());
        }

        /////////////////////////////////////test 9 spaces//////////////////////////////////////////////////////////////
        String s16 = "2 3 4 * + ";
        assertEquals(s16,test.infixToPostfix("2                   +             3       *     4 "));
        String s17 ="a b * 5 + ";
        assertEquals(s17,test.infixToPostfix("a   *  b    +       5"));
        String s18 ="0 21 - 7 * ";
        assertEquals(s18,test.infixToPostfix("(0   -    2    1     )    *       7    "));
        String s19 = "a b * c / ";
        assertEquals(s19,test.infixToPostfix("a  *     b     /     c     "));
        String s20 = "a b c - d + / e a - * c * ";
        assertEquals(s20,test.infixToPostfix("(a  / (b-c+   d))*(e  -a  )*     c"));
        String s21 = "a b / c - d e * + a c * - ";
        assertEquals(s21,test.infixToPostfix("a  / b -c+ d  *e-a   *c"));
        String s22 = "4 3 + 2 7 * - ";
        assertEquals(s22,test.infixToPostfix("( 4  +  3)-(  2*7)"));
        String s23 = "300 23 + 43 21 - * 84 7 + / ";
        assertEquals(s23,test.infixToPostfix( "(3     00 +2  3  )*(43-  21 )/(  84+7 )"));
        String s24 = "4 8 + 6 5 - * 3 2 - 2 2 + * / ";
        assertEquals(s24,test.infixToPostfix("(4  +8)  *(6-5)    /( (   3  -2) *(  2+2)  )"));

        //////////////////////////////////////test 10 more than one digit///////////////////////////////////////////////
        String s25 = "300 23 + 43 21 - * 84 7 + / ";
        assertEquals(s25,test.infixToPostfix( "(300+23)*(43-21)/(84+7)"));
        try {
            String s26 = "llllll ab + asdf qwr - * kl yy + / ";
            assertEquals(s26,test.infixToPostfix( "(llllll+ab)*(asdf-qwr)/(kl+yy)"));
        }catch (RuntimeException t){
            System.out.println(t.toString());
        }

        //////////////////////////////////test 11 negatives/////////////////////////////////////////////////////////////
        String s27 = "0 2 - 3 4 * + ";
        assertEquals(s27,test.infixToPostfix("-2+3*4 "));
        String s28 ="a 0 b - * 0 5 - - ";
        assertEquals(s28,test.infixToPostfix("a*-b--5"));
        String s29 ="0 21 - 7 * ";
        assertEquals(s29,test.infixToPostfix("-21*7"));
        String s30 = "a b * 0 c - / ";
        assertEquals(s30,test.infixToPostfix("a*b/-c"));
        String s31 ="0 4 - 0 5 - 2 * + ";
        assertEquals(s31,test.infixToPostfix("-4+-5*2"));
        ////////////////////////////test 12 other errors////////////////////////////////////////////////////////////////
        try {
            String s32 = " ";
            assertEquals(s32,test.infixToPostfix("14++6"));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s33 = " ";
            assertEquals(s33,test.infixToPostfix("14*/-6"));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }

        System.out.println("\t\t\t\t\t\t\t the InfixToPostfix test works well :D");






    }

    /**
     * test evaluate method
     */
    @org.junit.jupiter.api.Test
    void evaluate() {
        ExpressionEvaluator test = new ExpressionEvaluator();
        ///////////////////////////ordinary tests 1/////////////////////////////////////////////////////////////////////
        String s = "0";
        assertEquals(0,test.evaluate(s));
        String s1 ="1 2 + 7 *";
        assertEquals(21,test.evaluate(s1));
        ////////////////////////test 2 more than one digit\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        String s2 =" 500 20 + 400 - ";
        assertEquals(120,test.evaluate(s2));
        String s3 = " 300 45 * 10 -";
        assertEquals(13490,test.evaluate(s3));
        //////////////////////test 3  wrong expresion by different ways/////////////////////////////////////////////////
        try {
            String s4 = " ";
            assertEquals(0,test.evaluate(s4));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s5 = "5+52+3 ";
            assertEquals(0,test.evaluate(s5));
        }catch (NullPointerException t){
            System.out.println(t.toString());
        }
        try {
            String s6 = "5   +    2  + 3  ";
            assertEquals(0,test.evaluate(s6));
        }catch (NullPointerException t){
            System.out.println(t.toString());
        }
        try {
            String s7 = "ab+v+fr+g ";
            assertEquals(0,test.evaluate(s7));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s8 = "a b+ v+ fr + g  ";
            assertEquals(0,test.evaluate(s8));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s9 = " a b + c * ";
            assertEquals(0,test.evaluate(s9));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }

        ////////////////////////////////////test 4 negatives ///////////////////////////////////////////////////////////

        String s10 = "0 2 - 3 4 * + ";
        assertEquals(10,test.evaluate(s10));
        String s11 = "0 2 - 62  *  ";
        assertEquals(-124,test.evaluate(s11));
        String s12 ="0 2 - 10 * ";
        assertEquals(-20,test.evaluate(s12));
        String s13 = "0 2 - 10 /";
        assertEquals(0,test.evaluate(s13));
        String s14 ="0 2 - 10 + ";
        assertEquals(8,test.evaluate(s14));
        String s15 = "0 2 - 0 8 - -";
        assertEquals(6,test.evaluate(s15));

        //////////////////////////////////test 5 division\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        String s16 =" 10 2 /";
        assertEquals(5,test.evaluate(s16));
        String s17 =" 2 10 /";
        assertEquals(0,test.evaluate(s17));
        String s18 =" 2 10 / 5 3 / *";
        assertEquals(0,test.evaluate(s18));
        String s19 = " 3 2 /";
        assertEquals(1,test.evaluate(s19));
        try {
            String s20 = " 6 0 / ";
            assertEquals(0,test.evaluate(s20));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        String s21 ="0 6 /";
        assertEquals(0,test.evaluate(s21));

        //////////////////////////////////////////////test 8 parentheses////////////////////////////////////////////////
        try {
            String s22 = " (6 0 /) ";
            assertEquals(0,test.evaluate(s22));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s23 = " (6 0 / ";
            assertEquals(0,test.evaluate(s23));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s24 = " 6 0 /) ";
            assertEquals(0,test.evaluate(s24));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        try {
            String s25 = " 6) 0 / ";
            assertEquals(0,test.evaluate(s25));
        }catch (ArithmeticException t){
            System.out.println(t.toString());
        }
        System.out.println("\t\t\t\t\t\t\t the Evaluate test works well :D");

    }

}
