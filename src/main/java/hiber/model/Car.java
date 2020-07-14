package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (series != car.series) return false;
        if (!name.equals(car.name)) return false;
        return user.equals(car.user);
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + name.hashCode();
        result = 31 * result + series;
        result = 31 * result + user.hashCode();
        return result;
    }
}
