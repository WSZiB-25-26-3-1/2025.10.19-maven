package pl.edu.wszib.powtorka;

import org.apache.commons.codec.digest.DigestUtils;

public class TestMain {
    public static void main(String[] args) {

        /*CarBuilder carBuilder = new CarBuilder();
        carBuilder
                .brand("BMW")
                .model("3")
                .rent(false)
                .plate("KR77");
        Car car = carBuilder.build();

        new Car("BMW", "3", "KR77", false);*/

        String hash = DigestUtils.md5Hex("user");
        System.out.println(hash);

    }
}
