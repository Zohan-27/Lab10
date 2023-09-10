import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class LineLengthCalculator {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean shouldEnd = false;

        while (!shouldEnd) {
            try {
                System.out.print("Введите x координату точки (или 'exit' для завершения ввода): ");
                String input = scanner.next();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                int x = Integer.parseInt(input);

                System.out.print("Введите y координату точки (или 'exit' для завершения ввода): ");
                input = scanner.next();

                if (input.equalsIgnoreCase("exit")) {
                    shouldEnd = true;
                    break;
                }

                int y = Integer.parseInt(input);

                points.add(new Point(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число для координаты или 'exit' для завершения ввода.");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целое число для координаты.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        }

        double minLength = Double.MAX_VALUE;
        double maxLength = Double.MIN_VALUE;
        double totalLength = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double length = p1.distanceTo(p2);

            totalLength += length;

            if (length < minLength) {
                minLength = length;
            }

            if (length > maxLength) {
                maxLength = length;
            }
        }

        if (points.size() < 2) {
            System.out.println("Недостаточно точек для вычисления длин линий.");
        } else {
            System.out.println("Минимальная длина линии: " + minLength);
            System.out.println("Максимальная длина линии: " + maxLength);
            System.out.println("Сумма длин всех линий: " + totalLength);
        }
    }
}
