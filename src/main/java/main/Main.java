import global.MyFileWriter;

import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static global.Vars.allToys;
import static global.Vars.winsToys;

public class Main {

    public static void main(String[] args) {
        //Сначала создаем произвольные игрушки
        Toy cat = new Toy(1, "котик", 10, 20);
        Toy dog = new Toy(2, "собачка", 3, 5);
        Toy doll = new Toy(3, "кукла", 4, 10);
        Toy car = new Toy(4, "машина", 10, 30);
        Toy stroller = new Toy(5, "коляска", 6, 20);
        Toy plane = new Toy(6, "самолет", 5, 8);

        //добавляем созданные игрушки в список (в обычный непризовой) с новым весом
        addToListWithNewWeight(cat, 8);
        addToListWithNewWeight(dog, 27);
        addToListWithNewWeight(doll, 3);
        addToListWithNewWeight(car, 25);
        addToListWithNewWeight(stroller, 65);
        addToListWithNewWeight(plane, 17);

        //показываем что у нас в общем списке игрушек
        System.out.println("Все игрушки : ");
        showNewList(allToys);

        //формируем список призовых игрушек (пусть это будут с весом от 25)
        List<Toy> addedWinners = selectToyByMinWeight(allToys, 25);
        winsToys.addAll(addedWinners);

        //отображаем призовые игрушки
        System.out.println("Призовые игрушки: ");
        showNewList(winsToys);

        //выбираем призовую игрушку на выдачу из призового списка (пусть случайным образом)
        Toy givedWinner = selectRandomToy(winsToys);
        //удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        //отображаем инфо о призовой игрушке на выдачу
        System.out.println("Розыгрыш завершен. " + givedWinner.info());

        //пишем инфо в текстовый файл
        MyFileWriter.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(Toy newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("игрушка [" + (i+1) + "]: " + myList.get(i).getName() + "; ");
        }
        System.out.println("");
    }
}