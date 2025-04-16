# Sprint_4 Джанбеков Роман 20fs qa

Тестовые сценарии: 

* Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
Реализовано в файлe __src/test/java/TestImportantQuestions.java______
* Заказ самоката. Нужно проверить весь флоу позитивного сценария с двумя наборами данных. Проверить точки входа в сценарий, их две: кнопка «Заказать» вверху страницы и внизу.
Из чего состоит позитивный сценарий:
Нажать кнопку «Заказать». На странице две кнопки заказа.
Реализация в _src/test/java/TestButtonOrder.java_

* Заполнить форму заказа.
Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
Реализовано в файлe _src/test/java/TestOrder.java_ 

Локаторы элементов основного задания расположены в __src/test/java/locator/locator.java__

Описание локаторов Page Object __src/test/java/PageObject/OrderPageOne.java__


Дополнительные задания:
Локаторы элементов расположены в _src/test/java/locator/LocatorAddTask.java_

Задание:
* Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
  _src/test/java/test/add/task/TestLogoScooter.java_
* Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
  _src/test/java/test/add/task/TestLogoScooter.java_

* Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет -
  _src/test/java/test/add/task/TestNoFoundOrder.java_

* Проверить ошибки для всех полей формы заказа -
_src/test/java/test/add/task/TestErrorMessage.java_

* В пакете _test/add/task/test/fields_ расположены тесты валидации полей ввода: Имя, Фамилия, Адрес, Номер телефона, Комментарий

подключенные зависимости в pow

    <groupId>my.sprigBootProject</groupId>
    <artifactId>Sprint_4</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.8.0</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project> 








