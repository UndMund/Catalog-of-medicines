# Catalog-of-medicines
Restful API with authentication made with Java, Spring Boot and Hibernate
## Предметная область
Прилложение рпедставляет из себя каталог медикаментов и аптек. Соответсвенно предоставляет следущий функционал:
* Добавить медикамент
* Добавить аптеку
* Добавить медикамент в наличие в аптеку
* Просмотреть список всех медикаментов
* Просмотреть список всех аптек
* Просмотреть список аптек отфильтрованный по необходимой таблетке и городу (опционально)
* Регистрация, аутентификация.
## Запуск приложения
* Для запуска приложения требуется переопределение dataSource в application.yml, а так же maven.install для mapstruct и queryDSL
* Для запуска тестов - maven.test
  
