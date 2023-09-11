import java.awt.*;
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество точек: ");
        int numberOfPoints = scanner.nextInt();

        if (numberOfPoints < 2) {
            System.out.println("Недостаточно точек для вычисления длин линий.");
            return;
        }

        Point[] points = new Point[numberOfPoints];

        try {
            for (int i = 0; i < numberOfPoints; i++) {
                System.out.print("Введите x координату точки " + (i + 1) + ": ");
                String xInput = scanner.next();

                if (xInput.equalsIgnoreCase("exit")) {
                    System.out.println("Введено недопустимое значение для x.");
                    return;
                }

                int x = Integer.parseInt(xInput);

                System.out.print("Введите y координату точки " + (i + 1) + ": ");
                String yInput = scanner.next();

                if (yInput.equalsIgnoreCase("exit")) {
                    System.out.println("Введено недопустимое значение для y.");
                    return;
                }

                int y = Integer.parseInt(yInput);

                points[i] = new Point(x, y);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите целое число для координаты.");
            return;
        }

        double minLength = Double.MAX_VALUE;
        double maxLength = Double.MIN_VALUE;
        double totalLength = 0;

        for (int i = 0; i < numberOfPoints - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            double length = p1.distanceTo(p2);

            totalLength += length;

            if (length < minLength) {
                minLength = length;
            }

            if (length > maxLength) {
                maxLength = length;
            }
        }

        System.out.println("Минимальная длина линии: " + minLength);
        System.out.println("Максимальная длина линии: " + maxLength);
        System.out.println("Сумма длин всех линий: " + totalLength);
    }
}
