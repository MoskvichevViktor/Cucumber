package dns;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Класса для запуска тестов
@RunWith(Cucumber.class)
// Опции для запуска сценариев
@CucumberOptions(
        // Список папок с feature файлами - фичи/сценарии
        features = {"src/test/resources/features"},
        // Спиcок пакетов с используемыми классами
        glue = {"dns"}
)
public class RunCucumberTest {
}







