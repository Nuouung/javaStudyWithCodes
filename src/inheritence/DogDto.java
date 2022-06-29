package inheritence;

public class DogDto {

    private int age;
    private String illness;
    private Double height;
    private Double weight;

    private Boolean wild;

    // 말티즈용
    private String name;
    private String ownerName;

    public DogDto(int age, String illness, Double height, Double weight, Boolean wild, String name, String ownerName) {
        this.age = age;
        this.illness = illness;
        this.height = height;
        this.weight = weight;
        this.wild = wild;
        this.name = name;
        this.ownerName = ownerName;
    }

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
}
