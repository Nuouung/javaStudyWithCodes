package inheritence;

public class Main {

    public static void main(String[] args) {

        DogDto dogDto = new DogDto(3, "HEALTHY", 1.1d, 2d, false, "Cutie", "Human");

        DogWrapper wrapper = Dog.from(dogDto);

        Maltese maltese = wrapper.getMaltese();

        System.out.println(maltese);

    }
}
