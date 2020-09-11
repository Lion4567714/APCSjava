public class printlnShapes {
    public static void main(String[] args) {
        //the shapes are a little squished, but you get the idea
        open();
        close();
        middle();
        open();
        close();
        middle();
        close();
        open();
        middle();
        close();
    }

    public static void open() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }

    public static void close() {
        System.out.println("\\         /");
        System.out.println(" \\       /");
        System.out.println("  -------");
    }

    public static void middle() {
        System.out.println("-\"-'-\"-'-\"-");
    }
}
