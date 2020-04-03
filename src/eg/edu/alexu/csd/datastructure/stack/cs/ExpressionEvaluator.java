package eg.edu.alexu.csd.datastructure.stack.cs;

public class ExpressionEvaluator implements IExpressionEvaluator {

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression
     * infix expression
     * @return postfix expression
     */
    @Override
    // i assume if he enter only { + ~ / ~ * ~ - ~  ( ~ ) } i will send to him error
    public String infixToPostfix(String expression) {
        if (expression == null)
            throw new NullPointerException("Expression Not Found");
        if (expression.charAt(0)==' ')
            throw new NullPointerException("Expression Not Found");


        int len1 = expression.length();
        char ch1 = expression.charAt(0);

        if (len1==1 && ch1!='+' && ch1!='-' && ch1!='*' && ch1!='/' && ch1!='(' && ch1!=')'&&check(ch1))
            return String.valueOf(expression.charAt(0));
        else if (len1 == 1)
            throw new ArithmeticException("Wrong Expression");

        int i =0,j,count ,k=0;
        MyStack st = new MyStack();
        char ch,myTemp,pervious=' ';
        StringBuilder result= new StringBuilder();
        StringBuilder tempp = new StringBuilder();
        boolean t = false;
        char nexT=' ';
        boolean precious = false;


       while (k < len1) {
            ch = expression.charAt(k);
           if (k>0)
               pervious = expression.charAt(k-1);
           if (k<len1-1)
               nexT = expression.charAt(k+1);
           if (k > 0&&k<tempp.length())
                precious=tempp.charAt(k-1)==' ';
           if(check(ch)&&pervious==' '&&nexT==' '&&k!=len1-1&&k>0&&precious)
               throw new ArithmeticException("Wrong Expression");

            if (ch==' '){
                k++;
                continue;
            }
            count = 0;

           if ((k == 0 || pervious == '*' || pervious == '+' || pervious == '-' || pervious == '/') && ch == '-') {
                tempp.append("(0-");
                t = true;
                count++;
            }
            else if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '(' && ch != ')' && check(ch)) {
                j = k;
                myTemp = expression.charAt(j);
                if (j == len1 - 1) {
                    tempp.append(myTemp);
                    count++;
                    if (t){
                        t= false;
                        tempp.append(")");
                    }
                }
                else {
                    while (myTemp != '+' && myTemp != '-' && myTemp != '*' && myTemp != '/' && myTemp != '(' && myTemp != ')' && j != len1 - 1 && check(myTemp)) {
                        tempp.append(myTemp);
                        j++;
                        count++;
                        myTemp = expression.charAt(j);
                    }
                }
                if (t){
                    t= false;
                    tempp.append(")");
                }
            }
            else {
                tempp.append(ch);
                count++;
            }
            k=k+count;
        }

        expression = tempp.toString();
        int len = expression.length();
        if (expression.charAt(len-1)=='+'||expression.charAt(len-1)=='-'||expression.charAt(len-1)=='*'||expression.charAt(len-1)=='/')
            throw new ArithmeticException("Wrong Expression");
        char now=expression.charAt(0);
        if (now=='+'||now=='-'||now=='*'||now=='/')
            throw new ArithmeticException("Wrong Expression");
        make_Sure(expression);


        while (i < len){
           ch = expression.charAt(i);
           count=0;
            if (i>0)
                pervious = expression.charAt(i-1);
            if (i<len-1)
                nexT = expression.charAt(i+1);

            if ((ch=='+'||ch=='-'||ch=='*'||ch=='/')&&((pervious=='+'||pervious=='-'||pervious=='*'||pervious=='/')||(nexT=='+'||nexT=='-'||nexT=='*'||nexT=='/')))
                throw new ArithmeticException("Wrong Expression");

              if(ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='(' && ch!=')'&&check(ch)) {
                j = i;
                myTemp = expression.charAt(j);
                if (j == len - 1) {
                    result.append(myTemp);
                    count++;

                } else {
                    while (myTemp != '+' && myTemp != '-' && myTemp != '*' && myTemp != '/' && myTemp != '(' && myTemp != ')' && j <= len - 1&&check(myTemp)) {
                        result.append(myTemp);
                        j++; count++;
                        if (j <= len - 1)
                            myTemp = expression.charAt(j);
                    }
                }
                result.append(" ");
           }
           else if (ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='(' && ch!=')'&&!check(ch))
               throw new ArithmeticException("Wrong Expression");
           else {
               // +
               if (ch == '+'){
                   if (st.isEmpty())
                       st.push('+');
                   else if(!(st.isEmpty())){
                       while (!(st.isEmpty())) {
                           char temp =(char)st.peek();
                           if (temp =='(') {
                               st.push('+');
                               break;
                           }
                           else {
                               result.append(st.pop());
                               result.append(" ");
                           }
                       }
                       if (st.isEmpty())
                           st.push('+');
                   }
               }
               // -
               else if (ch == '-'){
                   if (st.isEmpty())
                       st.push('-');
                   else if(!(st.isEmpty())){
                       while (!(st.isEmpty())) {
                           char temp =(char)st.peek();
                           if (temp =='(') {
                               st.push('-');
                               break;
                           }
                           else {
                               result.append(st.pop());
                               result.append(" ");
                           }
                       }
                       if (st.isEmpty())
                           st.push('-');
                   }
               }
               // *
              else if  (ch=='*'){
                   if (st.isEmpty())
                       st.push('*');
                   else {
                       char temp = (char) st.peek();
                       if (temp == '+' || temp == '-' || temp == '(')
                           st.push(ch);
                       else {
                           result.append(st.pop());
                           result.append(" ");
                           st.push('*');
                       }
                   }
                       }

               // /
               else if (ch=='/'){
                   if (st.isEmpty())
                       st.push('/');
                   else {
                       char temp = (char) st.peek();
                       if (temp == '+' || temp == '-' || temp == '(')
                           st.push(ch);
                       else {
                           result.append(st.pop());
                           result.append(" ");
                           st.push('/');
                       }
                   }
               }
               // (
               else if  (ch == '(')
                   st.push('(');
               else {
                   char temp = (char) st.peek();
                   while (temp!='('&&!(st.isEmpty())) {
                       result.append(st.pop());
                       result.append(" ");
                       temp = (char) st.peek();
                   }
                   if (st.isEmpty())
                       throw new ArithmeticException("Wrong Expression");
                   else if (temp == '('){
                       st.pop();
                   }
               }
           }
           if(count==0)
               i++;
           else
               i=i+count;

        }
        while (!(st.isEmpty())){
            char temp = (char) st.pop();
            if (temp==')'||temp=='(')
                throw new ArithmeticException("Wrong Expression");
            else {
                result.append(temp);
                result.append(" ");
            }
        }
        return result.toString();
    }


    /**
     * Evaluate a postfix numeric expression, with a single space separator
     *
     * @param expression
     * postfix expression
     * @return the expression evaluated value
     */

    @Override
    public int evaluate(String expression) {
        if (expression == null)
            throw new NullPointerException("Expression Not Found");
        int len = expression.length();
        char ch1 = expression.charAt(0);
        final boolean b = ch1 == '0' || ch1 == '1' || ch1 == '2' || ch1 == '3' || ch1 == '4' || ch1 == '5' || ch1 == '6' || ch1 == '7' || ch1 == '8' || ch1 == '9';
        if (len==1 && b)
            return expression.charAt(0);
        else if (len==1)
            throw new ArithmeticException("Wrong Expression");

        int i=0,j,count;
        float temp3=0,temp1,temp2,temp4;
        char myTemp,ch;
        StringBuilder result = new StringBuilder();

        MyStack st = new MyStack();
        while (i < len){
           ch = expression.charAt(i);
           if (ch==' '){
               i++;
               continue;
           }

           if ((ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9')){
               count=0;
               j = i;
               myTemp = expression.charAt(j);
               if (j == len - 1&&myTemp!='-') {
                   result.append(myTemp);
                   count++;
               }
               else {
                   while ((myTemp == '0' || myTemp == '1' || myTemp == '2' || myTemp == '3' || myTemp == '4' || myTemp == '5'|| myTemp == '6'|| myTemp == '7'|| myTemp == '8'|| myTemp == '9' )&& j != len - 1) {
                       result.append(myTemp);
                       j++; count++;
                       myTemp = expression.charAt(j);
                   }
               }
               //
               temp4 = Float.parseFloat(result+"");
               st.push(temp4);
               i=i+count;
               result = new StringBuilder();
           }
           else if (ch=='+'||ch=='-'||ch=='*'||ch=='/') {
               if(st.isEmpty())
                   throw new ArithmeticException("Wrong Expression");
               temp1= Float.parseFloat(st.pop()+"");
               temp2 = Float.parseFloat(st.pop()+"");
               if (ch=='+')
                   temp3=temp1+temp2;
               if (ch=='-')
                   temp3=temp2-temp1;
               if (ch=='*')
                   temp3=temp2*temp1;
               if (ch=='/') {
                   if (temp1==0)
                       throw new ArithmeticException("Cannot Divide By Zero");
                   temp3 = temp2 / temp1;
               }
               st.push(temp3); i++;
           }
           else
               throw new ArithmeticException("Wrong Expression");
        }
        if (st.size()!=1)
            throw new ArithmeticException("Wrong Expression");
        return (int) Float.parseFloat(st.pop()+"");
    }

    /**
     * check if the input is in range or not
     *
     * @param in ,
     * @return the input is alpha or not
     */
    public boolean check (char in){
        if (in <= 'z' && in >= 'a')
            return true;
        if (in <= 'Z' && in >= 'A')
            return true;
        return in == '0' || in == '1' || in == '2' || in == '3' || in == '4' || in == '5' || in == '6' || in == '7' || in == '8' || in == '9';

    }
    /**
     * check if the input is in range or not
     *
     * @param in .
     * @return the input is alpha or not
     */
    public boolean check2 (char in){
        if (in <= 'z' && in >= 'a')
            return true;
        return in <= 'Z' && in >= 'A';

    }



    public void make_Sure( String string){
        char now , pervious = ' ';
        int i=0;
        while (i<string.length()){
            now =string.charAt(i);
            if (i>0)
                pervious=string.charAt(i-1);
            if ((check(now)&&check2(pervious))||(check2(now)&&check(pervious)))
                throw new RuntimeException("Wrong expression");
                i++;
            pervious = ' ';
        }

    }

}
