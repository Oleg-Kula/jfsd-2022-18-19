Для подключения к smtp-серверу необходимо прописать имя пользователя и пароль в ".env"(поля "SPRING_MAIL_USERNAME" и "SPRING_MAIL_PASSWORD")
Креды для подключения к SMTP-серверу Gmail высылаются личным сообщением, так как хранение их в открытом репозитории приводит к блокировке аккаунта из за спам-рассылок.

Сборка проекта выполняется через Maven(clean-install в IDE или 'mvn package' в терминале)

Подключение MongoDB, Kafka и приложения осуществляются через "docker-compose.yml" (run в IDE или 'docker compose up' в терминале)

Эндпоинт, ожидающий получение данных для формирования письма расположен по пути "/data"

Пример тела POST-запроса на эндпоинт "/data", JSON:

{
    "recipientId" : "1",
    "subject" : "Example message" ,
    "content" : "Example text for content" ,
    "email" : "examlpe@ukr.net"
}