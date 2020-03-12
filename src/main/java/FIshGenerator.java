import java.util.Random;

public class FIshGenerator {

    Random random;

    public FIshGenerator(){
        random = new Random();
    }

    public Fish generateFish(){
        int number = random.nextInt(17);
        if(number == 0){
            return new Fish("Ивана", "resources/fishes/Ivan.png");
        }
        if(number == 1){
            return new Fish("Александра", "resources/fishes/Alexandr.png");
        }
        if(number == 2){
            return new Fish("Немо", "resources/fishes/nemo.png");
        }
        if(number == 3){
            return new Fish("Дори", "resources/fishes/dori.jpg");
        }
        if(number == 4){
            return new Fish("Рейв-краба", "resources/fishes/crab.jpg");
        }
        if(number == 5){
            return new Fish("Ариэль", "resources/fishes/ariel.jpg");
        }
        if(number == 6){
            return new Fish("Мусор", "resources/fishes/trash.jpg");
        }
        if(number == 7){
            return new Fish("Жемчужину", "resources/fishes/pearl.jpg");
        }
        if(number == 8){
            return new Fish("Водоросли", "resources/fishes/weed.jpg");
        }
        if(number == 9){
            return new Fish("Рыбу-ежа", "resources/fishes/ball.jpg");
        }
        if(number == 10){
            return new Fish("Сундук с сокровищами", "resources/fishes/chest.jpg");
        }
        if(number == 11){
            return new Fish("Ската", "resources/fishes/skat.jpg");
        }
        if(number == 12){
            return new Fish("Карпа", "resources/fishes/karp.jpg");
        }
        if(number == 13){
            return new Fish("Лосося", "resources/fishes/losos.jpg");
        }
        if(number == 14){
            return new Fish("Акулу", "resources/fishes/shark.jpg");
        }
        if(number == 15){
            return new Fish("Кенни", "resources/fishes/Kenny.jpg");
        }
        if(number == 16){
            return new Fish("Пересдачу", "resources/fishes/testF.jpg");
        }
        return new Fish("КЕК","resources/fishes/shrek.png");
    }
}
