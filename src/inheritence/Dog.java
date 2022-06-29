package inheritence;

public class Dog {

    protected final String appearance = "CUTE";

    protected int age;
    protected String illness;
    protected Double height;
    protected Double weight;

    protected Boolean wild;

    // 정적 팩토리 메소드
    public static DogWrapper from(DogDto dto) {
        Dog dog = new Dog();

        dog.age = dto.getAge();
        dog.illness = dto.getIllness();
        dog.height = dto.getHeight();
        dog.weight = dto.getWeight();
        dog.wild = dto.getWild();

        return Maltese.from(dto);
    }

    // Getter and Setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getWild() {
        return wild;
    }

    public void setWild(Boolean wild) {
        this.wild = wild;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "appearance='" + appearance + '\'' +
                ", age=" + age +
                ", illness='" + illness + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", wild=" + wild +
                '}';
    }
}
