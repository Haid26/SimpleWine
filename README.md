# Автоматические тесты для  [SimpleWine](https://simplewine.ru/)

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://allurereport.org/"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/Qameta.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

____
<a id="cases"></a>
## <a>**Примеры автоматизированных тест-кейсов:**</a>
____
-  *Проверка работы поиска*
-  *Проверка добавления товара в корзину*
-  *Проверка изменения количества товаров в корзине*
-  *Проверка удаления товара из корзины*
-  *Проверка формы подписки на рассылку новостей*

____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Kod3ik_qa_guru_x5/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/view/java_students/job/C39-Evgeny_Karpov_Jenkins3//"><img src="images/screens/jenkins_build.jpg" alt="Jenkins" width="950"/></a>  
</p>

### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, по умолчанию 100.0)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean SimpleWineSimpleTests
```

***Удалённый запуск через Jenkins:***
```bash  
clean SimpleWineSimpleTests
"-Dbrowser=${browser}"
"-DbrowserVersion=${browserVersion}"
"-DbrowserSize=${browserSize}"
"-DbaseUrl=${baseUrl}"
"-DremoteUrl=${remoteUrl}"
```

___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/view/java_students/job/C39-Evgeny_Karpov_Jenkins3/6/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/report_main.jpg" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screens/testcases.jpg" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screens/graphs1.jpg" width="850">

<img title="Allure Graphics" src="images/screens/graphs2.jpg" width="850">  
</p>

____
<a id="telegram"></a>
## <img height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screens/telegram.jpg" width="550">  
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="images/video/simplewine.gif" width="550" height="350"  alt="video">   
</p>