class Guy{

    String greet(){

        return "hi ";

    }}

class Cowboy extends Guy{

    String greet(){

        return "howdy ";

    }}

class Wrangler extends Cowboy{

    String greet(){

        return "ouch! ";

    }

}



class Greetings2  {

    public static void main (String [] args) {

        Guy g=new Wrangler();

        Guy g2=new Cowboy();

        Wrangler w2=new Wrangler();

        System.out.print(g.greet()+g2.greet()+w2.greet());

    }

}