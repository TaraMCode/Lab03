package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // this will display the requested JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the parameters from the POST request (the form)
        String firstnumber = request.getParameter("first_number");
        String secondnumber = request.getParameter("second_number");

        // set the attributes for the JSP
        request.setAttribute("firstNumber", firstnumber);
        request.setAttribute("secondNumber", secondnumber);
        
        String operation = request.getParameter("button");

        // validation: if the parameters don't exist or are empty, show the form again
        if (firstnumber == null || firstnumber.equals("") || secondnumber == null || secondnumber.equals("")) {
            // Create a helpful message to send to the user
            request.setAttribute("message", "Invalid");
            // forward the request and response objects to the JSP
            //display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

            return; // very important! Stop the code call.
        }
        
        if (firstnumber == null || firstnumber.equals("") && secondnumber == null || secondnumber.equals("")) {
            // Create a helpful message to send to the user
            request.setAttribute("message", "---");
            // forward the request and response objects to the JSP
            //display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

            return; // very important! Stop the code call.
        }

        else if(firstnumber.matches("[A-Za-z]{1,50}") || secondnumber.matches("[A-Za-z]{1,50}")) {
            request.setAttribute("message", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        }
        
        else {
        switch (operation) {
            case "+":
            int parsedNumberOneAddition = Integer.parseInt(firstnumber);
            int parsedNumberTwoAddition = Integer.parseInt(secondnumber);
            int additionAnswer = parsedNumberOneAddition + parsedNumberTwoAddition;
            request.setAttribute("message", additionAnswer);
                break;
            case "-":
                int firstNumberInt = Integer.parseInt(firstnumber);
                int secondNumberInt = Integer.parseInt(secondnumber);
                int subtractionAnswer = firstNumberInt - secondNumberInt;
                request.setAttribute("message", subtractionAnswer);
                break;
            case "*":
             int firstNumberIntMultiply = Integer.parseInt(firstnumber);
             int secondNumberIntMultiply = Integer.parseInt(secondnumber);
            int multiplicationAnswer = firstNumberIntMultiply * secondNumberIntMultiply;
            request.setAttribute("message", multiplicationAnswer);
                break;
            case "%":
            int firstNumberIntModulus = Integer.parseInt(firstnumber);
            int secondNumberIntModulus = Integer.parseInt(secondnumber);
            int modulusAnswer = firstNumberIntModulus % secondNumberIntModulus;
            request.setAttribute("message", modulusAnswer);
                break;
            default:
                request.setAttribute("message", "---");
                break;
        }
        }
        
        //display the helloWord JSP
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
}
