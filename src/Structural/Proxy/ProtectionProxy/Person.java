package Structural.Proxy.ProtectionProxy;

public class Person implements PersonBean {
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount;

    public Person() {
        rating = 0;
        ratingCount = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) {
            return ratingCount;
        }
        return rating / ratingCount;
    }

    @Override
    public void setName(String n) {
        name = n;
    }

    @Override
    public void setGender(String g) {
        gender = g;
    }

    @Override
    public void setInterests(String i) {
        interests = i;
    }

    @Override
    public void setHotOrNotRating(int r) {
        rating += r;
        ++ratingCount;
    }
}
