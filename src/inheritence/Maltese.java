package inheritence;

public class Maltese extends Dog {

    private String name;
    private String ownerName;

    public static DogWrapper from(DogDto dto) {

        Maltese maltese = new Maltese();

        maltese.age = dto.getAge();
        maltese.illness = dto.getIllness();
        maltese.height = dto.getHeight();
        maltese.weight = dto.getWeight();
        maltese.wild = dto.getWild();

        maltese.name = dto.getName();
        maltese.ownerName = dto.getOwnerName();

        DogWrapper wrapper = new DogWrapper();
        wrapper.setMaltese(maltese);
        wrapper.setDogType("MALTESE");

        return wrapper;
    }

    // Setter and Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Maltese{" +
                "appearance='" + appearance + '\'' +
                ", age=" + age +
                ", illness='" + illness + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", wild=" + wild +
                "name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
