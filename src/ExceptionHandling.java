public class ExceptionHandling {
    public static void main(String[] args) {
//        int myInt = Integer.parseInt("pants"); // this wil result in the program blowing up because a number can't
        // be derived from 'pants'.
        // try and catch blocks can help to handle these unique situations so the rest of the codee doesn't blow up

        try {
            //code that may cause an exception
           getInt();
            System.out.println("this should not print unless no preceding code caught an exception"); // if 'getInt()'
            // has no exception, then the try block continues onto the rest of the code. I imagine you could also
            // test multiple cases then and it would run until one of the cases threw and caught an exception, if any
        }
//        catch (NumberFormatException nfe){ // the catch block will catch a NumberFormatException if it is thrown by try block
//            //codee that we want to execute if this type of exception is found
//            //type of exception uses exception hierarchy means that only exceptions of this type will bee caught or subclasses of that type
//            // a more generic type of exception than 'NumberFormatException' is just 'Exception' which will catch all exce ptions
//            System.out.println("hey dude, you can't make an int from that, (printed from nfe)");
//        }
//        catch (NullPointerException npe){
//            System.out.println("hey dude, you can't make an int from that, (printed from npe)");
//            //note that we can also have multiple catch blocks for different types of exceptions
//        }
        catch (NumberFormatException | NullPointerException e){  // to avoid code duplication like above, we can also
            // have multiple exception types caught using a 'multi-catch' statement where both types are in the parameter
            // the only downside here is that you will not know what type of exception was caught
            System.out.println("hey dude, you can't make an int from that");
        }
        finally { //this block will execute regardless of whether there was an exception thrown or caught. the whole try
            // block can be empty and this will still execute and will print even if there was a return statement in
            // try block as an example. this will ALWAYS print and will always be LAST. in theory, if a try block returned
            // one thing but the finally block returned another, the finally block return would override all other returns
            System.out.println("finally block run");
        }
        System.out.println("end here");
    }

    private static void getInt(){
        int myInt = Integer.parseInt("pants"); //catch block will execute
        int myInt2 = Integer.parseInt("1"); // no exception so catch block will not execute
    } //the way this has been formatted such that main calls this method is that the exception will be thrown up the
    // call stack to calling method, caught and handled but we could alternatively call the 'getInt()' method and have the try/catch block
    // in the private method block here too
}
