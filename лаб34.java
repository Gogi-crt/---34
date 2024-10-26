import java.util.ArrayList;
import java.util.List;

public class TemperatureAdapter {

    private TemperatureScale scale;
    private double temperature;
    private List<Double> temperatureChanges;

    public enum TemperatureScale {
        CELSIUS, FAHRENHEIT
    }

    // Конструктор
    public TemperatureAdapter(TemperatureScale scale, double temperature) {
        this.scale = scale;
        this.temperature = temperature;
        this.temperatureChanges = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public TemperatureScale getScale() {
        return scale;
    }

    public void setScale(TemperatureScale scale) {
        this.scale = scale;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        temperatureChanges.add(temperature);
    }

    // Методы для преобразования
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Геттер для температурных изменений
    public List<Double> getTemperatureChanges() {
        return temperatureChanges;
    }

    // Метод для преобразования температуры
    public double convertTemperature() {
        if (scale == TemperatureScale.CELSIUS) {
            return celsiusToFahrenheit(temperature);
        } else if (scale == TemperatureScale.FAHRENHEIT) {
            return fahrenheitToCelsius(temperature);
        } else {
            return temperature; // Если шкала не задана, вернуть текущую температуру
        }
    }

    public static void main(String[] args) {
        // Пример использования
        TemperatureAdapter adapter = new TemperatureAdapter(TemperatureScale.CELSIUS, 25);
        System.out.println("Температура в Цельсиях: " + adapter.getTemperature());
        System.out.println("Температура в Фаренгейтах: " + adapter.convertTemperature());

        adapter.setTemperature(28);
        System.out.println("Измененная температура в Цельсиях: " + adapter.getTemperature());
        System.out.println("Измененная температура в Фаренгейтах: " + adapter.convertTemperature());

        System.out.println("Все изменения температуры: " + adapter.getTemperatureChanges());
    }
}