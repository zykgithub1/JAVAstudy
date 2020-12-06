abstract class Bar {

    public int getNum() {

        return 38;

    }

}






public abstract class AbstractTest {

    public int getNum() {

        return 45;

    }





    public static void main(String[] args) {

        AbstractTest t = new AbstractTest() {

            public int getNum() {

                return 22;

            }

        };



        Bar f = new Bar() {

            public int getNum() {

                return 57;

            }

        };

        System.out.println(f.getNum() + " " + t.getNum());

    }

}