import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final Scanner input = new Scanner(System.in);
        List<Toy> initialToyList = new ArrayList<>(); // инициализируем список, который будет хранить типы созданных нами игрушек
        for (int i = 0; i < 4; i++){ //  создаем необходимое количество типов игрушек
            Toy toy = new Toy(); // создаем объект toy и заполняем поля объекта
            System.out.print("Введите ID игрушки: ");
            toy.setID(input.next());
            System.out.println();
            System.out.print("Введите вес игрушки: ");
            toy.setWeight(input.nextInt());
            System.out.println();
            System.out.print("Введите название игрушки: ");
            toy.setToyName(input.next());
            System.out.println();
            initialToyList.add(toy); // добавляем созданный тип игрушки в список для хранения
        }
        ToySet toySet = new ToySet(initialToyList); // создаем объект набора на основе созданных нами игрушек
        List<Toy> currentToySet = toySet.fillingOutToySet(initialToyList); /// для заполнения набора с учетом веса каждой игрушки используем соответствующий метод
        System.out.println();
        Queue queue = new Queue(currentToySet); //для дальнейшего учета веса игрушки каждого типа создаем приоритетную очередь
        PriorityQueue<Toy> priorityQueue = queue.composePriorityQueue(currentToySet); // вызываем на объекте соответствующий метод
        CommonQueue commonQueueComposer = new CommonQueue(priorityQueue); //создаем объект общей очереди
        LinkedList<Toy> commonQueue = commonQueueComposer.composeCommonQueue(priorityQueue);// вызываем соответствующий метод на объекте

        System.out.println();

        File myFile = new File("listLotteryResult.txt"); // создаем файл для записи результатов розыгрышей
        FileOutputStream outputStream = new FileOutputStream(myFile);

        Lottery lottery = new Lottery(commonQueue); // создаем объект лотереи
        for(int i = 0; i < 20; i++){  //разыгрываем лотерею интересующее число раз
            Toy yourToy = lottery.getToy(commonQueue); // вызываем на объекте метод, который случайным образом выбирает игрушку из созданной ранее очереди
            String text = "Your toy ID is " + yourToy.getID() + ", your toy name is " + yourToy.getToyName() + "\n";
            //строка выше позволяет зафиксировать инфорамацию о выигранной игрушке
            byte[] buffer = text.getBytes(); // помещаем в буфер строку
            outputStream.write(buffer); // записываем информацию о выигранной игрушке в файл
        }
        outputStream.close();
    }
}
