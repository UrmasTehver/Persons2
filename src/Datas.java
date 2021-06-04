public class Datas {
    String firstname;
    String lastname;
    String gender;
    String birth;
    String death;
    String place;
    String type;
    String county;

    public Datas(String firstname, String lastname, String gender, String birth, String death, String place, String type, String county) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.place = place;
        this.type = type;
        this.county = county;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth() {
        return birth;
    }

    public String getDeath() {
        return death;
    }

    public String getPlace() {
        return place;
    }

    public String getType() {
        return type;
    }

    public String getCounty() {
        return county;
    }
}
