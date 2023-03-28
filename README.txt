Для подключения к smtp-серверу необходимо прописать имя пользователя и пароль в "application.properties"(поля "spring.mail.username" и "spring.mail.password")
Креды для подключения к SMTP-серверу Gmail высылаются личным сообщением, так как хранение их в открытом репозитории приводит к блокировке аккаунта из за спам-рассылок.

Подключение MongoDB и Kafka осуществляются через "docker-compose.yml"

Эндпоинт, ожидающий получение данных для формирования письма расположен по пути "/data"

Пример тела POST-запроса на эндпоинт "/data", JSON:

{
    "recipientId" : "1",
    "subject" : "Example message" ,
    "content" : "Example text for content" ,
    "email" : "examlpe@ukr.net"
}