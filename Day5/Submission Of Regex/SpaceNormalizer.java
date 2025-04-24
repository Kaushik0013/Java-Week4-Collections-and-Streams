public class SpaceNormalizer{
    public static void main(String[]args){
        String input = "Multiple       Spaces       example.";
        String normalized = input.replaceAll("\\s{2,}"," ");
        System.out.println(normalized);
    }
}